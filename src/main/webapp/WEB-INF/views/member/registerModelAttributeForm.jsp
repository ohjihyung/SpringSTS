<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegisterModelAttribute</title>
</head>
<body>
	<h3> 3. @ModelAttribute 어노테이션</h3>
	
	<p>
		 요청 View : registerModelAttributeForm.jsp<br/>
		 컨트롤러 : ModelAttributeMemberController
	</p>
	
	<p>  1) 기본 자료형은 매개변수로 선언하더라도 기본적으로 전달되지않는다</p>
	
	<form action ="/modelattribute/register01" method ="post">
		userId : <input type="text" name ="userId" value ="hong"/>
		password : <input type="text" name ="password" value ="1234"/>
		<input type="submit"  value ="register01"/>
	</form><br/>
	
	<p>2)기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정해 데이터 전달</p>
	<form action ="/modelattribute/register02" method ="post">
		userId : <input type="text" name ="userId" value ="hong"/>
		password : <input type="text" name ="password" value ="1234"/>
		<input type="submit"  value ="register02"/>
	</form><br/>
	
	
	<p>3)기본 자료형인 매개변수가 여러 개인 경우에 각각 매개변수에 @ModelAttribute 어노테이션을 지정해 데이터 전달</p>
	<form action ="/modelattribute/register03" method ="post">
		userId : <input type="text" name ="userId" value ="hong"/>
		password : <input type="text" name ="password" value ="1234"/>
		<input type="submit"  value ="register03"/>
	</form><br/>
	
	<p>4 )자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달</p>
	<form action ="/modelattribute/register04" method ="post">
		userId : <input type="text" name ="userId" value ="hong"/>
		password : <input type="text" name ="password" value ="1234"/>
		<input type="submit"  value ="register04"/>
	</form><br/>
	
	<p>5 )자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달</p>
	<form action ="/modelattribute/register04" method ="post">
		userId : <input type="text" name ="userId" value ="hong"/>
		password : <input type="text" name ="password" value ="1234"/>
		postCode : <input type="text" name ="address.postCode" value ="123456"/>
		location : <input type="text" name ="address.location" value ="대전시"/>

		<input type="submit"  value ="register05"/>
	</form><br/>
	
</body>
</html>