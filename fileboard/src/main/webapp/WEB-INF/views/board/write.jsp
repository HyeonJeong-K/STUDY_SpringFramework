<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>
	<form action="write" method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th><label >제 목</label></th>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<th><label>첨부파일</label></th>
				<td><input type="file" name="uploadFile" multiple="multiple"/></td>
			</tr>
			<tr>
				<th><label>내 용</label></th>
				<td><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<th><label>작성자</label></th>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<th><label>비밀번호</label></th>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">&nbsp&nbsp
			<a href="<c:url value="/list"/>">목 록</a>
		</div>
	</form>
</body>
</html>