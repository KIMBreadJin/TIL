<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>제품 구매 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  </head>
  <body>
    <h1>제품 구매</h1>
    <form action="/exam/buy" method="post">
    	<input type='hidden' name='sid' value="${list.sid}"/>
      이름 : <input type="text" name="bname" value="${list.sname}" /><br />
      비밀번호 : <input type="text" name="bpassword" value="${list.spassword}" /><br />
      주소 : <input type="text" name="baddress" value="${list.address}" /><br />
      상세주소 : <input type="text" name="baddress2" value="${list.address2}" /><br />
      폰전화 : <input type="text" name="bphone2" value="${list.phone2}" /><br />
      송장번호 : <input type="text" name="bnum" value="${buy.bnum}" /><br />
      제품선택 :
      <select name="product" id="product">
        <option value="">제품선택</option>
        <option value="1000">피자</option>
        <option value="2000">치킨</option>
        <option value="3000">족발</option></select
      ><br />

      제품 가격 : <input type="text" name="price" id="output" /><br />
      수량 : <input type="text" name="amount" id="amount" /><br />
      총 가격 : <input type="text" name="total" id="total" /><br />
      쿠폰 :
      <select name="coupon" id="coupon">
        <option value="">쿠폰선택</option>
        <option value="1000">1000</option>
        <option value="2000">2000</option>
        <option value="3000">3000</option></select
      ><br />
      쿠폰 사용여부 : <input type="text" name="cuse" id="cuse" value="N" style=color:red; /><br />
      <input type="submit" value="구매" />
      <input type="reset" value="초기화" />
    </form>
    
      <form action="/exam/list" method="get" >
		<input type="submit" id="buy" value="구매 리스트 보기"></input>
	  </form>
    <script>
      $(document).ready(function () {
        var output = ''
        var totalprice = 0
        $('#product').change(onSelectChange)
        function onSelectChange() {
          var selected = $('#product option:selected')

          if (selected.val() != 0) {
            output = selected.val()
          }
          $('#output').val(output)
        }
        $('#amount').keyup(function () {
          var selected = $('#product option:selected')

          var input = $(this).val()
          totalprice = Number(output) * Number(input)
          $('#total').val(totalprice).css('color', 'red')
        })
        $('#coupon').change(function () {
          var selected = $('#coupon option:selected')
          if (selected.val() != 0) {
            var cprice = selected.val()
          }
          totalprice = Number(totalprice) - Number(cprice)
          console.log(Number(cprice))
          $('#total').val(totalprice).css('color', 'blue')
          $('#cuse').val('Y').css('color', 'green')
        })
      })
    </script>
  </body>
</html>
