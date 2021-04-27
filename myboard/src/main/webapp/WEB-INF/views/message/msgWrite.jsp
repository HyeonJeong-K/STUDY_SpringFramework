<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 보내기</title>
</head>
<body>
	<form:form commandName="messageVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="msg_title">제 목</form:label></th>
				<td><form:input path="msg_title" /><form:errors path="msg_title" /></td>
			</tr>
			<tr>
				<th><form:label path="msg_text">내 용</form:label></th>
				<td><form:input path="msg_text" /><form:errors path="msg_text" /></td>
			</tr>
			<tr>
				<th><form:label path="msg_writer">작성자</form:label></th>
				<td><form:input path="msg_writer" /><form:errors path="msg_writer" /></td>
			</tr>
			<tr>
				<th><form:label path="board_seq">board_seq</form:label></th>
				<td><form:input path="board_seq" value="${boardVO.board_seq}" /><form:errors path="board_seq" /></td>
			</tr>
		</table>
		
		<div>
			<input type="submit" value="등록">&nbsp&nbsp
			<a href="<c:url value="/list"/>">목 록</a>
		</div>
	</form:form>
</body>
</html>