<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/themes/icon.css" />
	<script src="<%=request.getContextPath() %>/style/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/style/js/jquery-migrate-1.2.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<style type="text/css">
*{
	margin: 0px;
	padding: 0px;
}
ul li{
	margin:10px 0px;
	list-style: none;
	height: 30px;
	line-height: 30px;
	text-align: center;
}
ul li :HOVER{
	background-color: #ccc;
}

a{	
	display:block;
	font-size:20px;
	text-align: center;
	text-decoration: none;
}

</style>
<body class="easyui-layout">   
   
    <div data-options="region:'north',split:false,border:false,collapsible:false" style="height: 80px;background-color: #FFFAF0;">
		<h1 style="font-size: 25px;line-height: 80px;display: inline-block;margin-left: 20px" >个人博客系统后台管理系统</h1>
		<span style="float: right; margin-right: 20px;margin-top: 50px">
		您好：${admin.adminname }
		&nbsp;&nbsp;
		今天是：<% out.print((new SimpleDateFormat("yyyy年MM月dd日")).format(new Date()));%>
		</span>
	</div>  
   
    <div data-options="region:'west',title:'快捷菜单',split:false" style="width:200px;">
    	<div class="easyui-accordion">
			<div title="用户管理 " style="overflow:auto;padding:10px;">
				<ul>
					<li><a href="<%=request.getContextPath() %>/admin/usersearch" target="mainFrame">查看用户</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/userdelete" target="mainFrame">删除用户</a></li>
				</ul>
			</div>
			<div title="文章管理" style="padding:10px;">
				<ul>
					<li><a href="<%=request.getContextPath() %>/admin/essaysearch" target="mainFrame">文章检索</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/essaydelete" target="mainFrame">文章删除</a></li>
				</ul>
			</div>
		</div>
    </div>   
   
	<div data-options="region:'center',title:'博客管理'" style="padding:5px;background:#eee;">
		<iframe name="mainFrame" id="mainFrame" src="<%=request.getContextPath() %>/admin/usersearch" scrolling="no" frameborder="none" style="width: 100%; height: 100%" onload="this.height=this.contentWindow.document.documentElement.scrollHeight">
			
		</iframe>
	</div>  
   
    <div data-options="region:'south',split:false" style="height:60px;">
			<div id="" style="text-align: center;font-size: 18px;margin-top: 18px;">
				copyright@科大讯飞
			</div>
	</div>   
</body>  


</html>