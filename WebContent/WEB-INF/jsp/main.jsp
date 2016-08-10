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
<body id="body">
	<div class="main pure-g">
		<jsp:include page="/WEB-INF/jsp/common/top.jsp"></jsp:include>
		<div class="pure-u-3-4">
			<div class="c1 ph-500 mg">
				<!--内容-->
				<div class="content">
					<c:choose>
						<c:when test="${status==0 }">
							<c:forEach items="${datas}" var="each">
								<div class="post-infos">
									<h2 class="post-title">
										<a href="${each.catalogPath }">${each.catalogId}</a>
									</h2>
									<div class="post-meta">${each.createDate}</div>
									<div class="post-content">
									<c:forEach items="${each.articles}" var="article">
										<li class="article" name="article">
										<a href="${article.articlePath }">${article.articleTitle }</a>
										</li>
				               		</c:forEach>
								</div>
							</div>
							</c:forEach>
						</c:when>
						<c:when test="${status==1 }">
							<div class="post">
										<c:forEach items="${artList }" var="article">
												<div class="articles" name="articles">
													<h2 class="post-title"><a class="article-title" name="article" href="${article.articlePath }">${article.articleTitle }</a>
													</h2>
													<div class="post-meta">${createDate}</div>
													<p class="post-article-content"> ${article.articleContent }</p>
												</div>
										</c:forEach>
							</div>
						</c:when>
						
						<c:when test="${status==6 }">
							<div class="articles" name="articles">
									<h2 class="post-title">
										<a class="articles" name="article"
											href="${articlePath }">${articleTitle }</a>
									</h2>
									<div class="post-meta">${createDate}</div>
									<p>${articleContent }</p>
							</div>
							<div id="fb_comments_container">
								<ul id="fb_comments">
									<c:forEach items="${comments }" var="comment">
										<div id="comment_title" class="comment_title">
											<div class="comment_username">${comment.username }</div>
											<div class="comment_content" id="comment_content"
												name="comment_content">${comment.content }</div>
										</div>
									</c:forEach>
								</ul>
								<div id="fb_new_comment">
									<form id="fb_new_comment" method="post"
										onsubmit="return check();" action="">
										<textarea name="content" id="content"></textarea>
										<div class="input_body">
											<ul>
												<li><label>Name:</label> <input type="text"
													name="username" id="username" value="" /></li>
												<li><label>Email:</label> <input type="text"
													name="email" id="email" value="" /></li>
												<li><label>Site:</label> <input type="text" id="site"
													name="site" value="" /></li>
												<li><input id="c_submit" type="submit" value="Comment"
													class="c_button" /></li>
											</ul>
										</div>
									</form>
								</div>
							</div>
						</c:when>
						<c:when test="${status==5 }">
							<div class="post">
								<h2 class="post-title">
									<a href="#">Hi, ${blog_name }</a>
								</h2>
								<div class="post-meta">${date }</div>
								<div class="post-content">
									<p>欢迎来到这里，等你的第一篇文章出现时，我就会消失。</p>
									<p>
										现在可以<a href="admin/editor" target="_blank">在线写一篇</a>,
									</p>
									<p>
									</p>
								</div>
							</div>
						</c:when>
						<c:when test="${status==2 }">
							<span class="searchText" id="searchText">搜索包含 <b>${searchVal }</b>
								的结果
							</span>
							<c:forEach items="${datas}" var="each">
							<div class="post">
									<c:forEach items="${each.articles}" var="article">
										<h2 class="post-title">
											<li class="article" name="article">${article.articleTitle }
											</li>
										</h2>
										<div class="post-meta">${each.createDate}</div>
				 	                     <p>${article.articleContent }</p>
				               		</c:forEach>
								</div>
							</div>
							</c:forEach>
						</c:when>
					</c:choose>
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
								href="${catalog.catalogPath } " title="${catalog.catalogId }">${catalog.catalogId }</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="c2 ph-300 mg"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
var submitCount =0;
	$(function() {
		var comment_content = $('.comment_content');
		$(document).keydown(
				function(event) {
					if (event.keyCode == 116) {
						if(getUrl().contains('post')){
							$('#content').val(
									comment_content.eq(comment_content.length - 1)
											.text());
							alert("内容重复不允许提交");
							return false;
						}
				}
		})

		$(".comment_title").each(function() {
			$(this).css({
				"padding-top" : "20px",
				"padding-bottom" : "30px",
				"border-bottom" : "solid #cfcfcf 1px",
				"width" : "100%"
			});
		})
		$(".search").keydown(
				function(event) {
					if (event.keyCode == 13) {
						var searchText = $(".search").val();
						if (searchText == null || searchText == ""
								|| searchText.length == 0) {
							window.location = _path;
						} else {
							window.location = _path + "/main.do?s="
									+ base64_encode(searchText);
						}
					}
				});
		$('.blog_name').click(function() {
			window.location = _path+"/index.do";
		})
		
	});
	function check() {
		if(submitCount == 0){
			var name = $('[name="username"]').val();
			var site = $('[name="site"]').val();
			var content = $('[name="content"]').val();
			var email = $('[name="email"]').val();
			var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
			$('name=["comment_content"]').each(function() {
				if ($(this).val() == content) {
					return false;
				}
			})
	
			if (!reg.test(email)) {
				alert("邮箱格式不正确，请重新输入");
				return false;
			} else if (site.length == 0 && name.length == 0 && content.length == 0) {
				alert("内容不能为空");
				return false;
			}
			submitCount+=1;
		}
		else{
			alert("请勿重复提交");
			$()
		}
	}
	
	function getUrl(){
		window.location.href;
	}

	/* function saveToLocal(){
		if($(".c_button").click(function(){
			$("#fb_comments").append("<div id='comment_title' class='comment_title'><div class='comment_username'></div><div class='comment_content' id='comment_content' name='comment_content'></div></div>");
			$("comment_title").text($('[name="username"]').val());
			$("comment_content").text($('[name="content"]').val());
		}))
		
	} */
</script>
</html>