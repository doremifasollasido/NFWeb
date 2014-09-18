<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>DELETE MOOD</title>
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="stylesheet" href="../assets/css/wf.main.css" />
<link rel="stylesheet" href="../assets/css/wf.grey.css" class="skin-color" />
</head>

<body>
<div id="header">
  <h1><a href="###">南方校友后台</a></h1>
</div>
<div id="search">
  <input type="text" placeholder="Search here..." />
  <button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav btn-group">
    <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">退出</span></a></li>
  </ul>
</div>
<div id="sidebar"> <a href="#" class="visible-phone"><i class="icon icon-inbox"></i></a>
  <ul>
    <li><a href="http://localhost:8080/nf/manager/adminIndex.jsp"><i class="icon icon-home"></i> <span>首页</span></a></li>
    <li><a href="http://localhost:8080/nf/manager/deleteComment.jsp"><i class="icon icon-th-list"></i> <span>删除评论</span></a></li>
    <li class="active"> <a href="mooddisplay.action"><i class="icon icon-signal"></i> <span>删除心情</span></a> </li>
  <li ><a href="userdisplay.action" ><i class="icon icon-inbox"></i> <span>删除用户</span></a> </li>
  </ul>
</div>
<div id="content">
<div id="content-header">
  <h1>删除心情</h1>
</div>
<div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> 首页</a> <a href="#" class="current">删除心情</a> </div>
<div class="container-fluid">
<div class="row-fluid">
  <div class="span12">
    <div class="widget-box">
      <div class="widget-title"><span class="icon"><i class="icon-file"></i></span>
        <h5>心情列表</h5>
        <span title="54 total posts" class="label label-info tip-left">3</span></div>
      <div class="widget-content nopadding">
      <s:iterator value="list" id="mood">
        <ul class="recent-posts">
          <li>
            <div class="user-thumb"> <img width="40" height="40" alt="" src="" /> </div>
            
            <div class="article-post"> <span class="user-info"> 用户名:<s:property value="user.username"/>&nbsp;发表时间<s:property value="uptime"/></span>
              <p> 内容:<a href="#"><s:property value="content"/></a> </p>

              <s:a href="mooddelete.action?id=%{#mood.id}" class="btn btn-danger btn-mini btn-right">Delete</s:a> </div>
          </li>
        </ul>
        </s:iterator>
      </div>
    </div>
  </div>
</div>
<script src="../assets/js/jquery.min.js"></script> 
<script src="../assets/js/jquery.ui.custom.js"></script> 
<script src="../assets/js/bootstrap.min.js"></script> 
<script src="../assets/js/jquery.uniform.js"></script> 
<script src="../assets/js/select2.min.js"></script> 
<script src="../assets/js/unicorn.js"></script> 
<script src="../assets/js/jquery.dataTables.min.js"></script> 
<script src="../assets/js/unicorn.tables.js"></script>
</body>
</html>