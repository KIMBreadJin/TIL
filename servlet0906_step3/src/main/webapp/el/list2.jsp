<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="test.Green" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="green.dto.Member"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap" %>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//값 준비
		Map<String, String> map = new HashMap<>();
		map.put("s01","홍길동");
		map.put("s02","임꺽정");
		map.put("s03","일지매");
		pageContext.setAttribute("map",map);
		
		pageContext.setAttribute("member",
				new Member().setNo(100).setName("홍길동").setEmail("as@asdsd.cpm")
		);
		
	%>
	${map.s01}
	${map.s02}
	${map.s03}
	이메일 : ${member.email}
	<ul>
	<c:forEach items="${pp}" var="u">
		<li> <a hred="hello2?no = ${u.no}"> ${u.no}</a>, ${u.name}, ${u.email}</li>
	</c:forEach>
	</ul>

</body>
</html>