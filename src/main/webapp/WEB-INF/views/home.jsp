<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">

<c:import url="./template/bootStrap.jsp"></c:import>
<link type="text/css" rel="stylesheet" href="./resources/css/test.css">

<title>Home!</title>
</head>
<body>

	<c:import url="./template/header.jsp">
	</c:import>

	<div>
		<button id="btn" onclick="go()">click</button>
		<button onclick="go2()">click2</button>
	</div>

	<div class="b1" id="c1">
		<h1 id="t1">Welcome Home Page</h1>
	</div>

	<script type="text/javascript" src="./resources/js/test.js"></script>
</body>
</html>