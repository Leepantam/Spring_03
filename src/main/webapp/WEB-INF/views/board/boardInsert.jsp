<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- summernote -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<!------------>
<style type="text/css">
#sample {
	display: none;
}
</style>
<title>Insert title here</title>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>${board}Insert</h1>
	<form action="./${board}Insert" method="post" id="frm"
		enctype="multipart/form-data">
		<div class="container">

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>TITLE</th>
						<th><input type="text" name="title" id="title"
							class="myCheck"></th>
						<!-- 비어있으면 안됨 -->
						<th>WRITER</th>
						<th><input readonly="readonly" name="writer" id="writer"
							value="${member.id}" class="myCheck"></th>
					</tr>
				</thead>
				<tr>
					<td width="10%">CONTENTS</td>
					<!-- 비어있으면 안됨 -->
					<td colspan="3" ><textarea name="contents"
							style="resize: none;" id="contents" class="myCheck"></textarea></td>
				</tr>

				<tbody>
				</tbody>
			</table>
			<input type="button" value="add" class="btn btn-outline-danger"
				id="add"> <input type="button" value="delete"
				class="btn btn-danger" id="del">

			<div id="files" title="0"></div>
			<input type="button" value="WRITE" class="btn btn-outline-primary"
				id="btn">
		</div>



	</form>
	<div id="sample">

		<div class="input-group">
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="inputGroupFile04"
					aria-describedby="inputGroupFileAddon04" name="files"> <label
					class="custom-file-label" for="inputGroupFile04">Choose
					file</label>
			</div>
			<div class="input-group-append delete">
				<input class="btn btn-outline-secondary" type="button"
					id="inputGroupFileAddon04" value="Delete">
			</div>
		</div>

	</div>
	<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
	<script type="text/javascript">
		$("#contents").summernote({
			height:500,
			placeholder:'write here...',
			callbacks :{
				onImageUpload: function(files){
					uploadFile(files);
				}
			}
		});
		
	</script>
	<script type="text/javascript" src="../resources/jquery/summerFile.js"></script>
</body>
</html>