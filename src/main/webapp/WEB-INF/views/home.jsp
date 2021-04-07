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

<style type="text/css">
	#d1{
		width : 200px;
		height : 200px;
		background-color:red;
		overflow:hidden;
	}
	#d2{
		width : 50px;
		height : 50px;
		background-color:yellow;
		margin : 75px auto;
	}
</style>
<title>Home!</title>
</head>
<body>

	<c:import url="./template/header.jsp">
	</c:import>

	<button class="b">BUTTON</button>
	<button id="btn" class="b">CLICK</button>
	<button id="btn2" class="b">CLICK2</button>
	<h1 id="t">version 7</h1>
	
	<ol id="result">
		<li>a</li>
	</ol>
	<select id="mon">
	</select>
	
	
	<div id="d1">
		<div id="d2">
		</div>
	</div>

	<script type="text/javascript">
	
	$("#d1").click(function(){
		console.log("parent");
	});
	$("#d2").click(function(){
		console.log("child");
	});
	
	
	$('#btn2').click(function(){
		for(let i=1;i<13;i++){
		$("#mon").append('<option>'+i+'</option>');
		}
	});
	$('#btn').click(function(){
		$("#result").prepend('<li>stop</li>');
	});
		
	</script>
</body>
</html>