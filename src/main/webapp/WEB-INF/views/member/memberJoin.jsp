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
    <!-- 6글자 이상 -->
  </div>
  <div class="form-group">
    <label for="pw">Password</label>
    <input type="password" class="form-control" id="pw" name="pw">
    <!-- 8글자 이상 -->
  </div>
  <div class="form-group">
    <label for="pw">Password check</label>
    <input type="password" class="form-control" id="pw2" name="pw">
    <!-- pw 두개가 일치 -->
  </div>
  <div class="form-group">
    <label for="name">NAME</label>
    <input type="text" class="form-control" id="name" name="name">
    <!-- 비어있으면 안됨 -->
  </div>
  <div class="form-group">
    <label for="phone">PHONE</label>
    <input type="text" class="form-control" id="phone" name="phone">
    <!-- 비어있으면 안됨 -->
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email">
    <!-- 비어있으면 안됨 -->
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <input type="button" class="btn btn-primary" value="join" onclick="mCheck()">
</form>
</div>

<script type="text/javascript" src="../resources/js/memberCheck.js"></script>
</body>
</html>