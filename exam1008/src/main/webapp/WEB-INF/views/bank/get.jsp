<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>입/출금</title>
    <style>
      td {
        text-align: center;
      }
      table.main {
        width: 800px;
      }
    </style>
  </head>
  <body>
    <h1>입/출금</h1>
    <table class="main" border="1"  align="center">
      <thead>
        <tr>
          <th>#번호</th>
          <th>이름</th>
          <th>계좌번호</th>
        </tr>
      </thead>
      <tr>
        <td>${list.free_id}</td>
        <td>${list.free_name}</td>
        <td>${list.free_serial}</td>
      </tr>
    </table>
    <br>
    <table border="1" width = "500px" align="center">
      <thead>
        <tr>
          <th>잔액</th>
        </tr>
      </thead>
      <tr>
        <td>${list.fmoney}</td>
      </tr>
    </table>
    <br>
    <form action="/bank/deposit" method="post" align="center">
        <input type="number" name="fdeposit" min="0" max="10000"/>
        <input type="hidden" name="fmoney" value="${list.fmoney}" />
        <input type="hidden" name="free_id" value="${list.free_id}" />
		<button type="submit" class="deposit" align="center">입금하기</button>	
	</form>
	<form action="/bank/withdraw" method="post" align="center">
		<input type="number" name="fwithdraw" min="0" max="${list.fmoney}" />
        <input type="hidden" name="fmoney" value="${list.fmoney}" />
        <input type="hidden" name="free_id" value="${list.free_id}" />
		<button type="submit" class="withdraw" align="center">출금하기</button>
	</form>
    <script>
      $(document).ready(function () {
		$('button').click(function(e){
			console.log("새로고침");
			 location.reload();
		})
      })
    </script>
  </body>
</html>
