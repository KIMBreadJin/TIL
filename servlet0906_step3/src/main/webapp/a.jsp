<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 사용하기</title>
</head>
<body>
	<%! int b=200;  // '!' => 선언문 %> 
	<% int a=100;
		out.print("이곳에 자바 코드를 사용할 수 있어요 <br>");
	%>
	HTML 태그를 사용하여 줄바꿈
	<%
		out.print("변수 a의 값은 " + a + "<br>"); 
		out.print("\' out.print() \' 메서드 내부에서는 HTML 태그 사용이 가능하다 <br>"); 
	%>
	<%= "<b> 출력문에서도 당연히 html 태그를 사용할 수 있다 </b>" %>
	<%= b %>
	<a href = "b.jsp">b로가라</a>
</body>
</html>