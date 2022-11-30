<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyGallary</title>
</head>
<body>

<h1>갤러리</h1>
<c:forEach items="${photos}" var ="photo" >
	<img id="image" src="../resources/mybox/image/${photo }" name = "${photo }" onclick="javascript:showImage();"><br/>
	<a href="/download?image=${photo }">다운로드</a>
  	<h3>${photo }</h3><br/><hr/>
</c:forEach>
 
<script>
function showImage(){
	
	
	
}

</script>
</body>
</html>