<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	$("#modBtn").on("click",function(){
		var form = $("#modify");
		
		if($("#title").val() == null || $("#title").val() ==""){
			alert("빈칸 ㄴㄴ");
			return false;
		}
		if($("#writer").val() == null || $("#writer").val() ==""){
			alert("빈칸 ㄴㄴ");
			return false;
		}
		
		if($("#content").val() == null || $("#content").val() ==""){
			alert("빈칸 ㄴㄴ");
			return false;
		}
		form.submit();
		
	});
	
	
	$("#delBtn").on("click",function(){
		if(confirm("진짜 삭제?")){
			location.href="/free/delete?boardNo="+${board.boardNo};
		}
	});
	
	
});
</script>
</head>
<body>
	<form method="post" action="/free/modify" id="modify">
		번호:<input type="text" id="boardNo" name="boardNo" value="${board.boardNo }" readonly="readonly"/><br/>
		제목:<input type="text" id="title" name="title" value="${board.title }"/><br/>
		작성자:<input type="text" id="writer" name="writer" value="${board.writer }"/><br/>
		내용:<textarea rows="6" cols="20" id="content" name="content">${board.content }</textarea><br/>
	</form>	
	
	<button type="button" id="modBtn">수정</button>
	<button type="button" id="delBtn">삭제</button>
</body>
</html>