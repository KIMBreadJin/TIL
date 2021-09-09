<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<b> request 객체 정보 </b><p>
<%="인코딩 방식 :" + request.getCharacterEncoding() + "<p>" %>
<%="MIME 타입 :" + request.getContentType() + "<p>" %>
<%="요청 정보 길이 : " + request.getContentLength()+"<p>" %>
<%="헤더 이름 : " + request.getHeaderNames() + "<p>" %>
<%="웹 전달 경로 : " + request.getPathInfo() + "<p>" %>
<%="클라이언트 이름 : " + request.getRemoteHost() + "<p>" %>
<%="클라이언트 ip주소 : " + request.getRemoteAddr() + "<p>" %>
<%="클라이언트 url 주소 : " + request.getRequestURL() + "<p>" %>
<%="전송 방식 : " + request.getMethod() + "<p>"%>
<%="프로토콜 이름 : " + request.getProtocol() + "<p>"%>
<%="서버 이름: " + request.getServerName() + "<p>"%>
<%="서버 포트 번호: " + request.getServerPort() + "<p>"%>

jsp 내에서 out, request, response 내장 객체


<a href="ch04/request2.html"> request2.html로 이동</a>

<a href="ch04/request3.html">request3.html로 이동</a>