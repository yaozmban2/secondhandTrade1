<%/*
物品详情页，包含详情和操作按钮
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../site/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>物品详情</title>
<script type="text/javascript">
function toLogin(isLogin){
	if(!isLogin)
	{
		window.location.href="user/login.jsp?login-info="+"请先登录";
	}
}
function collect(goodsId){
   collectRequest=new XMLHttpRequest();
   collectRequest.onreadystatechange=function()
      {
      if (( collectRequest.readyState==4)&&( collectRequest.status==200))
        {
        if( collectRequest.responseText=="success")
            {
            document.getElementById("collectButton").innerHTML="==已收藏==";
            }
        }
      }
   collectRequest.open("GET","CollectServlet?goodsId="+goodsId+"&t="+Math.random(),true);
   collectRequest.send();
}
function shoppingCart(isLogin,goodsNum,goodsId){

if(isLogin){
	xmlShop=new XMLHttpRequest();
	xmlShop.onreadystatechange=function()
	  {
	  if ((xmlShop.readyState==4)&&(xmlShop.status==200))
	    {
	    if(xmlShop.responseText=="success")
	    	{
	    	document.getElementById("goodsNum").innerHTML=(parseInt(document.getElementById("goodsNum").innerHTML)+1).toString(); 		
	    	document.getElementById("addCastButton").innerHTML="已加入购物车";
	    	}else{
	    		document.getElementById("addCastButton").innerHTML="错误，你可能重复添加了！";
	    	}
	    }
	  }
	xmlShop.open("GET","ShoppingCartServlet?goodsId="+goodsId+"&t="+Math.random(),true);
	xmlShop.send();
		}else{
			window.location.href="user/login.jsp?login-info="+"请先登录";
		}
	}

</script>
</head>
<body>
	<jsp:include page="../site/header.jsp" flush="true" />

	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-info">
					<div class="panel-heading">
						<span style="text-align:center;font-size:16px;" class="center-block">物品详情</span>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-md-5">
								<img title="右键查看原图" class="info-img" src="${goods.image}">
							</div>
							<div class="col-md-7 info-goods">
								<p>
								<h3 class="info-goods-name"></h3>
								<p>
								${goods.name}
								</p>
								<p>
									<br />类型：<a target="_blank" href="indexController.action?ceta=${goods.typeId}">${goodsType}</a><br />
									<br />
								</p>
								<p>
									            价格：${goods.price}<br />
									<br />
								</p>
								
								
								<p>
									发布者：
									<a target="_blank" href="user/personal.jsp?tab=info&userid">${goods.userName}</a>
										(联系:<a href="mailto:">123456@qq.com</a>
									或
									<a target="_blank" href="user/personal.jsp?tab=mess&handle=write&toemail=%20==>%20">站内信</a>)
									<br /> <br />
								</p>
								<p>
									发布时间：${goods.createDate}
									<br /> <br />
								</p>
								<p class="info-goods-content">
									物品说明：${goods.content} <%-- =good.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br />") --%>
								</p>
							</div>
						</div>
						<!-- 确认购买区域 -->
						<script type="text/javascript">
						$(document).ready(function(){
						  $("#buy").click(function(){
						  $(".buy-confirm").show(200);
						  });
						});
						</script>
						<div style="display:none;" class="buy-confirm">
						<hr />
						<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="panel panel-info">
								<div class="panel-heading">
								<span class="center-block" style="text-align:center;font-size:15px;">确定购买</span>
								</div>
								<div class="panel-body">
								<p>
								请输入给卖家的附加消息，然后点击 "确定" 按钮，我们将会通知卖家。
								</p>
								
								<form action="OrderCheckServlet?goodsid=&userid=" method="post">
								  <div class="form-group">
								    <textarea class="form-control" name="message-to-seller" id="message-to-seller"></textarea>
								  </div>
								  <button type="submit" class="pull-left btn btn-default">确认购买</button>
								</form>
								
								</div>
							</div>
						</div>
						</div>
						</div>
						<!-- end of 确认购买区域 -->
						
						<!-- 提示消息 -->
						<%
						if(request.getParameter("info")!=null){
						%>
						<div class="alert alert-warning"><%=request.getParameter("info") %></div>
						<%}%>
						
						<hr />
						<div class="row">
							<div class="col-md-4">
								<button id="collectButton" onclick="collect()" type="button" class="center-block btn btn-default">收藏此物品</button>
							</div>
							<div class="col-md-4">
							</div>
							<div class="col-md-4">
								<button  id="buy" type="button" class="center-block btn btn-default" onclick="toLogin()">
								购买
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%--<jsp:include page="../site/footer.jsp" />--%>
</body>
</html>
