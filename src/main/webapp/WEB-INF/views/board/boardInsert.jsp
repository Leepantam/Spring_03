<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
#sample{
	display: none;
}
</style>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1>${board} Insert</h1>
<form action="./${board}Insert" method="post" id="frm">
<div class="container">

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th> TITLE </th>
			<th><input type="text" name="title" id="title" class="myCheck"></th>
			<!-- 비어있으면 안됨 -->
			<th> WRITER </th>
			<th><input readonly="readonly" name="writer" id="writer" value="${member.id}" class="myCheck"></th>
		</tr>
	</thead>
		<tr>
			<td width="10%">CONTENTS</td>
			<!-- 비어있으면 안됨 -->
			<td colspan="3"><textarea rows="30" cols="100" name="contents" style="resize: none;" id="contents" class="myCheck"></textarea></td>
		</tr>

	<tbody>
	</tbody>
</table>
			<input type="button" value="add" class="btn btn-outline-danger" id="add">
		<div id="files"></div>
			<input type="button" value="WRITE" class="btn btn-outline-primary" id="btn">
</div>

</form>
<div id ="sample">
<div class="form-group">
      <input type="file" class="form-control-file border" name="file">
    </div>
</div>
<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
</body>
</html>