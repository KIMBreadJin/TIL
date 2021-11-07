<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div  align="center">
	<h1>로그인</h1> 
	<form action="/exam/buy" method="get" >
		<table border="1">
		<col width="100"><col width="100">
			<tr>
				<th>N A M E</th>
				<td><input type="text" name = "sname"></td>
			</tr>
			<tr>
				<th>P W D</th>
				<td><input type="text" name = "spassword"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	<form action="/exam/signup" method="get" >
		<button type="submit">회원가입</button>
	</form>
</div>
</body>
</html>