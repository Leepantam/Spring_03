<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bankbook Select</h1>

<h3>NAME: ${dto.account_name}</h3>
<h3>NUMBER : ${dto.account_number}</h3>

<a href="./bankbookDelete?account_number=${dto.account_number}">Delete</a>

</body>
</html>