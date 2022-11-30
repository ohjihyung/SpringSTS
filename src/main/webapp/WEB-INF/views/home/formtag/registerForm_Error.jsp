<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm_ERROR</title>
</head>
<body>
	<h2>Spring form</h2>
	<p>1) 모델에 폼 객체를 추가하지 않으면 에러가 발생 - 서버 컨트롤러 메소드에 담긴 member 객체를 받지 않앗음</p>
	
	<form:form modelAttribute="member" method="POST" action="/formtag/register">
		<table>
			<tr>
				<td>유저 Id</td>
				<td>
					<form:input path="userId"/>
					<font color="red">
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>

</body>
</html>