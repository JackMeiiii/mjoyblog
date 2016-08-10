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
	        {field:'writeDate',title:'发表时间',width:50,align:'center'},
	        {field:'exist',title:'操作',width:50,align:'center',
				formatter: function(value,row,index){
					var del = '<a href="#" onclick="deleteEssay(\''
								+ row.articleId + ',' + row.articleTitle 
								+ '\')">删除</a>'; 
					return del;
				}	
			 }
	    ]]    
	});
}


function deleteEssay(essay){
	$.confirm({
		icon: 'fa fa-warning',
		columnClass: 'col-md-2 col-md-offset-2',
	    title: '删除警告！！！',
	    content: '确认删除？？？此删除操作不可逆！！！',
	    confirmButton: '确认',
		cancelButton: '取消',
		autoClose: 'cancel|6000',
	    confirm: function(){
	        /*alert('已删除!');*/
	    	var arr=new Array();
	    	arr=essay.split(',');//注split可以用字符或字符串分割
	    	var eid = arr[0];
	    	$.ajax({
	    		type: "POST",
	    		url: "${ctx}/admin/deleteBlogEssay", //EssayController 缺少删除方法
	    		data: { articleId: eid },
	    		error:function(){
	    			alert("删除失败！！！")
	    		},
	    		success: function(){
	    			query();
	    		}
	    	});
	    },
	    cancel: function(){}
	});
}

</script>
<title>文章删除</title>
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