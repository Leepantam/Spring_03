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