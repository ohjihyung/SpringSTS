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
	<p>모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달</p>
	
	<form:form modelAttribute="member" method="post" action="/formtag/checkbox/result">
		<table>
			<tr>
				<td>개발자여부</td>
				<td>
					<form:checkbox path="developer" value ="Y"/>
				</td>
			</tr>
			<tr>
				<td>외국인여부</td>
				<td>
					<form:checkbox path="foreigner" value ="true"/>
				</td>
			</tr>
			
		
			<tr>
				<td>취미(hobby)</td>
				<td>
					<form:checkbox path="hobby"  value = "Sports" label="Sports"/><br/>
					<form:checkbox path="hobby"  value = "Music" label="music"/><br/>
					<form:checkbox path="hobby"  value = "Movie" label="movie"/><br/>
				</td>
			</tr>
			
		
			<tr>
				<td>취미(hobbyArray)</td>
				<td>
					<form:checkbox path="hobbyArray"  value = "Sports" label="Sports"/> <br/>
					<form:checkbox path="hobbyArray"  value = "Music" label="music"/> <br/>
					<form:checkbox path="hobbyArray"  value = "Movie" label="movie"/> <br/>
				</td>
			</tr>
			
			<tr>
				<td>취미(hobbyList)</td>
				<td>
					<form:checkbox path="hobbyList"  value = "Sports" label="Sports"/>
					<form:checkbox path="hobbyList"  value = "Music" label="music"/>
					<form:checkbox path="hobbyList"  value = "Movie" label="movie"/>
				</td>
			</tr>
					
		</table>
		<form:button name ="register">등록</form:button>
	</form:form>
</body>
</html>