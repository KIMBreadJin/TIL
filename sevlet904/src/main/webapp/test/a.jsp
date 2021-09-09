<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	홍길동
	
	<h1>번호 이름 이메일</h1>
	<ul>
	<c:forEach items="${d}" var ="i">
		<li>${i.no} ,${i.name}, ${i.email}</li>
	</c:forEach>
	</ul>
	
</body>
</html>