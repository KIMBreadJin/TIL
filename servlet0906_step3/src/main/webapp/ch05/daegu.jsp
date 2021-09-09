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
	대구다<br>
	<%
		Green w= (Green)session.getAttribute("b");
	%>
	<% w.setTire(500); %>
	<% w.setDriver(400); %>
	<% w.setWindow(512); %>
	<% w.setName("이대구"); %>

</body>
</html>