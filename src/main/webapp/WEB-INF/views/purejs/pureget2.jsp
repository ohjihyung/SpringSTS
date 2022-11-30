<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<body>

<form id="frm" action = "/getname" method = "get">
	name  : <input type="text" id = "name"/>
	<input type="submit" value="send"> 
</form>

<script>

var frm = document.querySelector("#frm");

frm.addEventListener("submit", function(){
	event.preventDefault();
	console.log("폼 멈춤");
	var obj = {};
	obj.name = document.querySelector("#name").value;
	console.log(obj);
	
});


</script>
</body>
</html>