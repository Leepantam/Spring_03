<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:forEach items="${list}" var="i">
<table class="table table-hobber">
<tr>
	<td>
		${i.writer}
	<td>
	<td>
		${i.contents}
	<td>
	<td>
		${i.regdate}
	<td>
</tr>
</table>
</c:forEach>