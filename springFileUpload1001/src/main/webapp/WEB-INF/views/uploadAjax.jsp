<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>ajax로 파일 업로드</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  </head>
  <body>
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
    <div class="bigPictureWrapper">
      <div class="bigPicture"></div>
    </div>
    <h1>ajax로 파일 업로드</h1>
    <div class="uploadDiv">
      <input type="file" name="uploadFile" multiple="multiple" />
      <button id="uploadBtn">파일업로드</button>
    </div>
    <div class="uploadResult">
      <ul></ul>
    </div>
    <script>
      var regex = new RegExp('(.*?)\.(exe|sh|zip|alz)$') //정규 표현식
      var maxSize = 5242880 // 5MB 제한
      function checkExtension(fileName, fileSize) {
        //확장자 체크함수 정의
        if (fileSize >= maxSize) {
          alert('파일 사이즈 초과')
          return false
        }
        if (regex.test(fileName)) {
          alert('해당 종류의 파일은 업로드 할 수 없습니다. ')
          return false
        }
        return true
      }
      function showImage(fileCallPath) {//파일호출 경로 
        console.log('여기 함수 showImage 호출')
        $('.bigPictureWrapper').css('display', 'flex').show()
        $('.bigPicture')
          .html("<img src='/display?fileName=" + encodeURI(fileCallPath) + "'>")
          .animate({ width: '100%', height: '100%' }, 1000)
        setTimeout(() => {
          $(this).hide()
        }, 1000)
      }

      $(document).ready(function (e) {
        var cloneObj = $('.uploadDiv').clone()
        $('#uploadBtn').click(function (e) {
          var formData = new FormData()
          var inputFile = $("input[name='uploadFile']")
          var files = inputFile[0].files
          console.log(files)
          //formData에 파일 목록 추가
          for (let i = 0; i < files.length; i++) {
            if (!checkExtension(files[i].name, files[i].size)) return false
            formData.append('uploadFile', files[i])
          }
          $.ajax({
            url: '/uploadAjaxAction',
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType: 'json',
            success: function (result) { //첨부파일의 배열
              //alert('uploaded')
              console.log(result)
              showUploadFile(result) // uploadAjaxAction 전달하고 성공하면 controller에서
              // result에 파일 배열을 전달 
              $('.uploadDiv').html(cloneObj.html())
            },
          }) // $.ajax p503
        }) //#uploadBtn

        var uploadResult = $('.uploadResult ul')

        const showUploadFile = (uploadResultArr) => {//uploadResultArr에는 컨틀롤러에서 성공하면
        	//그때의 여러개의 배열 이미지 파일이 담긴다 
          //ajax 결과를 화면에 출력하는 함수 정의
          var str = ''
          $(uploadResultArr).each(function (i, obj) {
            if (!obj.image) {
              var fileCallPath = encodeURIComponent(obj.uploadPath + '/' +  obj.uuid+ '_' + obj.fileName)
              var fileLink = fileCallPath.replace(new RegExp(/\\/g), '/')
              str +=
                "<li><div><a href='/download?fileName=" +
                fileCallPath +
                "'>" +
                "<img src='/resources/img/attach.png'>" +
                obj.fileName +
                '</a>' +
                "<span data-file='" +
                fileCallPath +
                "' data-type='file'> x </span>" +
                '<div></li>'
            } else { //이미지 일때 
              var fileCallPath = encodeURIComponent(obj.uploadPath + '/s_' + obj.uuid + '_' + obj.fileName)
              var originPath = obj.uploadPath + '\\' + obj.uuid + '_' + obj.fileName
              originPath = originPath.replace(new RegExp(/\\/g), '/')
              str +=
                '<li><a href="javascript:showImage(\'' +
                originPath +
                '\')">' +
                "<img src='display?fileName=" +
                fileCallPath +
                "'></a>" +
                "<span data-file='" +
                fileCallPath +
                "' data-type='image'> x </span>" +
                '<li>'
            }
          })
          uploadResult.append(str)
        }
        $('.uploadResult').on('click', 'span', function (e) {
          console.log('여기가 왜 안눌려?')
          var targetFile = $(this).data('file') // data-file="fileCallPath" 
          var type = $(this).data('type') //dat-type="여기 정보가져오기"
          console.log(targetFile)
           $.ajax({
        		url:'/deleteFile',
        		data:{fileName:targetFile, type:type},
        		dataType:'text',
        		type:'POST',
        		success:(result)=>{
        			alert(result);
        		}
        	}) 
        })
      })
    </script>
  </body>
</html>
