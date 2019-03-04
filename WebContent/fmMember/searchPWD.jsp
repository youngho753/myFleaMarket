<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../fm/script.js"></script>
<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="animate.css">
<!-- Custom Stylesheet -->
<link rel="stylesheet" href="login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<script>
$(document).ready(function(){
	$("#submit_bt").click(function(){
		if($("#id").val() ==""){
			alert("id 입력하세요");
			return false;
		}
		if($("#email").val() ==""){
			alert("이메일 입력하세요");
			return false;
		}
		$.ajax({
			type:"post",
			url : "pwd_search.do?id="+$("#id").val()+"&email="+$("#email").val(),
			success:function(data){
				if(data.trim() =="-1"){
					alert("가입한 정보가 없습니다.");
				}
				else{
					alert("해당 메일로 임시비밀번호를 전송했습니다.");
					self.close();
				}
			},
			error :function(e){
				alert(e);
			},
			
		});
	});
});

</script>
<body>
<font size="5px" color="#0B3861"><strong>비번찾기</strong></font>
<br>
<strong >가입했던 id/email 입력하세요</strong>
<br>
<hr>
<div style="width:100%; ">
	<div class="col-xs-12" align="center" >
	<label for="id" >id : </label> <input type="text" id="id" name="id" class="form-control" >
	<label for="id" >email :</label>  <input type="email" id="email" name="email"  class="form-control" >
	<br>
	<input type="button" id="submit_bt" value="확인" class="btn btn-default">
	</div>
</div>
</body>
</html>