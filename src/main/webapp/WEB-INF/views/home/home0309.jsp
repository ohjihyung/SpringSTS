<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0308</title>
</head>
<body>
	 <h3>4. 표현 언어 (EL)</h3>
	 <p>4 empty</p>
	 
	 <table border = "1">
			<tr>
				<td>\${empty member}</td>
				<td>${empty member}</td>
			</tr>
		
			<tr>
				<td>\${empty member.hobbyList}</td>
				<td>${empty member.hobbyList}</td>
			</tr>
		
			<tr>
				<td>\${member.hobbyList[0]}</td>
				<td>${member.hobbyList[0] }</td>
			</tr>
		
	 </table>
</body>
</html>