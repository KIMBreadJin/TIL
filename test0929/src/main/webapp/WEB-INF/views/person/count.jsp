<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인원조사</title>
 <style>
      td {
        text-align: center;
      }
      table {
        width: 300px;
      }
    </style>
</head>
<body>
   <h1>지역 총인원</h1>
	<table>
      <thead>
        <tr>
          <th>#지역</th>
          <th>인원 총합</th>
        </tr>
      </thead>
        <tr>
          <td>${cnt}</td>
          <td>${count}</td>
        </tr>
    </table>
</body>
</html>