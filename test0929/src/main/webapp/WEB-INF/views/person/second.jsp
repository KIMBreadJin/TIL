<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>지역 총인원 많은 순서</h1>

    <h4>#인원 많은 지역순</h4> 
    <ol type ="1">
      <c:forEach items="${sec}" var="sec">  
      	<li>
      		${sec.address}
      	</li>
        </c:forEach>
    </ol>
</body>
</html>