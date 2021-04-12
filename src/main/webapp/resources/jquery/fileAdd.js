let num=$("#files").attr("title");
$("#add").click(function(){
		console.log(num);
	if(num>4){
		alert("파일은 5개까지 가능")
	}else{		
		num++;
		$("#files").append($("#sample").html());
	}
})
$("#del").click(function(){
	num=0;
	$("#files").empty();
})

//이벤트 전달
$("#files").on("click",".delete",function(){
	$(this).parent().remove();
	num--;
})