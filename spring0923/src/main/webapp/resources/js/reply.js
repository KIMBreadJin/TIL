console.log("Reply module....");
var replyService= (function(){
	const add = (reply, callback)=>{
		console.log("댓글 reply.js .........");
		console.log("댓글 reply.js의 객체는 1)  " , reply);
		console.log("댓글 reply.js의 함수 는 2)  " , callback);
		$.ajax(
					{
						type:'post',
						url:'/replies/new',
						data:JSON.stringify(reply),
						contentType:"application/json;charset=utf-8",
						success:function(result,status,xhr){ //resolve
							if(callback){ //ajax에서 호출시 두번쨰 파라미터로 전달한값이 있으므로 if문실행 
								console.log("컨트롤러 서버에 호출후 정상 동작 후 호출된 함수는 3)  " , callback);
								console.log("컨트롤러 서버에 호출후 정상 동작 후 반환된 result 4)  " , result);
								callback(result);//여기서 호출이 일어남?
							}
						},
						error:function(xhr,status,er){ //reject

						}
					}
		)
	}
	function getList(param,callback, error){
		var bno = param.bno;
		var page = param.page ||  1;
		$.getJSON("/replies/pages/" +bno+"/"+page+".json",
			function(data){
				if(callback){
					callback(data.replyCnt,data.list);//ReplyPageDTO(갯수, 댓글의 목록의 배열) 
				}
			}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	function remove(rno,f){
		$.ajax({
			type:'delete',
			url:'/replies/' +rno,
			dataType:'html',
			success :function(deleteResult,status){
				if(f){
					f(deleteResult);
				}
			},
			error:function(){
				
				}
			})
		}
	const update = (reply, callback)=>{
		console.log("수정 reply.js rno: "+reply.rno);
		$.ajax({
			type:'put',
			url:'/replies/' +reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success: function(result ,status){
				if(callback){
					callback(result);
				}
			},
			error:function(){
				
			}
		})
	}
	const get = (rno, callback)=>{
		$.get("/replies/" + rno+".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			console.log('에러발생함 ');
		})
	}
	const displayTime =(timeValue) =>{
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		if(gap<(1000*60*60*24)){ //시분초  1milli second 
			var hh =dateObj.getHours();
			var mi =dateObj.getMinutes();
			var ss =dateObj.getSeconds();
			return [ (hh>9?'':'0') +hh, ':',(mi>9?'':'0')+mi,':',(ss>9?'':'0')+ss].join('');
		}  else {//년월일
			var yy= dateObj.getFullYear();
			var mm= dateObj.getMonth() +1; //getMonth는 0부터 시작
			var dd = dateObj.getDate();
			return [ yy,'/ ',(mm>9?'':'0')+mm,'/',(dd>9?'':'0')+dd].join('');
		}
	}
	return {add,getList,remove,update,get,displayTime};
})();



