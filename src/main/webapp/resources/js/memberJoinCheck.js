/**
 * 
function check(){
	let all = document.getElementById("all");
	let ch = document.getElementsByClassName("check");
	let i = 0;
	for(i;i<ch.length;i++){
		if(!ch[i].checked){
			all.checked=false;
			break;
		} 
	}
	if(i==ch.length){
		all.checked=true;
	}
}
 */

let all = document.getElementById("all");
let ch = document.getElementsByClassName("check");

function aCheck(){
	let check=true;
	for(let c of ch){
		if(!c.checked){
			check=false;
			break;
		} 
	}
	all.checked=check;
}

all.addEventListener("click", function(){
for(let c of ch){
	c.checked=all.checked;
}
})

for(let c of ch){
	c.addEventListener("click",aCheck);
}
