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
						 ${data.key}
						<ul>
						 <c:forEach items="${data.value}" var="catInfo">
							<li class="catInfo" name="catInfo">${catInfo.createDate }    <a href="${catInfo.catalogPath }" title="${catInfo.catalogId }">${catInfo.catalogId }</a></li>
						</c:forEach>
						</ul>
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
		$(".search").keydown(function(event){
			if(event.keyCode == 13){
			var searchText = $(".search").val();
			if(searchText==null||searchText==""||searchText.length==0){
				window.location=_path;
			}
			else{
				window.location=_path+"/index.do?s="+base64_encode(searchText);
			}
		  }
		});
	 	$('.blog_name').click(function(){
	 		window.location=_path;
	 	})
	});
</script>
</html>