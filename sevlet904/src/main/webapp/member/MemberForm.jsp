<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원등록</h1>
	<form action = "add" method="post">
		이름 : <input type='text' name = 'name'><br> 
		이메일 : <input type = 'text' name = 'email'><br>
		암호 : <input type = 'password' name = 'password'><br>
		<input type = 'submit' value = '추가'>
		<input type = 'submit' value = '취소'	>
		</form>
</body>
</html>