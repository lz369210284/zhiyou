<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="jumbotron col-md-8">
				<h2>添加主讲人-主讲人管理</h2>
			</div>
			<div>
				<form class="form-horizontal" action="${pageContext.request.contextPath}/user/speaker/addspeaker.action">
					<div class="form-group">
						<label for="input1" class="col-md-2 col-md-offset-1 control-label">名字</label>
						<div class="col-md-7">
							<input name="speaker_name" type="text" class="form-control" id="input1"
								placeholder="主讲人姓名">
						</div>
					</div>
					<div class="form-group">
						<label for="input2" class="col-md-2 col-md-offset-1 control-label">职业</label>
						<div class="col-md-7">
							<input name="speaker_job" type="text" class="form-control" id="input2"
								placeholder="主讲人职业">
						</div>
					</div>
					<div class="form-group">
						<label for="input3" class="col-md-2 col-md-offset-1 control-label">头像图片</label>
						<div class="col-md-7">
							<input name="speaker_head_url" type="text" class="form-control" id="input3"
								placeholder="主讲人头像地址，网络图片">
						</div>
					</div>
					<div class="form-group">
						<label for="input4" class="col-md-2 col-md-offset-1 control-label">简介</label>
						<div class="col-md-7">
							<textarea placeholder="简要描述" name="speaker_descr" class="form-control" rows="3"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3 col-md-10">
							<input type="submit" class="btn btn-default btn-primary" value="保存" />
							<button onclick="javascript:history.go(-1)" class="btn btn-default">返回列表</button>
						</div>
					</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>