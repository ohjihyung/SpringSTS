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
		<h3>7장 jsp</h3>
		<p>JSP에서 사용될 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시한다</p>
		
		<table border = "1">
			<tr>
				<td>member.userId</td>
				<td>${member.userId}</td>
			</tr>
			
		</table>
</body>
</html>