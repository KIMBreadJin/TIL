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
	<ul>
	<c:forEach var= "i" items="${tt}">
	<li> 
		타이어 : ${tt.tire}
		윈도우 : ${tt.window}
		운전자 : ${tt.name}
		이름	  : ${tt.driver}
	</li>
	</c:forEach>
	</ul>
</body>
</html>