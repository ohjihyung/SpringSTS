<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>EL</p>
	<p>str : ${str }</p>
	<p>contains : ${fn:contains(str,"Hello") }</p>
	<p>containsIgnoreCase : ${fn:containsIgnoreCase(str,"Hello") }</p>
	<p>startsWith : ${fn:startsWith(str,"Hello") }</p>
	<p>endsWith : ${fn:endsWith(str,"World!") }</p>
	<p>indexOf : ${fn:indexOf(str,"World!") }</p>
	<p>length : ${fn:length(str) }</p>
	<p>escapeXml : ${fn:escapeXml(str) }</p> <!-- 태그가 태그의 기능을 할 수 없도록  -->
	<p>replace : ${fn:replace(str,"Hello","Hi")}</p>
	<p>toLowerCase : ${fn:toLowerCase(str)}</p>
	<p>toUpperCase : ${fn:toUpperCase(str)}</p>
	<p>trim : ${fn:trim(str)}</p>
	<p>substring : ${fn:substring(str, 7, 12)}</p>
	<p>substringAfter : ${fn:substringAfter(str,"World!")} </p>
	<p>substringBefore : ${fn:substringBefore(str,"World!")}</p>
	<p>split : ${fn:split(str, ' ')}</p>

	
	<c:set value ="${fn:split(str,' ')}" var="strArray"/> 
	fn:join() : 배열의 모든 요소를 ​​문자열로 결합합니다.
	<p>${strArray[0] }</p> <!-- hello -->
	<p>join : ${fn:join(strArray, '-') }</p>
	<p>join : ${fn:join(fn:split(str,''), '-') }</p>
	
	
</body>
</html>