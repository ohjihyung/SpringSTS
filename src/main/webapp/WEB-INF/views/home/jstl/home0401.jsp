<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home0401</title>
</head>
<body>
		<h3>7장 jsp</h3>
		<p>el 식 내부에서 발생한 예외는 el식 내부에서 처리하므로 catch 변수 'ex'에 저장되지 않는다.</p>
		<c:set var="memberId" value ="${member.userId }"/>
		<c:catch var ="ex">
			${member.hobbyArray[3] }
		</c:catch>
		<p>
			<c:if test="${ex != null }">
				${ex }
			</c:if>
		</p>
</body>
</html>