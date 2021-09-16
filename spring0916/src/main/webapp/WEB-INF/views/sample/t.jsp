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
	여기는 t 입니다. 
	<ul>
	<c:forEach items="${name2}" var="name">
		<li> 번호는  ${name.num} ,  이름은 ${name.name} ,  암호 는  ${name.pwd} , 국어는  ${name.kor} , 영어는 ${name.eng} , 수학은 ${name.math} </li>

	</c:forEach>
	</ul> 
</body>
</html>