<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.container{
	width: 80%;
	margin: 0 auto;
	padding-top: 25px;
}
</style>
<body>

<script>
	$(document).ready(function(){
		$("#check_bt").click(function(){
			if($("#num_check").val()==""){
				alert("입력하세요");
				return false;
			}
			if($("#num_check").val() == $("#num").val()){
				alert("인증이 완료되었습니다.");
				$(opener.document).find("#email").attr("readonly",true);
				$(opener.document).find("#email_check_bt").attr("disabled",true);
				$(opener.document).find("#email_valid").val("1");
	           	self.close();	
			}
		})
	})	
</script>

<div class="container">
<h5><b>Email 인증</b></h5>
<input type="hidden" id="num" value ="${num }">
  ${email } 로 인증번호를 전송했습니다.<br>
인증번호를 입력하세요<br><br>
<input type="text" class="text" id="num_check">
<input type="button" class="btn btn-success" id="check_bt" value="확인">
</div>


</body>
</html>