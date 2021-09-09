<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= "jsp 컨테이너 정보 :" + application.getServerInfo() + "<br>" %>
	<%= "jsp 컨테이너 Major정보 :" + application.getMajorVersion() + "<br>" %>
	<%= "jsp 컨테이너 Minor정보 :" + application.getMinorVersion() + "<br>" %>
	
	3.1 servlet 버전
	application (servletContext) > Session (login~logout, 타임아웃) > request ~ reponse > page(pageContext)
</body>
</html>