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

	<h1>Notice Select</h1>

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
				<td>${nDto.num}</td>
				<td>${nDto.title}</td>
				<td>${nDto.writer}</td>
				<td>${nDto.regdate}</td>
				<td>${nDto.hit}</td>
			</tr>
			<tr>
				<td colspan="5" align="center"><textarea readonly="readonly"
						cols="100" rows="25" style="resize: none;">${nDto.contents}</textarea></td>
			</tr>
			<tr align="center">
				<c:if test="${not empty member and member.id eq 'admin'}">
					<td><a href="./noticeDelete?num=${nDto.num}" type="button"
						class="btn btn-outline-danger"> DELETE </a></td>
					<td><a href="./noticeUpdate?num=${nDto.num}" type="button"
						class="btn btn-outline-success">UPDATE</a></td>
				</c:if>
			</tr>
		</tbody>


	</table>






</body>
</html>