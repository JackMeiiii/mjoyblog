<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${hello} - 后台管理</title>
	<jsp:include page="/WEB-INF/jsp/common/common.jsp"></jsp:include>
</head>
<body class="admin-body">
	<div class="main">
		<div class="login-div">
			<div class = "logo-div">
				<img class="logo-img" alt="MJoyBlog" src="<%=request.getContextPath()%>/style/img/logo.png">
			</div>
			<form class="pure-form" action="sign.do" method="POST" onsubmit="return check();">
				<fieldset class="pure-group">
					<input type="text" name="loginName" value="" class="pure-input-1" placeholder="请输入用户名" required oninvalid="setCustomValidity('请输入用户名');" oninput="setCustomValidity('');"/>
					<input type="text" name="loginPwd" value=""  class="pure-input-1" placeholder="请输入密码" required oninvalid="setCustomValidity('请输入密码');" oninput="setCustomValidity('');"/>
					<input type="text" name="pwdAgain" value=""  class="pure-input-1" placeholder="请再次输入密码" required oninvalid="setCustomValidity('请输入密码');" oninput="setCustomValidity('');"/>
					<input type="text" name="nickName" value=""  class="pure-input-1" placeholder="请输入昵称" required oninvalid="setCustomValidity('请输入昵称');" oninput="setCustomValidity('');"/>
					<input type="text" name="email" value=""  class="pure-input-1" placeholder="请输入邮箱" required oninvalid="setCustomValidity('请输入邮箱');" oninput="setCustomValidity('');"/>
					<input id = "autoLogin-ipt" type="hidden" name="autoLogin"/>
				</fieldset>
				<button type="submit" class="pure-button pure-input-1 pure-button-primary blog-sign">注&nbsp;&nbsp;&nbsp;册</button>
			</form>
		</div>
		<div class="footer-div"><p>- Powered By & Meihf -</p></div>
	</div>
</body>
<script type="text/javascript">
	$('#autoLogin').change(function(){
		$('#autoLogin-ipt').val($("input[name='autoLogin']:checked").length > 0);
	});
	$(function(){
		var errorMsg = "${errorMsg}";
		if (errorMsg.length != 0) {
			showTips(errorMsg, 340, 2);
		}
	})
	function check() {
		var name = $('[name="loginName"]').val();
		var pwd = $('[name="loginPwd"]').val();
		var nick = $('[name="nickName"]').val();
		var pwdAgain = $('[name="pwdAgain"]').val();
		var email = $('[name="email"]').val();
		var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		if (!reg.test(email)) {
			alert("邮箱格式不正确，请重新输入");
			return false;
		} else if (pwd.length == 0 && name.length == 0 && nick.length == 0) {
			alert("内容不能为空");
			return false;
		}
		else if(!pwd.equals(pwdAgain)){
			alert("两次密码不同，请重新输入");
			return false;
		}
	}
</script>
</html>