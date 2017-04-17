<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%/*
个人信息页，被/personal包含，非自己只显示公开信息
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="panel panel-info">
	<div class="panel-heading">
        <a href="/showMessageInfo.action">我的消息</a>
         /
        <a href="/toSendMessagePage.action">发送站内信</a>
	</div>
    <%  if (request.getAttribute("isSendMessage") != null && "true".equals(request.getAttribute("isSendMessage"))) { %>
        <div class="alert alert-warning" role="alert">
            注意：消息发送成功后，对方将收到**站内消息**
        </div>
        <div class="alert alert-warning" role="alert">
            ${sendMessageResult}
        </div>
        <div class="panel-body">
            <form action="/sendMessage.action" method="post">
                <div class="form-group">
                    <label for="InputEmail">发送给用户：</label>
                    <input value="" type="text" class="form-control" id="InputEmail" name="InputEmailToSend" placeholder="输入用户邮箱">
                </div>
                <div class="form-group">
                    <label for="InputMess">消息正文：</label>
                    <textarea rows="5" class="form-control" id = "InputMess" name="InputMess" placeholder="输入消息正文">${inputMess}</textarea>
                </div>
                <button type="submit" class="btn btn-default">发送</button>
            </form>
            <!-- end of 消息发送页 -->
            <%--<%} %>--%>
        </div>
    <% } else { %>
        <div class="panel-body">
            <div class="alert alert-warning" role="alert">
                注意：系统消息会带有“sys”标签，其他皆为用户消息,带有“user”标签。
            </div>
            <c:forEach items="${messageList}" var="message">
                <div onMouseLeave="hide(this,'cz-bt-','is-bt-');" onMouseOver="show(this,'cz-bt-');" id="mess-" class="media">
                    <div class="media-left">
                        <a href="#">
                            <img width="65px" class="media-object" src="/pic${message.img}"<%//获取该用户头像 %> alt="sss">
                        </a>
                    </div>
                    <div class="media-body">
                        <span class="media-heading">
                            <span class="label label-danger">user</span>
                                来自
                            <a target="_blank" href="user/personal.jsp?tab=info&userid=">${message.email}
                            </a>${message.sendTime}
                        </span>
                        <div style="display:none" id="cz-bt-${message.messId}">
                            <button type="button" class="btn btn-xs btn-success" onclick="window.open('user/personal.jsp?tab=mess&handle=write&toemail=%20==>%20&userid=')">回复</button>
                            <button type="button" class="btn btn-xs btn-danger" onclick="is_delete('${message.messId}')">删除此条消息</button>
                        </div>
                        <div style="display:none" id="is-bt-${message.messId}">
                            <button type="button" class="btn btn-xs btn-danger" onclick="delete_mess('${message.messId}')">点此确认删除</button>
                        </div>
                        <pre>${message.messText}</pre>
                    </div>
                </div>
            </c:forEach>
            <nav>
                <ul class="pager">
                    <li class=""><a class="page-cut-btn" href="/showMessageInfoUpPage.action"><span aria-hidden="true"></span>上一页</a></li>
                    <li style=""><span style="border:0">    　　第<span style="color:red;border:0">${pageNum}</span>页　　</span></li>
                    <li class=""><a class="page-cut-btn" href="/showMessageInfoNextPage.action">下一页<span aria-hidden="true"></span></a></li>
                </ul>
            </nav>
            <div class="alert alert-warning" role="alert">
                ${messageResult}
            </div>
        </div>
    <% } %>
</div>

<script>
function show(obj,id1) {
	var objDiv = $("#"+id1+"");
	$(objDiv).css("display","inline");
}

function hide(obj,id1,id2) {
var objDiv = $("#"+id1+"");
$(objDiv).css("display", "none");
var objDiv2 = $("#"+id2+"");
$(objDiv2).css("display", "none");
}

function is_delete(id){
	var objDiv = $("#"+id+"");
	$(objDiv).css("display","inline");
}

function delete_mess(messid){
	xmlMess=new XMLHttpRequest();
	xmlMess.onreadystatechange=function()
	  {
	  if (xmlMess.readyState==4 && xmlMess.status==200)
	    {
	    if(xmlMess.responseText=="success")
	    	{
				//移除节点
		    	cnode = document.getElementById("mess-"+messid);
		    	cnode.parentNode.removeChild(cnode);
	    	}
	    }
	  }
	xmlMess.open("GET","RemoveMessServlet?messid="+messid+"&t="+Math.random(),true);
	xmlMess.send(null);
}
</script>