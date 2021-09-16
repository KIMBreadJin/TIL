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

	<h1>학생 명단</h1>
	<p><a href='add'>점수추가</a></p>
	<h3>번호/이름/국어/수학/영어/총점/평균/pnp</h3>
	<c:forEach var ="score" items = "${scores}">
	<h3>> ${score.sno},
		<a href='update?sno=${score.sno}'>${score.sname}</a>,
		${score.korea},
		${score.math},
		${score.eng},
		${score.total},
		${score.avg},
		${score.isFail} </h3>
	</c:forEach>
</body>
</html>