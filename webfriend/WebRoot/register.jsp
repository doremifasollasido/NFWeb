<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="register.action" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    重复密码：<input type="password" name="repassword"><br/>
    学号：<input type="text" name="sno"><br/>
    昵称:<input type="text" name="alais"><br/>
    邮箱:<input type="text" name="Email"><br/>
    专业:<input type="text" name="major"><br/>
    系名:<input type="text" name="dept"><br/>
    班级<input type="text" name="classnumber"><br/>
    籍贯<input type="text" name="address"><br/>
     <input type="submit" value="提交">
    
    </form>
  </body>
</html>
