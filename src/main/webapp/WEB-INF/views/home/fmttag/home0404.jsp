<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0404</title>
</head>
<body>
	
	<p>13) dataStyle 속성을 long로 지정하여 문자열을 Date 객체로 변환한다.</p>

	<p>dateValue  : ${dateValue } </p>
	<fmt:parseDate value="${dateValue }" type="date" dateStyle="long" var="date"/>
	
	<p>date : ${date }</p>
</body>
</html>