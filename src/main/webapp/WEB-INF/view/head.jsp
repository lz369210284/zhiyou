<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频管理系统</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
function activeStatus(as) {
	var lis = document.getElementsByTagName("li");
	for (var i = 0;i < lis.length;i++ ) {
		lis[i].setAttribute('class','');
	}
	as.parent.setAttribute('class','active');
}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">视频管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a onclick="activeStatus(this)" target="pagebox" href="${pageContext.request.contextPath}/user/video/selectVideoByCondition.action">视频管理</a></li>
				<li class=""><a onclick="activeStatus(this)" target="pagebox" href="${pageContext.request.contextPath}/user/speaker/selectSpeakerByCondition.action">主讲人管理</a></li>
				<li class=""><a onclick="activeStatus(this)" target="pagebox" href="${pageContext.request.contextPath}/user/course/selectCourseByCondition.action">课程管理</a></li>
				<li class=""><a onclick="activeStatus(this)" target="pagebox" href="${pageContext.request.contextPath}/user/chart/chartInfo.action">统计分析</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
        		<li><a href="${pageContext.request.contextPath}/user/user/loginout.action">${user.login_name }<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
      		</ul>
		</div>
	</div>
	</nav>
	<!-- 16:9 aspect ratio -->
	<div class="embed-responsive embed-responsive-4by3">
 	<iframe name="pagebox" class="embed-responsive-item" src="${pageContext.request.contextPath}/user/video/selectVideoByCondition.action"></iframe>
	</div>
	
</body>
</html>