<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
      <%@ include file="../includes/header.jsp" %>
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
        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-default">
              <div class="panel-heading">File Attach</div>
              <!-- /.panel-heading-->
              <div class="panel-body">
                <div class="form-group uploadDiv">
                  <input type="file" name="uploadFile" multiple>
                </div>
                <div class="uploadResult">
                  <ul>

                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <script>
          $(document).ready(function (e) {
        	  var formObj = $("form[role='form']");
        	  
        	  $("button[type='submit']").on("click", function(e){
        	    
        	    e.preventDefault();
        	    
        	    console.log("submit clicked1)");
        	    
        	    var str = "";
        	    
        	    $(".uploadResult ul li").each(function(i, obj){
        	      
        	    	 console.log("여기도 안찍히는 듯하고 2)");
        	      var jobj = $(obj);
        	      
        	      console.dir(jobj);
        	      console.log("-------------------------");
        	      console.log(jobj.data("filename"));
        	      
        	      //AttachFileDTO 
        	      //attachList BoardVO의 멤버변수( AttachFileDTO 를 배열(List) => 첨부파일의 갯수만큼 )
        	      str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
        	      str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
        	      str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
        	      str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
        	      
        	    });
        	    
        	    console.log("여기 문자열이 안찎 히네 3) "+ str);
        	    e.preventDefault();
  
      	        formObj.append(str).submit();

        	   
            });
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
                  showUploadedFile(result);
                }
              }); //ajax
            });
            function showUploadedFile(uploadResultArr) {
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
            $(".uploadResult").on("click", "button", function (e) {
              console.log("delete file");
              var targetFile = $(this).data("file");
              var type = $(this).data("type");

              var targetLi = $(this).closest("li");
              $.ajax({
					url:'/deleteFile',
					data:{fileName: targetFile,type:type},
					dataType:'text',
					type: 'POST',
					success: (result)=>{
						alert(result);
						targetLi.remove();
					}
				})//$.ajax

            })
            
          })
        </script>
        <%@ include file="../includes/footer.jsp" %>