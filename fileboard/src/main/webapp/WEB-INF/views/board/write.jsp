<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>
	<form:form commandName="boardVO" method="POST" enctype="multipard/form-data">
		<table border="1">
			<tr>
				<th><form:label path="title">제 목</form:label></th>
				<td><form:input path="title" /><form:errors path="title" /></td>
			</tr>
			<tr>
				<th><form:label path="file">첨부파일</form:label></th>
				<td><form:input path="file" /><form:errors path="file" /></td>
			</tr>
			<tr>
				<th><form:label path="content">내 용</form:label></th>
				<td><form:input path="content" /><form:errors path="content" /></td>
			</tr>
			<tr>
				<th><form:label path="writer">작성자</form:label></th>
				<td><form:input path="writer" /><form:errors path="writer" /></td>
			</tr>
			<tr>
				<th><form:label path="password">비밀번호</form:label></th>
				<td><form:password path="password" /><form:errors path="password" /></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="등록">&nbsp&nbsp
			<a href="<c:url value="/list"/>">목 록</a>
		</div>
	</form:form>
</body>
</html>