<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zhiyou100.com/common/" prefix="fen"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
function addTeacher() {
	location.href = "${pageContext.request.contextPath}/user/speaker/addTeacherjsp.action";
}
function deleteSpeaker(s) {
	location.href = "${pageContext.request.contextPath}/user/speaker/deletespeaker.action?id=" + s.name;
}
</script>
</head>
<body>
<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="jumbotron col-md-8">
					<h2>主讲人列表-主讲人管理</h2>
				</div>
				<div>
					<div class="col-md-4 col-md-offset-2">
						<button onclick="addTeacher()" class="btn btn-primary">添加主讲人</button>
					</div>
					<div class="col-md-6">
						<form class="form-inline" action="${pageContext.request.contextPath}/user/speaker/selectSpeakerByCondition.action">
							<div class="form-group">
								<label for="exampleInputName2">名称</label>
								<input value="${speaker_name}" name="speaker_name" type="text" class="form-control" id="exampleInputName2" placeholder="主讲人名称">
							</div>
							<div class="form-group">
								<label for="exampleInputName3">职位</label>
								<input value="${speaker_job}" name="speaker_job" type="text" class="form-control" id="exampleInputName3" placeholder="主讲人职位">
							</div>
							<input type="submit" class="btn btn-primary" value="查询" />
						</form>
					</div>
				</div>
				<div class="col-md-8">
					<table class="table table-hover col-md-offset-3">
						<thead>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>职位</th>
								<th>简介</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${page.rows}" var="speaker" varStatus="status">
							<tr>
								<th scope="row">${status.count}</th>
								<td>${speaker.speaker_name}</td>
								<td>${speaker.speaker_job}</td>
								<td>${speaker.speaker_descr}</td>
								<td><a href="${pageContext.request.contextPath}/user/speaker/updatespeakerjsp.action?id=${speaker.id}"
									class="glyphicon glyphicon-edit"></a></td>
								<td>
									<a id="${speaker.id}" data-toggle="modal" data-target="#myModal${speaker.id}"
									class="glyphicon glyphicon-trash"></a>
								</td>
							</tr>
							<div class="modal fade" id="myModal${speaker.id}" tabindex="-1"
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
											<button name="${speaker.id}" onclick="deleteSpeaker(this)"
												type="button" class="btn btn-primary">确认</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
						</tbody>
					</table>
					<fen:page url="${pageContext.request.contextPath}/user/speaker/selectSpeakerByCondition.action"></fen:page>
				</div>
			</div>
		</div>
</body>
</html>