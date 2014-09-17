<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>南方交友平台</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="../assets/css/login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
    <body>
    	<div class="container-fluid">

            <div class="page-header">
                <div id="logo">
                   <img src="../assets/img/logo.png">
                </div>
            </div>
            <div class="row">
                <div class="span7" ><!--style="background:#9F0"-->
                    <img src="../assets/img/login-picture3.jpg">
                </div>
                <div class="span4" ><!--style="background:#999"-->
                    <div id="loginbox">   
                        <div class="container-fluid">         
                        <form id="loginform" class="form-vertical" action="login.action" method="post" />
                            <p>请输入用户名和密码</p>
                            <div class="control-group">
                                <div class="controls">
                                    <div class="input-prepend">
                                        <span class="add-on"><i class="icon-user"></i></span><input type="text" name="username" placeholder="用户名" />
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    <div class="input-prepend">
                                        <span class="add-on"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="密码" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-actions">
                                <span class="pull-left"><a href="register.jsp" class="flip-link">免费注册</a></span>
                                <span class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
                            </div>
                        </form>
                    </div>
                </div>
                 <h3><s:property value="#session.error" /></h3>
                <%session.removeAttribute("error");%>
            </div>
            
        </div>
        <script src="../assets/js/jquery.min.js"></script>  

    </body>
</html>


