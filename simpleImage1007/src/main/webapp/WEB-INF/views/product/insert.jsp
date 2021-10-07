<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>상품 등록</title>

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
  </head>
  <body>
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">상품 등록</h1>
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
            <form action="/product/register" method="POST" role="form">
              <div class="form-group">
                <label for="pname">제품명</label>
                <input type="text" class="form-control" name="pname" />
              </div>
              <div class="form-group">
                <label for="pprice">가격</label>
                <input type="text" class="form-control" name="pprice" />
              </div>
              <div class="form-group">
                <label for="pdetail">제품설명</label>
                <input type="text" class="form-control" name="pdetail" />
              </div>
              <div class="form-group">
                <label for="pmanufacture">제조사</label>
                <input type="text" class="form-control" name="pmanufacture" />
              </div>
              <div class="form-group uploadDiv">
                <input type="file" name="uploadFile" />
              </div>
              <div class="uploadResult"></div>
              <input tpye = "hidden" name="uploadPath"/>
              <input tpye = "hidden" name="uuid"/>
              <input tpye = "hidden" name="fileName"/>
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
    <script>
      $(document).ready(function (e) {
        $("input[type='file']").change(function (e) {
          console.log('파일선택하려 하는가?')
          var formData = new FormData()
          var inputFile = $("input[name='uploadFile']")
          var files = inputFile[0].files
          for (var i = 0; i < files.length; i++) {
            formData.append('uploadFile', files[i])
          }

          $.ajax({
            url: '/product/uploadAjaxAction',
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType: 'json',
            success: function (result) { //컨트롤러부터 데이터를 result 에 저장
              console.log(result)
              showUploadedFile(result)
            },
          }) //ajax
        })
        function showUploadedFile(resultShow) {
          console.log('여기찍히나 showUploadResult 3)' + resultShow)
          var uploadURL = $('.uploadResult')
          var str = ''
          var fileCallPath = encodeURIComponent(resultShow.uploadPath + '/s_' + resultShow.uuid + '_' + resultShow.fileName)
          str += '<div data-path=' + resultShow.uploadPath + "'"
          str += " data-uuid='" + resultShow.uuid + "' data-fileName='" + resultShow.fileName + "'" + '><div>'
          str += '<span> ' + resultShow.fileName + '</span><br>'
          str += "<img src='/product/display?fileName=" + fileCallPath + "'>"
          str += '</div>'
          str += '</div>'

          uploadURL.append(str)
          $("input[name='uploadPath']").val(resultShow.uploadPath)
          $("input[name='uuid']").val(resultShow.uuid)
          $("input[name='fileName']").val(resultShow.fileName)
        }
      })
    </script>
  </body>
</html>
