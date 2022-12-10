<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM3 REGISTER</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
      $("#btnList").on("click", function(){
         location.href = "/item3/list";
      });
      
      var itemId = ${item.itemId};
      console.log(itemId);
      $.getJSON("/item3/getAttach/" + itemId, function(list){
    	  $(list).each(function(){
    		 console.log("data : " + this);
    		 var data = this;
    		 var str = "";	 
    		 if(checkImageType(data)){ // 이미지면 이미지 태그를 이용하여 출력
                 str += "<div>";
                 str += "   <a href='/item3/displayFile?fileName=" + data + "'>";
                 str += "      <img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>";
                 str += "   </a>";
                 str += "   <span>X</span>"; // span을 눌렀을 때 작동하는 메소드는 바로 아래에 만들었다.
                 str += "</div>";
              }else{
                 str += "<div>";
                 str += "   <a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a>";
                 str += "   <span>X</span>";
                 str += "</div>";               
              }
              
              $(".uploadedList").append(str);
    	  });
      });
      
      $("#item").submit(function(event){
         event.preventDefault();
         var that = $(this); // 폼태그 자신
         var str = "";
         $(".uploadedList a").each(function(index){
            var value = $(this).attr("href");
            value = value.substr(27); // '?fileName=' 다음에 나오는 경로들
            
            str += "<input type='hidden' name='files["+index+"]' value='" + value + "'/>"; // div에 넣은 개수만큼 생성
         });
         
         console.log("str : " + str);
         that.append(str);
         that.get(0).submit();
      });
      
      
      $("#inputFile").on("change", function(event){
         console.log("change...!");
         var files = event.target.files;
         var file = files[0];
         
         console.log(file);
         var formData = new FormData();
         formData.append("file", file);
         
         // formData는 key/value의 형태로 데이터가 저장된다.
         // dataType은 응답 데이터를 내보낼 때 보내줄 데이터 타입을 말한다.
         // processData는 데이터 파라미터를 data라는 속성으로 넣는데, 제이쿼리 내부적으로 쿼리스트링을 구성한다.
         //              파일 전송의 경우, 쿼리스트링을 사용하지 않으므로 해당 설정의 기본값은 false이다.
         // contentType : Content-Type을 설정시, 해당 설정의 기본값은
         //              "application/x-www-form-urlencoded; charset=utf-8",
         //               그래서 기본값으로 나가지 않고 "multipart/form-data"로 나갈 수 있도록 설정을 false한다.
         // request 요청에서 Content-type을 확인해보면 "multipart/form-data; boundary=---Web"과 같은 값으로 전송되는 것을 확인할 수 있다.
         $.ajax({
            url : "/item3/uploadAjax",
            data : formData,
            processData : false,
            contentType : false,
            type : "POST",
            success : function(data){
               console.log(data);
               
               var str = "";
               if(checkImageType(data)){ // 이미지면 이미지 태그를 이용하여 출력
                  str += "<div>";
                  str += "   <a href='/item3/displayFile?fileName=" + data + "'>";
                  str += "      <img src='/item3/displayFile?fileName=" + getThumbnailName(data) + "'/>";
                  str += "   </a>";
                  str += "   <span>X</span>"; // span을 눌렀을 때 작동하는 메소드는 바로 아래에 만들었다.
                  str += "</div>";
               }else{
                  str += "<div>";
                  str += "   <a href='/item3/displayFile?fileName=" + data + "'>" + getOriginalName(data) + "</a>";
                  str += "   <span>X</span>";
                  str += "</div>";               
               }
               
               $(".uploadedList").append(str);
            }
         })
         
      });
      
      $(".uploadedList").on("click", "span", function(){
         $(this).parent("div").remove(); // this는 span, span을 감고 있는 div가 부모이므로 그것을 없앰
      });
      
      function getOriginalName(fileName){
         if(checkImageType(fileName)){
            return;
         }
         var idx = fileName.indexOf('_') + 1;
         return fileName.substr(idx);
      }
      
      function getThumbnailName(fileName){
         var front = fileName.substr(0, 12);
         var end = fileName.substr(12);
         
         console.log("front :" + front);
         console.log("end :" + end);
         
         return front + "s_" + end;
      }
      
      function checkImageType(fileName){
         var pattern = /jpg|gif|png|jpeg/i; // i는 대소문자를 구분하지 않음.
         return fileName.match(pattern); // 패턴과 일치하면 true(이미지구나 확인해주는 곳)
      }
   });
</script>
<body>
   <h2>Modify</h2>
   <form:form modelAttribute="item" action = "/item3/remove"  method = "post" enctype = "multipart/form-data">
     <input type="hidden" name="itemId" value="${item.itemId }">
      <table>
         <tr>
            <td>상품명</td>
            <td>
               <input type = "text" name = "itemName" id = "itemName" value="${item.itemName }" disabled="disabled">
            </td>
         </tr>
         <tr>
            <td>가격</td>
            <td>
               <input type = "text" name = "price" id = "price" value="${item.price }" disabled="disabled">
            </td>
         </tr>
         <tr>
            <td>파일</td>
            <td>
               <input type = "file"  id = "inputFile">
               <div class = "uploadedList"></div>
            </td>
         </tr>
         <tr>
            <td>개요</td>
            <td>
               <textarea rows = "10" cols = "30" name = "description" disabled="disabled">${item.description }</textarea>
            </td>
         </tr>
      </table>
      <div>
         <button type = "submit" id = "btnRegister">remove</button>
      </div>
   </form:form>
</body>
</html>