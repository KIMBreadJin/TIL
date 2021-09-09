<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "test.Green" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	부산이다 <br>
	<%
		Green q= (Green)session.getAttribute("a");
	%>
	<% q.setTire(11); %>
	<% q.setDriver(22); %>
	<% q.setWindow(33); %>
	<% q.setName("김부산"); %>

</body>
</html>