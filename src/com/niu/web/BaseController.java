package com.niu.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niu.utils.EmptyUtil;
import com.niu.utils.PrintUtil;
import com.niu.utils.ReturnResult;

public abstract class BaseController extends HttpServlet{
	public abstract Class getServletClass();

	/**
	 *binglong
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * binglong
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		Method method = null;
		Object result = null;

		try {
			if (EmptyUtil.isEmpty(action)) {
				result = getRespPathStr(request, response);
			} else {
				method = getServletClass().getDeclaredMethod(action,
						HttpServletRequest.class, HttpServletResponse.class);
				result = method.invoke(this, request, response);
			}
			toView(result, request, response);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			response.sendRedirect("400.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			if (EmptyUtil.isEmpty(result)) {
				response.sendRedirect("500.jsp");
			} else {
				if (result instanceof String) {

				} else {
					ReturnResult returnResult = new ReturnResult();
					returnResult.returnFail("系统错误！");
					PrintUtil.print(returnResult, response);
				}
			}

		}

	}

	private void toView(Object result, HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		try {
			//如果是字符串则跳转到相关页面
			if (result instanceof String) {
				request.getRequestDispatcher(result.toString() + ".jsp").forward(request, response);
			}else{
				//进行数据传输
				PrintUtil.print(result, response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * 获得响应路径！
	 * 
	 * @author 牛牛
	 * 
	 * @date 2017-12-29
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private Object getRespPathStr(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/index";
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 * @throws SQLException 
	 */
	public void init() throws ServletException {
	}
}
