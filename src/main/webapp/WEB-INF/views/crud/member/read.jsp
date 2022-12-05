<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Read</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnRemove").on("click",function(){
		if(confirm("정말로 삭제??")){
			$("#delForm").submit();
		}
	});
	
	$("#btnList").on("click",function(){
		location.href="/crud/member/list";
	});
});
</script>
</head>
<body>
	<h3>READ</h3>
	<table>
		<tr>
			<td>userId</td>
			<td>${member.userId}</td>
		</tr>
		<tr>
			<td>userName</td>
			<td>${member.userName}</td>
		</tr>
		<tr>
			<td>auth - 1</td>
			<td>${member.authList[0].auth}</td>
		</tr>
		<tr>
			<td>auth - 2</td>
			<td>${member.authList[1].auth}</td>
		</tr>
		<tr>
			<td>auth - 3</td>
			<td>${member.authList[2].auth}</td>
		</tr>
	</table>
	<form action="/crud/member/remove" id="delForm" method="post">
		<input type="hidden" name="userNo" value="${member.userNo }"/>
	</form>
	<div>
		<a href="/crud/member/modify?userNo=${member.userNo}">
			<button type="button" id="btnModify">Modify</button>
		</a>
			<button type="button" id="btnRemove">Remove</button>
			<button type="button" id="btnList">List</button>
	</div>
</body>
</html>