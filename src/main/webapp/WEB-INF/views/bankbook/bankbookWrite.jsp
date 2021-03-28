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
<h1>write</h1>
<form action="./bankbookWrite" method="post">
  <div class="form-group">
    <label for="name">NAME</label>
    <input type="text" class="form-control" id="name" name="account_name">
  </div>
  <div class="form-group">
    <label for="rate">RATE</label>
    <input type="text" class="form-control" id="rate" name="interest_rate">
  </div>
  <div class="form-group">
  	<select id="inputState" class="form-control" name="can_make">
  		<option selected> Y </option>
  		<option> N </option>
  	</select>
  </div>
	<button class="btn btn-outline-success"> WRITE </button>
</form>
</div>
	
</body>
</html>