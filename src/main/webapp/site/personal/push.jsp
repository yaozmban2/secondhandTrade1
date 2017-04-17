<%/*
商品发布页，被/personal.jsp包含
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isThreadSafe="false"%>

<div class="panel panel-info">
	<div class="panel-heading">
		发布商品
	</div>
	<div class="panel-body">

		<form action="" method="post" enctype="multipart/form-data">

			<%--<% if(request.getParameter("info")!=null && !request.getParameter("info").equals("")){%>--%>
			<div class="alert alert-success" role="alert">
				商品发布<%--<%out.print(new String(request.getParameter("info").getBytes("UTF-8"),"UTF-8"));%>--%>
			</div>
			<%--<%}%>--%>
			<%--<% if(request.getParameter("seccess")!=null && request.getParameter("seccess").equals("0") && request.getAttribute("isCheck")!=null){%>--%>
			<div class="alert alert-danger" role="alert">
				<%--<%
					 if(request.getAttribute("nameCheck")!=null&&!request.getAttribute("nameCheck").equals("")){
						 out.print(request.getAttribute("nameCheck"));


					 };if(request.getAttribute("quantityCheck")!=null&&!request.getAttribute("quantityCheck").equals("")){
						 out.print(request.getAttribute("quantityCheck"));

					 }if(request.getAttribute("contentCheck")!=null&&!request.getAttribute("contentCheck").equals("")){
						 out.print(request.getAttribute("contentCheck"));

					 }
					 if(request.getAttribute("fileCheck")!=null&&!request.getAttribute("fileCheck").equals("")){
						 out.print(request.getAttribute("fileCheck"));

					 }
				 %>--%>
				名字检查
			</div>
			<%--<% }%>--%>
			<div class="form-group">
				<p>物品名称：</p>
				<input class="form-control" name="name">
			</div>
			<div class="form-group">
				<p>价格(元)：</p>
				<input type="number" class="form-control" name="price">
			</div>
			<div class="form-group">
				<p>物品简介：</p>
				<textarea rows="3" class="form-control" name="content"></textarea>
			</div>
			<div class="form-group">
				<p>选择一个分类：</p>
				<select name="typeId" class="form-control">
					<option value="1">书籍</option>
					<option value="2">生活出行</option>
					<option value="3">衣服鞋包</option>
					<option value="4">电子产品</option>
					<option value="5">体育运动</option>
					<option value="6">其他</option>
				</select>
			</div>
			<div class="form-group">
				<p>物品图片：</p>
				<input type="file" name="file">
				<p class="help-block">提醒：请上传真实物品照片</p>
			</div>
			<button type="submit" class="btn btn-primary">提交</button>
		</form>
	</div>
</div>