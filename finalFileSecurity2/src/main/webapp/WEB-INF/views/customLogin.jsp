<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
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
    <script src="/resources/dist/js/sb-admin-2.js"></script>
  </head>
  <body>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4">
          <div class="login-panel panel panel-default">
            <div class="panel-heading">
              <div class="panel-title">로그인 페이지</div>
            </div>
            <div class="panel-body">
              <form role="form" method="post" action="/login">
                <fieldset>
                  <div class="form-group">
                    <input type="text" id="username" name="username" value="admin" />
                  </div>
                  <div class="form-group">
                    <input type="text" id="password" name="password" value="admin" />
                  </div>
                  <div>
                    <input type="hidden" class="logout" name="logout" value="${logout}" />
                  </div>
                  <div class="checkbox">
                    <label> <input type="checkbox" name="remember" value="로그인 저장" />로그인 저장 </label>
                  </div>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div>
                  <button class="btn-success">로그인</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
      $(document).ready(function (e) {
        $('.btn-success').click(function () {
          e.preventDefault()
          $('form').submit()
          if ('.logout'.val() != null) {
            $('.logout').attr('type', 'text')
          }
        })
      })
    </script>
  </body>
</html>
