<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加视频</title>
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
				<h2>添加视频-视频管理</h2>
			</div>
			<div>
				<form class="form-horizontal" action="${pageContext.request.contextPath}/user/video/addvideo.action">
					<div class="form-group row">
						<label for="input1" class="col-md-2 col-md-offset-1 control-label">视频标题</label>
						<div class="col-md-7">
							<input name="video_title" type="text" class="form-control" id="input1" placeholder="视频标题">
						</div>
					</div>
					<div class="form-group">
						<label for="input2" class="col-md-2 col-md-offset-1 control-label">主讲人</label>
						<div class="col-md-7">
							<select name="speaker_id" class="form-control" id="input2">
								<option selected="selected">请选择主讲人</option>
								<c:forEach items="${speakernamelist}" var="speaker" varStatus="status">
								<option value="${speaker.id}">${speaker.speaker_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="input3" class="col-md-2 col-md-offset-1 control-label">所属课程</label>
						<div class="col-md-7">
							<select name="course_id" class="form-control" id="input2">
								<option selected="selected">请选择课程</option>
								<c:forEach items="${coursenamelist}" var="course" varStatus="status">
								<option value="${course.id}">${course.course_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="input4" class="col-md-2 col-md-offset-1 control-label">视频时长</label>
						<div class="col-md-7">
							<input name="video_length" type="text" class="form-control" id="input4" placeholder="视频时长（秒）">
						</div>
					</div>
					<div class="form-group">
						<label for="input5" class="col-md-2 col-md-offset-1 control-label">封面图片</label>
						<div class="col-md-7">
							<input name="video_image_url" type="text" class="form-control" id="input5"
								placeholder="视频封面图片地址，网络图片">
						</div>
					</div>
					<div class="form-group">
						<label for="input6" class="col-md-2 col-md-offset-1 control-label">视频播放地址</label>
						<div class="col-md-7">
							<input name="video_url" type="text" class="form-control" id="input6"
								placeholder="视频播放地址，网络地址">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3"
							class="col-md-2 col-md-offset-1 control-label">视频简介</label>
						<div class="col-md-7">
							<textarea name="video_descr" class="form-control" rows="3"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3 col-md-10">
							<input class="btn btn-default btn-primary" type="submit" value="保存"/>
							<button onclick="javascript:history.go(-1)" class="btn btn-default">返回列表</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>