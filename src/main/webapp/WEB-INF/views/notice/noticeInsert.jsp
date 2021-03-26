<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Notice Insert</h1>
<form action="./noticeInsert" method="post">

	title<input type="text" name="title">
	writer<input readonly="readonly" name="writer" value="${member.id}"><br>
	contents<br><textarea rows="50" cols="100" name="contents" style="resize: none;"></textarea><br>
	<button>submit</button>
	

</form>

</body>
</html>