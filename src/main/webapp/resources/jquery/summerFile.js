/**
 * 
 */
function uploadFile(files){
	const formData = new FormData(); // form 태그 작성
	formData.append('file',files[0]); // input type = "File" name="file"
	
	$.ajax({
		type:"post",
		url:"./summerFileUpload",
		data:formData,
		enctype:"multipart/form-data",
		cache:false,
		processData:false,
		contentType:false
	});
}