<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="../template/bootStrap.jsp"></c:import>

<title>Insert title here</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>
<div class="container">
<h2>bankbookList</h2>

<table class="table">
	<thead class="thead-dark">
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
<a href="./bankbookWrite">Write</a>
</div>


</body>
</html>