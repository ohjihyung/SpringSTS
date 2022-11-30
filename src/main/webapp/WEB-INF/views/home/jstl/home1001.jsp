<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0901</title>
</head>
<body>
		<h3>c:url</h3>
		<p>웹 어플리케이션 내에서의 절대 경로를 사용하면 실제로 생성된 컨텍스트 경로가 포함된다.</p>
		<p>절대 Url</p>
		
		<c:url value = "http://localhost/board/list"/>
		
		<p>상대 URL - 절대경로</p>
		<c:url value = "/board/list"/>
		<c:url value = "/board/detail?bo_no=1" var="boardUrl"/>
		${boardUrl }
		<p>상대 URL - 상대경로</p>
		<c:url value = "../../board/list"/>
		
</body>
</html>