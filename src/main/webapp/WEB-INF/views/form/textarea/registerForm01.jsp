<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring Form</h2>
	<form:form modelAttribute="member" method="post" action="/formtag/register">
		<table>
			<tr>
				<td>소개</td>
				<td>
					<form:textarea path="introduction" rows="6" cols="30"/>
					<font color ="red">
						<form:errors path="password"/>
					</font>
				</td>
			</tr>
					
		</table>
		<form:button name ="register">등록</form:button>
	</form:form>
</body>
</html>