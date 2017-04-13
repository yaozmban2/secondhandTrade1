<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="/site/head.jsp" />
<title>注册-成都信息工程大学二手交易</title>
<link href="../src/css/sign.css" rel="stylesheet">

</head>

<body>
	<jsp:include page="/site/header.jsp" flush="true" />

	<div class="alert alert-danger" role="alert">
	</div>

	<div class="container">
		<div class="xt_mid">

			<!--提交此form 注册 -->
			<form action="/register.action" method="post" class="form-horizontal">
				<h2 class="form-signin-heading">注册账号</h2>
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-7">
						<input type="email" class="form-control" id="email" value="${registerUser.email}"
							name="email" placeholder="">
					</div>
					<label for="email" class="col-sm-5 control-label">${emailReult}</label>
				</div>
				<div class="form-group">
					<label for="pwd" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="pwd"
							name="pwd" placeholder="请设置为六位以上">
					</div>
					<label for="pwd" class="col-sm-4 control-label">${pwdResult}</label>
				</div>

				<div class="form-group">
					<label for="validatePwd" class="col-sm-2 control-label">密码重复</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="validatePwd"
							name="validatePwd" placeholder="">
					</div>
					<label for="validatePwd" class="col-sm-5 control-label">${pwdValidateResult}</label>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">名字</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="name" name="name" value="${registerUser.name}"
							placeholder="请填写真实姓名">
					</div>
					<label for="name" class="col-sm-4 control-label">${nameResult}</label>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="validateCode" name="validateCode"
							   placeholder="请填写验证码">
					</div>
					<div class="col-sm-2">
						<img src="/validateCodeServlet" alt="验证码" align="button">
					</div><a>换一张</a>
					<label for="name" class="col-sm-9 control-label">${validateCodeResult}</label>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10" style="text-align: left;">
						同意注册说明您已阅读<a href="user/agreement.jsp" target="_blank">《用户协议》</a>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-6">
						<button type="submit" class="btn btn-block btn-primary">注册</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /container -->
	<%--<jsp:include page="../site/footer.jsp" />--%>
</body>
</html>