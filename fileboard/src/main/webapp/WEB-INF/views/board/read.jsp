<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVO.title}&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${boardVO.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardVO.content}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardVO.writer}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardVO.regdate}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardVO.readcnt}</td>
		</tr>
	</table>
	
	<div>
		<a href="<c:url value="/edit/${boardVO.board_seq}"/>">수정</a>
		<a href="<c:url value="/delete/${boardVO.board_seq}"/>">삭제</a>
		<a href="<c:url value="/list"/>">목록</a>
	</div>
	
</body>
</html>