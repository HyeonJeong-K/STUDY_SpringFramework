<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
</head>
<body>
	<form action="register" method="POST">
		<div>
			<table border="1">
				<tr>
					<th><label>이름</label></th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th><label>이메일(아이디)</label></th>
					<td><input type="text" name="email" /></td>
					<td><input type="button" name="idChk">중복확인</td>
				</tr>
				
				<tr>
					<th><label>비밀번호</label></th>
					<td><input type="text" name="password"/></td>
				</tr>
			</table>
		</div>
		
		<div>
			<input type="submit" value="회원가입">&nbsp&nbsp
			<input type="reset" value="다시작성">&nbsp&nbsp
			<a href="<c:url value="/"/>">목 록</a>
		</div>
	</form>
</body>
</html>