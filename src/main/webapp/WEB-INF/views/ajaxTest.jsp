<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
    <input type="button" value="아작스 요청" id="aBtn"/>
    <input type="button" value="아작스 요청2" id="aBtn2"/>
    <input type="button" value="아작스 요청3" id="aBtn3"/>
    <input type="button" value="짜증나" id="aBtn4"/>
    <input type="button" value="VO 사용" id="aBtn5"/>
    <script>
        var vaBtn = document.querySelector("#aBtn");
        var vaBtn2 = document.querySelector("#aBtn2");
        var vaBtn3 = document.querySelector("#aBtn3");
        var vaBtn4 = document.querySelector("#aBtn4");
        var vaBtn5 = document.querySelector("#aBtn5");

        vaBtn5.onclick = function() {
            var merong = {
                name : "민지짱",
                idols : ["레드벨벳","있지","없지"],
                age : 30,
                homeTown : "논산"
            }
            $.ajax({
                type: "post",
                url: "/ajax/getTest5",
                data : JSON.stringify(merong),  // 편지 봉투
                contentType: "application/json;charset=utf-8",  // 편지 내용 json 형식의 긴문자열을 보내겠다
                dataType: "text",
                success: function(rslt){
                    console.log("회신 결과",rslt);  
                }  
            })
        }
        vaBtn4.onclick = function() {
            var merong = {
                name : "민지짱",
                idols : ["레드벨벳","있지","없지"]
            }
            $.ajax({
                type: "post",
                url: "/ajax/getTest4",
                data : JSON.stringify(merong),  // 편지 봉투
                contentType: "application/json;charset=utf-8",  // 편지 내용 json 형식의 긴문자열을 보내겠다
                dataType: "text",
                success: function(rslt){
                    console.log("회신 결과",rslt);  
                }  
            })
        }
        vaBtn3.onclick = function() {
            var dataArr = [
                {name:"김보미", age : "10"},
                {name:"남지현", age : "20"},
                {name:"허소영", age : "30"},
                {name:"김혜진", age : "40"}
            ];
            $.ajax({
                type: "post",
                url: "/ajax/getTest3",
                data : JSON.stringify(dataArr),  // 편지 봉투
                contentType: "application/json;charset=utf-8",  // 편지 내용 json 형식의 긴문자열을 보내겠다
                dataType: "text",
                success: function(rslt){
                    console.log("회신 결과",rslt);  
                }  
            })
        }
        vaBtn2.onclick = function() {
            // 배열 <-> 리스트 ,  JSON <-> MAP
            var dataArr = ["김보미","남지현","허소영"];
            $.ajax({
                type: "post",
                url: "/ajax/getTest2",
                data : JSON.stringify(dataArr),  // 편지 봉투
                contentType: "application/json;charset=utf-8",  // 편지 내용 json 형식의 긴문자열을 보내겠다
                dataType: "text",
                success: function(rslt){
                    console.log("회신 결과",rslt);  
                }  
            })
        }
        vaBtn.onclick = function() {
            // 배열 <-> 리스트 ,  JSON <-> MAP
            var ojh={
            name:"왜지형",
            age:"왠지어릴듯"
        }
        $.ajax({
            type: "post",
            url: "/ajax/getTest",
            data : JSON.stringify(ojh),  // 편지 봉투
            contentType: "application/json;charset=utf-8",  // 편지 내용 json 형식의 긴문자열을 보내겠다
            dataType: "text",
            success: function(rslt){
                console.log("회신 결과",rslt);  
            }  
        })
    }
</script>
</body>
</html>