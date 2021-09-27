<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/replies/new" method="POST">
	
            <label for="bno">게시글번호</label>
            <input type="text"  name="bno" />
            
            <label for="reply">댓글</label>
            <input type="text"  name="reply" />
      
            <label for="replyer">작성자</label>
            <input type="text" name="replyer" />
            
          <button type="submit">등록</button>
   </form>
</body>
</html>