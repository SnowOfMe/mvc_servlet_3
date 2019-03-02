<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	td{
		text-align: center
	}
</style>
<script type="text/javascript">
			 $.post(
				"student/list2.do",
				function(data){
					$(data.list).each(function(i){
						$("#tbody").append("<tr><td><input type='checkbox' name='xz'></td><td>"+i+"</td><td>"+this.id
								+"</td><td>"+this.name+"</td><td>"+this.age+"</td><td><a>编辑</a>||<a>删除</a></td></tr>");
					})
				},
				"json"
			) 
			$.post(
				"select/province.do",
				function(data){
					$(data.plist).each(function(i){
						$("#pid").append("<option value="+this.id+">"+this.name+"</option>");
					}) 
				},
				"json"
			)
	$(function(){
		$("#pid").change(function(){
			$("#cid").html("<option>---请选择---</option>");
			var $pid = $("#pid").val();
			$.post(
					"select/city.do",
					{"pid":$pid},
					function(data){
						$(data.clist).each(function(i){
							$("#cid").append("<option value="+this.id+">"+this.name+"</option>");
						}) 
					},
					"json"
				)
		})
		
	})
</script>
</head>
<body>
	<h3 align="center">学生信息管理系统</h3>	
	<span style="margin-left: 270px" >欢迎您:${username}&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="pid">
			<option>---请选择---</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="cid">
			<option>---请选择---</option>
		</select>
	</span><br/>
	<hr/><br>
	<table align="center" border="1" cellpadding="6" width="60%">
		<thead>
			<tr>
				<td><input type="checkbox" name="qx" id="topc"></td>
				<td>编号</td>
				<td>ID</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
</body>
</html>