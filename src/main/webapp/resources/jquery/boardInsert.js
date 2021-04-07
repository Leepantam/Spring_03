$("#btn").click(function(){
	/*
	let writer = $('#writer').val() != "";
	let title = $('#title').val() != "";
	let contents = $('#contents').val().length == 0;
	*/
	
	let result = true;
	
	$('.myCheck').each(function(s1, s2){
		console.log(s1);
		console.log($(s2).val());
		console.log($(this).val());
		if($(this).val()==""){
			result = false;
		}
	});
	
	if(result){	
		$('#frm').submit();
	}else{
		alert("재확인")
	}

})


let num=0;
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

