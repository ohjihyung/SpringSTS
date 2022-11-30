<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home1101</title>
</head>
<body>
		<h3>7장 jsp</h3>
		<p>지정한 페이지로 리다이렉트한다.</p>
		<p>c:redirect 사용 ㅇㅖ</p>
		<c:redirect url = "http://localhost/board/list"/>
		<h2>리다이렉트 이후의 코드는 실행되지않음</h2>
		<br/>
		<hr/>
		
		
</body>
</html>