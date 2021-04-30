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

<form action="read" method="POST">
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${boardVO.title}</td>
		</tr>
	
		<c:if test="${boardVO.file_name ne null}">
			<tr>
				<th>첨부파일</th>
				<td><a href="/file/down/${boardVO.file_name}?fileName=${boardVO.file_name}">${boardVO.file_name}</a></td>
			</tr>
		</c:if>
		
		<tr>
			<th>내용</th>
			<td><textarea name="content" cols="40" rows="10">${boardVO.content}</textarea></td>
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
</form>
	<div>
		<a href="<c:url value="/edit/${boardVO.board_seq}"/>">수정</a>
		<a href="<c:url value="/delete/${boardVO.board_seq}"/>">삭제</a>
		<a href="<c:url value="/list"/>">목록</a>
	</div>
	
</body>
</html>