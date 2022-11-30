<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myBox</title>
</head>
<c:forEach items="${fileList}" var ="list" >
  ${list } <br/>
</c:forEach>
<body>
</body>
</html>




