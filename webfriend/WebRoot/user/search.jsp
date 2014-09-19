﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8" />
    <title>南方交友平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="assets/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="assets/css/style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<style>
	.container{
		width:1000px;
	}
	</style>
   <body background="assets/img/bg4.jpg">
	<!--导航条-->
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
      	<div class="container" style="width:1100px;">
        	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
            </a>
            
            <a class="brand" href="#"><img src="assets/img/logo.png"></a>
            
            <div class="nav-collapse collapse">
                <ul class="nav">
                  <li><a href="#"><img src="assets/img/icons/20/home.png"> 首页</a></li>
                  <li><a href="#"><img src="assets/img/icons/20/user.png"> 好友</a></li>
                  <li  class="active"><a href="#"><img src="assets/img/icons/20/search.png"> 查找好友</a></li>
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
            </div><!--nav-collapse end-->
        </div><!--container end-->
       </div><!--navbar-inner end-->
 	</div><!--navbar end-->
    
    <div class="container" style="margin-top:70px;">
            <div class="row">
            	<div class="span6 offset2 friend-search">
                    <form action="#" method="post">
                    	<div class="input-append">
                          <input class="span5" id="appendedInputButton" type="text" style="height:32px;">
                          <button class="btn" type="button" style="width:70px;"><img src="assets/img/icons/32/searchf.png"></button>
                        </div>
                    </form>
                 </div>
                 
           </div><!--row end-->
           <div class="row">
           		<div class="span12 friend-list">
                	<ul class="thumbnails">
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test2.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test1.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test1.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test1.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test1.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                      <li class="span2">
                        <div class="thumbnail">
                          <img src="assets/img/test/test1.jpg" alt="">
                          <h5>姓名<a href="#" class="btn btn-info btn-mini pull-right">加为好友</a></h5>
                          <p>专业-班级</p>
                        </div>
                      </li>
                    </ul>
                </div>
           </div>
        </div>
    	
     <div class="modal-footer" style="text-align:center">
    	Copyright © 2014 - 2015 Tencent.中山大学南方学院-JAVA班-7组 版权所有
    </div>
    
    <script src="assets/js/jquery.min.js"></script>  
	</body>
</html>
