<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${messageVO.msg_title}&nbsp내용</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${messageVO.msg_title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${messageVO.msg_text}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${messageVO.msg_writer}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${messageVO.msg_date}</td>
		</tr>
	</table>
	
	<div>
		<a href="<c:url value="/msgDelete/${messageVO.msg_seq}"/>">삭제</a>
		<a href="<c:url value="/msgList/${messagVO.board_seq}"/>">목록</a>
	</div>
	
</body>
</html>