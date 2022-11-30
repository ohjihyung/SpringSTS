<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" enctype ="multipart/form-data">
		username : <input type="text" name = "username" id = "username" value="홍길동"/> <br/>
		password : <input type="text" name = "password" id = "password" value="12345"/><br/>
		password1 : <input type="text" name = "password1" id = "password1" value="12345"/><br/>
		password2 : <input type="text" name = "password2" id = "password2" value="12345"/><br/>
		password3 : <input type="text" name = "password3" id = "password3" value="12345"/><br/>
		
		<input type ="file" id ="file" name = "file" >
		<input type ="button" id ="postBtn" value ="post">
	</form>

<script>

	const myFrm = document.querySelector("#frm");

	var btn = document.querySelector("#postBtn");

	btn.addEventListener("click", function() {
		const formData = new FormData(myFrm);
		
		console.log("formdata : ",formData); // 볼수 없음 
		
		const json = {}; //object 
		formData.forEach((value, key) => json[key] = value);
		console.log("json : ",json);
		const sjson = JSON.stringify(json);
		console.log("sjson : ",sjson);
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState === XMLHttpRequest.DONE){
				if(xhr.status === 200){
					console.log(xhr.response);
				}else{
					console.log(xhr.status);
				}
			}
		}
		
		xhr.open('POST', '/postname', true);
		xhr.setRequestHeader('content-type',"application/json");
		xhr.send(sjson);
		//xhr.send(json);
		
	});

	
</script>
</body>
</html>