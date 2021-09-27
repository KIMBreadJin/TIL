console.log("Reply modul......")
var replyService = 
	(function(){
		function add(reply, callback, error){
			console.log("add reply ..... ");
			$.ajax({
				type:'post',
				url:'/replies/new',
				data:JSON.stringify(reply),
				contentType:"application/json; charset=utf-8",
				success:function(result, status, xhr){
					if(callback) callback(result)
				},
				error:function (xhr,status,er){
					if(error) error(err)
				}
			})
		};
		const getList = (param,callback,error)=>{
			var bno = param.bno;
			var page = param.page || 1
			$.getJSON("/replies/pages/" + bno + "/"+page+".json",
				(data)=>{
					if(callback) callback(data)
				}
			).fail(function(xhr,status,err){
				if(error) error()
			})	
		}
		const remove = (rno,callback,error)=>{
			$.ajax({
				type:'delete',
				url:'/replies/' +rno,
				success:(deleteResult, status, xhr)=>{
					if(callback) callback(deleteResult)
				},
				error:(xhr,status,er)=>{
					if(error) error(err)
				}
			})
		}
				
		return{add,getList,remove}
	})();