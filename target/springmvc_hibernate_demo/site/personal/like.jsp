<%/*
购物车页面，被/personal.jsp包含，查找所有购物车内物品
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="panel panel-info">
    <div class="list-group">
            <span class="list-group-item list-group-item-info">我的收藏</span>
            <div onMouseLeave="hide(this,'re-bt-')" onMouseOver="show(this,'re-bt-')" class="list-group-item">
                <div class="row">
                    <div class="goods-img col-md-2">
                        <img class="img-rounded img-item-goods" src="" />
                    </div>
                    <div class="col-md-10">
                        <div class="row detail-goods lead">
                            <span class="label label-info">
                                出售中
                            </span>
                            <a href="goods/info.jsp?goodsid=">商品1</a>
                        </div>
                        <div class="row detail-goods">￥<span class="text-danger">20</span>
                            <span class="detail-goods text-muted">　发布者:张伟 </span>
                            <span class="detail-goods text-muted">　时间：2017/07/21
                                <button id="re-bt-12" style="display:none" type="button" class="btn btn-xs btn-danger" onclick="delete_collect(3)">移除收藏</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="list-group-item">
                尚未收藏任何物品
            </div>
    </div>
    <nav>
      <ul class="pager">
        <li class=""><a class="page-cut-btn" href="user/personal.jsp?tab=like&pn="><span aria-hidden="true"></span>上一页</a></li>
        <li style=""><span style="border:0">    　　第<span style="color:red;border:0">2</span>页　　</span></li>
        <li class=""><a class="page-cut-btn" href="user/personal.jsp?tab=like&pn=&userid=">下一页 <span aria-hidden="true"></span></a></li>
      </ul>
    </nav>
</div>

<script>
function show(obj,id1) {
    var objDiv = $("#"+id1+"");
    $(objDiv).css("display","inline");
}

function hide(obj,id1) {
var objDiv = $("#"+id1+"");
$(objDiv).css("display", "none");
}

function delete_collect(goodsid){
    collectRemove=new XMLHttpRequest();
    collectRemove.onreadystatechange=function()
      {
      if (collectRemove.readyState==4 && collectRemove.status==200)
        {
        if(collectRemove.responseText=="success")
            {
                cnode = document.getElementById("re-bt-"+goodsid);
                cnode.innerHTML="已从收藏夹移除";
            }
        }
      }
    collectRemove.open("GET","RemoveCollectServlet?goodsid="+goodsid+"&t="+Math.random(),true);
    collectRemove.send(null);
}

</script>
