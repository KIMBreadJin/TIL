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
		String userId = request.getParameter("id");
		String userPassword = request.getParameter("pwd");
		String sessionId = session.getId();
		session.setMaxInactiveInterval(1);
		int sessionTime = session.getMaxInactiveInterval();
		// invalidate() 호춣, 세션시간 설정
		out.print(userId + " 님 환영합니다 <p>");
		out.print(" 생성된 세션 id : " + sessionId + "<p>");
		out.print(" 세션 유지 시간 : " + sessionTime + "<p>");
		
	%>

</body>
</html>