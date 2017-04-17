<%/*
个人信息页，被/personal包含，非自己只显示公开信息
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="panel panel-info">
	    <div class="panel-heading">个人资料</div>
	    <div class="panel-body">
            <div class="alert alert-danger" role="alert">信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${checkOldPWD}${checkValidatePWD}${checkNewPWD}${checkChangePersonalInfo}</div>
            <div><button id="set-img" type="button" class="btn btn-primary btn-sm">上传新头像</button></div>
            <div id="up-img-body" style="display:none" class="row">
                <div class="col-md-3">
                    <img class="img-rounded img-personal-info-info" src="/pic${user.img}" />
                </div>
                <div class="col-md-9">
                    <fieldset>
                        <form action="/uploadAvatar.action" method="post" enctype="multipart/form-data">上传文件：
                            <input type="file" name="file" accept="image/gif, image/jpeg, image/x-png" class="btn btn-default btn-sm">
                            <input type="submit" value="更新" class="btn btn-primary btn-sm">
                            <input type="button" id="image-quit" value="取消" class="btn btn-primary btn-sm">
                        </form>
                    </fieldset>
                </div>
            </div>
            <br />
            <% String isPWDPage = null;
                if (request.getAttribute("isPWDpage") != null)
                {
                    isPWDPage = (String) request.getAttribute("isPWDpage");
                }
                if(isPWDPage == null || !isPWDPage.equals("PWDpage")) { %>
	        <form id="change-personal-info-form" action="/changePersonalInfo.action" method="post">
                <div id="set-info-input">
                    <div class="form-group" >
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
                </div>
            </form>
            <form id="change-personal-pwd-form" action="/changePersonalPWD.action" method="post" >
                <div style="display:none" id="set-pwd-input">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd">&nbsp&nbsp旧密码&nbsp</span>
                            <input placeholder="填写您的旧密码" name="pwd" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd1">新的密码</span>
                            <input placeholder="填写新的密码" name="newPWD" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd2">密码重复</span>
                            <input placeholder="验证新的密码" type="password" name="validatePWD" class="form-control" value="">
                        </div>
                    </div>
	            </div>
            </form>
            <button id="change-info" type="submit" class="btn btn-primary">修改资料</button>
            <button id="set-pwd" type="button" class="btn btn-primary">修改密码</button>
            <button id="change-pwd" style="display:none" type="button" class="btn btn-primary">修改密码</button>
            <button id="set-pwd-quit" style="display:none" type="button" class="btn btn-primary">取消</button>
            <% } else { %>
            <form id="change-personal-info-form" action="/changePersonalInfo.action" method="post">
                <div style="display:none" id="set-info-input">
                    <div class="form-group" >
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
                </div>
            </form>
            <form id="change-personal-pwd-form" action="/changePersonalPWD.action" method="post" >
                <div id="set-pwd-input">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd">&nbsp&nbsp旧密码&nbsp</span>
                            <input placeholder="填写您的旧密码" name="pwd" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd1">新的密码</span>
                            <input placeholder="填写新的密码" name="newPWD" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon" id="pwd2">密码重复</span>
                            <input placeholder="验证新的密码" type="password" name="validatePWD" class="form-control" value="">
                        </div>
                    </div>
                </div>
            </form>
            <button id="change-info" style="display:none"  type="submit" class="btn btn-primary">修改资料</button>
            <button id="set-pwd" style="display:none"  type="button" class="btn btn-primary">修改密码</button>
            <button id="change-pwd" type="button" class="btn btn-primary">修改密码</button>
            <button id="set-pwd-quit" type="button" class="btn btn-primary">取消</button>
            <% } %>
	            <%--<button onclick='window.open("user/personal.jsp?tab=mess&handle=write&toemail=${user.email}%20==>%20${user.name}")' id="send-mess-to-he" type="button" class="btn btn-primary">给他发送消息</button>--%>

	    </div>
    </div>

    <script>
        $(document).ready(function(){
            //点击设置密码的按钮的事件
            $("#set-pwd").click(function(){
                $("#set-pwd-input").show();
                $("#set-info-input").hide();
                $("#set-pwd").hide();
                $("#set-pwd-quit").show();
                $("#change-info").hide();
                $("#change-pwd").show();
            });
            //点击设置密码里面取消按钮的事件
            $("#set-pwd-quit").click(function(){
                $("#set-pwd-input").hide();
                $("#set-info-input").show();
                $("#set-pwd").show();
                $("#set-pwd-quit").hide();
                $("#change-info").show();
                $("#change-pwd").hide();
            });
            //点击上传新头像的事件
            $("#set-img").click(function(){
                $("#up-img-body").show();
                $("#set-img").hide();
            });
            //进了新头像上传事件后点击取消的事件
            $("#image-quit").click(function(){
                $("#up-img-body").hide();
                $("#set-img").show();
            });
            //点击更新我的资料
            $("#change-pwd").click(function(){
                $("#change-personal-pwd-form").submit();
            })
            //点击修改密码
            $("#change-info").click(function(){
                $("#change-personal-info-form").submit();
            })
          });
    </script>
