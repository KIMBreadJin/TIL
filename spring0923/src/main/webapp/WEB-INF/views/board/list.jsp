<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">목록</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        게시판 목록 페이지
        <button id="regBtn" type="button" class="btn btn-xs pull-right">새로운 게시글 등록</button>
      </div>
      <!-- /.panel-heading -->
      <div class="panel-body">
        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
          <thead>
            <tr>
              <th>#번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>수정일</th>
            </tr>
          </thead>
          <c:forEach items="${list}" var="board">
            <tr>
              <td>${board.bno}</td>
              <td><a href='/board/get?bno=<c:out value="${board.bno}"/>'> ${board.title}</a></td>
              <td>${board.writer}</td>
              <td><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></td>
              <td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd" /></td>
            </tr>
          </c:forEach>
        </table>
        <div class="pull-right">
          <ul class="pagination">
            <c:if test="${pageMaker.prev}">
              <li class="paginate_button previous">
                <a href="${pageMaker.startPage-1}">이전</a>
              </li>
            </c:if>

            <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
              <li class="pagenate_button">
                <a href="${num}">${num}</a>
              </li>
            </c:forEach>

            <c:if test="${pageMaker.next}">
              <li class="pagenate_button next">
                <a href="${pageMaker.endPage+1}">다음</a>
              </li>
            </c:if>
          </ul>
          <c:forEach var="amt" begin="10" end="100" step="5">
              <li class="pagenate_button_1">
                <a href="${amt}">${amt}</a>
              </li>
            </c:forEach>
		</div>
        <!-- end pagination-->
		<form action="/board/list" id = "actionForm" method="get">
			<input type='text' name ="pageNum" value="${pageMaker.cri.pageNum}">
			<input type='text' name ="amount" value="${pageMaker.cri.amount}">
		</form>
        <!-- 모달 추가 -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <button class="close" data-dismiss="modal" type="button">&times;</button>
              <h4 class="modal-title" id="myModalLabel">모달 제목</h4>
              <div class="modal-body">처리가 완료되었습니다</div>
              <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">닫기</button>
                <button class="btn btn-primary" type="button">변경된 내용 저장</button>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
      <script type="text/javascript">
        $(document).ready(function () {
          var result = '<c:out value="${result}"/>'
          checkModal(result)
          history.replaceState({}, null, null)
          function checkModal(result) {
            if (result === '' || history.state) return
            if (parseInt(result) > 0) $('.modal-body').html('게시글 ' + parseInt(result) + '번이 등록되었습니다.')
            $('#myModal').modal('show')
          }
          $('#regBtn').click(function () {
            self.location = '/board/register'
          })
          var actionForm = $("#actionForm");
          $(".pagenate_button a").click(function(e){
        	  e.preventDefault();
        	  var thisis = $(this).attr("href");
        	  console.log("페이지 로직이 늘어났어요" + thisis);
        	  actionForm.find("input[name='pageNum']").val(thisis);
        	  //눌린 페이지 번호(this)의 속성이 href인 것의 값(url 주소)를 input태그의 속성(name)의 pageNum인 요소를 찾아 거기에 추가한다
          })
           $(".pagenate_button_1 a").click(function(e){
        	  e.preventDefault();
        	  var thisis = $(this).attr("href");
        	  console.log("amount 변경" + thisis);
        	  actionForm.find("input[name='amount']").val(thisis);
          })
        })
      </script>

      <%@ include file="../includes/footer.jsp" %>
    </div>
  </div>
</div>
