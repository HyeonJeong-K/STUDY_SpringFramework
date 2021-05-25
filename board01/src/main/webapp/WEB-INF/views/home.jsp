<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>메인 페이지</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<c:if test="${member == null}">
	<a href="<c:url value="list"/>">게사판</a>
	<a href="<c:url value="login" />">로그인</a>
	<a href="<c:url value="regist" />">회원가입</a>
</c:if>

<c:if test="${member != null}">
	<a href="<c:url value="list"/>">게사판</a>
	<a href="<c:url value="logout" />">로그아웃</a>
	<br>
	<p>${member.name} 님 환영합니다.</p>
</c:if>
	

</body>
</html>
