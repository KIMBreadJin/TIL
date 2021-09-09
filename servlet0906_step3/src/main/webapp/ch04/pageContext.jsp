<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	out.print("out.print() 메서드를 이용해서 출력합니다.");
	//pageContext의 내장 객체의 getOut() 메서드를 통해 print() 메서드 호출
	pageContext.getOut().print("pageContext.getOut() 메서드를 통해 출력합니다. <br>");
	%>

</body>
</html>