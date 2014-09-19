<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>南方交友平台-好友主页</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-responsive.min.css" />

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
.sider ul li {
	margin: 0;
}
.span3 ul li img {
	width: 160px;
	height: 160px;
	margin: 0px;
}
.line {
	border-bottom: 1px solid #eaeaea;
	margin: 10px 0 0 10px;
}
.media a img {
	width: 40px;
	height: 40px;
}
.username {
	color: #435E99;
}
.classes {
	color: #B1B1B1;
}
.mood-picture {
	margin-top: 10px;/*height:480px;*/
}
.mood-picture ul {
	width: 400px;
	list-style-type: none;
	margin-top: 5px;
	background: #900;
	padding: 0;
	margin-left: 5px;
}
.mood-picture li {
	float: left;
	margin-right: 4px;
	width: 76px;
}
.mood-picture li img {
	width: 76px;
	height: 57px;
}
.mood-picture span {
	display: block;
	color: #435E99;
	clear: both;
	padding-top: 5px;
}
.time {
	color: #B3B3B3;
	font-size: 12px;
}
.span8>ul>li {
	border-bottom: 1px solid #e5e5e5;
	margin-bottom: 15px;
	padding-bottom: 15px;
}
.span9{border-left:1px solid #eaeaea;}
.relations ul li img{width:40px;height:40px;margin:10px 6px 0px 3px;}
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
          <li><a href="#">我的主页</a></li>
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

<div class="container-fluid" style="margin:88px 80px 0 80px;">
<div class="row-fluid">
<div class="span3" style="margin-right:0px;">
  <ul style="list-style:none; border-bottom:1px solid #eaeaea;margin-bottom:35px">
    <li>
    	<center>
        <img src="../assets/img/test/test6.jpeg">
		</center>
    </li>
    <li>
      <center>
        <h3>{姓名}</h3>
      </center>
    </li>
  </ul>
  <div class="span12 relations">
    　　<strong>关系交集：</strong><br/>
  	<ul style="list-style:none;">
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
         <li><img class="img-polaroid pull-left" src="../assets/img/test/test6.jpg"></li>
    </ul>
  </div>
</div>
<div class="span9 friendMain clearfix">
<a class="btn btn-small btn-info pull-right" href="##">取消关注</a>
<div class="personInfo-txt"> <i class="icon-user"></i>　{昵称} </div>
<div class="personInfo-class"> <i class="icon-thumbs-up"></i>　{系}-{专业}-{班级} </div>
<div class="personInfo-mail"> <i class="icon-envelope"></i>　{邮箱} </div>
<div class="personInfo-locate"> <i class="icon-map-marker"></i>　现居　<a href="">{籍贯}</a> </div>
<div class="line"></div>
<div class="span12 pull-left" style="margin-left:-5px; margin-top:10px;">
<ul>
<!--一条心情-->
<li>
  <div class="media"><!--头像--> 
    <a class="pull-left" href="#"> <img class="media-object" src="../assets/img/test/av1.jpg"> </a>
    <div class="media-body" ><!--心情内容-->
      <div class="media-heading"> <span class="username"><a href="#">姓名</a></span>&nbsp;-&nbsp; <span class="classes">班级</span> </div>
      发表的心情Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
      <div class="mood-picture"> <img src="../assets/img/test/test1.jpg" width="400" height="300">
        <ul>
          <li><img src="../assets/img/test/test1.jpg"></li>
          <li><img src="../assets/img/test/test2.jpg"></li>
          <li><img src="../assets/img/test/test3.jpg"></li>
          <li><img src="../assets/img/test/test4.jpg"></li>
          <li><img src="../assets/img/test/test5.jpg"></li>
        </ul>
        <span> 评论(2)&nbsp;-&nbsp; <span style="display:inline; color:#B3B3B3;">9月14日 21：01</span> </span> </div>
      <div class="media" style="clear:left;"><!--评论--> 
        <a class="pull-left" href="#"><!--头像--> 
        <img class="media-object" src="../assets/img/test/av1.jpg"> </a>
        <div class="media-body"><!--评论内容-->
          <div class="media-heading"> <span class="username"><a href="#">姓名</a>：</span> 评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. </div>
          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp; <i class="icon-comment" title="回复"></i> 
          <!--回复评论-->
          <div class="media" style="clear:left;"><!--评论--> 
            <a class="pull-left" href="#"><!--头像--> 
            <img class="media-object" src="../assets/img/test/av1.jpg"> </a>
            <div class="media-body"><!--评论内容-->
              <div class="media-heading"> <span class="username"><a href="#">姓名</a>：</span> 评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. </div>
              <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp; <i class="icon-comment" title="回复"></i> </div>
          </div>
          <!--media end--> 
        </div>
      </div>
      <!--media end--> 
      <!--第二条评论-->
      <div class="media" style="clear:left;"><!--评论--> 
        <a class="pull-left" href="#"><!--头像--> 
        <img class="media-object" src="../assets/img/test/av1.jpg"> </a>
        <div class="media-body"><!--评论内容-->
          <div class="media-heading"> <span class="username"><a href="#">姓名</a>：</span> 评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. </div>
          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp; <i class="icon-comment" title="回复"></i> </div>
      </div>
      <!--media end-->
      <div class="media" style="clear:left;"><!--评论--> 
        <a class="pull-left" href="#"><!--头像--> 
        <img class="media-object" src="../assets/img/test/av1.jpg"> </a>
        <div class="media-body"><!--评论内容-->
          <div class="media-heading">
            <form action="#" method="post">
              <textarea name="" style="width:400px; height:30px;" placeholder="我也说一句..."></textarea>
              <br>
              <button type="submit" class="btn btn-success" style="float:left; margin-left:360px;">发表</button>
            </form>
          </div>
        </div>
        <!--media end--> 
      </div>
      <!--media end--> 
    </div>
    <!--media-body end--> 
  </div>
  <!--media end--> 
</li>
<!--心情 结束-->

</div>
</div>
</div>
<div class="modal-footer" style="text-align:center"> Copyright © 2014 - 2015 Tencent.中山大学南方学院-JAVA班-7组 版权所有 </div>
<script src="../assets/js/jquery.min.js"></script> 
<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>