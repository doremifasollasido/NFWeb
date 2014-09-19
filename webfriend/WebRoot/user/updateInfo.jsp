<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>南方交友平台-</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="../assets/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<style>
body {
	font-size: 12px;
}
.navbar, .navbar-inner {
	height: 65px;
}
.navbar .nav {
	font-size: 22px;
	margin-top: 15px;
}
.navbar .brand img {
	width: 200px;
	height: 50px;
}
.search-position {
	margin-top: 18px;
	width: 400px;
	float: left;
	position: relative;
}
#tab1 {
	padding: 0;
	margin: 10px 0 0 150px
}
#tab2 {
	padding: 0;
	height: 400px;
	margin: 0px 0 0 150px
}
#tab3 {
	padding: 0;
	height: 400px;
	margin: 10px 0 0 150px
}
.baseinfo {
	margin: 68px 0 0 0;
}
</style>
<body>
<!--导航条-->
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container" style="width:1100px;"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#"><img src="../assets/img/logo.png"></a>
      <div class="nav-collapse collapse">
        <ul class="nav">
          <li><a href="#"><img src="../assets/img/icons/20/home.png"> 首页</a></li>
          <li><a href="#"><img src="../assets/img/icons/20/user.png"> 好友</a></li>
        </ul>
        <!--搜索-->
        <div class="search-position">
          <form action="#" method="post" class="form-search">
            <div class="input-append">
              <input type="text" name="" class="span2 search-query">
              <button type="submit" class="btn">搜索</button>
            </div>
          </form>
        </div>
        <ul class="nav pull-right">
          <li class="active"><a href="#">我的主页</a></li>
          <li><a href="#">退出</a></li>
        </ul>
      </div>
      <!--nav-collapse end--> 
    </div>
    <!--container end--> 
  </div>
  <!--navbar-inner end--> 
</div>
<!--navbar end-->

<div class="container-fluid" style="margin:100px 48px 0 100px;">
  <div class="row-fluid"> 
    <!--侧边栏-->
    <div class="span10">
      <div class="tabbable tabs-left"> <!-- Only required for left/right tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab">基本资料</a></li>
          <li><a href="#tab2" data-toggle="tab">头像照片</a></li>
          <li><a href="#tab3" data-toggle="tab">联系方式</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <div class="progress progress-striped active">
              <div class="bar" style="width: 10%;"></div>
            </div>
            <div class="baseinfo">
              <form class="form-horizontal">
                <div class="control-group">
                  <label class="control-label" for="inputName">姓名：</label>
                  <div class="controls">
                    <input type="text" id="inputName" placeholder="">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputAlais">昵称：</label>
                  <div class="controls">
                    <input type="password" id="inputAlais" placeholder="">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputSex">性别：</label>
                  <div class="controls">
                    <select name="inputSex">
                      <option value="男">男</option>
                      <option value="女">女</option>
                    </select>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputEmail">邮箱：</label>
                  <div class="controls">
                    <input type="password" id="inputEmail" placeholder="">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputDesc">就读于：</label>
                  <div class="controls">
                    <select name="inputDesc">
                      <option value="电子通讯与软件工程系">电子通讯与软件工程</option>
                      <option value="会计系">会计系</option>
                      <option value="文传系">文传系</option>
                    </select>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputMajor"></label>
                  <div class="controls">
                    <select name="inputMajor">
                      <option value="计算机科学与技术专业">计算机科学与技术专业</option>
                      <option value="电子专业">电子专业</option>
                      <option value="通信专业">通信专业</option>
                    </select>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputClass"></label>
                  <div class="controls">
                    <select name="inputClass">
                      <option value="1班">1班</option>
                      <option value="2班">2班</option>
                      <option value="3班">3班</option>
                    </select>
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label" for="inputAddr">现居地：</label>
                  <div class="controls">
                    <input type="password" id="inputAddr" placeholder="">
                  </div>
                </div>
                <div class="control-group">
                  <div class="controls">
                    <button type="submit" class="btn btn-info">保存信息</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div class="tab-pane" id="tab2">
            <form action="" name="pic">
              <img src="" id="img0" width="140" height="140"/>
              <input type="file" name="image" id="image" multiplse />
              <br/>
              <br/>
              <br/>
              <button type="submit" class="btn btn-success">保存头像</button>
            </form>
          </div>
          <div class="tab-pane" id="tab3">
            <div class="widget-content nopadding">
              <form action="#" method="get" class="form-horizontal" />
              
              <div class="control-group">
                <label class="control-label">QQ：</label>
                <div class="controls">
                  <input type="text" />
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">手机：</label>
                <div class="controls">
                  <input type="text" />
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Email</label>
                <div class="controls">
                  <input type="email"/>
                </div>
              </div>
              <div class="form-actions">
                <button type="submit" class="btn btn-primary">保存信息</button>
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--主体内容-->
    <div class="span8"  style="border-left:1px solid #EAEAEA"> </div>
    <!--span8 end--> 
    
  </div>
  <!--row end--> 
</div>
<!--container end-->
<div class="modal-footer" style="text-align:center"> Copyright © 2014 - 2015 Tencent.中山大学南方学院-JAVA班-7组 版权所有 </div>

<script src="../assets/js/jquery.min.js"></script> 
<script src="../assets/js/bootstrap.min.js"></script>
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
