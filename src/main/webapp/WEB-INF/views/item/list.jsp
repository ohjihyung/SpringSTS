<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item list</title>
</head>
<body>
	<h2>List</h2>
	<a href="/item/register">상품 등록</a>
	
	<table border="1">
		<tr>
			<th align="center" width="80" >상품ID</th> 
			<th align="center" width="320" >상품명 </th>
			<th align="center" width="100" >가격 </th>
			<th align="center" width="80" >편집 </th>
			<th align="center" width="80" >제거 </th>
		</tr>
		
		<c:forEach items="${itemList }" var="item">
			<tr>
			<th align="center" >${item.itemId } </th> 
			<th align="left" >${item.itemName } </th> 
			<th align="right" >${item.price } </th> 
			<th align="center" ><a href="/item/modify?itemId=${item.itemId}"> 상품편집</a> </th> 
			<th align="center" ><a href="/item/remove?itemId=${item.itemId}"> 상품제거</a> </th> 	
		</tr>
		</c:forEach>
	</table>
</body>
</html>