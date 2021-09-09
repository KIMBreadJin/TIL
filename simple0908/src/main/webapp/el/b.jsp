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
 <c:forEach var= "i" items="${li}">
	<li> 
		타이어 : ${li.tire}
		윈도우 : ${li.window}
		운전자 : ${li.name}
		이름	  : ${li.driver}
	</li>
	</c:forEach>
</body>
</html>