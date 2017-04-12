<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
 <jsp:include page="site/head.jsp" />
<title>物品交易-成都信息工程大学-首页</title>
</head>
<body>
	<jsp:include page="site/header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="row">
					<div class="col-md-12">
						<div class="list-group">
							<span class="list-group-item list-group-item-info">分类</span>
							<%! int ceta=0; %>
                            <%
                                if(request.getAttribute("returnCeta") != null)
                                {
                                    ceta = (int) request.getAttribute("returnCeta");
                                }
                            %>
							<a href="indexController.action?ceta=0" class="list-group-item <%=ceta==0?"active":"" %>"><span class="badge"><!-- 这里写数量，暂时搁置 --></span>全部</a>
							<a href="indexController.action?ceta=2" class="list-group-item <%=ceta==2?"active":"" %>"><span class="badge"></span>生活出行</a>
							<a href="indexController.action?ceta=1" class="list-group-item <%=ceta==1?"active":"" %>"><span class="badge"></span>书籍</a>
							<a href="indexController.action?ceta=5" class="list-group-item <%=ceta==5?"active":"" %>"><span class="badge"></span>体育运动</a>
							<a href="indexController.action?ceta=4" class="list-group-item <%=ceta==4?"active":"" %>"><span class="badge"></span>电子产品</a>
							<a href="indexController.action?ceta=3" class="list-group-item <%=ceta==3?"active":"" %>"><span class="badge"></span>衣物鞋包</a>
							<a href="indexController.action?ceta=6" class="list-group-item <%=ceta==6?"active":"" %>"><span class="badge"></span>其他</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="list-group">
                    <!-- 用来判断用户选择的分类并显示在商品显示栏的左上角 -->
                    <%! String type="全部"; %>
                    <%
                        if(request.getAttribute("type") != null)
                        {
                            type = (String) request.getAttribute("type");
                        }
                    %>
					<span class="list-group-item list-group-item-info">分类-<%= type%></span>
                    <c:forEach items="${goodsItems}" var="item">
			    	<div class="list-group-item">
						<div class="row">
							<div class="goods-img col-md-2">
								<img class="img-rounded img-item-goods"
									src="${item.image}" />
							</div>
							<div class="col-md-10">
								<div class="row detail-goods lead">
									<a href="showGoods.action?goodsid=${item.id}">${item.name}</a>
								</div>
								<div class="row detail-goods">￥<span class="text-danger">${item.price}</span>
									<span class="detail-goods text-muted">　发布者:${item.userName} </span>
									<span class="detail-goods text-muted">　时间：<fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></span>
								</div>
                                <div class="row detail-goods">
                                    <span class="detail-decription">${item.content}</span>
                                </div>
							</div>
						</div>
			    	</div>
                    </c:forEach>
			    	<%--<%--%>
			    	  <%--}--%>
			     	 <%--}else{%>--%>
					<div class="list-group-item">
					此分类下暂无物品或页数已经到达最大！
					</div>
					<%--<%}%>--%>
				</div>
				<%--<%--%>
				<%--int maxPage=num.value%perPage==0?num.value/perPage:num.value/perPage+1;--%>
				<%--%>--%>
				<%--<nav>--%>
				  <%--<ul class="pager">--%>
					<%--<li class=""><a class="page-cut-btn" href="index.jsp?ceta=<%=ceta%>&pn=<%=pn<=1?pn:pn-1%>"><span aria-hidden="true"></span><%=pn>1?"上一页":"位于首页"%></a></li>--%>
					<%--<li style=""><span style="border:0">    　　第<span style="color:red;border:0"><%=pn %></span>页　　</span></li>--%>
					<%--<li class=""><a class="page-cut-btn" href="index.jsp?ceta=<%=ceta%>&pn=<%=pn<maxPage?pn+1:pn%>"><%=pn<maxPage?"下一页":"位于末页"%> <span aria-hidden="true"></span></a></li>--%>
				  <%--</ul>--%>
				<%--</nav>--%>
			</div>
		</div>  
	</div>
	<%-- <jsp:include page="site/footer.jsp" / --%>
</body>
</html>
