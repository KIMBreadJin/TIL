<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.green.dto.Member" %>
<jsp:useBean id="member" scope="session" class="com.green.dto.Member" type="com.green.dto.Member"></jsp:useBean>
<div style="background-color:#00008b; color:#ffffff; height:20px; padding:5px;">
	GMPS(Green Computer Management System)
	<% if(member.getEmail() != null) { %>
	<span style="float:right">
	<%= member.getName() %>
	<a style="color:white" href="<%=request.getContextPath() %>/auth/logout">로그아웃</a>
	</span>
	<%} %>
	<!--  현재 경로 얻어오기  getContextPath  -->
</div>

