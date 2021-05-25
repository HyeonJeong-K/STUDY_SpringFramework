<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form action="edit" method="POST">
		<div>
			<table border="1">
				<tr>
					<th><label>제목</label></th>
					<td><input type="text" name="title" value="${contentVO.title}"/></td>
				</tr>
				<tr>
					<th><label>내용</label></th>
					<td><textarea name="content" cols="40" rows="10">${contentVO.content}</textarea></td>
				</tr>
				<tr>
					<th><label>작성자</label></th>
					<td><input type="text" name="uid" value="${contentVO.uid}"/></td>
				</tr>
			</table>
		</div>
		
		<div>
			<input type="submit" value="수정">&nbsp&nbsp
			<a href="<c:url value="/"/>">목 록</a>
		</div>
	</form>
</body>
</html>