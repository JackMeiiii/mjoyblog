<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${blog_name}</title>
<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
</head>
<body>
	<div class="main pure-g">
		<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
		<div class="pure-u-3-4">
			<div class="c1 ph-500 mg">
				<!--内容-->
				<div class="content">
					<c:forEach items="${datas}" var="data">
						<div class="category">
							<a href="/MJoyBlog/category/${data.key }">
							<h3>${data.key }</h3> 
							  <span> 
								<c:choose>
									<c:when test="${data.value==1 }">
				  		            ${data.value } post
				  					</c:when>
									<c:otherwise>
				  		            ${data.value } posts
				  					</c:otherwise>
								</c:choose>
							  </span>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="pure-u-1-4">
			<div class="c2 ph-200 mg">
				<div class="c3 ph-200 mg">
					<input type="text" class="search" placeholder="Search">
					<div class="catalog">
						<span class="catalogName">目录</span>
					</div>
					<ul>
						<c:forEach items="${catList}" var="catalog">
							<li class="catalogURL" name="catalogURL"><a
								href="${catalog.catalogPath }" title="${catalog.catalogId }">${catalog.catalogId }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="c2 ph-300 mg"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var regExp = /[a-z]$/;
		$(".category a").each(
				function() {
					var value = $(this).children('h3').text();
					if (!regExp.test(value)) {
						$(this).attr("href",
								"/MJoyBlog/category/" + base64_encode(value));
					}
				})
		$(".category").eq(0).siblings().css("margin-left", "20px");
		$(".search").keydown(
				function(event) {
					if (event.keyCode == 13) {
						var searchText = $(".search").val();
						if (searchText == null || searchText == ""
								|| searchText.length == 0) {
							window.location = _path;
						} else {
							window.location = _path + "/index.do?s="
									+ base64_encode(searchText);
						}
					}
				});
		$('.blog_name').click(function() {
			window.location = _path;
		})
	});
</script>
</html>