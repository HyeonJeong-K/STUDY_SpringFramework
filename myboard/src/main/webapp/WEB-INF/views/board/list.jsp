<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제 목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${list}" varStatus="loop">
			<tr>
				<td>${board.board_seq}</td>
				<td><a href="<c:url value="/read/${board.board_seq}" />">${board.title} </a></td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.readcnt}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/write" />">새 글</a>
</body>
</html>