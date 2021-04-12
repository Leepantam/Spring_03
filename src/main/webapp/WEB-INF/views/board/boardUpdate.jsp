<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
#sample{
	display: none;
 }
</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>${path}Update</h1>
	<form action="./${board}Update" method="post" enctype="multipart/form-data">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>TITLE</th>
					<th><input type="text" name="title" value="${dto.title}"></th>
					<th>WRITER</th>
					<th><input readonly="readonly" name="writer"
						value="${dto.writer}"></th>
				</tr>
			</thead>
			<tr>
				<td>CONTENTS</td>
				<td colspan="3"><textarea rows="20" cols="100" name="contents"
						style="resize: none;">${dto.contents}</textarea></td>
			</tr>

			<tbody>
			</tbody>
		</table>
		<c:forEach items="${dto.boardFiles}" var="file">
			<div>
				<span>${file.origineName}</span><span class="fileDelete"
					title="${file.fileNum}">X</span>
			</div>
		</c:forEach>
		<input hidden="true" name="hit" value="${dto.hit}"> <input
			hidden="true" name="num" value="${param.num}"> <input
			type="button" value="add" class="btn btn-outline-danger" id="add">
		<div id="files" title="${dto.boardFiles.size()}"></div>
		<button class="btn btn-outline-success">submit</button>


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

	<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>

</body>
</html>