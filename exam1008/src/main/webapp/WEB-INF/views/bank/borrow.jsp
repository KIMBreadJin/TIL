<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>고객 리스트</title>
    <style>
      td {
        text-align: center;
      }
      table {
        width: 800px;
      }
    </style>
  </head>
  <body>
    <h1>고객 명단</h1>
    <table border="1" align="center">
      <thead>
        <tr>
          <th>#번호</th>
          <th>이름</th>
          <th>대출가능총액</th>
          <th>최근 대출 출금액</th>
          <th>대출잔액</th>
          <th>대출가능여부</th>
        </tr>
      </thead>
      <tr>
        <td>${borw.free_id}</td>
        <td>${borw.free_name}</td>
        <td>${borw.loan_total}</td>
        <td>${borw.loan_withdraw}</td>
        <td>${borw.lmoney}</td>
        <td>${list.borrowable}</td>
      </tr>
    </table>
    <br />
    <div align="center">
      <h3>대출받을 금액</h3>
      <form action="/bank/update" method="POST">
        <input type="number" name="loan_withdraw" min="0" max="${borw.lmoney}" />
        <input type="hidden" name="lmoney" value="${borw.lmoney}" />
        <input type="hidden" name="free_id" value="${borw.free_id}" />
        <input type="submit" id="button" value="대출 받기"></button>
      </form>
    </div>
    <br />
    <form action="/bank/insert" method="get" align="center">
      <input type="hidden" name="free_id" value="${list.free_id}" />
      <input type="hidden" name="free_name" value="${list.free_name}" />
      <input type="hidden" name="loan_total" value="${list.fmoney*10}" />
      <input type="hidden" name="loan_withdraw" value="0" />
      <input type="hidden" name="lmoney" value="${list.fmoney*10}" />
      <h4>처음 대출 받으시는 고객님은 '대출 신청' 을 눌러주세요</h4>
      <input type="submit" id="add" value="대출 신청" />
    </form>

    <script>
       $(document).ready(function () {
        	if(${list.fmoney} < 500){
        	 	$('#button').attr("type", "hidden");
        		$('#input').attr("type", "hidden");
        		$('#add').attr("type", "hidden");
        	}
        	if(${borw.lmoney} < 1){
		        alert("대출 한도가 초과했습니다.");
		        self.location='/bank/list'
      	}
      })
    </script>
  </body>
</html>
