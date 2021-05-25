<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>

<body>
	<form action="write" method="POST" enctype="multipart/form-data">
		<div>
			<table border="1">
				<tr>
					<th><label>제목</label></th>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<th><label>내용</label></th>
					<td><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<th><label>작성자</label></th>
					<td><input type="text" name="uid" value="${memberVO.uid}"/></td>
				</tr>
			</table>
		</div>
		
		<div>
			<input type="submit" value="등록">&nbsp&nbsp
			<input type="reset" value="리셋">&nbsp&nbsp
			<a href="<c:url value="/"/>">목 록</a>
		</div>
	</form>
	
</body>

</html>