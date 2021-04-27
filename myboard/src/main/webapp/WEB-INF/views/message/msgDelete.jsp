<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
	<form name="msgDeleteForm" action="<c:url value="/${board_seq}/msgDelete/${msg_seq}" />" method="post">
		<input size="1" name="msg_seq" value="${msg_seq}"/>번 쪽지를 삭제하시겠습니까?<br>
		<input name="check" type="checkbox" value="true" >
		<input type="submit" value="삭제" >
		<a href="<c:url value="/${board_seq}/msgRead/${msg_seq}" />">취소</a>
	</form>
</body>
</html>