<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int score = 83;
		int i = score/10;
		if(i==10){
			//만점입니다. 수고하셨습니다 출력
			out.print("만점입니다. 수고하셨습니다");
		}
		else if(i >= 9){
			out.print("90점대 입니다. 조금만 더 노력하세요");
		}
		else if(i >= 8){
			out.print("80점대입니다. 열심히 하세요");
		}
		else {
			out.print("80대 미만입니다. 많이 노력하세요");
		}
		
		// 9일경우 90점대 입니다. 조금만 더 노력하세요
		//8일 경우 80점대입니다. 열심히 하세요
		//그렇지 않으면 80대 미만입니다. 많이 노력하세요
		%>
		<a href = "switch.jsp">switch로 가기</a>
</body>
</html>