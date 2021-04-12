let num = $("#comments").attr("title");

getList();

function getList(){	
$.get("../comments/commentsList?num="+num,function(data){
	console.log(data)
	$('#comments').html(data.trim());
});
}

$("#write").click(function(){
	let writer = $("#writer").val();
	let contents = $("#contents").val()
	$.post("../comments/commentsInsert",
	{writer: writer, contents: contents, num: num},
	function(data){
		data = data.trim();
		if(data==1){
			alert("등록 성공");
			$("#writer").val("");
			$("#contents").val("");
			getList();
		}else{
			alert("등록 실패");
		}
	});
})


//이벤트 위임
$("#comments").on("click", "#remove", function(){
	const ar = [];
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).val())
		}
	});
	
	console.log(ar);
	
	/*
	//get
	$.get("../comments/commetnsDelete?num="+ar,function(data){
		alert(data);
	});
	
	//post 인데 안됨 왜냐 num때문에
	$.post("../comments/commentsDelete",{num:ar},function(data){
		alert(data);
	})
*/

	$.ajax({
		type : "post",
		url : "../comments/commentsDelete",
		traditional:true,
		data : {commentsNum:ar},
		success : function(data){
			if(data==1){
				alert("삭제 성공");
				getList();
			}else{
				alert("삭제 실패");
			}
		}
	})
});

