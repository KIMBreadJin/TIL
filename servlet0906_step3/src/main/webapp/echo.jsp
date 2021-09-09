<%@ page import="test.Echo" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "myEcho" class="test.Echo" scope="page"></jsp:useBean>
<jsp:setProperty name ="myEcho" property="msg"/>

<%
	out.print("Echo 빈즈에서 받은 내용: " +myEcho.getMsg()+"<br>");
%>