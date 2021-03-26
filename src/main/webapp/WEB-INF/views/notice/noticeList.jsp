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
<h1>noticeList</h1>

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
		<c:forEach items="${noticeList}" var="dto">
		<tr>
			<td>${dto.num}</td>
			<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.regdate}</td>
			<td>${dto.hit}</td>
		</tr>
		</c:forEach>
	</tbody>
	
	
</table>

<c:if test="${not empty member and member.id eq 'admin'}">
<a href="./noticeInsert">WRITE</a>
</c:if>

</body>
</html>