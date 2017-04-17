<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<jsp:include page="../site/head.jsp" />
<title>登录-成都信息工程大学二手交易</title>
<link href="../src/css/sign.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../site/header.jsp" flush="true" />
	<%--<%if(request.getAttribute("isRegister")!=null){--%>
<%--out.print("<div class=\"alert alert-success\" role=\"alert\">注册成功，现在你可以登录</div>");--%>
<%--}--%>
<%--%>--%>

	<%--<%if(request.getAttribute("isLoginOk")!=null && request.getAttribute("isLoginOk").equals("false")){--%>
<%--out.print("<div class=\"alert alert-danger\" role=\"alert\">登录失败，请检查邮箱和密码</div>");--%>
<%--}--%>
<%--%>--%>

	<%--<%if(request.getParameter("login-info")!=null){--%>
		 <%--String loginInfo=new String(request.getParameter("login-info").getBytes("UTF-8"),"UTF-8");--%>
<%--out.print("<div class=\"alert alert-danger\" role=\"alert\">"+loginInfo+"</div>");--%>
<%--}--%>
<%--%>--%>
	<div class="container">
		<form class="form-signin" action="/login.action" Method="Post">
			<h8 class="form-signin-heading">${changePresonalPWDScucess}</h8>
			<h2 class="form-signin-heading">登录网站</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" class="form-control" name="inputEmail" placeholder="邮箱地址" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" name="inputPassword" placeholder="密码" required>
			<label for="inputPassword" class="col-sm-9 control-label">${loginReult}</label>
			<input style="width: 150px;height:40px;"type="text" id="validateCode" name="validateCode" placeholder="验证码" required>
			&nbsp&nbsp<img style="width: 65px;" src="/validateCodeServlet" alt="验证码" align="button" >&nbsp&nbsp&nbsp<a>换一张</a>
			<label for="validateCode" class="col-sm-9 control-label">${validateCodeResult}</label>


			<div class="checkbox">
				<label> <input type="checkbox" name="auto_login">下次自动登录 </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
	<!-- /container -->
	<%--<jsp:include page="../site/footer.jsp" />--%>
</body>
</html>