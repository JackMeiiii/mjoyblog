<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Editor</title>
<link
	href="<%=request.getContextPath() %>/style/css/editor/font-awesome.min.css"
	type="text/css" rel="stylesheet" />
<link
	href="<%=request.getContextPath() %>/style/css/editor/pure_editor.scss"
	type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="<%=request.getContextPath() %>/style/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/style/js/editor/editor.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath() %>/style/js/editor/knockout-min.js"></script>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
</head>
<body>
	<div id="main">
		<div id="controls" class="cat_controls">
			<div class="cmds" id="cat_cmds">
				<a href="" class="goBack">Back</a><a id="create_post" class="create_post" data-bind="click: open_new_window" href="#">New
					Post</a>
			</div>
			<ul id="posts" data-bind="foreach: posts" class="posts"
				name="cat_posts">
				<c:forEach items="${cdatas }" var="catalog">
					<li name="catList"><a
						data-bind="click: edit, event:{touchend: edit}" href=""
						class="post" id="cat_post"> <span data-bind="text: title"
							class="catalogId">${catalog.catalogId }</span> <span
							data-bind="click: remove" class="remove">x</span>
					</a></li>
				</c:forEach>
				<div id="cat_save" class="cat_save">
					<a id="save" data-bind="click: open_new_window" href="#" class="">Save</a>
				</div>
			</ul>
		</div>
		<jsp:include page="/WEB-INF/jsp/admin/articleContent.jsp"></jsp:include>
		<div id="article_controls" class="article_controls">
			<div class="art_cmds" id="art_cmds">
				<a id="create_post" data-bind="click: open_new_window" href="#">New
					Article </a>
			</div>
			<ul id="posts" data-bind="foreach: posts" class="posts"
				name="art_posts">
				<c:forEach items="${adatas }" var="each">
					<li name="artList" class="art_list"><a
						data-bind="click: edit, event:{touchend: edit}" href="#"
						class="post" id="art_post"> <span data-bind="text: title" class="each_art_title">${each.articleTitle }</span>
							<span data-bind="click: remove" class="remove">x</span>
					</a></li>
				</c:forEach>
				<div class="art_save" id="art_save">
					<a class="save" data-bind="click: open_new_window" href="#">Save</a>
				</div>
			</ul>
		</div>
	</div>
</body>
</html>