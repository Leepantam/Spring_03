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
<h1>member Page</h1>
<h3>ID: ${member.id}</h3>
<h3>PW: ${member.pw}</h3>
<h3>NAME:${member.name}</h3>
<h3>PHONE:${member.phone}</h3>
<h3>EMAIL:${member.email}</h3>
<a href="./memberUpdate" type="button" class="btn btn-outline-primary">수정</a>
<a href="./memberDelete" type="button" class="btn btn-outline-danger">탈퇴</a>
<a href="../account/accountList" type="button" class="btn btn-outline-info">계좌 관리</a>
</body>
</html>