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
<h1>Notice Insert</h1>
<form action="./noticeInsert" method="post" id="noticeForm">

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th> TITLE </th>
			<th><input type="text" name="title" id="title"></th>
			<!-- 비어있으면 안됨 -->
			<th> WRITER </th>
			<th><input readonly="readonly" name="writer" value="${member.id}"></th>
		</tr>
	</thead>
		<tr>
			<td width="10%">CONTENTS</td>
			<!-- 비어있으면 안됨 -->
			<td colspan="3"><textarea rows="30" cols="100" name="contents" style="resize: none;" id="contents"></textarea></td>
		</tr>
		<tr>
			<td><input type="button" value="WRITE" class="btn btn-outline-primary" id="writeBtn"></td>
		</tr>
	<tbody>
	</tbody>
</table>


</form>

<script type="text/javascript" src="../resources/js/insertCheck.js"></script>
</body>
</html>