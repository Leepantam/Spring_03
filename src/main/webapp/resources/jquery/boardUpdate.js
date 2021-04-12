$(".fileDelete").click(function(){
	// fileNum
	let fileNum=$(this).attr("title");
	let obj = $(this);
	// noticeFileDelete
	
	let check = confirm("file Delete?");
	if(check){	
		$.ajax({
			type:"get",
			url:"./fileDelete",
			data:{fileNum:fileNum},
			success:function(result){
				result=result.trim();
				if(result>0){
					alert("삭제 성공");
					obj.parent().remove();
					num--;
				}else{
					alert("삭제 실패");
				}
				
			}
		})
	}
})


