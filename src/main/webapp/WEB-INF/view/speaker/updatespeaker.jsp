<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑主讲人信息</title>
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
				<h2>编辑主讲人-主讲人管理</h2>
			</div>

				<form class="form-horizontal" action="${pageContext.request.contextPath}/user/speaker/updatespeaker.action">
					<input type="hidden" name="id" value="${speaker.id}"/>
					<div class="form-group">
						<label for="input1" class="col-md-4 control-label">名字</label>
						<div class="col-md-6">
							<input name="speaker_name" type="text" class="form-control" id="input1"
								value="${speaker.speaker_name}" placeholder="史蒂夫">
						</div>
					</div>
					<div class="form-group">
						<label for="input2" class="col-md-4 control-label">职业</label>
						<div class="col-md-6">
							<input name="speaker_job" type="text" class="form-control" id="input2"
								value="${speaker.speaker_job}" placeholder="初级讲师">
						</div>
					</div>
					<div class="form-group">
						<label for="input3" class="col-md-4 control-label">头像图片</label>
						<div class="col-md-6">
							<input name="speaker_head_url" type="text" class="form-control" id="input3"
								value="${speaker.speaker_head_url}" placeholder="jpg">
						</div>
					</div>
					<div class="form-group">
						<label for="input4" class="col-md-4 control-label">简介</label>
						<div class="col-md-6">
							<textarea placeholder="简要介绍" name="speaker_descr" class="form-control" rows="3">${speaker.speaker_descr}</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-10">
							<input class="btn btn-default btn-primary" type="submit" value="保存" />
							<button class="btn btn-default"
								onclick="javaScript:history.go(-1);">返回列表</button>
					</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>