<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form action="login" method="POST">
		<div>
			<table border="1">
				<tr>
					<th><label>아이디(이메일)</label></th>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<th><label>비밀번호</label></th>
					<td><input type="text" name="password"/></td>
				</tr>
			</table>
		</div>
		
		<div>
			<input type="submit" value="로그인">&nbsp&nbsp
			<a href="<c:url value="/register"/>">회원가입</a>
		</div>
	</form>
</body>
</html>