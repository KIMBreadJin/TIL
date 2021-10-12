<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>회원등록</title>
    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet" />

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet" />

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet" />

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet" />

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  </head>
  <script>
  	$(document).ready(function(e){
  		$("input[name='free_deposit']").change(function(e){
  			$("input[name='free_withdraw']").val("0");
  		})
  		$("input[name='free_withdraw']").change(function(e){
  			$("input[name='free_deposit']").val("0");
  		})
  		$("button.btn-default").click(function(e){
  			$("form[action='/loan/register']").submit();
  		})
  	})
  
  </script>
  <body>
    <h4>예금거래</h4>
    <div class="panel_heading">
      <form action="/free/register" method="post" role="form">
        <div class="form-group">
          <label for="free_name">이름</label>
          <input type="text" class="form-control" name="free_name" value="${list.free_name}" readonly />
        </div>
        <div class="form-group">
          <label for="free_serial">계좌번호 </label>
          <input type="text" class="form-control" name="free_serial" value="${list.free_serial}" readonly />
        </div>
        <div class="form-group">
          <label for="free_deposit">입금 </label>
          <input type="text" class="form-control" name="free_deposit" />
        </div>
        <div class="form-group">
          <label for="free_withdraw">출금 </label>
          <input type="text" class="form-control" name="free_withdraw" />
        </div>
        <div class="form-group">
          <label for="free_balance">잔액 </label>
          <input type="text" class="form-control" name="free_balance" value="${list.free_balance}" />
        </div>
        <button class="btn btn-default">등록</button>
      </form>
      <form action="/loan/register" method="get">
      	<input type="hidden" value="${list.free_name}" name ="loan_name"/>
      </form>
      <div>
      	<c:choose> 
      		<c:when test="${list.free_loan eq 'Y'}">
      			<button class="btn btn-default" type="submit">대출가능</button>
      		</c:when>
      		<c:otherwise>
      			<button class="btn btn-default" type="submit">대출불가</button>
      		</c:otherwise>
      	</c:choose>
      </div>
    </div>
  </body>
</html>
