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

	<h1>noticeList</h1>

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
			<c:forEach items="${noticeList}" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writer}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>

			<tr>
				<td><c:if test="${not empty member and member.id eq 'admin'}">
						<a href="./noticeInsert" type="button"
							class="btn btn-outline-primary">WRITE</a>
					</c:if></td>
			</tr>
		</tbody>


	</table>



</body>
</html>