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
	else if(pw.value.length<8){
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

let id = document.getElementById("id");
let idResult = document.getElementById("idResult");
let name = document.getElementById("name");
let phone = document.getElementById("phone");
let email = document.getElementById("email");

id.addEventListener("blur",function(){
	if(id.value.length>5){
		idResult.innerText="6자 이상";
		idResult.setAttribute("class","r2");
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
	}else{
		pwResult.innerText="8자 미만";
		pwResult.setAttribute("class","r1");
	}
})

pw2.addEventListener("blur",function(){
	if(pw.value!=pw2.value){
		pw2.value="";
	}
})

pw.addEventListener("change", function(){
	if(pw.value!=pw2.value){
		pw2.value="";
	}
})

let btn = document.getElementById("btn");
btn.addEventListener("click",function(){
	let frm = document.getElementById("frm");
	if(id.value.length<6){
		alert("ID가 짧다");
	}
	else if(pw.value.length<8){
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
		frm.submit();
	}
})

let check = document.getElementById("check");
check.addEventListener("click", function(){
	alert("test");
	return false;
})



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