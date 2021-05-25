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
		
		<c:forEach var="content" items="${list}" varStatus="loop">
			<tr>
				<td>${content.cid}</td>
				<td><a href="<c:url value="/read/${content.cid}" />">${content.title} </a></td>
				<td>${content.uid}</td>
				<td>${content.condate}</td>
				<td>${content.readcnt}</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${member != null}">
		<a href="<c:url value="/write" />">새 글</a>
	</c:if>
	
	<a href="<c:url value="/" />">홈으로</a>
</body>
</html>