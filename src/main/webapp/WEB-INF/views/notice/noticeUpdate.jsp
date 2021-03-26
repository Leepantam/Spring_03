<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Notice Update</h1>
<form action="./noticeUpdate" method="post">

	title<input type="text" name="title" value="${nDto.title}">
	writer<input readonly="readonly" name="writer" value="${nDto.writer}"><br>
	contents<br><textarea rows="50" cols="100" name="contents" style="resize: none;" >${nDto.contents}</textarea><br>
	<input hidden="true" name="hit" value="${nDto.hit}">
	<input hidden="true" name="num" value="${nDto.num}">
	
	<button>submit</button>
	

</form>
</body>
</html>