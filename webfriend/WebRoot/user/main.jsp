<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <base href="<%=basePath%>">
        <title>南方交友平台</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="assets/css/style.css" />
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<script type="text/javascript" src="assets/js/jquery.min.js"></script>
    	<script type="text/javascript">
		
	var curPage = 1; //查询页
	
	var list=null;
	var num=0;
	//获取数据
	function getData(page){ 
		$.ajax({
			type: 'POST',
			url: 'ajaxquerymood.action',
			data: {'page':page},
			dataType:'json',
			beforeSend:function(){
				//$("#moodUl").append("loading...");
			},
			success:function(json){
				curPage=json.page+1;
				
				list = json.list;
				$.each(list,function(index,array){ //遍历json数据列
					num = 0;
					//var comment = getCommentString(list);
					var li = "<li id='moodli"+array['id']+"'>";
					li +="<div class='media'><a class='pull-left' href='#'><img class='media-object' src='assets/img/test/av1.jpg'></a>";
					li +="<div class='media-body'><div class='media-heading'><span class='username'><a href='#'>"+array['user']['alais']+"</a></span>&nbsp;-&nbsp;";
					li +="<span class='classes'>"+array['user']['dept']+"-"+array['user']['major']+"-"+array['user']['classnumber']+"班</span></div>"+array['content']+"<div class='mood-picture'>";
					if(undefined != array['pictures']){//mood.pic!=null
						li += "<img src='"+array['pictures']['url']+"' width='400' height='300'>";
					li +="<ul><li><img src='"+array['id']+"'></li><li><img src='"+array['id']+"'></li></ul>";
					}
					li +="<span>评论("+num+")&nbsp;-&nbsp;<span style='display:inline; color:#B3B3B3;'>"+array['uptime'].substring(0, 20)+"</span>";
					if("${sessionScope.user.username}" == array['user']['username']){
					li +="<a href='javascript:void(0)' onclick='delmood("+array['id']+")'>刪除</a>";
					}
					li +="</span></div>";
					
					//li +=comment;
					
					li +="</div>";//?
					
					li +="<div class='media' style='clear:left;'><a class='pull-left' href='#'><img class='media-object' src='assets/img/test/av1.jpg'></a>";
					li +="<div class='media-body'><div class='media-heading'>";
					li +="<form method='post' action='addcomment'><textarea placeholder='我也说一句...' style='width:400px; height:30px;' name='content'></textarea><br><input type='hidden' name='moodId' value='"+array['id']+"'/>";
					li +="<button class='btn btn-success' style='float:left; margin-left:360px;' type='submit'>发表</button></form>";
					
					
					li +="</div>";//评论的div结束
					li +="</div>";//心情的div结束
					li +="</li>";//li结束
					
					$("#moodUl").append(li);
										
				});
				
			},
			complete:function(){ //生成分页条
				$("#next").html("");
				getPageBar();
				
			},
			error:function(){
				alert("数据加载失败");
			}
		});
	}
	function delmood(id){ 
		$.ajax({
			type: 'POST',
			url: 'ajaxdelmood.action',
			data: {'moodid':id},
			dataType:'json',
			success:function(json){
				$("#moodli"+id).slideUp("slow");
			},
			complete:function(){ //生成分页条
				alert(curPage);
			},
			error:function(){
				alert("未登录，请登录再进行操作");
				
			}
		});
	}
	
	//获取分页条
	function getPageBar(){
		
		//页码小于1
		if(curPage >1){
			//alert(curPage);
			var nextLi = "<li id='pagecount'><a href='javascript:void(0)' rel='"+curPage+"'>更多动态</a></li>";			
			$("#next").append(nextLi);
			
		}else{
			$("#next").html("");
			var nextLi = "<li>已经是末尾了，点击<a href='user/main.jsp'>查看最新</a></li>";			
			$("#next").append(nextLi);
		}
		
	}
	function getCommentString(listComment){
		var licomment="";
		if(null != listComment){
			//$.each(listComment,function(index,array){
				num++;
			//for(var i=0;mood.comment!=null;i++){
				//licomment +="<div class='media' style='clear:left;'><a class='pull-left' href="+评论者连接+"> <img class='media-object' src="+评论者头像+"></a>";
				//licomment +="<div class='media-body'><div class='media-heading'><span class='username'><a href='#'>"+评论者名称+"</a>：</span>"+评论内容+"</div>";
				//licomment +="<span class='time'>"+评论日期+"</span>&nbsp;&nbsp;&nbsp;<i class='icon-comment' title='回复'></i>";
				//licomment +=getCommentString();
				//licomment +="</div>";
				
				//}
			//});
		}
		
		return licomment;
	}
	
$(function(){
	//alert("f");
		getData(1);
		$("#pagecount a").live("click",function(){
			var rel = $(this).attr("rel");
			if(rel){
				getData(rel);
			};
		});
				
	});	
</script>
    	</head>
        <script>
			
			$(function(){
				$("#at").toggle(function(){
					$("#show").show();	
				},function(){
					$("#show").hide();
				});	
				$("a[title=friend]").click(function(){
					var text = $(this).text();
					var text = "<a href='#'>@"+text+"</a> ";
					//alert(text);
					var val = $("#mood-content").text();
					var s_val = val+text;
					$("#mood-content").text(s_val);	
					$("#show").hide();
					return false;
				});
			});
		</script>
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
                  <li><a href="user/main.jsp">我的主页</a></li>
                  <li><a href="logout">退出</a></li>
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
                            <li><img src="assets/img/test/av1.jpg"><span style="margin-left:10px;"><s:property value="#session.user.alais"/></span></li>
                            <li class="active">
                            	<a tabindex="-1" href="#" >
                                	全部动态&nbsp;&nbsp;&nbsp;&nbsp;
                                	
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
                     <div style="margin-top:20px; margin-left:50px; width:500px">
                     	<!--发表-->
                        <form action="sendmood" method="post" id="uploadForm" enctype="multipart/form-data">
                        	<textarea name="content" rows="4" style="width:500px;" id="mood-content"></textarea><br>
                        	<button class="btn" id="at">@</button>
                            <div class="popover fade bottom in" id="show" style="top: 220px; left: 380px; display: none;">
                                <div class="arrow"></div>
                                <h3 class="popover-title">好友列表</h3>
                                <div class="popover-content">
                                    <img src="assets/img/test/av1.jpg"><a href="#" title="friend">好友1</a><br>
                                    <img src="assets/img/test/av1.jpg"><a href="#" title="friend">好友2</a><br>
                                    <img src="assets/img/test/av1.jpg"><a href="#" title="friend">好友3</a><br>
                                    <img src="assets/img/test/av1.jpg"><a href="#" title="friend">好友4</a><br>
                                </div>
                            </div>
                            <input id="fileImage" type="file" name="fileselect[]" style="width:75px;" multiple />
                            <button type="button" id="fileSubmit" class="btn upload_submit_btn">确认上传图片</button>
                            <button type="submit" class="btn btn-success" style="float:right;">发表</button>
                            <div id="preview" class="upload_preview"></div>
                        </form>
                     </div>
                  	<div class="span8 pull-left" style="margin-left:-5px; margin-top:10px;">
                    	<ul id="moodUl">
                           
                        </ul>
                        <ul id="next">
                           
                        </ul>
                    </div><!--span8 end-->
                 </div><!--span8 end-->
           </div><!--row end-->
        </div><!--container end-->
    <div class="modal-footer" style="text-align:center">
    	Copyright © 2014 - 2015 Tencent.中山大学南方学院-JAVA班-7组 版权所有
    </div>
    
    <script src="assets/js/zxxFile.js"></script>
<script>
var params = {
	fileInput: $("#fileImage").get(0),
	upButton: $("#fileSubmit").get(0),
	url: $("#uploadForm").attr("action"),
	filter: function(files) {
		var arrFiles = [];
		for (var i = 0, file; file = files[i]; i++) {
			if (file.type.indexOf("image") == 0) {
				if (file.size >= 512000) {
					alert('您这张"'+ file.name +'"图片大小过大，应小于500k');	
				} else {
					arrFiles.push(file);	
				}			
			} else {
				alert('文件"' + file.name + '"不是图片。');	
			}
		}
		return arrFiles;
	},
	onSelect: function(files) {
		var html = '', i = 0;
		$("#preview").html("<div class='upload_loading'></div>");
		var funAppendImage = function() {
			file = files[i];
			if (file) {
				var reader = new FileReader()
				reader.onload = function(e) {
					html = html + '<div id="uploadList_'+ i +'" class="upload_append_list"><p><strong>' + file.name + '</strong>'+ 
						'<a href="javascript:" class="upload_delete" title="删除" data-index="'+ i +'">删除</a><br />' +
						'<img id="uploadImage_' + i + '" src="' + e.target.result + '" class="upload_image" /></p>'+ 
					'</div>';
					
					i++;
					funAppendImage();
				}
				reader.readAsDataURL(file);
			} else {
				$("#preview").html(html);
				if (html) {
					//删除方法
					$(".upload_delete").click(function() {
						ZXXFILE.funDeleteFile(files[parseInt($(this).attr("data-index"))]);
						return false;	
					});
					//提交按钮显示
					$("#fileSubmit").show();	
				} else {
					//提交按钮隐藏
					$("#fileSubmit").hide();	
				}
			}
		};
		funAppendImage();		
	},
	onDelete: function(file) {
		$("#uploadList_" + file.index).fadeOut();
	}
};
ZXXFILE = $.extend(ZXXFILE, params);
ZXXFILE.init();
</script> 
	</body>
</html>