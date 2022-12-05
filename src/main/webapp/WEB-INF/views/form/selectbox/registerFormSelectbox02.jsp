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
		<p>모델에 List 타입 데이터를 생성하여 추가한 후에 화면에 전달</p>
		
		
		<form:form modelAttribute="member" action ="/formtag/selectbox/result" method="post">
			<tr>
				<td>국적</td>
				<td>
					<form:select path ="nationality" items="${nationalityCodeList }" itemLabel="label" itemValue="value"/>
				</td>
			</tr>
			<form:button name = "register"> 등록</form:button>
		</form:form>
		
</body>
</html>