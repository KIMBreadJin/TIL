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
          <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly" />
        </div>
        <button data-oper="modify" class="btn btn-default" type="submit">수정</button>
        <button data-oper="list" class="btn btn-info" type="submit">목록</button>
        <form action="/board/modify" method="get" id="operForm">
          <input type="hidden" id="bno" name="bno" value="${board.bno}" />
          <input type="hidden" name="pageNum" value="${cri.pageNum}" />
          <input type="hidden" name="amount" value="${cri.amount}" />
          <input type="hidden" name="keyword" value="${cri.keyword}" />
          <input type="hidden" name="type" value="${cri.type}" />
        </form>
      </div>
      <!-- /.panel-boby -->
    </div>
    <!-- /.panel -->
  </div>
  <!-- /.col-lg-12 -->

  <!--  /.row -->
  <!-- 교재 414 페이지 -->
  <div class="row col-lg-12">
    <!-- panel-->
    <div class="panel panel-default">
      <div class="panel-heading"><i class="fa fa-comments fa-fw">*comment</i></div>
      <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">댓글 등록</button>
    </div>
    <br />
    <!-- panel body-->
    <div class="panel-boby">
      <ul class="chat">
        <li class="left clearfix" data-rno="12">
          <div>
            <div class="header">
              <strong class="primary-font"></strong>
              <small class="pull-right text-muted">2021-09-28 11:06</small>
            </div>
            <p>잘했어요</p>
          </div>
        </li>
        <!-- end reply-->
      </ul>
    </div>
    <!-- end panel , chat-panel-->
    <div class="panel-footer"></div>
  </div>
  <!-- modal 420페이지-->
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button class="close">&times</button>
          <h4 class="modal-title" id="myModalLabel">Modal 댓글</h4>
        </div>
        <!-- modal-header-->
        <div class="modal-body">
          <div class="form-group">
            <label for="">댓글</label>
            <input type="text" class="form-control" name="reply" value="댓글등록!!" />
          </div>
          <div class="form-group">
            <label for="">댓글작성자</label>
            <input type="text" class="form-control" name="replyer" value="댓글작성자!!" />
          </div>
          <div class="form-group">
            <label for="">댓글작성일</label>
            <input type="text" class="form-control" name="replyDate" value="" />
          </div>
        </div>

        <!-- modal-body -->
        <div class="modal-footer">
          <button class="btn btn-warning" id="modalModBtn" type="button">수정</button>
          <button class="btn btn-danger" id="modalRemoveBtn" type="button">삭제</button>
          <button class="btn btn-primary" id="modalRegisterBtn" type="button">등록</button>
          <button class="btn btn-default" id="modalCloseBtn" data-dismiss="modal" type="button">닫기</button>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
  $(document).ready(function () {
    console.log('============')
    console.log('JS TEST')
    var bnoValue = '<c:out value = "${board.bno}"/>'
    var replyUL = $('.chat')

    //showList 함수는 파라미터로 전달되는 page 변수를 이용하여
    //원하는 댓글 페이지 가져옴
    //page번호가 -1로 전달되면 마지막 펭이지를 찾아서 다시 호출(재쉬)
    //사용자가 새로운 댓글을 추가하면 showList(-1)을 호출하여 우선 전에 댓글의 숫자 파악
    //이후에 다시 마지막 페이지를 호출해서 이동하는 방식
    //이러한 방식은 여러번 서버를 호출해야하는 단점이 있으나 댓글의 등록 행위가 댓글조회나
    //페이징에 비해서 적기 떄문에 크게 문제가 되지 않음
    const showList = (page) => {
      replyService.getList({ bno: bnoValue, page: page || 1 },
        	(replyCnt, list) => {
        console.log("ajax 성공 후 전제 목록 댓글 갯수:" +replyCnt)
        console.log("ajax 성공 후 전제 목록:" ,list)
        if(page == -1){
        	pageNum = Math.ceil(replyCnt/10.0) //댓글의 갯수를 10으로 나눈 몫
        	showList(pageNum);
        	return;
        }
          var str = ''
          if (list == null || list.length == 0) {
            replyUL.html('')
            return
          }
          for (var i = 0, len = list.length || 0; i < len; i++) {
            str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>"
            str += " <div><div class = 'header'><strong class='primary-font'>" + list[i].replyer + '</strong>'
            str += "	<small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + '</small></div>'
            str += ' <p>' + list[i].reply + '</p></div></li>'
          } //for
          replyUL.html(str)
          showReplyPage(replyCnt) // 아래 정의한 함수 호출
        } //성공시 호출되는 콜백함수
      ) //getList
    } //showList
    showList(1) //함수 호출, (page 439)
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
    /* replyService.remove(2,
  	(count)=>{
  	console.log(count);
  		if(count =="success") alert("삭제되었음")
  	},
  	(err)=>{
  		alert("error 발생")
  	}
  ) */
    /* 		replyService.update({
  	rno:63,
  	bno:bnoValue,
  	reply:"수정된 댓글123"},
  	(result) => alert("수정완료" +result)
  ) */
 //   replyService.get(63, (data) => console.log(data))
    var operForm = $('#operForm')
    $("button[data-oper='modify']").click(function (e) {
      operForm.attr('action', '/board/modify').submit()
    })
    $("button[data-oper='list']").click(function (e) {
      operForm.find('#bno').remove() //operForm 에서 id가 bno인 것을 찾아 데이터 삭제
      operForm.attr('action', '/board/list').submit()
    })
    var modal = $('.modal')
    var modalInputReply = modal.find("input[name='reply']")
    var modalInputReplyer = modal.find("input[name='replyer']")
    var modalInputReplyDate = modal.find("input[name='replyDate']")
    var modalModBtn = $('#modalModBtn')
    var modalRemoveBtn = $('#modalRemoveBtn')
    var modalRegisterBtn = $('#modalRegisterBtn')

    $('#addReplyBtn').click(function (e) {
      console.log('눌리나')
      modal.find('input').val('')
      modalInputReplyDate.closest('div').hide() //date의 가장 가까운 부모 div를 찾아 숨김
      modal.find("button[id != 'modalCloseBtn']").hide()
      modalRegisterBtn.show() //modal 표시
      $('.modal').modal('show')
      //등록 버튼을 누르면 입력에 필요 없는 항목들을 안보이게 처리하고 모달창을 표시함
    })
    //모달 등록 버튼이 눌리면
    modalRegisterBtn.click(function (e) {
      console.log('모달 등록 눌림')
      var reply = {
        reply: modalInputReply.val(),
        replyer: modalInputReplyer.val(),
        bno: bnoValue,
      }
      replyService.add(reply, (result) => {
        alert(result)
        modal.find('input').val('')
        modal.modal('hide')
      })
    })
    //특정 댓글 조회 클릭 이벤트 처리시 부모(.chat/ul) 아래의 li 태그를 누르면 발생
    $('.chat').on('click', 'li', function (e) {
      var rno = $(this).data('rno')
      console.log(rno)
      replyService.get(rno, (reply) => {
        modalInputReply.val(reply.reply)
        modalInputReplyer.val(reply.replyer)
        modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr('readonly', 'readonly')
        modal.data('rno', reply.rno)

        modal.find("button[id != 'modalCloseBtn']").hide()
        modalModBtn.show()
        $('.modal').modal('show')
      })
    })
    //댓글 수정
    modalModBtn.click(function (e) {
      var reply = { rno: modal.data('rno'), reply: modalInputReply.val() }
      replyService.update(reply, (result) => {
        alert(result)
        modal.modal('hide')
        showList(1)
      })
    })
    //댓글 삭제
    modalRemoveBtn.click(function (e) {
      var rno = modal.data('rno')
      replyService.remove(rno, (result) => {
        alert(result)
        modal.modal('hide')
        showList(1)
      })
    })
    //441페이지 추가
    replyPageFooter.on("click","li a", function(e){ // li태그로 만든 페이지 번호 누르면
    	e.preventDefault();
    	console.log("페이지가 눌렸다");
    	var targetPageNum = $(this).attr("href")
    	//this는 누른 페이지 li태그이고 이떄의 li태그의 href속성을 얻음 href = "3(페이지)"
    	console.log("targetPageNum : " + targetPageNum);
    	pageNum = targetPageNum;
    	showList(pageNum);
    })
 }) 
    //440페이지 코드 추가
	var pageNum =1;
	var replyPageFooter = $(".panel-footer");
	  //이전 BoardController에서 ㅖageDTO의 PageMaker 페이지 계산 자바 대체용
  
	const showReplyPage = (replyCnt) =>{//페이지 계산함수 정의
		var endNum = Math.ceil(pageNum/10.0) *10;
		var startNum = endNum -9;
		var prev = startNum != 1;
		var next = false;
		
		console.log(endNum + "엔드넘버1")
		if(endNum *10>= replyCnt){
			endNum = Math.ceil(replyCnt/10.0);
			console.log(endNum + "엔드넘버2")
		}
		if(endNum*10<replyCnt){
			next = true;
		}
		var str="<ul class='pagination pull-right'>";
		if(prev){
			str+= "<li class='page-item'><a class='page-link' href='" +
				(startNum-1) +"'>이전 페이지</a></li>";
		}
		for(var i=startNum; i<=endNum; i++){
			var active = pageNum == i ? "active" : "";
			str += "<li class='page-item "+active+" '><a class='page-link' href='" +
				i+"'>" + i + "</a></li>";
		}
		if(next){
			str += "<li class='page-item'><a class='page-link' href='" +
			(endNum+1) +"'> 다음 페이지 </a></li>";
		}
		str +="</ul/</div>";
		console.log(str);
		replyPageFooter.html(str);
  }
 
</script>
<%@ include file="../includes/footer.jsp" %>
