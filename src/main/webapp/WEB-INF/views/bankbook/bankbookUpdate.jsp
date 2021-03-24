<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bankbook Update Form</h1>
<form action="./bankbookUpdate" method="post">
	<!-- 
	NUMBER: <input type="text" readonly="readonly" name="account_number" value="${dto.account_number}"><br>
	 -->
	<input type="hidden" name="account_number" value="${dto.account_number}"><br>
	NAME: <input type="text" name="account_name" value="${dto.account_name}"><br>
	RATE: <input type="text" name="interest_rate" value="${dto.interest_rate}"><br>
	can_make: <input type="text" name="can_make" value="${dto.can_make}"><br>
	<button>update</button>
</form>
</body>
</html>