<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0501</title>
</head>
<body>
		<h3>7장 jsp</h3>
		<p>test 속성에 true false를 값으로 가지는 불리언 변수가 올 수 있다.</p>
		<c:if test="${member.foreigner }">
			<p>member.foreigner == true</p>
		</c:if>
		
</body>
</html>