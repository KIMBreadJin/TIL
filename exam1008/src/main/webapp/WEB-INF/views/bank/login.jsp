<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1> 
	<form action="/bank/list" method="post" >
		<table border="1" align="center">
		<col width="100"><col width="100">
			<tr>
				<th>N A M E</th>
				<td><input type="text" name = "free_name"></td>
			</tr>
			<tr>
				<th>P W D</th>
				<td><input type="text" name = "free_password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>