<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../site/head.jsp" />
<title>用户中心</title>
</head>
<body>
	<jsp:include page="../site/header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="row">
					<div class="col-md-12">
						<div class="list-group">
							<div class="list-group-item personal-main-info">
								<img class="img-rounded img-personal-main-info" src="/pic${user.img}" />
								<div class="row detail-goods text-muted">姓名：${user.name}</div>
								<div class="row detail-goods text-muted">邮箱：${user.email}</div>
							</div>
							<% String flag = (String) request.getAttribute("flag"); %>
							<a href="/showPersonal.action?flag=personalMSSG" class="list-group-item <%=flag.equals("personalMSSG")?"active":"" %>">个人信息</a>
							<a href="/showMessageInfo.action" class="list-group-item <%=flag.equals("correspondMSSG")?"active":"" %>">站内消息</a>
							<a href="/showPersonal.action?flag=releaseGoods" class="list-group-item <%=flag.equals("releaseGoods")?"active":"" %>">发布商品</a>
							<a href="/showMyReleaseGoods.action" class="list-group-item <%=flag.equals("myRelaaseGoodsInfo")?"active":"" %>">我的商品</a>
							<a href="/showPersonal.action?flag=myCollectGoodsInfo" class="list-group-item <%=flag.equals("myCollectGoodsInfo")?"active":"" %>">收藏夹 </a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<%if(flag.equals("releaseGoods")){%>
				<jsp:include page="../site/personal/push.jsp" />
				<%}else if(flag.equals("personalMSSG")){%>
				<jsp:include page="../site/personal/info.jsp" />
				<%}else if(flag.equals("myCollectGoodsInfo")){%>
				<jsp:include page="../site/personal/like.jsp" />
				<%}else if(flag.equals("correspondMSSG")){%>
				<jsp:include page="../site/personal/mess.jsp" />
				<%}else if(flag.equals("myRelaaseGoodsInfo")){%>
				<jsp:include page="../site/personal/pushed.jsp" />
				<%}else if(flag.equals("shoppingCart")){%>
				<jsp:include page="../site/personal/shopcart.jsp" />
				<% } %>
			</div>
		</div>
	</div>
	<%--<!-- <jsp:include page="../site" /> -->--%>
</body>
</html>