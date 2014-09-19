<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html  onLoad="onload()">
	<head>
		<title>南方交友平台</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="../assets/css/style.css" />
       <script type="text/javascript" src="../assets/js/jquery.min.js"></script>
	   <script type="text/javascript" src="../assets/js/register.js"></script> 
       <script type="text/javascript" src="../assets/js/city_dept.js"></script>

    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <style>
			.container{
				width:900px;
			}
		</style>
	</head>
    <body onLoad="onload()" background="../assets/img/bg4.jpg" >
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
                        <form class="form-horizontal" action="register.action" method="post" name="form1">
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
                              <img src="" id="img0" width="80" height="80">
                              <input type="file" name="image" id="image" multiple="multiple" />
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
                            <label class="control-label">系</label>
                            <div class="controls">
                              <select name="dept" onchange="majorName(this.selectedIndex)"> 
                                <option value="">请选择所在系</option> 
                              </select>
                            </div>
                          </div>
                          <!-- 专业-->
                          <div class="control-group">
                            <label class="control-label">专业</label>
                            <div class="controls">
                              <select name="major"> 
                                <option value="">请选择专业</option> 
                              </select> 
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
                            <label class="control-label">籍贯</label>
                            <div class="controls">
                              <select name="province" onchange="cityName(this.selectedIndex)"> 
                                <option value="">请选择省名</option> 
                              </select>
                              <select name="city"> 
                                <option value="">请选择城名</option> 
                              </select> 
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
        <script>	
		/*头像上传预览*/
		  $("#image").change(function(){
			  var objUrl = getObjectURL(this.files[0]) ;
			  console.log("objUrl = "+objUrl) ;
			  if (objUrl) {
				  $("#img0").attr("src", objUrl) ;
			  }
		  }) ;
		  //建立一個可存取到該file的url
		  function getObjectURL(file) {
			  var url = null ; 
			  if (window.createObjectURL!=undefined) { // basic
				  url = window.createObjectURL(file) ;
			  } else if (window.URL!=undefined) { // mozilla(firefox)
				  url = window.URL.createObjectURL(file) ;
			  } else if (window.webkitURL!=undefined) { // webkit or chrome
				  url = window.webkitURL.createObjectURL(file) ;
			  }
			  return url ;
		  }
		</script>
	</body>
</html>


