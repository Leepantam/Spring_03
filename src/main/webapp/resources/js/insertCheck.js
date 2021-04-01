
/**
 * 
 */

function insertCheck(){
	let c = document.getElementById("contents");
	let t = document.getElementById("title");
	
	
	if(t.value==""){
		alert("제목은 으디감?");
	}else if(c.value==""){
		alert("냉무?");
	}else{
		alert("ok");
	}
}
let c = document.getElementById("contents");
	let t = document.getElementById("title");
let noticeForm = document.getElementById("noticeForm");
let writeBtn = document.getElementById("writeBtn");
writeBtn.addEventListener("click",function(){
	if(t.value==""){
		alert("제목은 으디감?");
	}else if(c.value==""){
		alert("냉무?");
	}else{
		noticeForm.submit();
	}
})