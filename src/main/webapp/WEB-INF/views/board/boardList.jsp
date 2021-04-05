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
	<!--  -->
	<div class="container">

		<h1>${board}</h1>

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
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="./${board}Select?num=${dto.num}">
						<c:catch>
						<c:forEach begin="1" end="${dto.depth}">
						--
						</c:forEach>
						</c:catch>
						${dto.title}
						</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regdate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>

				<tr>
					<td><c:if test="${board ne 'notice' and not empty member}">
						
							<a href="./${board}Insert" type="button"
								class="btn btn-outline-primary">WRITE</a>
						</c:if>
						<c:if test="${board eq 'notice' and not empty member and member.id eq 'admin'}">
							<a href="./${board}Insert" type="button"
								class="btn btn-outline-primary">WRITE</a>
						</c:if></td>
				</tr>
			</tbody>


		</table>
	</div>


	 <div class="container">
		<ul class="pagination">
			<c:if test="${pager.pre}">
				<li class="page-item"><a class="page-link"
					href="./noticeList?kind=${pager.kind}&search=${pager.search}&curPage=${pager.startNum-1}">Previous</a></li>
			</c:if>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link"
					href="./noticeList?kind=${pager.kind}&search=${pager.search}&curPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.next}">
				<li class="page-item"><a class="page-link"
					href="./noticeList?kind=${pager.kind}&search=${pager.search}&curPage=${pager.lastNum+1}">Next</a></li>
			</c:if>
		</ul>
		<div class="input-group mt-3 mb-3">
			<form action="./noticeList" class="form-inline">
				<div class="input-group-prepend">
					<select class="form-control" id="sel1" name="kind">
						<option>Title</option>
						<option>Contents</option>
						<option>Writer</option>
					</select>
				</div>
				<input type="text" class="form-control" placeholder="Username"
					name="search">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>



	</div>

</body>
</html>