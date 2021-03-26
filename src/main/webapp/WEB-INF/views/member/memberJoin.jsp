<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h2>memberJoin</h2>
<form action="./memberJoin" method="post">
  <div class="form-group">
    <label for="id">ID</label>
    <input type="text" class="form-control" id="id" name="id">
  </div>
  <div class="form-group">
    <label for="pw">Password</label>
    <input type="password" class="form-control" id="pw" name="pw">
  </div>
  <div class="form-group">
    <label for="name">NAME</label>
    <input type="text" class="form-control" id="name" name="name">
  </div>
  <div class="form-group">
    <label for="phone">PHONE</label>
    <input type="text" class="form-control" id="phone" name="phone">
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>



<h1>memberJoin</h1>
<form action="./memberJoin" method="post">
	ID:<input type="text" name="id"><br>
	PW:<input type="text" name="pw"><br>
	NAME:<input type="text" name="name"><br>
	PHONE:<input type="text" name="phone"><br>
	EMAIL:<input type="text" name="email"><br>
	<button> JOIN </button>
</form>

</body>
</html>