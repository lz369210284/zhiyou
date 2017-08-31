<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://zhiyou100.com/common/" prefix="fen"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/jquery-confirm.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
<script>
var deleteNum = 0;
//单个CheckBox选中
function checkDelete(ele){
	 if(ele.checked){
		 deleteNum++;
	 }else{
		 deleteNum--;
	 }
	 $("#checkNum").text(deleteNum);
	 if( $("input[name=checkbox]").length == deleteNum){
		 $("#checkall").prop("checked",true);
	 }else{
		 $("#checkall").prop("checked",false);
	 }
	 
}
//全选
function checkAllElement(ele){
	 $("input[name=checkbox]").prop("checked",ele.checked);
	 if(ele.checked){
		 deleteNum = $("input[name=checkbox]").length;
	 }else{
		 deleteNum = 0;
	 }
	 $("#checkNum").text(deleteNum);
	
}
//批量删除
function batchDelete(){
	 if(deleteNum == 0){
		 $.alert({
			    title: '警告',
			    content: '没选中,删什么删',
			});
		 return;
	 }
	 $.confirm({
		    title: '提示',
		    content: '看清哦,可是全部删除!!',
		    buttons: {
		        confirm: {
		        	text: '非常肯定',
	
		        	action: function () {
		           		$("#deleteForm").submit();
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});	 
}
//单个删除
function deleteInfo(ele){
	 $.confirm({
		    title: '提示',
		    content: '是否确认',
		    buttons: {
		        confirm: {
		        	text: '非常肯定',
		        	action: function () {
		           		$.ajax({
		           			url:"${pageContext.request.contextPath}/user/video/deletevideo.action",
		           			dataType:"text",
		           			type:"post",
		           			data:{"id":ele.id},
		           			success:function(msg){
		           				if(msg=="success"){
		           					location.reload();
		           				}
		           			}
		           		});
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});
}
	var selected = 0;
	function addVideo() {
		location.href = "${pageContext.request.contextPath}/user/video/addvideojsp.action";
	}
	/* 
	 function deletePart() {
		var checkbox = document.getElementsByName("checkbox");
		var num = document.getElementById("checkNum").innerText;
		var part;
		if(num!=null&&num>0){
			part = "(";
			for (var i = 0;i < checkbox.length ;i++) {
				if(checkbox[i].checked==true){
					part = part.concat(checkbox[i].value)+",";
				}
			}
			part = part.substring(0,part.length-1);
			part = part + ")";
			alert(part);
			location.href = "${pageContext.request.contextPath}/user/video/deleteManyVideo.action?manyid=" + part;
		}else{
			alert("请选择删除项");
			// ${pageContext.request.contextPath}/user/video/selectVideoByCondition.action?page=?&rows=5 
			location.href = "${pageContext.request.contextPath}/user/video/selectVideoByCondition.action?page=1&rows=5";
		}
		
	} 
	function deleteVideo(v) {
		location.href = "${pageContext.request.contextPath}/user/video/deletevideo.action?id=" + v.name;
	}

	 
		//js：全选的checkbox事件
		function selectCheck() {
		var checkbox = document.getElementsByName("checkbox");
		var checkall = document.getElementById("checkall");
		for (var i = 0; i < checkbox.length; i++) {
			if (checkall.checked == true) {
				checkbox[i].checked = checkall.checked;
			} else {
				checkbox[i].checked = checkall.checked;
			}
		}
		if (checkall.checked == true) {
			selected = checkbox.length;
		} else {
			selected = 0;
		}
		document.getElementById("checkNum").innerHTML = selected;
	}
	//js：单个CheckBox的事件
	function addNum(n) {
		if (n.checked == true) {
			selected++;
		} else {
			selected--;
		}
		document.getElementById("checkNum").innerHTML = selected;
	} 

		$(function(){
			//jquery的CheckBox的点击事件并计算选中框的数量
			$(":checkbox").click(function(){
				if(this.id=="checkall"){
					$(":checkbox").each(function(index,obj){
						if(index==0){
							return true;
						}else{
							this.checked = $(":checkbox")[0].checked;
						}
					});
					if(this.checked==true){
						selected = $(":checkbox").length - 1;
					}else{
						selected = 0;
					} 
				}else{
					this.checked;
					if(this.checked==true){
						selected++;
					}else{
						selected--;
					}					
				}
				$("#checkNum").html(selected);
			});	
			
			$("#del").click(function(){
				var num = $("#checkNum").text();
				var str;
				alert(num);
				if(num!=null&&num>0){
					str = "(";
					$(":checkbox").each(function(index,obj){
						if(this.checked){
							if(index!=0){
								str = str + this.value + ",";
							}				
						}						
					});
					str = str.substring(0,str.length-1);
					str = str + ")";
					alert(str);
					location.href = "${pageContext.request.contextPath}/user/video/deleteManyVideo.action?manyid=" + str;
				}else{
					alert("请选择删除项");
					// ${pageContext.request.contextPath}/user/video/selectVideoByCondition.action?page=?&rows=5 
					location.href = "${pageContext.request.contextPath}/user/video/selectVideoByCondition.action?page=1&rows=5";
				}			
			});		
		}); */
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="jumbotron col-md-8">
				<h2>视频列表-视频管理</h2>
			</div>
			<div class="row">
				<div class="col-md-4 col-sm-4 col-md-offset-2" style="width: 300px;">
					<button class="btn btn-primary" onclick="addVideo()">添加视频</button>
					<button id="del" class="btn btn-primary" onclick="batchDelete()">
						批量删除<span id="checkNum" class="badge"  onclick="batchDelete()">0</span>
					</button>
				</div>
				<div class="col-md-6 col-sm-6">
					<form class="form-inline"
						action="${pageContext.request.contextPath}/user/video/selectVideoByCondition.action">
						<div class="form-group" style="width: 100px;">
							<input name="video_title" value="${video_title}" type="text"
								class="form-control" id="exampleInputEmail3" placeholder="视频标题">
						</div>
						<div class="form-group">
							<select name="speaker_name" class="form-control"
								style="width: 150px;">
								<option value="">请选择主讲人</option>
								<c:forEach items="${speakernamelist}" var="speaker"
									varStatus="status">
									<option value="${speaker.speaker_name}"
										${speaker_name eq speaker.speaker_name ? "selected":""}>${speaker.speaker_name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<select name="course_name" class="form-control"
								style="width: 150px;">
								<option value="">请选择课程</option>
								<c:forEach items="${coursenamelist}" var="course"
									varStatus="status">
									<option value="${course.course_name}"
										${course_name eq course.course_name ? "selected":""}>${course.course_name}</option>
								</c:forEach>
							</select>
						</div>
						<input type="submit" class="btn btn-primary" value="查询" />
					</form>
				</div>
			</div>
			<div class="col-md-8">
			<form action="${pageContext.request.contextPath}/user/video/deleteMuchVideo.action" id="deleteForm">
				<table class="table table-hover col-md-offset-3">
					<thead>
						<tr class="row">
							<!--<th><label><input type="checkbox" value=""></label></th>-->
							<th><input onclick="checkAllElement(this)" id="checkall"
								type="checkbox">序号</th>
							<th>名称</th>
							<th>介绍</th>
							<th>讲师</th>
							<th>课程</th>
							<th>时长（秒）</th>
							<th>播放次数</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.rows}" var="video" varStatus="status">
							<tr class="row">
								<th scope="row"><input onclick="checkDelete(this)"
									name="checkbox" type="checkbox" value="${video.id}">${status.count}</th>
								<td>${video.video_title}</td>
								<td>${video.video_descr}</td>
								<td>${video.speaker_name}</td>
								<td>${video.course_name}</td>
								<td>${video.video_length}</td>
								<td>${video.video_play_times}</td>
								<td><a
									href="${pageContext.request.contextPath}/user/video/updatevideojsp.action?id=${video.id}"
									class="glyphicon glyphicon-edit"></a></td>
								<td><a id="${video.id}" onclick="deleteInfo(this)"				
									class="glyphicon glyphicon-trash"></a></td><!-- data-toggle="modal" data-target="#myModal${video.id}"  -->
							</tr>
							<div class="modal fade" id="myModal${video.id}" tabindex="-1"
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
											<button name="${video.id}" onclick="deleteVideo(this)"
												type="button" class="btn btn-primary">确认</button>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</tbody>
				</table>
				</form>
				<fen:page
					url="${pageContext.request.contextPath}/user/video/selectVideoByCondition.action"></fen:page>
			</div>
		</div>
	</div>
</body>
</html>