<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zhiyou100.com/common/" prefix="fen"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
function addCourse() {
	location.href = "${pageContext.request.contextPath}/user/course/addCoursejsp.action";
}
function deleteCourse(c) {
	location.href = "${pageContext.request.contextPath}/user/course/deletecourse.action?id=" + c.name;
}
</script>
</head>
<body>
<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="jumbotron col-md-8">
				<h2>课程列表-课程管理</h2>
			</div>
			<div>
				<button onclick="addCourse()" class="btn btn-primary col-md-offset-2">添加课程</button>
			</div>
			<div class="col-md-8">
				<table class="table table-hover col-md-offset-3">
					<thead>
						<tr class="row">
							<th>序号</th>
							<th>标题</th>
							<th>学科</th>
							<th>简介</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${page.rows}" var="course" varStatus="status">
						<tr class="row">
							<th scope="row">${status.count}</th>
							<td>${course.course_name}</td>
							<td>${course.subject_name}</td>
							<td>${course.course_descr}</td>
							<td><a href="${pageContext.request.contextPath}/user/course/updatecoursejsp.action?id=${course.id}"
									class="glyphicon glyphicon-edit"></a></td>
							<td><a id="${course.id}" data-toggle="modal" data-target="#myModal${course.id}"
									class="glyphicon glyphicon-trash"></a></td>
						</tr>
						<div class="modal fade" id="myModal${course.id}" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">确认框</h4>
										</div>
										<div class="modal-body">确认删除吗？</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">取消</button>
											<button name="${course.id}" onclick="deleteCourse(this)"
												type="button" class="btn btn-primary">确认</button>
										</div>
									</div>
								</div>
							</div>
					</c:forEach>	
					</tbody>
				</table>
				<fen:page url="${pageContext.request.contextPath}/user/course/selectCourseByCondition.action"></fen:page>
			</div>
		</div>
		</div>
</body>
</html>