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
		int year = 4;
		out.print(year + " 학년입니다 <br>");
		switch(year){
			case 1:
			case 2:
			case 3:	
				out.print("저학년입니다");
				break;
			case 4:
			case 5:
			case 6:			
				out.print("고학년이군요");
				break;
		}
	%>
	<a href ="star.jsp">별찍기</a>
</body>
</html>