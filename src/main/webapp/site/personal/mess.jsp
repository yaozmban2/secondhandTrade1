<%/*
个人信息页，被/personal包含，非自己只显示公开信息
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="panel panel-info">
	<div class="panel-heading">
        <a href="user/personal.jsp?tab=mess&userid=">我的消息</a>
         /
        <a href="user/personal.jsp?tab=mess&handle=write&userid=">发送站内信</a>
	</div>
	<div class="panel-body">
        <div class="alert alert-warning" role="alert">
            注意：系统消息会带有“sys”标签，其他皆为用户消息,带有“user”标签。
        </div>
        <!-- 这里写消息列表 -->
        <%--<%
        //访问了消息页，则将消息数量清零
        userHandle.emptyMessnum(me);
        %>
        <script>
        //前端消息数量清零
        document.getElementById("mess-number").innerHTML="0";
        </script>
        <%
        if(allMess.size()!=0){
            for(int i=0;i<allMess.size();i++){
                Mess mess=allMess.get(i);
        %>--%>

        <%--<!-- 一条消息 -->	--%>
        <%--<%user=userHandle.findById(mess.getMessFromId()); %>--%>
        <div onMouseLeave="hide(this,'cz-bt-','is-bt-');" onMouseOver="show(this,'cz-bt-');" id="mess-" class="media">
            <div class="media-left">
                <a href="#">
                    <img width="65px" class="media-object" src=""<%//获取该用户头像 %> alt="sss">
                </a>
            </div>
            <div class="media-body">
                <span class="media-heading">
    
                <%--<%
                if(user.getId()==1){
                    out.print("<span class=\"label label-danger\">SYS</span>");
                }else{
                    out.print("<span class=\"label label-primary\">user</span>");
                }
                %>--%>
                    <span class="label label-danger">SYS</span>
                 来自
                    <a target="_blank" href="user/personal.jsp?tab=info&userid=">455766338@qq.com
                <%--<%
                if(user.getName()==null || user.getName().length()==0){
                    out.print(user.getEmail());
                }else{
                    out.print(user.getName());
                }
                %>--%>
                    </a>，2013/02/01
                <%--<%
                java.util.Date date=mess.getSendDate();
                SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateStr =myFmt.format(date);
                out.print(dateStr);
                %>--%>
                </span>
                <div style="display:none" id="cz-bt-">
                    <button type="button" class="btn btn-xs btn-success" onclick="window.open('user/personal.jsp?tab=mess&handle=write&toemail=%20==>%20&userid=')">回复</button>
	                <button type="button" class="btn btn-xs btn-danger" onclick="is_delete('is-bt-')">删除此条消息</button>
                </div>
 
                <div style="display:none" id="is-bt-">
	            <button type="button" class="btn btn-xs btn-danger" onclick="delete_mess('')">点此确认删除</button>
            </div>
 
            <pre><%--<%
                    if(user.getId()==1){
    	                out.print(mess.getMessText());
                    }else{
    	                out.print(mess.getMessText().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
                    }
            %>--%>这是一条信息</pre>
        </div>
    </div>
<!-- end of 一条消息 -->

    <%--<%}%>--%>
    <nav>
      <ul class="pager">
        <li class=""><a class="page-cut-btn" href="user/personal.jsp?tab=mess&userid=&pn="><span aria-hidden="true"></span>上一页</a></li>
        <li style=""><span style="border:0">    　　第<span style="color:red;border:0">2</span>页　　</span></li>
        <li class=""><a class="page-cut-btn" href="user/personal.jsp?tab=mess&userid=&pn=">下一页<span aria-hidden="true"></span></a></li>
      </ul>
    </nav>
    <%--<%}else{%>--%>
    <div class="alert alert-warning" role="alert">
    你尚未收到任何消息，或已经到达最大页数！
    </div>
    <%--<%}%>--%>
<!-- end of 消息列表 -->
<%--<%} else{ %>--%>
    <!-- 这里写消息发送页 -->
    <div class="alert alert-warning" role="alert">
    注意：消息发送成功后，对方将收到**站内消息**
    </div>

    <%--<%--%>
    <%--//提示--%>
    <%--if(request.getParameter("info")!=null && !request.getParameter("info").equals("")){--%>
    <%--%>--%>
    <div class="alert alert-warning" role="alert">
        <%=request.getParameter("info") %>
    </div>
    <%--<%}%>--%>
    <%--<%--%>
    <%--//邮箱自动填写--%>
    <%--String toEmail="";--%>
    <%--if(request.getParameter("toemail")!=null && !request.getParameter("toemail").equals("")){--%>
        <%--toEmail=request.getParameter("toemail");--%>
    <%--}--%>
    <%--%>--%>

    <form action="MessCheckServlet" method="post">
      <div class="form-group">
        <label for="InputEmail">发送给用户：</label>
        <input value="" type="text" class="form-control" id="InputEmail" name="InputEmailToSend" placeholder="输入用户邮箱">
      </div>
      <div class="form-group">
        <label for="InputMess">消息正文：</label>
        <textarea rows="5" class="form-control" id = "InputMess" name="InputMess" placeholder="输入消息正文"></textarea>
      </div>
      <button type="submit" class="btn btn-default">发送</button>
    </form>
<!-- end of 消息发送页 -->
<%--<%} %>--%>
	</div>
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