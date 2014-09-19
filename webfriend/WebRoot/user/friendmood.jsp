<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="assets/css/style.css" />
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
    <body>
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
                  <li class="active"><a href="#"><img src="assets/img/icons/20/home.png"> 首页</a></li>
                  <li><a href="#"><img src="assets/img/icons/20/user.png"> 好友</a></li>
                  <li><a href="#"><img src="assets/img/icons/20/search.png"> 查找好友</a></li>
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
       		 <!--侧边栏-->
            <div class="row">
            	<div class="span2 offset1">
                    <div class="dropdown clearfix sider">
                          <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display: block; position: static; margin-top:20px; *width: 180px;">
                            <li><img src="assets/img/test/av1.jpg"><span style="margin-left:10px;">姓名</span></li>
                            <li>
                            	<a tabindex="-1" href="#">
                                	全部动态&nbsp;&nbsp;&nbsp;&nbsp;
                                	<span class="badge badge-important">6</span>
                                </a>
                            </li>
                            <li>
                            	<a tabindex="-1" href="#">
                                	好友动态&nbsp;&nbsp;&nbsp;&nbsp;
                                	<span class="badge badge-important">6</span>
                                </a>
                            </li>
                            <li style="border-bottom:none">
                            	<a tabindex="-1" href="#">
                                	与我相关&nbsp;&nbsp;&nbsp;&nbsp;
                                    <span class="badge badge-important">3</span>
                                </a>
                            </li>
                          </ul>
                     </div>
                 </div>
                 <!--主体内容-->
                 <div class="span8">
                  	<div class="span8 pull-left" style="margin-left:-5px; margin-top:20px;">
                    	<ul>
                        	<!--一条心情-->
                        	<li>
                              <div class="media"><!--头像-->
                                <a class="pull-left" href="#">
                                  <img class="media-object" src="assets/img/test/av1.jpg">
                                </a>
                                <div class="media-body" ><!--心情内容-->
                                  <div class="media-heading">
                                    <span class="username"><a href="#">姓名</a></span>&nbsp;-&nbsp;
                                    <span class="classes">班级</span>	
                                  </div>
                                  发表的心情Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                  <div class="mood-picture">
                                      <img src="assets/img/test/test1.jpg" width="400" height="300">
                                      <ul>
                                        <li><img src="assets/img/test/test1.jpg"></li>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                        <li><img src="assets/img/test/test3.jpg"></li>
                                        <li><img src="assets/img/test/test4.jpg"></li>
                                        <li><img src="assets/img/test/test5.jpg"></li>
                                      </ul>
                                      
                                      <span>
                                        评论(2)&nbsp;-&nbsp;
                                        <span style="display:inline; color:#B3B3B3;">9月14日 21：01</span>
                                      </span>
                                  </div>
                             
                                      <div class="media" style="clear:left;"><!--评论-->
                                        <a class="pull-left" href="#"><!--头像-->
                                          <img class="media-object" src="assets/img/test/av1.jpg">
                                        </a>
                                        <div class="media-body"><!--评论内容-->
                                          <div class="media-heading">
                                            <span class="username"><a href="#">姓名</a>：</span>
                                            评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                          </div>
                                          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                          <i class="icon-comment" title="回复"></i>
                                          <!--回复评论-->
                                          <div class="media" style="clear:left;"><!--评论-->
                                            <a class="pull-left" href="#"><!--头像-->
                                              <img class="media-object" src="assets/img/test/av1.jpg">
                                            </a>
                                            <div class="media-body"><!--评论内容-->
                                              <div class="media-heading">
                                                <span class="username"><a href="#">姓名</a>：</span>
                                                评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                              </div>
                                              <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                              <i class="icon-comment" title="回复"></i>
                                            </div>
                                          </div><!--media end-->
                                        </div>
                                      </div><!--media end-->
                                      <!--第二条评论-->
                                      <div class="media" style="clear:left;"><!--评论-->
                                        <a class="pull-left" href="#"><!--头像-->
                                          <img class="media-object" src="assets/img/test/av1.jpg">
                                        </a>
                                        <div class="media-body"><!--评论内容-->
                                          <div class="media-heading">
                                            <span class="username"><a href="#">姓名</a>：</span>
                                            评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                          </div>
                                          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                          <i class="icon-comment" title="回复"></i>
                                        </div>
                                      </div><!--media end-->
                                        <div class="media" style="clear:left;"><!--评论-->
                                          <a class="pull-left" href="#"><!--头像-->
                                             <img class="media-object" src="assets/img/test/av1.jpg">
                                          </a>
                                          	<div class="media-body"><!--评论内容-->
                                              <div class="media-heading">
                                                 <form action="#" method="post">
                                                    <textarea name="" style="width:400px; height:30px;" placeholder="我也说一句..."></textarea><br>
                                                    <button type="submit" class="btn btn-success" style="float:left; margin-left:360px;">发表</button>
                                                 </form>
                                            </div>
                                         </div><!--media end-->
                                     </div><!--media end-->
                                </div><!--media-body end-->
                              </div><!--media end--> 
                           </li>
                           <!--心情 结束-->
                           <!--第二条心情-->
                           <li>
                              <div class="media"><!--头像-->
                                <a class="pull-left" href="#">
                                  <img class="media-object" src="assets/img/test/av1.jpg">
                                </a>
                                <div class="media-body" ><!--心情内容-->
                                  <div class="media-heading">
                                    <span class="username"><a href="#">姓名</a></span>&nbsp;-&nbsp;
                                    <span class="classes">班级</span>	
                                  </div>
                                  发表的心情Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                  <div class="mood-picture">
                                      <img src="assets/img/test/test2.jpg" width="400" height="300">
                                      <ul>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                        <li><img src="assets/img/test/test2.jpg"></li>
                                      </ul>
                                      
                                      <span>
                                        评论(2)&nbsp;-&nbsp;
                                        <span style="display:inline; color:#B3B3B3;">9月14日 21：01</span>
                                      </span>
                                  </div>
                             
                                      <div class="media" style="clear:left;"><!--评论-->
                                        <a class="pull-left" href="#"><!--头像-->
                                          <img class="media-object" src="assets/img/test/av1.jpg">
                                        </a>
                                        <div class="media-body"><!--评论内容-->
                                          <div class="media-heading">
                                            <span class="username"><a href="#">姓名</a>：</span>
                                            评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                          </div>
                                          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                          <i class="icon-comment" title="回复"></i>
                                          <!--回复评论-->
                                          <div class="media" style="clear:left;"><!--评论-->
                                            <a class="pull-left" href="#"><!--头像-->
                                              <img class="media-object" src="assets/img/test/av1.jpg">
                                            </a>
                                            <div class="media-body"><!--评论内容-->
                                              <div class="media-heading">
                                                <span class="username"><a href="#">姓名</a>：</span>
                                                评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                              </div>
                                              <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                              <i class="icon-comment" title="回复"></i>
                                            </div>
                                          </div><!--media end-->
                                        </div>
                                      </div><!--media end-->
                                      <!--第二条评论-->
                                      <div class="media" style="clear:left;"><!--评论-->
                                        <a class="pull-left" href="#"><!--头像-->
                                          <img class="media-object" src="assets/img/test/av1.jpg">
                                        </a>
                                        <div class="media-body"><!--评论内容-->
                                          <div class="media-heading">
                                            <span class="username"><a href="#">姓名</a>：</span>
                                            评论的内容Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                          </div>
                                          <span class="time">9月15日 20：38</span>&nbsp;&nbsp;&nbsp;
                                          <i class="icon-comment" title="回复"></i>
                                        </div>
                                      </div><!--media end-->
                                        <div class="media" style="clear:left;"><!--评论-->
                                          <a class="pull-left" href="#"><!--头像-->
                                             <img class="media-object" src="assets/img/test/av1.jpg">
                                          </a>
                                          	<div class="media-body"><!--评论内容-->
                                              <div class="media-heading">
                                                 <form action="#" method="post">
                                                    <textarea name="" style="width:400px; height:30px" placeholder="我也说一句..."></textarea><br>
                                                    <button type="submit" class="btn btn-success" style="float:left; margin-left:360px;">发表</button>
                                                 </form>
                                            </div>
                                         </div><!--media end-->
                                     </div><!--media end-->
                                </div><!--media-body end-->
                              </div><!--media end--> 
                           </li>
                        </ul>
                    </div><!--span8 end-->
                 </div><!--span8 end-->
           </div><!--row end-->
        </div><!--container end-->
    <div class="modal-footer" style="text-align:center">
    	Copyright © 2014 - 2015 Tencent.中山大学南方学院-JAVA班-7组 版权所有
    </div>
    <script src="assets/js/jquery.min.js"></script>  
	</body>
</html>
