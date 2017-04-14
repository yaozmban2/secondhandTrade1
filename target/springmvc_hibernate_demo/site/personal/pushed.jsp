<%/*
已发布的商品页，被/personal.jsp包含
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isThreadSafe="false"%>

<div class="panel panel-info">
	<div class="panel-heading">
        我的商品
	</div>
	<div class="panel-body">
    <%--<%--%>
    <%--if(list.size()>0){--%>
    <%--%>--%>
        <div class="list-group">
    <%--<% for(Goods good:list){ %>--%>
            <div class="list-group-item">
                <div class="row">
                    <div class="goods-img col-md-2">
                        <img class="img-rounded img-item-goods" src="" />
                    </div>
                    <div class="col-md-10">
                        <div class="row detail-goods lead">
                            <span class="label label-">
                                出售中
                            </span>
                            <a href="goods/info.jsp?goodsid=">商品1</a>
                        </div>
                        <div class="row detail-goods">￥<span class="text-danger">20</span>
                            <span class="detail-goods text-muted">　发布者:张伟 </span>
                            <span class="detail-goods text-muted">　时间：2017/7/2 </span>
                        </div>
                    </div>
                </div>
            </div>
    <%--<%}%>               --%>
    <%--<%}else{%>--%>
    还没有发布的物品
    <%--<%}%>--%>
        </div>
	</div>
</div>
