<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>login</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.min.js"></script>
	<script type="text/javascript">
$(function(){
	$("#checkForm").validate({
		rules:{
			login_name:{
				required:true,
			},
			login_pwd:{
				required:true
			}
		},
		messages:{
			login_name:{
				required:"用户名不能为空",
			},
			login_pwd:{
				required:"密码不能为空"
			}
		}
	});
});
</script>
    <style>
    	body{
    		margin: 0 auto;
    		text-align: center;
    		margin-top: 300px;
    		width: 309px;
    	}
    </style>
  </head>
  <body>
			<div>
				<img src="${pageContext.request.contextPath}/img/logo.png"/>
			</div>
			<form id="checkForm" class="form-signin" action="${pageContext.request.contextPath}/user/user/login.action">
				<input value="admin" type="text" name="login_name" class="form-control" placeholder="用户名"><br />
				<input value="admin" type="password" name="login_pwd" class="form-control" placeholder="登录密码"><br />
				<input type="submit" value="登录" class="btn btn-success btn-block" />
			</form>
  </body>
</html>