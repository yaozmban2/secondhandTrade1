<%@ page import="org.hibernate.Session" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%/*
已发布的商品页，被/personal.jsp包含
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isThreadSafe="false"%>



<div class="panel panel-info">
	<div class="panel-heading">
        我的商品
	</div>
	<div class="panel-body">
        <div class="list-group" id="has_goods">
            <c:forEach items="${myReleaseGoodsItems}" var="item" >
                <div class="list-group-item">
                    <div class="row">
                        <div class="goods-img col-md-2">
                            <img class="img-rounded img-item-goods" src="/pic${item.image}" />
                        </div>
                        <div class="col-md-7">
                            <div class="row detail-goods lead">
                                <span class="label label-info" >
                                    <c:if test="${item.status == 1}">
                                    已付款
                                    </c:if><c:if test="${item.status == 2}" >
                                    出售中
                                    </c:if><c:if test="${item.status == 3}" >
                                    下架中
                                    </c:if><c:if test="${item.status == 4}" >
                                    已成交
                                </c:if>
                                </span>
                                <a href="goods/info.jsp?goodsid=">${item.name}</a>
                            </div>
                            <div class="row detail-goods">￥<span class="text-danger">${item.price}</span>
                                <span class="detail-goods text-muted">　发布者:${item.userName} </span>
                                <span class="detail-goods text-muted">　时间：${item.createDate} </span>
                            </div>
                            <div class="row detail-goods">
                                <span class="detail-decription">${item.content}</span>
                            </div>
                        </div>
                        <c:if test="${item.status == 1}">
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>卖家地址</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>已经送到</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>取消交易</span></a></div>
                            </div>
                        </c:if>
                        <c:if test="${item.status == 2}">
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>修改</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>下架</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>删除</span></a></div>
                            </div>
                        </c:if>
                        <c:if test="${item.status == 3}">
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>修改</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>上架</span></a></div>
                            </div>
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>删除</span></a></div>
                            </div>
                        </c:if>
                        <c:if test="${item.status == 4}">
                            <div class="col-md-2">
                                <div class="row detail-goods lead"><a href="#" class="button button-khaki"><span>删除</span></a></div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            <nav>
                <ul class="pager">
                    <li class=""><a id="up_page" class="page-cut-btn" href="/showMyReleaseGoodsUp.action"><span aria-hidden="true"></span>上一页</a></li>
                    <li style=""><span style="border:0">    　　第<span style="color:red;border:0">${pageNum}</span>页　　</span></li>
                    <li class=""><a id="last_page" class="page-cut-btn" href="/showMyReleaseGoodsNext.action">下一页<span aria-hidden="true"></span></a></li>
                    <li class="" id="last_page_mess"></li>
                </ul>
            </nav>
        </div>
	</div>
</div>

<script>
    var rPageNum = <%= (int)request.getAttribute("rPageNum") %>;
    var isLastPage = <%= request.getAttribute("isLastPage") %>;
    var hasGoods = <%= request.getAttribute("hasGoods") %>;
    var changeLink = document.getElementById('up_page');
    var lastLink = document.getElementById('last_page');
    var hasGoodsTX = document.getElementById('has_goods');

    //将link标签中的href移除，设置为不可点击
    function delLink(link) {
        //link.disabled = true;
        link.setAttribute("disabled",true);
        link.removeAttribute('href');
    }

    if(rPageNum === 1) {
        delLink(changeLink);
    }
    if(isLastPage === true) {
        delLink(document.getElementById('last_page'));
        document.getElementById('last_page_mess').innerHTML = '已经是最后一页';
    }
    if(hasGoods === false) {
        delLink(lastLink);
        delLink(changeLink);
        hasGoodsTX.innerHTML = '您还未发布商品';
    }
</script>