<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0406</title>
</head>
<body>
	
	<p>15) pattern 속성을 지정하여 문자열 Date 객체로 변환한다.</p>

	<p>dateValue  : ${dateValue } </p>
	<fmt:parseDate value="${dateValue }" type ="date" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
	
	<p>date : ${date }</p>
</body>
</html>