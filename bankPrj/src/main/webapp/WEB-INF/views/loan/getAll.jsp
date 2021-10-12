<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>대출 목록 </title>
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
  <body>
    <h4> 대출 현황</h4>
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">번호</th>
          <th scope="col">계좌번호</th>
          <th scope="col">이름</th>
          <th scope="col">비밀번호</th>
          <th scope="col">상환</th>
          <th scope="col">출금</th>
          <th scope="col">잔액</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${list}" var="i">
          <tr>
            <td>${i.loan_id}</td>
            <td>${i.loan_serial}</td>
            <td>${i.loan_name}</td>
            <td>${i.loan_password}</td>
            <td>${i.loan_deposit}</td>
            <td>${i.loan_withdraw}</td>
            <td>${i.loan_balance}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
