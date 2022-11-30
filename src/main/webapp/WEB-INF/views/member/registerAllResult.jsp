<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	유저 ID : ${user.userId } <br/>
	패스워드: ${user.password } <br/>
	이름:  ${user.userName } <br/>
	EMAIL : ${user.email}	 <br/>
	생년월일 : ${user.dateOfBirth } <br/>
	성별 : ${user.gender}	 <br/>
	개발자여부: ${user.developer} <br/>
	외국인여부: ${user.foreigner } <br/>
	국적: ${user.nationality } <br/>
	소유차량: ${user.cars } <br/>
	취미: ${user.hobby } <br/>
	우편번호: ${user.address.postCode } <br/>
	주소: ${user.address.location } <br/>
	카드번호: ${user.card.cardNo } <br/>
	유효년월: ${user.card.validMonth } <br/>
	소개: ${user.introduction } <br/>
</body>
</html>