<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <base href="<%=basePath%>">
        <title>webfriends Admin</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />
		<link href="../assets/css/wf.login.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
    <body>
		<div class="page-header">后台登录</div>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="index.html" />
				<p>请输入用户名和密码</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
                </div>
            </form>
        </div>
        
        <script src="../assets/js/jquery.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
    </body>
</html>

