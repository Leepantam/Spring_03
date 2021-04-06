/**
 * 
 */

$('#all').click(function(){
	$('.check').prop("checked",$('#all').prop("checked"));
})

$('.check').click(function(){
let result = true;
	$('.check').each(function(){
		if(!$(this).prop("checked")){
			result=false;
		}
	})
	$('#all').prop("checked",result);
})

$('#btn').click(function(){
	if(!$('#all').prop("checked")){
		alert("필수 약관 동의")
	} else{
		location.href = "./memberJoin"
	}
})