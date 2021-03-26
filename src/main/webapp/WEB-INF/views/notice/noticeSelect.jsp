<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Notice Select</h1>

<table>
	<thead>
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
			<td colspan="5"><textarea readonly="readonly" cols="50" rows="50" style="resize: none;">${nDto.contents}</textarea></td>
		</tr>
	</tbody>
	
	
</table>

<c:if test="${not empty member and member.id eq 'admin'}">

<a href="./noticeDelete?num=${nDto.num}"> DELETE </a>
<a href="./noticeUpdate?num=${nDto.num}">UPDATE</a>

</c:if>

</body>
</html>