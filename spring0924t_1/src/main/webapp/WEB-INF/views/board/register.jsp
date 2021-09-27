<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시글 등록</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">게시글 등록 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <form action="/board/register" method="POST" role="form">
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" />
          </div>
          <div class="form-group">
            <label for="content">내용</label>
            <textarea name="content" id="content" rows="3" class="form-control"></textarea>
          </div>
          <div class="form-group">
            <label for="writer">저자</label>
            <input type="text" class="form-control" name="writer" />
          </div>
          <button class="btn btn-default" type="submit">등록</button>
          <button class="btn btn-default" type="reset">초기화</button>
        </form>
      </div>
      <!-- /.panel-boby -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!--  /.row -->
<%@ include file="../includes/footer.jsp" %>
