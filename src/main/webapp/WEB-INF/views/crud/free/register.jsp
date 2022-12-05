<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Free register Form</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var board = $("#board");
	
	$("#regBtn").on("click",function(){
		if($("#title").val() == null || $("#title").val() == ""){
			alert("제목을 입력!");
			return false;
		}
		if($("#writer").val() == null || $("#writer").val() == ""){
			alert("작성자를 입력!");
			return false;
		}
		if($("#content").val() == null || $("#content").val() == ""){
			alert("내용을 입력!");
			return false;
		}
		board.submit();
		
	});//end of regBtn
	
	$("#listBtn").on("click",function(){
		location.href="/free/list";
	});
	
});
</script>
</head>
<body>
	<form:form modelAttribute="board" action="/free/register" method="POST">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" id="writer"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="6" cols="30" id="content" name="content"></textarea></td>
			</tr>
		</table>
	</form:form>
	<button type="button" id="regBtn">등록</button>
	<button type="button" id="listBtn">목록</button>
</body>
</html>