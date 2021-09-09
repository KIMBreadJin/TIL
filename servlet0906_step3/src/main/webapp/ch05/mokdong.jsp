<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "test.Green" %>

<%

	Green gr = new Green();
	session.setAttribute("a", gr);
	
	Green gr2 = new Green();
	session.setAttribute("b", gr2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="busan.jsp"/>
	이름 : <%= gr.getName() %> <br>
	타이어 : <%= gr.getTire() %> <br>
	드라이버 : <%= gr.getDriver() %> <br>
	윈도우 : <%= gr.getWindow() %> <br><br>
<jsp:include page="daegu.jsp"/>	
	이름 : <%= gr2.getName() %> <br>
	타이어 : <%= gr2.getTire() %> <br>
	드라이버 : <%= gr2.getDriver() %> <br>
	윈도우 : <%= gr2.getWindow() %> <br>	
</body>
</html>