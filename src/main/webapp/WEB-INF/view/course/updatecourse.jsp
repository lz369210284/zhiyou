<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h2>编辑课程-课程管理</h2>
			</div>

				<form class="form-horizontal" action="${pageContext.request.contextPath}/user/course/updatecourse.action">
					<input type="hidden" name="id" value="${course.id}"/>
					<div class="form-group">
						<label for="input1" class="col-md-4 control-label">课程名</label>
						<div class="col-md-6">
							<input name="course_name" type="text" class="form-control" id="input1"
								value="${course.course_name}" placeholder="史蒂夫">
						</div>
					</div>
					<div class="form-group">
						<label for="input2" class="col-md-4 control-label">学科名</label>
						<div class="col-md-6">
							<select name="subject_id" class="form-control" id="input2">
								<option>请选择学科</option>
								<c:forEach items="${subjectlist}" var="subject" varStatus="status">
									<option value="${subject.id}" ${subject.subject_name eq course.subject_name ? "selected" : ""}>${subject.subject_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="input4" class="col-md-4 control-label">简介</label>
						<div class="col-md-6">
							<textarea placeholder="简要介绍" name="course_descr" class="form-control" rows="3">${course.course_descr}</textarea>
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