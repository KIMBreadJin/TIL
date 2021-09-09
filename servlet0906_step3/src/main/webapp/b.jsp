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
		String name;
		int hakbun;
		name="임꺽정";
		hakbun = 2010001;
		
	%>
	<%!
		class Green{
			private int ab;
			public int getAb(){return this.ab;}
			public void setAb(int ab){this.ab=ab;}
		}
	%>
	<%= name %>
	<%= hakbun %> 
	<% 
		Green a = new Green();
		a.setAb(11);
	%>
	<br>
	객체 생성 후 저장된 멤버변수의 값은 <%= a.getAb() %>
	<a href = "c.jsp"> 어려운 문제 풀기 </a>
</body>
</html>