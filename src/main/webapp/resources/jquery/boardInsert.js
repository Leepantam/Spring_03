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

	let num=1;
$("#add").click(function(){
	if(num>5){
		alert("파일은 5개까지 가능")
	}else{		
	$("#files").append($("#sample").html());
	num++;
	}
	
	
})