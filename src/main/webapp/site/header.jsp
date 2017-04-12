
<%/*
导航栏
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<nav class="navbar navbar-default">
<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="indexController.action?ceta=0"
			style="font-size: 24px">成都信息工程大学物品交易网</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
		</ul>
		<form action="search.jsp" class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" name="key" class="form-control" placeholder="关键字">
			</div>
			<button type="submit" class="btn btn-default">查找物品</button>
		</form>

		<ul class="nav navbar-nav navbar-right">

			<li><a href="user/personal.jsp?tab=shopcart&userid=">购物车(<span style="color: #d00;"
					id="goodsNum"></span>)</a></li>
			<li><a href="user/personal.jsp?tab=mess&userid=">消息(<span id="mess-number" style="color: #e00;"
					id="messNum"></span>)</a></li>
			<li class="dropdown"><a href="javascript:void(0)"
				class="dropdown-toggle" data-toggle="dropdown" role="button"
				aria-haspopup="true" aria-expanded="false"><span
					class="caret"></span> </a>
				<%--<ul class="dropdown-menu">--%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=info">个人中心</a></li>--%>
					<%--<%if(LoginVerify.isAdmin(request)){%>--%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=auditing">物品审核</a></li>--%>
					<%--<%}%>--%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=history">购买历史</a></li>--%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=push">发布物品</a></li>--%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=like">收藏夹</a></li>--%>
					<%--<!-- 并不需要设置页 --%>
					<%--<li><a href="<%=basePath %>user/personal.jsp?userid=<%=user.getId()%>&tab=setting">设置</a></li>--%>
					<%---->--%>
					<%--<li><a href="<%=basePath %>ExitLoginServlet">退出登录</a></li>--%>
				<%--</ul>--%>
			</li>
			<li><a href="user/login.jsp">登录</a></li>
			<li><a href="user/register.jsp">注册</a></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container-fluid --> </nav>
