<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/security/tags" prefix="sec" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />

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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>    
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <h1>Custom Logout 페이지</h1>
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <div class="login-panel panel paenl-default">
            <div class="panel-heading">
              <h3 class="panel-title">로그아웃</h3>
            </div>
            <div class="panel-body">
              <form action="/customLogout" method="post">
                <fieldset>
                  <button class="btn btn-lg btn-success btn-block">로그아웃</button>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
        $(document).ready(function (e) {
          $('.btn btn-lg btn-success btn-block').click(function () {
            console.log('눌리나')
            alert('로그아웃 하셨습니다.')
            e.preventDefault()
            $('form').submit()
          })
        })
      </script>
     <c:if test="${param.logout != null}">
    </c:if>
  </body>
</html>
