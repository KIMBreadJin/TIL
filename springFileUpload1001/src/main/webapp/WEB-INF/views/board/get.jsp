<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<div class="bigPictureWrapper">
  <div class="bigPicture"></div>
</div>
<style>
			.uploadResult {
				width: 100%;
				background-color: gray;
			}
			.uploadResult ul {
				display: flex;
				flex-flow: row;
				justify-content: center;
				align-items: center;
			}
			.uploadResult ul li {
				list-style: none;
				padding: 10px;
			}
			.uploadResult ul li img {
				width: 100px;
			}
			
			.uploadResult ul li span {
				color: white;
			}
			.bigPictureWrapper {
				position: absolute;
				display: none;
				justify-content: center;
				align-items: center;
				top: 0%;
				width: 100%;
				height: 100%;
				background-color: gray;
				z-index: 100;
				background: rgba(255, 255, 255, 0.5);
			}
			.bigPicture {
				position: relative;
				display: flex;
				justify-content: center;
				align-items: center;
			}
			.bigPicture img {
				width: 600px;
			}
		</style>
	
<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">게시글 조회</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">파일</div>
      <div class="panel-body">
        <div class="uploadResult">
          <ul></ul>
        </div>
      </div>
    </div>
  </div>
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
</div>
<!--  /.row -->
<!-- 교재 414 페이지 -->
<div class="row col-lg-12">
  <!-- panel -->
  <div class="panel panel-default">
    <div class="panel-heading"><i class="fa fa-comments fa-fw">댓글</i></div>
    <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">댓글 등록</button>
  </div>
  <!-- panel-body -->
  <div class="panel-body">
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
      <!-- end reply -->
    </ul>
  </div>
  <!-- end panel  , chat-panel -->
  <div class="panel-footer"></div>
</div>
<!-- modal 420 페이지 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button class="close">&times</button>
        <h4 class="modal-title" id="myModalLabel">Modal 댓글</h4>
      </div>
      <!-- modal-header -->
      <div class="modal-body">
        <div class="form-group">
          <label for="">댓글</label>
          <input type="text" class="form-control" name="reply" value="댓글 등록!!!" />
        </div>
        <div class="form-group">
          <label for="">댓글작성자</label>
          <input type="text" class="form-control" name="replyer" value="댓글 작성자!!!" />
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
        <button class="btn btn-default" id="modalCloseBtn" type="button">닫기</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
  $(document).ready(function () {

    // 571, 574
    (function(){
      var bno='<c:out value="${board.bno}"/>'
      $.getJSON("/board/getAttachList", {bno}, (arr) => {
        console.log("getJSON attachFile" + arr.map(console.log))
        var str =""
        $(arr).each(function(i, obj){
          if (!obj.fileType) {

            var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
            var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
            
            str += "<li ";
            str += "data-path='"+obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-fileName='" + obj.fileName 
            str += "'data-type='" + obj.fileType + "'><div>"
            str += "<span> " + obj.fileName + "</span><br/>";
            //str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
            str += "<img src ='/resources/img/attach.png'>";
            str += "</div>";
            str += "</li>";

          } else {

            var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
            str += "<li ";
            str += "data-path='"+obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-fileName='" + obj.fileName 
            str += "'data-type='" + obj.fileType + "'><div>"
            
            str += "<span> " + obj.fileName + "</span><br/>";
            //str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
            str += "<img src='/display?fileName=" + fileCallPath + "'>";
            str += "</div>";
            str += "</li>";
          }

        });
        $('.uploadResult ul').html(str)
      })//getjson

    })()//func
    const showImage =(fileCallPath) =>{
     // alert(fileCallPath)
      $(".bigPictureWrapper").css("dsplay", "flex").show()
      $(".bigPicture")
        .html("<img src='/display?fileName="+fileCallPath+"'>")
        .animate({whdth: '100%', height: '100%'},1000)
    }

    $(".uploadResult").on('click', 'li', function(e){
    	console.log("attach file clicked")
    	var liObj = $(this)
    	console.log($(this))
      	var path = encodeURIComponent(liObj.data("path")+"/"+liObj.data("uuid")+"_"+liObj.data("filename"))
      	console.log(path)
      if(!liObj.data("type")){
    	  console.log("else" , path, liObj.data("type"))
          self.location='/download?fileName=' + path
      }else{
        
        console.log("if :" , path, liObj.data("type"))
        showImage(path.replace(new RegExp(/\\/g), "/"))
      }
    })
    $(".bigPictureWrapper").click(function(e){
      $(".bigPicture").animate({width: '0%', height:'0%'}, 1000)
      setTimeout(() => {
        $('.bigPictureWrapper').hide()
      }, 1000)
    })
    
    console.log('================')
    console.log('JS TEST')
    var bnoValue = '<c:out value="${board.bno}"/>'
    var replyUL = $('.chat')
    //p439
  
    const showList = (page) => {
      replyService.getList({ bno: bnoValue, page: page || 1 }, 
    		  (replyCnt, list) => {
		console.log("전체 목록 댓글 갯수 : " +replyCnt)
		console.log("전체 목록 : " ,list)
		//console.log(list)
		if(page==-1){
			pageNum =Math.ceil(replyCnt/10.0)// 댓글의 갯수를 10으로 나눈 몫 
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
          str += " <div><div class='header'><strong class='primary-font'>" + list[i].replyer + '</strong>'
          str += "   <small class='pull-right text-muted'>" + replyService.displayTime(list[i].replyDate) + '</small></div>'
          str += ' <p>' + list[i].reply + '</p></div></li>'
        } 
        replyUL.html(str)
        showReplyPage(replyCnt)//(441페이지)
      })
    } 
    showList(-1) // (page 439)
    
    replyService.get(89, (data) => console.log(data))
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
    var modalCloseBtn =$('#modalCloseBtn')

    $('#addReplyBtn').click(function (e) {
      console.log('잘들어오나')
      modal.find('input').val('') 
      modalInputReplyDate.closest('div').hide() 
      modal.find("button[id != 'modalCloseBtn' ]").hide() 
      modalRegisterBtn.show() 
      $('.modal').modal('show')
    })
    
    modalRegisterBtn.click(function (e) {
      console.log('모달 등록 버튼이 눌림 ')
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
   
    $('.chat').on('click', 'li', function (e) {
      var rno = $(this).data('rno')
      console.log(rno) //destructuring
      replyService.get(rno, ({ reply, replyer, replyDate, rno }) => {
      
        modalInputReply.val(reply)
        modalInputReplyer.val(replyer)
        modalInputReplyDate.val(replyService.displayTime(replyDate)).attr('readonly', 'readonly')
        modal.data('rno', rno)

        modal.find("button[id!= 'modalCloseBtn']").hide()
        modalModBtn.show()
        modalRemoveBtn.show()
        $('.modal').modal('show')
      })
    })
    //댓글 수정(p427)
    modalModBtn.click(function (e) {
      var reply = { rno: modal.data('rno'), reply: modalInputReply.val() }
      
      replyService.update(reply, (result) => {
        alert(result)
        modal.modal('hide')
        showList(pageNum) //
      })
    })
   
    modalRemoveBtn.click(function (e) {
      var rno = modal.data('rno')
      replyService.remove(rno, (result) => {
        alert(result)
       
      })
       modal.modal('hide')
        showList(pageNum)
    })
    
    modalCloseBtn.click(function(e){
    	modal.modal('hide')
    })
    
    var pageNum =1;
    var replyPageFooter =$(".panel-footer");
    //441페이지 추가 
    replyPageFooter.on("click","li a",function(e){ //li 태그로 만든 페이지 번호를 누르면
    	e.preventDefault();
    	console.log("페이지가 눌렸어요");
    	var targetPageNum = $(this).attr("href");
    	
    	console.log("targetPageNum : " +targetPageNum);
    	pageNum= targetPageNum;
    	showList(pageNum);
    })
  
  /* //442 페이지 ~444
  modalModBtn.click(function(e){
    var reply = {rno:modal.data("rno"), reply:modalInputReply.val()}
    replyService.update(reply, (result) => {
      alert(result)
      modal.modal("hide")
      showList(pageNum)
    })
  })
  modalRemoveBtn.click(function(e){
    var rno= modal.data("rno")
    replyService.remove(rno, (result) => {
      alert(result)
      madal.madal("hide")
      showList(pageNum)
    })
  })
 */
  //440페이지 코드 추가 
  
  
  const showReplyPage =  (replyCnt) =>{
	  var endNum = Math.ceil(pageNum/10.0) *10;
  	  var startNum = endNum -9;
  	  var prev = startNum != 1;
  	  var next = false;
  	  
  	  if(endNum *10>= replyCnt){
  		  endNum = Math.ceil(replyCnt/10.0);
  	  }
  	  if(endNum*10<replyCnt) {
  		  next =true;
  	  }
  	  var str = "<ul class='pagination pull-right'>";
  	  if(prev){
  		  str+= "<li class='page-item'><a class='page-link' href='" +
  		  	(startNum-1) +"'>이전 페이지</a></li>";
  	  }
  	for (var i = startNum; i <= endNum; i++) {
		var active = pageNum == i ? "active" : "";
		str += "<li class='page-item " + active + " '><a class='page-link' href='" + i + "'>" + i + "</a></li>";
	}
  	  if(next){
  		  str+= "<li class='page-item'><a class='page-link' href='" +
  		  	(endNum+1) +"'>다음 페이지</a></li>";
  	  }
  	  str+= "</ul></div>";
  	  console.log(str);
  	  replyPageFooter.html(str);
	  
  }
})
</script>
<%@ include file="../includes/footer.jsp" %>
