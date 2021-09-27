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
      <div class="panel-heading">게시글 수정 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <form action="/board/modify" method="POST">
        	<input type='hidden' name='pageNum' value='${cri.pageNum}'>
        	<input type='hidden' name='amount' value='${cri.amount}'>
        	<input type="hidden" name='keyword' value="${cri.keyword}"/>
          	<input type="hidden" name='type' value="${cri.type}"/>
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
            <textarea name="content" id="content" rows="3" class="form-control">${board.content}</textarea>
          </div>
          <div class="form-group">
            <label for="writer">저자</label>
            <input type="text" class="form-control" name="writer" value="${board.writer}" />
          </div>
          <div class="form-group">
            <label for="regDate">등록일</label>
            <input
              type="text"
              class="form-control"
              name="regDate"
              value='<fmt:formatDate pattern ="yyyy-MM-dd" value="${board.regDate}"/>'
              readonly="readonly"
            />
          </div>
          <div class="form-group">
            <label for="updateDate">수정일</label>
            <input
              type="text"
              class="form-control"
              name="updateDate"
              value='<fmt:formatDate pattern ="yyyy-MM-dd" value="${board.updateDate}"/>'
              readonly="readonly"
            />
          </div>
          <button data-oper="modify" class="btn btn-default" type="submit">수정</button>
          <button data-oper="remove" class="btn btn-danger" type="submit">삭제</button>
          <button data-oper="list" class="btn btn-info" type="submit">목록</button>
        </form>
      </div>
      <!-- /.panel-boby -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!--  /.row -->
<script>
  $(document).ready(function(){
    var formObj = $("form");
    $("button").click(function(e){
      e.preventDefault(); //기본 동작을 막고 마지막에 submit() 을 적용함
      var operation = $(this).data('oper'); // data-oper에서의 value를 얻음 , modify, remove ,list
      console.log(operation);
      if(operation ==='remove') formObj.attr("action","/board/remove");
      else if(operation==='list'){
        formObj.attr("action","/board/list").attr("method","get");
        var pageNumTag = $("input[name='pageNum']").clone();//복제(복사)
        var amountTag = $("input[name='amount']").clone();//복제(복사)
        var keywordTag = $("input[name='keyword']").clone();//복제(복사)
        var typeTag = $("input[name='type']").clone();//복제(복사)
        formObj.empty();// form 태그의 데이터 비우기 
        formObj.append(pageNumTag);
        formObj.append(amountTag);
        formObj.append(keywordTag);
        formObj.append(typeTag);
      }
      formObj.submit();
    })
  })
</script>
<%@ include file="../includes/footer.jsp" %>
