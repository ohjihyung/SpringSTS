<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	$("#regBtn").on("click",function(){
		location.href = "/free/freeRegisterform";
	});
});
</script>
</head>
<body>
	<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
	
	</tr>
	<c:if test="${empty boardList }">
		<tr>
			<td colspan="4">조회할 개시물이 없습니다</td>
		</tr>
	</c:if>
		<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.boardNo }</td>
				<td><a href="/free/read?boardNo=${board.boardNo }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>	
	</table>
	<button type="button" id="regBtn">등록</button>
</body>
</html>