<%@page import="java.util.Locale"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home01</title>
</head>
<body>
<!-- 
			7장 JSP
			
			1. 지시자 
			지시자(directive)는 JSP 페이지에 대한 설정 정보를 지정할 때 사용한다
			jsp가 제공하는 지시자에는  page 지시자, taglib 지시자, include 지시자로 세가지가 있다.
			
			  page 지시자
			    JSP 페이지에 대한 정보를 지정합니다.
			   - contentType : JSP가 생성할 문서의 MIME 타입과 문자 코드를 지정합니다.
			   - pageEncoding : JSP 페이지 자체의 문자코드를 지정합니다.
			   - session : JSP 페이지가 세션을 사용할지의 여부를 지정합니다.
			   - import : JSP 페이지에서 사용할 자바 클래스를 지정합니다.
			   
			   taglib 지시자
			    JSP 페이지에서 사용할 태그 라이브러리를 지정하빈다
			    -prefix : 태그 라이브러리를 호출할 때 사용할 접두어 지정
			    - url  : TLD 파일이 위치한 URL 혹은 파일경로 지정
			    
			    include 지시자
			    JSP 페이지의 특정 여역에 다른 문서를 포함
			    - file : 포함할 파일의 경로를 지정
			    
			    
		;;;;; 스크립트릿
		
		2. 스크립트릿
		스크립트릿은 JSP 페이지에서 자바 코드를 실행할 때 사용하는 코드의 블록
		스크립틀릿 코드블록은 "&#60;&#37&#62;"사이, 그리고"&#60;&#37&#61; &#62;" 사이의 자바코드를 포함할 수 있습니다
		
		현재는 스크립틀릿을 사용하기 보다는 JSTL 같은 커스텀 태그라이브러리와 EL을 조합하여 jsp 구현하는 방법 많이 사용
			    
 -->
	<%
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.KOREA);
		String formatterDate = dateFormat.format(date);
		String serverTime = formatterDate;
	%>
	<h1>Hello world!</h1>
	<p>The time on the server is ${serverTime }</p>
	
	<!--  스크립트릿 표현을 확인하고 있습니다 -->
	<p>스크립틀릿 표현으로 출력하기</p>
	<p>The time on the server is <%=serverTime %></p>
	
</body>
</html>