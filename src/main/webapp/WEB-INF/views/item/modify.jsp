<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Modify</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

</head>
<body>
	<h2>Modify</h2>
	<form:form modelAttribute="Item" method="post" action="/item/modify" enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.itemId }">
		<input type="hidden" name="pictureUrl" value="${item.pictureUrl }">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="itemName" id="itemName" value="${item.itemName }"/></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" id="price" value="${item.price }"/>&nbsp;원</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<img src="/item/display?itemId=${item.itemId }" width="210" height="240"/>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" name="picture" id="picture">
				</td>
			</tr>
			<tr>
				<td>개요<td>
			
				<textarea rows="10" cols="30" name="description">${item.description}</textarea>
				
			</tr>
		</table>
		<div>
			<button type="submit" id="btnModify">Modify</button>
			<button type="button" id="btnList">List</button>
		</div>
	</form:form>

<script>
$(function(){
	
	$("#btnList").on("click",function(){
		location.href = "/item/list";
	});
});

</script>
</body>
</html>