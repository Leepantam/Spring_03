/**
 * 
 */

function insertCheck(){
	let c = document.getElementById("contents");
	let t = document.getElementById("title")
	
	if(t.value==""){
		alert("제목은 으디감?");
	}
	if(c.value==""){
		alert("냉무?");
	}
	if(t.value!="" && c.value!=""){
		alert("ok");
	}
}

