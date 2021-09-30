<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>가족 리스트</title>
    <style>
      td {
        text-align: center;
      }
      table {
        width: 100%;
      }
    </style>
  </head>

  <body>
    <h1>목록</h1>
    <table>
      <thead>
        <tr>
          <th>#번호</th>
          <th>이름</th>
          <th>아버지성함</th>
          <th>어머니성함</th>
          <th>자녀이름</th>
          <th>주소</th>
          <th>전화번호</th>
          <th>가족인원수</th>
        </tr>
      </thead>

      <c:forEach items="${list}" var="person">
        <tr>
          <td>${person.mpno}</td>
          <td>${person.sname}</td>
          <td>${person.paname}</td>
          <td>${person.maname}</td>
          <td>${person.sonname}</td>
          <td>${person.address}</td>
          <td>${person.phone}</td>
          <td>${person.familynum}</td>
        </tr>
      </c:forEach>
    </table>
    <form action="/person/count" method="post">
		주소입력 : <input type="text" name="address">
				 <input type="submit" value="총인원보기">
	</form>
	<form action="/person/second" method="get">
				<input type="submit" value="총인원순 보기">
	</form>
    <script>
      $(document).ready(function () {
      })
      
    </script>
  </body>
</html>
