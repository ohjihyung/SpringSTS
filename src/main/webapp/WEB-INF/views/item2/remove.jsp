<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Remove</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
	<h2>Remove</h2>
	<form:form modelAttribute="Item2" method="post" action="/item2/remove">
		<input type="hidden" name="itemId" value="${item.itemId }">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="itemName" id="itemName" value="${item.itemName }"disabled="disabled"/></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" id="price" value="${item.price }" disabled="disabled"/>&nbsp;원</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<img src="/item2/display?itemId=${item.itemId }" width="210" height="240"/>
				</td>
			</tr>
			
			<tr>
				<td>파일</td>
				<td>
					<img src="/item2/display2?itemId=${item.itemId }" width="210" height="240"/>
				</td>
			</tr>
			
			<tr>
				<td>개요<td>
			
				<textarea rows="10" cols="30" name="description" disabled="disabled">${item.description}</textarea>
				
			</tr>
		</table>
		<div>
			<button type="submit" id="btnDelete">Remove</button>
			<button type="button" id="btnList">List</button>
		</div>
	</form:form>

<script>
$(function(){
	
	$("#btnList").on("click",function(){
		location.href = "/item2/list";
	});
});

</script>
</body>
</html>