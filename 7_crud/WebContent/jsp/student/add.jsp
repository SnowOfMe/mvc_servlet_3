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
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#submitBtn").click(function(){
			
			//取得表单  提交表单
			$("#myForm").submit();
		
		})
	
	})

</script>
</head>
<body>
	
	<h3>我是添加页</h3>
	<form action="student/save.do" method="post" id="myForm">
		请输入姓名:<input type="text" name="name"/><br/><br/>
		请输入年龄:<input type="text" name="age"/><br/><br/>
		<!-- <input type="submit" value="提交"/> -->
		<button type="button" id="submitBtn">提交123</button>
	</form>
	
</body>
</html>


























