<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register All Form</title>
</head>
<body>
	<h2>Register ALL Form</h2>
	<form action = "/registerUser" method = "post">
			<table border = "1">
				<tr>
					<td>유저 ID</td>
					<td><input type = "text" name ="userId" value ="a001"></td>	
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type = "text" name ="password"></td>	
				</tr>
				<tr>
					<td>이름</td>
					<td><input type = "text" name ="userName"></td>	
				</tr>
				<tr>
					<td>E-MAIL</td>
					<td><input type = "text" name ="email"></td>	
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type = "text" name ="dateOfBirth"></td>	
				</tr>
				<tr>
					<td>성별</td>
					<td>
					
						<input type = "radio" name ="gender" value = "male" checked="checked"/>Male
						<input type = "radio" name = "gender" value = "female"/>female
						<input type = "radio" name = "gender" value = "other" />other
						
					</td>	
				</tr>
				<tr>
					<td>개발자 여부</td>
					<td><input type ="checkbox" name ="developer" value ="Y"/></td>	
				</tr>
				<tr>
					<td>외국인 여부</td>
					<td><input type ="checkbox" name ="foreigner" value ="true"/></td>	
				</tr>
				<tr>
					<td>국적</td>
					<td>
						<select name="nationality">
							<option value="korea">대한민국</option>
							<option value ="germany">독일</option>
							<option value ="austrailia">호주</option>
							<option value = "canada">케나다</option>
							<option value ="japan">일본</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>소유차향</td>
					<td>
						<select name ="cars" multiple="multiple">
							<option value = "jeep">Jeep</option>
							<option value = "volvo">Volvo</option>
							<option value = "bmw">BMW</option>
							<option value = "audi">AUDI</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
					<input type ="checkbox" name = "hobby" value="sports" > Sports <br/>
					<input type ="checkbox" name = "hobby" value="music" > music <br/>
					<input type ="checkbox" name = "hobby" value="movie" > movie <br/>
					<input type ="checkbox" name = "hobby" value="game" > game <br/>
					<input type ="checkbox" name = "hobby" value="development" > development <br/>
					</td>
				</tr>
				<tr>
					<td>우편번호 </td>		
					<td><input type ="text" name ="address.postCode" value ="12345"/></td>					
				</tr>
				<tr>
					<td>주소 </td>		
					<td><input type ="text" name ="address.location" value ="대전 서울"/></td>					
				</tr>
				<tr>
					<td>카드번호 </td>		
					<td><input type ="text" name ="card.cardNo" value =""/></td>					
				</tr>
				<tr>
					<td>유효년월 </td>		
					<td><input type ="text" name ="card.validMonth" value =""/></td>					
				</tr>
				<tr>
					<td>소개</td>		
					<td><textarea rows="10" cols="40" name ="introduction"></textarea></td>					
				</tr>
				
			</table>
			<table>
				<tr>
					<td><input type="submit" value ="등록"></td>
				</tr>
			
				<tr>
					<td><input type="reset" value ="취소"></td>
				</tr>
			
			</table>
	</form>
</body>
</html>