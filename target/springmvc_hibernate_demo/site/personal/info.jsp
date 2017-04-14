<%/*
个人信息页，被/personal包含，非自己只显示公开信息
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--<%
//根据cache参数来决定是否使用缓存
//解决上传新头像不刷新的问题
String isCache=request.getParameter("cache");
if(isCache!=null && isCache.equals("0")){
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
}
%>--%>
<%--<%
UserHandle userHandle=new UserHandle();
Boolean isLogined=LoginVerify.isLogin(request);
User me=(User)session.getAttribute("loginUser");
User user=null;
if(request.getAttribute("isMe")!=null){
    user=me;
}else{
    user=userHandle.findById(Integer.parseInt(request.getParameter("userid")));
}
%>--%>

<%--<%
String cantAlter="";
if(!isLogined || (isLogined && user.getId()!=me.getId())){	
    cantAlter="readonly";
}
%>--%>
    <div class="panel panel-info">
	    <div class="panel-heading">个人资料</div>
	    <div class="panel-body">
            <div class="alert alert-danger" role="alert">信息</div>
            <div><button id="set-img" type="button" class="btn btn-primary btn-sm">上传新头像</button></div>
            <div id="up-img-body" style="display:none" class="row">
                <div class="col-md-3">
                    <img class="img-rounded img-personal-info-info" src="/static/user_img/1" />
                </div>
                <div class="col-md-9">
                    <fieldset>
                        <form action="UpdateUserImgServlet" method="post" enctype="multipart/form-data">上传文件：
                            <input type="file" name="file" accept="image/gif, image/jpeg, image/x-png" class="btn btn-default btn-sm">
                            <input type="submit" value="更新" class="btn btn-primary btn-sm">
                        </form>
                    </fieldset>
                </div>
            </div>
            <br />
	        <form action="UpdateUserInfoServlet" method="post">
	            <div class="form-group">
	                <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">姓名</span>
                        <input type="text" class="form-control" name="name" value="${user.name}">
	                </div>
	            </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon2">邮箱</span>
                        <input readonly type="text" class="form-control" value="${user.email}">
	                </div>
	            </div>
	            <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">电话</span>
                        <input type="text" class="form-control" name="phone" value="${user.phone}" >
                    </div>
                </div>
                <div class="form-group" style="display:none" id="set-pwd-input">
                    <div class="input-group">
                        <span class="input-group-addon" id="pwd1">新的密码</span>
                        <input placeholder="不更新密码留空此项即可" name="pwd1" type="password" class="form-control" value="123456">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon" id="pwd2">密码重复</span>
                        <input type="password" name="pwd2" class="form-control" value="">
                    </div>
	            </div>
	            <button id="set-pwd" type="button" class="btn btn-primary">设置密码</button>
	            <button type="submit" class="btn btn-primary">更新我的资料</button>
	            <%--<button onclick='window.open("user/personal.jsp?tab=mess&handle=write&toemail=${user.email}%20==>%20${user.name}")' id="send-mess-to-he" type="button" class="btn btn-primary">给他发送消息</button>--%>
	        </form>
	    </div>
    </div>

    <script>
        $(document).ready(function(){
            $("#set-pwd").click(function(){
                $("#set-pwd-input").show(200);
                $("#set-pwd").hide(200);
            });
            $("#set-img").click(function(){
                $("#up-img-body").show();
                $("#set-img").hide();
            });
          });
    </script>
