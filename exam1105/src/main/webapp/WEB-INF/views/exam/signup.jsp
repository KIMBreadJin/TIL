<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
	<h1> 회원 등록 </h1>
	<form action ="/exam/signup" method="post">
		이름 : <input type='text' name='sname'><br>  
		비밀번호 : <input type='text' name ='spassword'><br>
		주소 : <select name="address">
				    <option value="">주소선택</option>
				    <option value="seoul">서울</option>
				    <option value="daejeon">대전</option>
				    <option value="daegu">대구</option>
				    <option value="busan">부산</option>
			  </select><br>
		상세주소 : <input type='text' name ='address2'><br>
		집전화 : <input type='text' name ='phone' value=""><br>
		폰전화 : <input type='text' name ='phone2'><br>
		<input type='submit' value ='추가'>
		<input type='reset' value ='취소'>
	</form>
	
</body>
</html>