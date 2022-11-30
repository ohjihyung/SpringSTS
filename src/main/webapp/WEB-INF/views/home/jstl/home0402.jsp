<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0402</title>
</head>
<body>
		<h3>7장 jsp</h3>
		<p>JSP 표현식에서 발생한 예외는 catch 변수 'ex'에 저장된다.</p>
		<%
			String[] hoobyArray = {"music","movie"};
		%>
		<c:catch var ="ex">
			<%=hoobyArray[3] %>
		</c:catch>
		<p>
			<c:if test="${ex != null }">
				${ex }
			</c:if>
		</p>
</body>
</html>