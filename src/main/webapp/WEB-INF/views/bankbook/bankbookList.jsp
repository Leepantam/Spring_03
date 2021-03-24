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
<h1>bankbookList</h1>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Rate</th>
			<th>can_make</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="./bankbookSelect?account_number=${dto.account_number}">${dto.account_name}</a></td>
			<td>${dto.interest_rate}</td>
			<td>${dto.can_make}</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>
</body>
</html>