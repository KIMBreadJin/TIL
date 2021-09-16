<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	안녕하세요? 깨질지모르니 영어로 Hi hello
	<form action="/sample/b">
		<div>
			<label for="name"> 이름 </label>
			<input type="text" name="name" id ="name"/>
		</div>
		<div>
			<label for="pwd"> 암호 </label>
			<input type="text" name="pwd" id ="pwd"/>
		</div>
		<div>
			<label for="kor"> 국어 </label>
			<input type="text" name="kor" id ="kor"/>
		</div>
		<div>
			<label for="math"> 수학 </label>
			<input type="text" name="math" id ="math"/>
		</div>
		<div>
			<label for="eng"> 영어 </label>
			<input type="text" name="eng" id ="eng"/>
		</div>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>