<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0101</title>
</head>
<body>
		<p>pattern 속성으로 사용할 서식 사용가능입니다..</p>
		<p>coin  : ${coin }</p>
		
		
		<fmt:parseNumber value="${coin }" pattern ="000,000.00" var="coinNum"/>
		<p>coinNum  : ${coinNum }</p>
	
</body>
</html>