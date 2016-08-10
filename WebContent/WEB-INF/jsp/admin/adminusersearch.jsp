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
	    url:'${ctx}/admin/findBlogUserList', 
	    method:'post',//默认为post
	    fitColumns:true,
	    resizeHandle:'right',
	    striped:true,
	    nowrap:true,
	    pagination:true,
	    rownumbers:true,
	    idField:'loginName',
	    scrollbarSize:10,
	    singleSelect:true,
	    /* 传参数 */
	    queryParams: {
	    	email: $('#useremail').val(),
		}, /* */
	    columns:[[
	        {field:'loginName',title:'用户名',width:50,align:'center'},    
	        {field:'sex',title:'性别',width:50,align:'center',
	        	formatter: function(value,row,index){
					if (value==0){
						return '女';
					} else {
						return '男';
					}
				}
	        },    
	        /* {field:'bornDate',title:'出生日期',width:100,align:'center'},  */
	        {field:'email',title:'邮箱',width:100,align:'center'}
	        /* {field:'createDate',title:'注册时间',width:80,align:'center'}   */ 
	    ]]    
	});
}
</script>

<title>管理员</title>
</head>
<body>
	<div class="easyui-panel" id="topPanel">
		<form id="queryForm">
			<div style="height: 50px; line-height: 50px">
				<label>查询用户:</label>
				<input type="text" id="useremail" name="useremail" placeholder="请输入用户邮箱" />
				&nbsp;
				<a onclick="query()" class="easyui-linkbutton  btn btn-primary" data-options="iconCls:'icon-search'">查   询</a> 
			</div>
		</form>
	</div>
	<table id="dg"></table> 
</body>
</html>