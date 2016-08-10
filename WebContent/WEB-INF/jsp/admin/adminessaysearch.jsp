<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/inc/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/themes/icon.css" />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style/js/jquery-confirm/css/jquery-confirm.css" />

	
<script src="<%=request.getContextPath() %>/style/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/style/js/jquery-migrate-1.2.1.min.js" type="text/javascript" charset="utf-8"></script>

<script src="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=request.getContextPath() %>/style/js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>

<script src="<%=request.getContextPath() %>/style/js/jquery-confirm/js/jquery-confirm.js" type="text/javascript" charset="utf-8"></script>

<script  type="text/javascript">
$(function(){
	query();
})

function query(){
	$('#dg').datagrid({    
	    url:'${ctx}/admin/findBlogEssayByKeywords', 
	    method:'post',//默认为post
	    fitColumns:true,
	    resizeHandle:'right',
	    striped:true,
	    nowrap:true,
	    pagination:true,
	    rownumbers:true,
	    idField:'articleId',
	    scrollbarSize:10,
	    singleSelect:true,
	    /* 传参数 */
	    queryParams: {
	    	keywords: $('#keywords').val()
		}, /* */
	    columns:[[
	        {field:'articleId',title:'id',hidden:true},    
	        {field:'articleTitle',title:'标题',width:80,align:'center'},    
	        {field:'articleContent',title:'内容',width:200,align:'center'},    
	        {field:'writeDate',title:'发表时间',width:50,align:'center'} 
	    ]]    
	});
}

</script>

<title>文章检索</title>
</head>
<body>
<div class="easyui-panel" id="topPanel">
		<form id="queryForm">
			<div style="height: 50px; line-height: 50px">
				<label>博文检索:</label>
				<input type="text" id="keywords" name="keywords" placeholder="请输入关键字" />
				&nbsp;
				<a onclick="query()" class="easyui-linkbutton  btn btn-primary" data-options="iconCls:'icon-search'">查   询</a> 
			</div>
		</form>
	</div>
	<table id="dg"></table> 
</body>
</html>