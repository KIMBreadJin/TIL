<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import = "java.util.ArrayList" %>
 <%@ page import = "java.util.List" %>
 <%@ page import = "green.dto.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Header.jsp"></jsp:include>
	<c:forEach var ="member" items = "${members}">
		번호: ${member.no},
		<a href='update?no=${member.no}'>${member.name}</a>,
		${member.email},
		${member.createdDate}
		<a href='delete?no=${member.no}'>[삭제]</a><br>
	</c:forEach>
	<a href="/auth/logout">로그아웃</a>
	<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>