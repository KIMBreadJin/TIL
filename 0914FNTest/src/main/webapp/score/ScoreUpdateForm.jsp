<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생점수</h1>
	<form action="update" method='post'>
	
		번호 : <input type='text' name ='sno' value='${score.sno}' readonly="readonly"/><br>
		이름 : <input type='text' name ='sname' value='${score.sname}' readonly="readonly"/><br>
		국어 : <input type='text' name ='korea' value='${score.korea}'/><br>
		수학 : <input type='text' name ='math' value='${score.math}'/><br>
		영어 : <input type='text' name ='eng' value='${score.eng}'/><br>
		
		<input type='submit' value='저장'/>
		<input type='button' value='삭제'
			onclick='locatino.href="delete?no*${member.no}";'>
		<input type="button" value='취소' onclick='location.href="list"'>
	</form>
</body>
</html>