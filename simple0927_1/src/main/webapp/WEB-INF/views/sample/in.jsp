<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<script>
		function add(reply,callback){
			$.ajax({
				type:'post',
				url:'/sample/new',
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				success:function(result, status,xhr){
					if(callback) callback(result)
				}
			})
		}
		function remove(rno,callback){
			$.ajax({
				type:'delete',
				url:'/sample/' +rno,
				success:(deleteResult, status, xhr)=>{
					if(callback) callback(deleteResult)
				}
			})
		}
		function getList(param,callback){
			var bno = param.bno;
			var page = param.page || 1
			$.getJSON("/sample/pages/" + bno + "/"+page+ ".json",
				(data)=>{
					if(callback) callback(data)
				})
		}
		$(document).ready(function(){
		var bnoValue = '<c:out value = "${board.bno}"/>'
			$("#a").click(function(){
				add(
					{reply:"JS Test", replyer:"tester",bno:"1"},
					(result)=>{
						alert("RESULT: " + result)
					}
					);
			})
			$("#b").click(function(){
				remove($("#d").val(),
					(count)=>{
					console.log(count);
						if(count =="success") alert("삭제되었음")
					}
				)
			})
			$("#c").click(function(){
				getList({bno:$("#e").val(),page:1}, (list)=>{
					for (var i=0, len=list.length||0; i<len; i++) {
						console.log(list[i]);			
					}
				})
			})
		})
	</script>
	<button id = "a">추가</button> <br>
	삭제하려는 번호 입력<input type="text" id = "d"/> <button id = "b">삭제</button><br>
	조회하려는 bno 번호<input type="text" id = "e"/> <button id = "c">전체조회</button>
	
</body>
</html>