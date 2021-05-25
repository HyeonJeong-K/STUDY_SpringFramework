<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${contentVO.title}&nbsp내용</title>
</head>
<body>
	<form action="contentRead" method="POST">

		<h3>게시글 내용</h3>
		
		<div>
			<table  border="1">
				<tr>
					<th>제목</th>
					<td>${contentVO.title}</td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="40" rows="10">${contentVO.content}</textarea></td>
				</tr>

				<tr>
					<th>작성자</th>
					<td>${contentVO.uid}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${contentVO.condate}</td>
				</tr>
				
			</table>
		</div>

	</form>
	<div>
		<c:if test="${member != null}">
			<c:if test="${contentVO.uid == member.uid}">
				<a href="<c:url value="/edit/${content.cid}" />">글 수정</a>
				<a href="<c:url value="/delete/${content.cid}" />">글 삭제</a>
			</c:if>
		</c:if>
		<c:if test="${member != null}">
			
		</c:if>
		<a href="<c:url value="/list"/>">목록</a>
	</div>
	
	<div>
		<c:if test="${member != null}">
			 <form:form commandName="replyVO" method="POST">
				<%@ include file="/WEB-INF/views/reply/repWrite.jsp" %>
			</form:form>
		</c:if>
	</div>
	
	<div>
		<%@ include file="/WEB-INF/views/reply/repList.jsp" %>
	</div>

</body>
</html>