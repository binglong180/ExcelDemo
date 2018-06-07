package com.niu.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class PrintUtil {
	/**
	 * 
	 * 字符串的打印！
	 * 
	 * @author 牛牛
	 *
	 * @date 2017-12-29
	 *
	 * @param msg
	 * @param response
	 */
	public static void print(String msg,HttpServletResponse response){
		if(response!=null){
			PrintWriter out=null;
			try {
				out = response.getWriter();
				out.print(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				out.flush();
				out.close();
			}
		}
	}
	/**
	 * 
	 * 数据的传输！
	 * 
	 * @author 牛牛
	 *
	 * @date 2017-12-29
	 *
	 * @param object
	 * @param response
	 */
	public static void print(Object object,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		String json=JSONObject.toJSONString(object);
		print(json, response);
	}
}
