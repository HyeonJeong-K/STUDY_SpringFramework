<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table border="1">
	<tr>
		<th><form:label path="rep_text">내 용</form:label></th>
		<td><form:input path="rep_text" /><form:errors path="rep_text" /></td>
	</tr>
	<tr>
		<th><form:label path="rep_writer">작성자</form:label></th>
		<td><form:input path="rep_writer" /><td><form:errors path="rep_writer" /></td>
	</tr>
</table>

<div>
	<input type="submit" value="댓글등록">&nbsp&nbsp
</div>
