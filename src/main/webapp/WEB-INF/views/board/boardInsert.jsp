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
			<input type="button" value="delete" class="btn btn-danger" id="del">
			
			<div id="files"></div>
			<input type="button" value="WRITE" class="btn btn-outline-primary" id="btn">
</div>


<div id ="sample">

<div class="input-group">
  <div class="custom-file" >
    <input type="file" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
    <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  </div>
  <div class="input-group-append delete">
    <input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
  </div>
</div>

</div>


</form>
<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
</body>
</html>