<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var board = $("#board");
	
	$("#btnRegister").on("click",function(){
		if($("#title").val() == null || $("#title").val() == ""){
			alert("제목을 입력해주세요");
			return false;
		}		
		if($("#writer").val() == null || $("#writer").val() == ""){
			alert("작성자을 입력해주세요");
			return false;
		}
		if($("#btnRegister").text()=="수정"){
			board.attr("action","/crud/board/modify");
		}
		board.submit();
	});
	
	$("#btnList").on("click",function(){
		location.href = "/crud/board/list";
	});
});


</script>
</head>
<body>

	
	<h2>Register</h2>
	<form:form modelAttribute="board" action="/crud/board/register" method ="post">
		<c:if test="${status eq 'u' }">
			<input type="hidden" name="boardNo" value="${board.boardNo }"/>
		</c:if>
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" id ="title" name ="title" value="${board.title }"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" id ="writer" name ="writer" value="${board.writer }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="6" cols="30" id="content" name ="content" >${board.content }</textarea></td>
			</tr>
		</table>
	</form:form>
		<div>
		<c:set var="buttonText" value="등록"/>
		<c:if test="${status eq 'u' }">
			<c:set var="buttonText" value="수정"/>
		</c:if>
			<button type="submit" id="btnRegister">${buttonText }</button>
			<button id="btnList">목록</button>
		</div>
</body>
</html>