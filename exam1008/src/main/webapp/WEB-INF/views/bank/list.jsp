<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>사용자 정보</title>
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
    <h1>사용자 정보</h1>
    <table class="main" border="1" align="center">
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
    <table width="500px" border="1" align="center">
      <thead>
        <tr>
          <th>입금액</th>
          <th>출금액</th>
          <th>잔액</th>
        </tr>
      </thead>
      <tr>  
      	<td>${list.fdeposit}</td>
      	<td>${list.fwithdraw}</td>
        <td>${list.fmoney}</td>    
      </tr>
    </table>
    <br> 
    
    <form action="/bank/get" method="get" align="center">
		<button type="submit" class="deposit" align="center">입출금하기</button>
	</form>
	<br><br><br>
    <form action="/bank/borrow" method="post" align="center">
		<input type="hidden" name="free_name" value="${list.free_name}" />
     	<input type="submit" id="borrow" value="대출 조회" />
    </form>
  
    <script>
      $(document).ready(function () {
       $('#borrow').click(function(e){
        if(${list.fmoney} < 500){
      	    alert("고객님 대출을 받으실 수 없습니다.");
        }else {
        	alert("고객님은 대출 가능하십니다.")
        }
        
       })
      })
    </script>
  </body>
</html>
