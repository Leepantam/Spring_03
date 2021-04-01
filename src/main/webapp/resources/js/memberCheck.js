/**
 * 
 */

let id = document.getElementById("id");
let idResult = document.getElementById("idResult");
let name = document.getElementById("name");
let phone = document.getElementById("phone");
let email = document.getElementById("email");

let idCheckResult = false; // id check 결과
let pwCheckResult = false; // pw check 결과
let pwEqualResult = false; // pw 확인 결과
let etcResult = true;
let etc = document.getElementsByClassName("etc");


id.addEventListener("blur",function(){
	if(id.value.length>5){
		idResult.innerText="6자 이상";
		idResult.setAttribute("class","r2");
		idCheckResult = true;
	}else{
		idResult.innerText="6자 미만";
		idResult.setAttribute("class","r1");
	}
})

let pw = document.getElementById("pw");
let pwResult = document.getElementById("pwResult");
let pw2 = document.getElementById("pw2");

pw.addEventListener("blur",function(){
	if(pw.value.length>7){
		pwResult.innerText="8자 이상";
		pwResult.setAttribute("class","r2");
		pwCheckResult = true;
	}else{
		pwResult.innerText="8자 미만";
		pwResult.setAttribute("class","r1");
	}
})

pw2.addEventListener("blur",function(){
	if(pw.value!=pw2.value){
		pw2.value="";
	}else{
		pwEqualResult =true;
	}
	
});


pw.addEventListener("change", function(){
	if(pw.value!=pw2.value){
		pw2.value="";
	}
})

let btn = document.getElementById("btn");

/*
//강의
*/
btn.addEventListener("click", function(){
	for(let e of etc){
		if(e.value==""){
			etcResult=false;
			break;
		}
	}
	alert("1"+idCheckResult);
	alert("2"+pwCheckResult);
	alert("3"+pwEqualResult);
	alert("4"+etcResult);
	if(idCheckResult && pwCheckResult && pwEqualResult && etcResult){
		alert("ok");
		//frm.submit();
	}
	
});


/*
직접
btn.addEventListener("click",function(){
	let frm = document.getElementById("frm");
	if(id.value.length<6){
		alert("ID는 6자 이상이어야 합니다.");
	}
	else if(pw.value.length<8){
		alert("password는 8자 이상이어야 합니다.")
	}
	else if(pw.value!=pw2.value){
		alert("비밀번호가 일치하지 않습니다.");
	}
	else if(name.value==""){
		alert("이름을 입력해 주세요.");
	}
	else if(phone.value==""){
		alert("전화번호 입력해주세요.");
	}
	else if(email.value==""){
		alert("email 입력해주세요.");
	}
	else{
		frm.submit();
	}
})

*/



 /*
ㅎㅈㄲㅉ

키 누를 때마다 표시
id.addEventListener("keyup",function(){
	if(id.value.length>6){
		idResult.innerText="6자 이상";
	}else if(id.value.length==6){
		idResult.innerText="6자";
	}else{
		idResult.innerText="6자 이하";
	}
})

id.addEventListener("keyup",function(){
	idResult.innerText=id.value.length+"/6";
})
*/