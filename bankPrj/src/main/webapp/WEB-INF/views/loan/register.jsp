<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>대출관리</title>
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
  		$("input[name='loan_deposit']").change(function(e){
  			$("input[name='loan_withdraw']").val("0");
  		})
  		$("input[name='loan_withdraw']").change(function(e){
  			$("input[name='loan_deposit']").val("0");
  		})
  	})
  </script>
  <body>
    <h4>대출거래</h4>
    <div class="panel_heading">
      <form action="/loan/register" method="post" role="form">
        <div class="form-group">
          <label for="loan_name">이름</label>
          <input type="text" class="form-control" name="loan_name" value="${list.loan_name}" readonly />
        </div>
        <div class="form-group">
          <label for="loan_serial">계좌번호 </label>
          <input type="text" class="form-control" name="loan_serial" value="${list.loan_serial}" readonly />
        </div>
        <div class="form-group">
          <label for="loan_deposit">상환 </label>
          <input type="text" class="form-control" name="loan_deposit" />
        </div>
        <div class="form-group">
          <label for="loan_withdraw">출금 </label>
          <input type="text" class="form-control" name="loan_withdraw" />
        </div>
        <div class="form-group">
          <label for="loan_balance">잔액 </label>
          <input type="text" class="form-control" name="loan_balance" value="${list.loan_balance}" />
        </div>
        <button class="btn btn-default">등록</button>
      </form>
    </div>
  </body>
</html>
