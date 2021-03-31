/**
 * 
 */
function mCheck(){
	let id = document.getElementById("id");
	let pw = document.getElementById("pw");
	let pw2 = document.getElementById("pw2");
	let name = document.getElementById("name");
	let phone = document.getElementById("phone");
	let email = document.getElementById("email");
	
	if(id.value.length<6){
		alert("ID가 짧다");
	}
	else if(pw.value==""){
		alert("pw 입력")
	}
	else if(pw.value!=pw2.value){
		alert("비밀번호 확인");
	}
	else if(name.value==""){
		alert("이름 없음?");
	}
	else if(phone.value==""){
		alert("님 폰 없?");
	}
	else if(email.value==""){
		alert("email 없음")
	}
	else{
		alert("ok")
	}
}