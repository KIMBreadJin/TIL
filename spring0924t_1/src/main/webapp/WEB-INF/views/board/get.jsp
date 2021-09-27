<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시글 조회</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">게시글 조회 페이지</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
          <div class="form-group">
            <label for="title">번호</label>
            <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly" />
          </div>
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" name="title" value="${board.title}" readonly="readonly" />
          </div>
          <div class="form-group">
            <label for="content">내용</label>
            <textarea name="content" id="content" rows="3" class="form-control" readonly="readonly">${board.content}</textarea>
          </div>
          <div class="form-group">
            <label for="writer">저자</label>
            <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly"/>
          </div>
          <button data-oper ="modify" class="btn btn-default" type="submit">수정</button>
          <button data-oper ="list" class="btn btn-info" type="submit">목록</button>
          <form action="/board/modify" method="get" id="operForm">
          	<input type="hidden" id='bno' name='bno' value="${board.bno}"/>
          	<input type="hidden" name='pageNum' value="${cri.pageNum}"/>
          	<input type="hidden" name='amount' value="${cri.amount}"/>
          	<input type="hidden" name='keyword' value="${cri.keyword}"/>
          	<input type="hidden" name='type' value="${cri.type}"/>
          </form>
      </div>
      <!-- /.panel-boby -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->
</div>
<!--  /.row -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	$(document).ready(function () {
		console.log("============")
		console.log("JS TEST")
		var bnoValue = '<c:out value = "${board.bno}"/>'
		/* replyService.add(
			{reply:"JS Test", replyer: "tester", bno:bnoValue},
			
			function(result){
				alert("RESULT: " + result)
			}
		); */
		/* replyService.getList({bno:bnoValue,page:1}, (list)=>{
			for (var i=0, len=list.length||0; i<len; i++) {
				console.log(list[i]);			
			}
		}) */
		replyService.remove(2,
			(count)=>{
			console.log(count);
				if(count =="success") alert("삭제되었음")
			},
			(err)=>{
				alert("error 발생")
			}
		)
		var operForm = $("#operForm");
		$("button[data-oper='modify']").click(function(e){
			operForm.attr("action","/board/modify").submit();
		})
		$("button[data-oper='list']").click(function(e){
			operForm.find("#bno").remove();//operForm 에서 id가 bno인 것을 찾아 데이터 삭제 
			operForm.attr("action","/board/list").submit();
		})
	})

</script>
<%@ include file="../includes/footer.jsp" %>
