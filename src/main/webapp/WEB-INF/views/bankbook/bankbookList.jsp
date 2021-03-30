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
						<td><a
							href="./bankbookSelect?account_number=${dto.account_number}">${dto.account_name}</a></td>
						<td>${dto.interest_rate}</td>
						<td>${dto.can_make}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty member and member.id eq 'admin'}">
			<a href="./bankbookWrite" type="button"
				class="btn btn-outline-primary">Write</a>
		</c:if>
	</div>
	<div class="container">
		<ul class="pagination">
			<c:if test="${pager.pre}">
				<li class="page-item"><a class="page-link"
					href="./bankbookList?kind=${pager.kind}&search=${pager.search}&curPage=${pager.startNum-1}">Previous</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link"
					href="./bankbookList?kind=${pager.kind}&search=${pager.search}&curPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link"
					href="./bankbookList?kind=${pager.kind}&search=${pager.search}&curPage=${pager.lastNum+1}">Next</a></li>
			</c:if>
		</ul>


		<div class="input-group mt-3 mb-3">
			<form action="./bankbookList" class="form-inline">
				<div class="input-group-prepend">
					<select class="form-control" id="sel1" name="kind">
						<option>account_name</option>
						<option>rate</option>
					</select>
				</div>
				<input type="text" class="form-control" placeholder="Search" name="search">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>


	</div>


</body>
</html>