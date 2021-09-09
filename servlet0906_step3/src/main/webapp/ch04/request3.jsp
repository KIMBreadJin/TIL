<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String formData = request.getParameter("data");
	out.print("웹 브라우저로부터 받은 데이터 : " + formData);
	jsp의 스크립트릿<% %>, 표현식 <%= %>, <%! %>
	내장객체, out, request
	액션 태그 => include, forward, useBean, serProperty
	지시자(directive) page import
	response
%>