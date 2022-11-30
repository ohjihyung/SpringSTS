<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<body>

<form>
	name  : <input type="text" id = "name"/>
	<input type ="button" value ="get" id = "getBtn"/>
</form>
 <span id = "output"></span>
<script>


var getBtn = document.querySelector("#getBtn");
console.log(name);
 getBtn.addEventListener("click", ajaxget); 

 function ajaxget(){
	var name = document.querySelector("#name").value;
	alert(name);
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            if (xhr.status == 200) {
                console.log(xhr.response);
                document.querySelector("#output").innerHTML = xhr.responseText;
            } else {
                document.body.innerText = 'Error: ' + xhr.status;
            }
        }
    };

    xhr.open('GET', '/getname?name='+name, true);
    xhr.send();
} 
	

</script>
</body>
</html>