<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Spring Form</h2>
	
	<form:form modelAttribute="member" action ="/formtag/hidden/result"  method = "post">
		<form:hidden path="userId"/>
		<table>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color = "red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name = "register">등록</form:button>
	</form:form>
</body>
</html>