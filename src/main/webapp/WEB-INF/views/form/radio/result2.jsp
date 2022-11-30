<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>result</h2>
		<h4>gender : </h4>
		<table>
			<tr>
				<td>성별</td>
				<td><c:out value="${member.gender }"/></td>
			</tr>
		</table>
	
</body>
</html>