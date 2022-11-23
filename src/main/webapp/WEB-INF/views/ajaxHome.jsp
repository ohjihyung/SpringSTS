<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjaxHome</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	// 5. Headers 매핑
	// 요청 해더값을 지정하지 않고 전송
	
	$("#putBtn").on("click",function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result : " + result );
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	}); // onclick
	
	$("#putHeaderBtn").on("click", function(){
		
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			
			// X-HTTP-Method-Override 요청 해더값을 PUT으로 지정 합니다.
			headers : {
				"X-HTTP-Method-Override" : "PUT"
			},
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				console.log("result : " + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		})
	}); //onclick
	
	//Content-Type
	// HTTP Message(요청,응답) 에 담긴 데이터 형식을 정의하는 헤더
	$("#postBtn").on("click",function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "post",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result :" + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});
	
	$("#putContentTypeJsonBtn").on("click",function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var boardObject = {
				
				boardNo : boardNoVal,
				title : titleVal,
				content : contentVal,
				writer : writerVal
		}
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			data : JSON.stringify(boardObject),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				console.log("result :" + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	});

	$("#putContentTypeXmlBtn").on("click",function(){
		var boardNoVal = $("#boardNo").val();
		var titleVal = $("#title").val();
		var contentVal = $("#content").val();
		var writerVal = $("#writer").val();
		
		var xmlData = "";
		xmlData += "<BoardNo>";
		xmlData += "<boardNo>" + boardNoVal + "</boardNo>";
		xmlData += "<title>" + titleVal + "</title>";
		xmlData += "<content>" + contentVal + "</content>";
		xmlData += "<writer>" + writerVal + "</writer>";
		xmlData += "<regDate> 2022-10-12 </regDate>";
		xmlData += "</BoardNo>";
		
		$.ajax({
			type : "put",
			url : "/board/" + boardNoVal,
			data : xmlData,
			contentType : "application/xml; charset=utf-8",
			success : function(result){
				console.log("result :" + result);
				if(result === "SUCCESS"){
					alert("SUCCESS");
				}
			}
		});
	}); // onclick
	
	
	// 7. Accept 매핑 
	$("#getBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		// GET 방식 비동기 HTTP 요행 수청
		$.get("/board/" + boardNoVal, function(data){
			console.log(data);
			alert(JSON.stringify(data));
		});
	});
	
	$("#getJsonBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/json"
			},
			success : function(result) {
				console.log("result :" + result);
				alert(JSON.stringify(result));
			}
		});
	});
	
	$("#getXmlBtn").on("click", function(){
		var boardNoVal = $("#boardNo").val();
		
		console.log(boardNoVal);
		
		$.ajax({
			type : "get",
			url : "/board/" + boardNoVal,
			headers : {
				"Accept" : "application/xml"
			},
			success : function(result) {
				console.log("result :" + result);
				alert(xmlToString(result));
			}
		});
	}); // onclick
});

function xmlToString(xmlData){
	
	var xmlString;
	
	// window.ActiveXObject 는 ActiveXObject을 지원하는 브라우저
	// Object를 리턴하고 그렇지 않다면 null 리턴
	if(window.ActiveXObject){
		xmlString = xmlData.xml;
		
	}else{
		// 파싱된 xml 데이터를 String으로 변환
		xmlString = (new XMLSerializer()).serializeToString(xmlData);
	}
	return xmlString;
}

</script>
</head>
<body>
	<h3>HOME & AJAX HOME</h3>
	
	<form>
		<p>boardNo : <input type="text" name ="boardNo" id ="boardNo"/></p>
		<p>title : <input type="text" name ="title" id ="title"/></p>
		<p>
			content : <textarea rows="10" cols="30" id ="content" name="content"></textarea>
		</p>
		<p>writer :<input type="text" name ="writer" id ="writer"/> </p>
		
		<input type="button" id ="submitbtn" value="전송"/>
	</form>
	<div>
		<h4>Headers Mapping Button Group</h4>
		<button id ="putBtn">MODIFY(PUT)</button>
		<button id ="putHeaderBtn">MODIFY(PUT WITH HEADER)</button>
		
		<h4>Content-Type Button Group</h4>
		<button id = "postBtn">Modify(POST)</button>
		<button id = "putContentTypeJsonBtn">Modify(put with ContentType Json)</button>
		<button id = "putContentTypeXmlBtn">Modify(put with ContentType Xml)</button>
		<br/>
		<h3>Accept Button Group</h3>
		<button id = "getBtn">READ</button>
		<button id = "getJsonBtn">READ(JSON)</button>
		<button id = "getXmlBtn">READ(XML)</button>
	</div>
</body>
</html>