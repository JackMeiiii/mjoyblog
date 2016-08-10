<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="pure-u-1 ph-150 mg">
	<a class="writerArticle" href="/MJoyBlog/admin/editor">在线写一篇</a>
	<div class="blog_name">${blog_name }</div>
	<div class="space">
		<c:choose> 
			<c:when test="${selected=='archive'}">
				<a class="archive cut_bottom" href="/MJoyBlog/archive">归档</a>
				<a class="categories" href="/MJoyBlog/categories">分类</a>
				<a class="all_blogs" href="/MJoyBlog/index.do">博客</a>
			</c:when>
			<c:when test="${selected=='categories'}">
				<a class="archive" href="/MJoyBlog/archive">归档</a>
				<a class="categories cut_bottom" href="/MJoyBlog/categories">分类</a>
				<a class="all_blogs" href="/MJoyBlog/index.do">博客</a>
			</c:when>
			<c:when test="${selected=='search'}">
				<a class="archive" href="/MJoyBlog/archive">归档</a>
				<a class="categories" href="/MJoyBlog/categories">分类</a>
				<a class="all_blogs" href="/MJoyBlog/index.do">博客</a>
			</c:when>
			<c:otherwise>
				<a class="archive" href="/MJoyBlog/archive">归档</a>
				<a class="categories" href="/MJoyBlog/categories">分类</a>
				<a class="all_blogs cut_bottom" href="/MJoyBlog/index.do">博客</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>