<%/*
商品发布页，被/personal.jsp包含
*/%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isThreadSafe="false"%>

<div class="panel panel-info">
	<div class="panel-heading">
		发布商品
	</div>
	<div class="panel-body">

		<form action="/releaseGoods.action" method="post" enctype="multipart/form-data">
			<div class="alert alert-danger" role="alert">
				提示信息&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${releaseGoodsResult}
			</div>
			<div class="form-group">
				<p>物品名称：</p>
				<input class="form-control" name="name" value="${goods.name}">
			</div>
			<div class="form-group">
				<p>价格(元)：</p>
				<input type="text" class="form-control" name="price" value="1">
			</div>
			<div class="form-group">
				<p>物品简介：</p>
				<textarea rows="3" class="form-control" name="content" >${goods.content}</textarea>
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
				<p>选择货物寄送方式</p>
				<select name="deliveryType" class="form-control">
					<option value="送货上门">送货上门</option>
					<option value="交易网寄售">交易网寄售</option>
					<option value="自取">自取</option>
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