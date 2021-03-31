function go(){
	//alert("button click");
	console.log("print log");
	//30 - 리터럴
	//변수 선언 - 데이터타입 변수명 = 릴터럴;
	var num=30;
	console.log(num);
	// leepantam - 문자열, 문자타입은 없음, 암뒤로 '' or ""
	var name = "LeePanTam";
	console.log(name);
	
	num=name;
	
	var num=1;
	console.log(num);
	
	const n1 = 'lpt';
	console.log(n1);
	
	//n1='LEE';
	//console.log(n1);
	
	let n2 ='lpt2';
	console.log(n2);
	n2='LEE';
	console.log(n2);
}

function go2(){
	console.log("go2 start");
	var c1 = window.document.getElementById("c1");
	console.log(c1)
	alert(c1);
	var c2 = c1.innerHTML;
	console.log(c2);
	alert(c2);
	var c3 = c1.innerText;
	console.log(c3);
	
	var name = window.prompt("이름 입력 : ");
	console.log(name);
	
	c1.innerHTML = '<input type="text">';
	
	
}