<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/taglibs.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
<style type="text/css">	
      .row{
      	background-repeat: no-repeat;
      	margin-top: 120px;
      	margin-left: 200px;
      	height: 540px;
      	width: 1020px;
      } 	
</style>

</head>
<body>
<div class="row" style="background-image: url(${ctx}/style/img/1-15010QH319596.jpg)">
		<form action="${ctx}/admin/checkLogin" method="post" style="margin-top:280px; margin-left:520px ;">
			<label>用户名：</label>
			<input type="text" name="adminemail" id="adminemail" /><br />
			<label style="margin-top: 20px;">密&nbsp;&nbsp;&nbsp;码：</label>
			<input type="password" name="adminpassword" id="adminpassword"/><br />
			<button id="sunmitBtn" class="btn btn-info"  style="margin-left: 20px;margin-top: 20px;">登录</button>
			<button class="btn btn-info" type="reset" style="margin-left: 20px;margin-top: 20px;"/>取消</button>
		</form>
</div>	
</body>
</html>