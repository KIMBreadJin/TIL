<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="test.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 b 페이지 입니다. 
	<%
		User v = (User)session.getAttribute("t");
	%>
	<%= v.getName() %>
	<%= v.getNum() %>
</body>
</html>