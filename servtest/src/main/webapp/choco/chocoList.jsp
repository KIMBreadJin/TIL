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
	<c:forEach var ="choco" items = "${chocos}">
		국어: ${choco.korea},
		수학: ${choco.math},
		영어: ${choco.eng},
		주소: ${choco.address},
		핸드폰: ${choco.phone},
		파더: ${choco.father}
	</c:forEach>
</body>
</html>