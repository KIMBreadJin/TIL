console.log("Reply module.......")
var replyService = 
	(function(){
		function add(reply,callback,error){
			console.log("add reply.......");
			$.ajax({
				type:'post',
				url:'/replies/new',
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				success:function(result, status,xhr){
					if(callback) callback(result)
				},
				error:function(xhr,status,er){
					if(error) error(err)
				}
			})
		};
		const getList = (param, callback,error)=>{
			var bno = param.bno;
			var page = param.page || 1
			$.getJSON("/replies/pages/" +bno +"/" +page+ ".json",
				(data)=>{
					if(callback) callback(data.replyCnt,data.list)//controller에서
					//반환되는 pageDTO 
				}
			).fail(function(xhr,status,err){
				if(error) error()
			})
		}
		const remove = (rno,callback,error)=>{
			$.ajax({
				type:'delete',
				url:'/replies/' +rno,
				success:(deleteResult,status,xhr)=>{
					if(callback) callback(deleteResult)
				},
				error:
					(xhr,status,er)=>{
						if(error) error(er);
					}
			})
		}
		const update= (reply,callback,error)=>{
			console.log("Rno: " +reply.rno);
			$.ajax({
				type:'put',
				url:'/replies/' + reply.rno,
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				success:(result, status, xhr)=>{
					if(callback) callback(result);
				},
				error:(xhr,status,er)=>{
					if(error) error(er);
				}
			})
		}
		const get = (rno ,callback ,error)=>{
			$.get("/replies/" +rno +".json" , (result) =>{
				if(callback) callback(result)
			}).fail((xhr,status,err) =>{
				if(error) error();
			})
		}
		const displayTime = ( timeValue)=>{
			var today = new Date();
			var gap = today.getTime() - timeValue;
			var dateObj = new Date(timeValue);
			var str="";
			if(gap<(1000*60*60*24)){ //하루보다 작으면, 오늘날짜는 시간으로 
				var hh = dateObj.getHours();
				var mi = dateObj.getMinutes();
				var ss = dateObj.getSeconds();
				return [(hh>9 ? '' :'0') +hh,
					(mi>9 ? '' : '0') +mi,
					(ss>9 ? '' : '0') +ss
				 ].join(":")//배열에서 하나씩 꺼내서 문자열 생성  , 결합(join) 은 ":"  로 결합해라 
			} else {//하루 지난시간
				var yy = dateObj.getFullYear();
				var mm = dateObj.getMonth() +1;// getMonth는 0부터 시작
				var dd = dateObj.getDate();
				return [yy,(mm>9?'':'0') +mm,
					(dd>9?'':'0') +dd
				 ].join("/")
			}
		}
		return {add,getList,remove,update, get,displayTime}
	})();// IIFE (함수 정의와 동시에 호출 )
