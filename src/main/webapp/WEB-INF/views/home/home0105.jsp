<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0105</title>
</head>
<body>
	
	<table border = "1">
			<tr>
				<td>\${member.userId }</td>
				<td>${memberMap["userId"] }</td>
			</tr>
			<tr>
				<td>\${member.password }</td>
				<td>${memberMap.password }</td>
			</tr>
			<tr>
				<td>\${member.userName }</td>
				<td>${memberMap.userName }</td>
			</tr>
			<tr>
				<td>\${member.email }</td>
				<td>${memberMap.email }</td>
			</tr>
			<tr>
				<td>\${member.dateofBirth }</td>
				<td>${memberMap.dateofBirth }</td>
			</tr>
	</table>
	
</body>
</html>