<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
        <td>
        	<form action="ImportServlet?action=importExcelFile" method="post" enctype="multipart/form-data">
        	 <input type="file" name="upfile"/>
            <input type="submit" value="导入">
        	</form>
           
        </td>
    </tr>
    <tr>
    	<td>
            <button onclick="exportDepart()" class="save-btn">导出</button>
        </td>
    </tr>
</table>
</body>
<script type="text/javascript" src="/public/jquery-2.1.0.min.js"></script>
<script type="text/javascript">

</script>
</html>