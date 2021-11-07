<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
   <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <style type="text/css">
      div#container {
        width: 95%;
        margin: 0 auto;
      }

      table {
        width: 90%;
        border: solid 1px gray;
        border-collapse: collapse;
        margin-top: 30px;
        text-align: center;
      }

      th,
      td {
        border: solid 1px gray;
        border-collapse: collapse;
      }

      tbody tr:hover {
        background-color: #ccc;
        cursor: pointer;
      }

      button {
        margin-top: 30px;
        margin-right: 180px;
        float: right;
      }
      h1,
      form {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <div id="container">
      <h1>구매 목록</h1>
      <table>
        <thead>
          <tr>
            <th>#번호</th>
            <th>제품</th>
            <th>운송번호</th>
            <th>수량</th>
            <th>제품가격</th>
            <th>쿠폰 할인가</th>
            <th>최종 가격</th>
          </tr>
        </thead>
        <c:forEach items="${blist}" var="blist">
          <tr>
            <td>${blist.sid}</td>
            <td>${blist.product}</td>
            <td>${blist.bnum}</td>
            <td>${blist.amount}</td>
            <td>${blist.price}</td>
            <td>${blist.coupon}</td>
            <td>${blist.total}</td>
          </tr>
        </c:forEach>
      </table>
      <form action="/exam/takeback" method="post" >
      	운송번호 : <input type="text" name="bnum">
		<input type="submit" id="takeback" value="반품"></input>
	  </form>
	  
	  <form action="/exam/buy" method="get" >
	  	<input type="hidden" name="sname" value="${list.sname}" />
	  	<input type="hidden" name="spassword" value="${list.spassword}" />
		<input type="submit" id="buy" value="더 구매하러 가기"></input>
	  </form>
 <script>
      $(document).ready(function () {
    	  $('#takeback').click(function () {
    		  alert("반품되었습니다.")
    	  })
      })
    </script>
    </div>
  </body>
</html>
