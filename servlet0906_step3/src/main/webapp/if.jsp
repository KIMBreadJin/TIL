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
		boolean flag  =true;
		if(flag==true) out.print("flag값은 true 입니다. <br>");
		out.print("if문을 벗어났습니다 ");
	%>
	<a href="if2.jsp">if2로 가기</a>
</body>
</html>