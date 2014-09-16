<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<title>南方交友平台</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="../assets/css/style.css" />
       <script type="text/javascript" src="../jquery/jquery.min.js"></script>
	            <script type="text/javascript" src="../js/register.js"></script> 
        
        
        
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <style>
			.container{
				width:900px;
			}
		</style>
	</head>
    <body background="../assets/img/bg4.jpg">
		<div class="container">
        	<div class="row">
            	<div class="register-header">
                	 <img src="../assets/img/logo.png">
                </div>
            </div>
            <div class="row">
            	<div id="register-box">
                	<div class="row pull-right" style="margin-bottom:5px; margin-right:100px;">
                    	<a href="login.jsp">&lt;返回登录</a>
                    </div>
                	<div class="span12">
                        <form class="form-horizontal" action="register.action" method="post">
                        	<!--姓名 -->
                          <div class="control-group">
                            <label class="control-label" for="username">用户名</label>
                            <div class="controls">
                              <input type="text" id="username" name="username" placeholder="用户名">
                              <span id="us">请输入4-10位数的用户名</span>
                            </div>
                          </div>
                          <!--密码 -->
                          <div class="control-group">
                            <label class="control-label" for="password">密码</label>
                            <div class="controls">
                              <input type="password" id="password" name="password" placeholder="密码">
                              <span id="pw">请输入4-10位数的密码</span>
                            </div>
                          </div>
                          <!-- 确认密码-->
                          <div class="control-group">
                            <label class="control-label" for="repassword">确认密码</label>
                            <div class="controls">
                              <input type="password" id="repassword" name="repassword" placeholder="确认密码">
                              <span id="rpw"></span>
                            </div>
                          </div>
                          <!-- 昵称-->
                          <div class="control-group">
                            <label class="control-label" for="alais">昵称</label>
                            <div class="controls">
                              <input type="text" id="alais" name="alais" placeholder="昵称">
                              <span id="al">请输入2-10位数的昵称</span>
                            </div>
                          </div>
                          <!-- 学号-->
                          <div class="control-group">
                            <label class="control-label" for="sno">学号</label>
                            <div class="controls">
                              <input type="text" id="sno" name="sno" placeholder="学号">
                              <span id="sn">请输入2-10位数的学号</span>
                            </div>
                          </div>
                          <!-- 头像-->
                          <div class="control-group">
                            <label class="control-label" for="image">上传头像</label>
                            <div class="controls">
                              <input type="file" id="image">
                            </div>
                          </div>
                          <!-- 邮箱-->
                          <div class="control-group">
                            <label class="control-label" for="email">邮箱</label>
                            <div class="controls">
                              <input type="text" id="email" name="email" placeholder="邮箱">
                              <span id="em"></span>
                            </div>
                          </div>
                          <!-- 系名-->
                          <div class="control-group">
                            <label class="control-label" for="dept">系名</label>
                            <div class="controls">
                              <input type="text" id="dept" name="dept" placeholder="系名">
                            </div>
                          </div>
                          <!-- 专业-->
                          <div class="control-group">
                            <label class="control-label" for="major">专业</label>
                            <div class="controls">
                              <input type="text" id="major" name="major" placeholder="专业">
                            </div>
                          </div>
                          <!-- 班级-->
                          <div class="control-group">
                            <label class="control-label" for="classnumber">班级</label>
                            <div class="controls">
                              <input type="text" id="classnumber" name="classnumber" placeholder="班级">
                            </div>
                          </div>
                          <!-- 籍贯-->
                          <div class="control-group">
                            <label class="control-label" for="address">籍贯</label>
                            <div class="controls">
                              <input type="text" id="address" name="address" placeholder="籍贯">
                            </div>
                          </div>
                          <!-- 注册按钮-->
                          <div class="control-group">
                            <div class="controls">
                              <button type="submit" class="btn btn-info span2" id="sub">注册</button>
                            </div>
                          </div>
                       </form>
                     </div>
                </div>
            </div>
        </div>
        
    	<script src="../assets/js/jquery.min.js"></script>  
	</body>
</html>


