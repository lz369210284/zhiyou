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
					<h2>添加课程-课程管理</h2>
				</div>
				<div>
					<form class="form-horizontal" action="${pageContext.request.contextPath}/user/course/addcourse.action">
						<div class="form-group">
							<label for="input4" class="col-md-2 col-md-offset-1 control-label">所属课题</label>
							<div class="col-md-7">
								<select name="subject_id" class="form-control" id="input2">
									<option selected="selected" value="">请选择所属课题</option>
									<c:forEach items="${subjectlist}" var="subject" varStatus="status">
										<option value="${subject.id}">${subject.subject_name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="input5" class="col-md-2 col-md-offset-1 control-label">标题</label>
							<div class="col-md-7">
								<input name="course_name" type="text" class="form-control" id="input5" placeholder="课程标题">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-md-2 col-md-offset-1 control-label">简介</label>
							<div class="col-md-7">
								<textarea name="course_descr" class="form-control" rows="3"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-3 col-md-10">
								<button type="submit" class="btn btn-default btn-primary">保存</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>