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
	<c:forEach var ="score" items = "${key}">
		 ${score.tno})
		이름 : [${score.tname}]
		수학 :[${score.kor}]
		영어 :[${score.eng}]
		수학 :[${score.math}]
		평균 :[${score.tavg}]
		총점 :[${score.total}]
		등급 :[${score.grade}]
	</c:forEach>
</body>
</html>