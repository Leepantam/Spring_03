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
<h1>Account List</h1>
<table>
	<thead>
		<tr>
		<th>account</th>
		<th>info</th>
		<th>make_date</th>
		<th>balance</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${list}" var="dto">
		<tr>
		<td>${dto.account}</td>
		<td>${dto.book_info}</td>
		<td>${dto.make_date}</td>
		<td>${dto.balance}</td>
		</tr>
</c:forEach>
	</tbody>
</table>



</body>
</html>