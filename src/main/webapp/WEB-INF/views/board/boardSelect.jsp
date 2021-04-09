<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>

	<c:import url="../template/header.jsp"></c:import>

	<h1>${board}Select</h1>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>NO</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>DATE</th>
				<th>HIT</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.num}</td>
				<td>${dto.title}</td>
				<td>${dto.writer}</td>
				<td>${dto.regdate}</td>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td colspan="5" align="center"><textarea readonly="readonly"
						cols="100" rows="25" style="resize: none;">${dto.contents}</textarea></td>
			</tr>

			<div>
				<c:forEach items="${dto.boardFiles}" var="file">
					<tr>
						<td colspan="5" align="center"><a
							href="../resources/upload/${board}/${file.fileName}">${file.origineName}</a>
						</td>
					</tr>
				</c:forEach>
			</div>
		</tbody>


	</table>
	<!--  댓글 -->



	<div id="comments" title="${dto.num}"></div>

	<div class="form-group">
		<label for="writer">Name:</label> <input type="text" class="form-control"
			id="writer">
	</div>
	<div class="form-group">
		<label for="comment">Comment:</label>
		<textarea class="form-control" rows="5" id="contents"></textarea>
	</div>
	<button type="button" class="btn btn-primary" id="write">write</button>





	<!--  버튼  -->

	<c:if test="${not empty member and member.id eq 'admin'}">
		<a href="#" type="button" class="btn btn-outline-danger" id="del">
			DELETE </a>
		<a href="./${board}Update?num=${dto.num}" type="button"
			class="btn btn-outline-success">UPDATE</a>

	</c:if>
	<c:if test="${board ne 'notice'}">
		<a href="./${board}Reply?num=${dto.num}" type="button"
			class="btn btn-outline-success">Reply</a>
	</c:if>


	<form action="./${board}Delete" id="frm">
		<input type="hidden" name="num" value="${dto.num}">
	</form>


	<script type="text/javascript" src="../resources/jquery/comments.js"></script>
	<script type="text/javascript">
		let del = document.getElementById("del");
		let frm = document.getElementById("frm");
		del.addEventListener("click", function() {
			let result = confirm("delete?");
			console.log(result);
			if (result) {
				frm.setAttribute("method", "post");
				frm.submit();
				//location.href="./${board}Delete?num=${dto.num}";
			}
		})
	</script>

</body>
</html>