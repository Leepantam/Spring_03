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
<h1>${path} Update</h1>
<form action="./${board}Update" method="post">
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th> TITLE </th>
			<th><input type="text" name="title" value="${dto.title}"></th>
			<th> WRITER </th>
			<th><input readonly="readonly" name="writer" value="${dto.writer}"></th>
		</tr>
	</thead>
		<tr>
			<td>CONTENTS</td>
			<td colspan="3" ><textarea rows="20" cols="100" name="contents" style="resize: none;" >${dto.contents}</textarea></td>
		</tr>
		<tr>
			<td>
				<input hidden="true" name="hit" value="${dto.hit}">
				<input hidden="true" name="num" value="${param.num}">
				<button class="btn btn-outline-success">submit</button>
			</td>
		</tr>
	<tbody>
	</tbody>
</table>


</form>

</body>
</html>