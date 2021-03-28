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
	<h1>member Update</h1>
	<form action="./memberUpdate" method="post">
		<h3>
			ID: <input readonly="readonly" name="id" value="${member.id}">
		</h3>
		<h3>
			PW:<input type="text" name="pw" value="${member.pw}">
		</h3>
		<h3>
			NAME:<input type="text" name="name" value="${member.name}">
		</h3>
		<h3>
			PHONE:<input type="text" name="phone" value="${member.phone}">
		</h3>
		<h3>
			EMAIL:<input type="text" name="email" value="${member.email}">
		</h3>
		<button class="btn btn-outline-primary" >수정</button>
	</form>
</body>
</html>