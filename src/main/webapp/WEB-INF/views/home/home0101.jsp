<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0101</title>
</head>
<body>
	<h3>4. 표현언어(EL)</h3>
	<p>1) 자바빈즈 프로퍼티를 조회하는 경우 '속성명.프로퍼티명'을 지정</p>
	<table border = "1">
		<tr>
			<td>\${member.userId }</td>
			<td>${member.userId }</td>
		</tr>
	
		<tr>
			<td>\${member.password }</td>
			<td>${member.password }</td>
		</tr>
	
		<tr>
			<td>\${member.userName }</td>
			<td>${member.userName }</td>
		</tr>
	
		<tr>
			<td>\${member.email }</td>
			<td>${member.email }</td>
		</tr>
	
		<tr>
			<td>\${member.dateofBirth }</td>
			<td>${member.dateofBirth }</td>
		</tr>
	
	</table>
	
</body>
</html>