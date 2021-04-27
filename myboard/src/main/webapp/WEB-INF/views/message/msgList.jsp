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
		</tr>
		
		<c:forEach var="message" items="${msgList}" varStatus="loop">
			<tr>
				<td>${message.msg_seq}</td>
				<td><a href="<c:url value="/${message.board_seq}/msgRead/${message.msg_seq}" />">${message.msg_title} </a></td>
				<td>${message.msg_writer}</td>
				<td>${message.msg_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>