<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0601</title>
</head>
<body>
		<h3>7장 jsp</h3>
		<p>모든 c:when 태그의 test 결과값이 false 이면 c:otherwise가 실행된다..</p>
		<c:choose>
			<c:when test="${member.gender == 'M' }">
				<p>male</p>
			</c:when>
			<c:when test="${member.gender == 'F' }">
				<p>female</p>
			</c:when>
			<c:otherwise>
				<p>other</p>
			</c:otherwise>
		</c:choose>
		
</body>
</html>