<%/*
购物车页面，被/personal.jsp包含，查找所有购物车内物品
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="panel panel-info">
	<div class="panel-heading">我的购物车</div>
	<div id="panel-body" class="panel-body">
		<div class="list-group">
	<%--<%--%>
	<%--if(list.size()!=0){--%>
	<%--String goodsIdList="";%>--%>
			<div id="list-goods">
				<div id="list-goods-" class="list-group-item">
					<div class="row">
						<div class="col-md-3">
							<img class="img-rounded img-item-goods" src="" />
						</div>
						<div class="col-md-9">
							<div class="row detail-goods lead">
								<div>
									<a href="goods/info.jsp?goodsid=</a>
									<button  type="button" onclick="shopcart_remove()" class="pull-right btn btn-success">移除</button>
								</div>
							</div>
							<div class="row detail-goods text-muted">价格:20 </div>
							<div class="row detail-goods text-muted">发布者:张三 </div>
							<div class="row detail-goods text-danger">时间：2013/03/02</div>
						</div>
					</div>
	    		</div>
			</div>
			<div>
				<button id ="buyAll"class="pull-right btn btn-success" onclick="buy_all()">购买全部</button>
			</div>
			购物车是空的！
			<div class="alert alert-success" role="alert"></div>
		</div>
	</div>
</div>

<script>
function shopcart_remove(goodsId){
	xmlRemove=new XMLHttpRequest();
	xmlRemove.onreadystatechange=function()
	{
	  if ((xmlRemove.readyState==4)&&(xmlRemove.status==200))
	    {
	    if(xmlRemove.responseText=="success")
	    	{
	    	cnode = document.getElementById("list-goods-"+goodsId);
	    	cnode.parentNode.removeChild(cnode); 	
	    	if(!(document.getElementById("list-goods")).hasChildNodes())
	    		{
	    		cnode=document.getElementById("buyAll");
	    		cnode.parentNode.removeChild(cnode);
	    		}
	    	document.getElementById("goodsNum").innerHTML=(parseInt(document.getElementById("goodsNum").innerHTML)-1).toString();
	    	}
	    }
	}
	xmlRemove.open("GET","RemoveShopCartServlet?goodsId="+goodsId+"&t="+Math.random(),true);
	xmlRemove.send(null);
}

function buy_all(){
    xmlBuy=new XMLHttpRequest();
    xmlBuy.onreadystatechange=function()
    {
      if ((xmlBuy.readyState==4)&&(xmlBuy.status==200))
        {
    	  document.getElementById("panel-body").innerHTML=xmlBuy.responseText;
    	  document.getElementById("goodsNum").innerHTML="0";
        }
    }
    xmlBuy.open("GET","BuyAllShopcartServlet"+"?t="+Math.random(),true);
    xmlBuy.send(null);
}
</script>