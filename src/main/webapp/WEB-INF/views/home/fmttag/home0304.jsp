<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>8) type 속성을 both로 지정하여 날짜, 시간 둘다 포멧팅을 한다..</p>
	<p>now  : ${now } </p>
	
	<p>pattern : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /></p>
	<p>pattern : <fmt:formatDate value="${now }" pattern="a H:mm"/></p>
	<p>pattern  : <fmt:formatDate value="${now }" pattern="z a h:mm" /></p>

	
</body>
</html>