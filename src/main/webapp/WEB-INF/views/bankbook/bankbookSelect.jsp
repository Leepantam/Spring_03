<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>bankbook Select</h1>

	<h3>NAME: ${dto.account_name}</h3>
	<h3>NUMBER : ${dto.account_number}</h3>
	<c:if test="${not empty member}">
		<c:if test="${member.id eq 'admin'}">
			<a href="./bankbookDelete?account_number=${dto.account_number}">Delete</a>
			<a href="./bankbookUpdate?account_number=${dto.account_number}">Update</a>
		</c:if>
		<c:if test="${member.id ne 'admin'}">
			<a href="../account/accountInsert?account_number=${dto.account_number}" type="button" class="btn btn-outline-primary"> 가입 </a>
		</c:if>
	</c:if>
	<%-- 
	<c:catch>
		<c:if test="${member.id eq 'admin'}">
			<a href="./bankbookDelete?account_number=${dto.account_number}">Delete</a>
			<a href="./bankbookUpdate?account_number=${dto.account_number}">Update</a>
		</c:if>
	</c:catch> 
	문제 발생 가능성 있음
	--%>

</body>
</html>