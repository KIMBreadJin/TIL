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
	<jsp:include page="/Header.jsp"></jsp:include>
	<h1>회원목록</h1>
	<p><a href='add'>신규회원</a></p>
	<c:forEach var ="member" items = "${members}">
		번호: ${member.no},
		<a href='update?no=${member.no}'>${member.name}</a>,
		${member.email},
		${member.createdDate}
		<a href='delete?no=${member.no}'>[삭제]</a><br>
	</c:forEach>
	<jsp:include page="/Tail.jsp"></jsp:include>
</body>
</html>