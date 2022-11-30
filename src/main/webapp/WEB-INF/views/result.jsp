<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
		<h3>Result</h3>
		userId : ${userId }<br/>
		password : ${password }<br/>
		
		<!-- member.userId인 이유 
			member의 getter를 통해 가져오는데 
			getter의 값을 첫글자  소문자로 받아와 바로 사용가능하다 el에서
		 -->
		member.userId : ${member.userId }<br/>
		member.password : ${member.password  }<br/>
		
		<c:if test="${not empty member.address.postCode }">
			member.address.postCode : ${member.address.postCode }
		</c:if><br/>
		
		<c:if test="${not empty member.address.location }">
			member.address.location :  ${member.address.location }
		</c:if>
		
		<!-- RedirectAttribute시에 사용 -->
		msg : ${msg }
	
</body>
</html>