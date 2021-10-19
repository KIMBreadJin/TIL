<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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
    width: 20px;
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
    <h1 class="page-header">게시글 수정</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">
      <div class="panel-heading">파일</div>
      <div class="panel-body">
        <div class="form-groupt uploadDiv">
          <input type="file" name="uploadFile" multiple>
        </div>
        <div class="uploadResult">
          <ul></ul>
        </div>
      </div>
    </div>
  </div>
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
		 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          <input type="hidden" name="pageNum" value="${cri.pageNum}" />
          <input type="hidden" name="amount" value="${cri.amount}" />
          <input type="hidden" name="keyword" value="${cri.keyword}" />
          <input type="hidden" name="type" value="${cri.type}" />
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
          <sec:authentication property="principal" var="pinfo" />
          <sec:authorize access="isAuthenticated()">
          	<c:if test="${pinfo.username eq board.writer}">
         		<button data-oper="modify" class="btn btn-default" type="submit">수정</button>
          		<button data-oper="remove" class="btn btn-danger" type="submit">삭제</button>
          	</c:if>
          </sec:authorize>
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
  $(document).ready(function () {
    //584p
    (function () {
              var bno = '<c:out value="${board.bno}"/>';
              $.getJSON("/board/getAttachList", { bno: bno }, function (arr) {
                console.log(arr);
                var str = "";
                $(arr).each(function (i, attach) {
                  if (attach.fileType) {
                	  var fileCallPath = encodeURIComponent(attach.uploadPath + "/s_" + attach.uuid + "_" + attach.fileName);
                      str += "<li data-path='" + attach.uploadPath + "' data-uuid='" + attach.uuid + "' data-filename='" + attach.fileName + "'data-type='" + attach.fileType + "'><div>";
                      str += "<span> " + attach.fileName + "</span>";
                      str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                      str += "<img src='/display?fileName=" + fileCallPath + "'>";
                      str += "</div>";
                      str += "</li>";
                  } else {
                    str += "<li data-path='" + attach.uploadPath + "' data-uuid='" + attach.uuid + "' data-filename='" + attach.fileName + "'data-type='" + attach.fileType + "' ><div>";
                    str += "<span> " + attach.fileName + "</span>";
                    str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                    str += "<img src ='/resources/img/attach.PNG'>";
                    str += "</div>";
                    str += "</li>";
                  }
                })
                $(".uploadResult ul").html(str);
      }) //getJSON
    })() //end function IIFE
  //588p
	$(".uploadResult").on("click", "button", function (e) {
		console.log("delete 파일 ");
		if (confirm("정말로 이파일을 삭제하시려고요? ")) {
			var targetLi = $(this).closest("li");
			targetLi.remove();
		}
	});// on click 
	//589p
	 var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
       var maxSize = 5242880; //5MB

       function checkExtension(fileName, fileSize) {
         if (fileSize >= maxSize) {
           alert("파일 사이즈 초과");
           return false;
         }
         if (regex.test(fileName)) {
           alert("해당 종류의 파일은 업로드할 수 없습니다.");
           return false;
         }
         return true;
       }
       $("input[type='file']").change(function (e) {
         var formData = new FormData();
         var inputFile = $("input[name='uploadFile']");
         var files = inputFile[0].files;
         for (var i = 0; i < files.length; i++) {
           if (!checkExtension(files[i].name, files[i].size)) {
             return false;
           }
           formData.append("uploadFile", files[i]);
         }

         $.ajax({
           url: '/uploadAjaxAction',
           processData: false,
           contentType: false, data:
             formData, type: 'POST',
           dataType: 'json',
           success: function (result) {
             console.log(result);
             showUploadedResult(result);
           }
         }); //ajax
       }); //change 이벤트 
       function showUploadedResult(uploadResultArr) {
         if (!uploadResultArr || uploadResultArr.length == 0) { return; }
         var uploadUL = $(".uploadResult ul");
         var str = "";
         $(uploadResultArr).each(function (i, obj) {
           OriginPath = obj;
           if (!obj.image) {
             var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
             var fileLink = fileCallPath.replace(new RegExp(/\\/g), "/");
             str += "<li ";
             str += "data-path='"+obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-fileName='" + obj.fileName 
 str += "'data-type='" + obj.image + "'><div>"
             str += "<span> " + obj.fileName + "</span>";
             str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
            str += "<img src ='/resources/img/attach.PNG'></a>";
            str += "</div>";
            str += "</li>";

           } else {
           	   var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
                  str += "<li ";
                  str += "data-path='"+obj.uploadPath + "' data-uuid='" + obj.uuid + "' data-fileName='" + obj.fileName 
				  str += "'data-type='" + obj.image + "'><div>"
                  str += "<span> " + obj.fileName + "</span>";
                  str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                  str += "<img src='/display?fileName=" + fileCallPath + "'>";
                  str += "</div>";
                  str += "</li>";
           }
         });
         uploadUL.append(str);
       }
	//590p
    var formObj = $('form')
    $('button').click(function (e) {
      e.preventDefault() //기본 동작을 막고 마지막에 submit() 을 적용함
      var operation = $(this).data('oper') // data-oper에서의 value를 얻음 , modify, remove ,list
      console.log(operation)
      if (operation === 'remove') formObj.attr('action', '/board/remove')
      
      else if (operation === 'list') {
        formObj.attr('action', '/board/list').attr('method', 'get')
        var pageNumTag = $("input[name='pageNum']").clone() //복제(복사)
        var amountTag = $("input[name='amount']").clone() //복제(복사)
        var keywordTag = $("input[name='keyword']").clone() //복제(복사)
        var typeTag = $("input[name='type']").clone() //복제(복사)
        formObj.empty() // form 태그의 데이터 비우기
        formObj.append(pageNumTag)
        formObj.append(amountTag)
        formObj.append(keywordTag)
        formObj.append(typeTag)
      } else if (operation =='modify'){//590p 추가
    	  console.log("수정 버튼 눌림")
    	      		  var str =""
    	  $(".uploadResult ul li").each(function(i,obj){
    		  var jobj = $(obj)
    		  console.dir(jobj)
    		  str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
    	      str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
    	      str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
    	      str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
    	  })//each
    	  formObj.append(str).submit();//수정 버튼시 hidden으로 숨겨서 컨틀롤러로 전송 
      }
      formObj.submit()
    })
  })//document ready 
</script>
<%@ include file="../includes/footer.jsp" %>
