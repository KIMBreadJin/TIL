<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시글 수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">게시판 수정 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <form action="/board/modify" method="POST">
          <div class="form-group">
            <label for="title">번호</label>
            <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly" />
          </div>
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" value="${board.title}" />
          </div>
          <div class="form-group">
            <label for="content">내용</label>
            <textarea name="content" id="content" rows="3" class="form-control">"${board.content}" </textarea>
          </div>
          <div class="form-group">
            <label for="title">저자</label>
            <input type="text" class="form-control" name="writer" value="${board.writer}" />
          </div>
          <div class="form-group">
            <label for="regDate">등록일</label>
            <input
              type="text"
              class="form-control"
              name="regDate"
              value='<fmt:formatDate pattern = "yyyy-MM-dd" value="${board.regDate}"/>'
              readonly="readonly"
            />
          </div>
          <div class="form-group">
            <label for="regDate">수정일</label>
            <input
              type="text"
              class="form-control"
              name="updateDate"
              value='<fmt:formatDate pattern = "yyyy-MM-dd" value="${board.updateDate}"/>'
              readonly="readonly"
            />
          </div>
          <button data-oper="modify" class="btn btn-default" type="submit">수정</button>
          <button data-oper="remove" class="btn btn-danger" type="submit">삭제</button>
          <button data-oper="list" class="btn btn-info" type="submit">목록</button>
        </form>
      </div>
      <!-- /.panel-heading -->
    </div>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script>
  $(document).ready(function () {
    var formObj = $('form')
    $('button').click(function (e) {
      e.preventDefault() // 기본 동작을 막고 마지막에 submit 을 적용함
      var operation = $(this).data('oper')
      console.log(operation)
      if (operation === 'remove') formObj.attr('action', '/board/remove')
      else if (operation === 'list') {
       	formObj.attr("action","/board/list").attr("method","get");
        formObj.empty();
      }
      formObj.submit()
    })
  })
</script>

<%@ include file="../includes/footer.jsp" %>
