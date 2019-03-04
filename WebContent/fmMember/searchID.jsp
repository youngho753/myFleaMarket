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
      <link rel="stylesheet" href="tabs.css">	
      <link rel="stylesheet" href="../fm/style.css" type="text/css">
     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../fm/script.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="../fm/script.js"></script>
	<style>  
	body{
	padding : 30px;
	}
	
	body { background: #fff; }
	#blueone {
	  border-collapse: collapse;
	}  
	#blueone th {
	  padding: 10px;
	  color: #168;
	  border-bottom: 3px solid #0B2161;
	  text-align: left;
	}
	#blueone td {
	  color: #669;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	}
	#blueone tr:hover td {
	  color: #004;
	}
</style>
</head>

<script>
	$(document).ready(function(){
		$("#submit_bt").click(function(){
			if($("#name").val() ==""){
				alert("이름 입력하세요");
				return false;
			}
			if($("#email").val() ==""){
				alert("이메일 입력하세요");
				return false;
			}
			if($("#phone").val() ==""){
				alert("폰을 입력하세요");
				return false;
			}
			$.ajax({
				type:"post",
				url : "search.do?name="+$("#name").val()+"&email="+$("#email").val()+"&phone="+$("#phone").val(),
				success:function(data){
					if(data.trim() =="-1"){
						$("#result").val("");
						alert("가입한 정보가 없습니다.");
					}
					else{
						$("#result").val(data);
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
<table id="blueone">
	<tr>
		<th colspan="2">
			가입정보를 입력하세요
		</th>
	</tr>
	<tr>
		<td> 이름 : </td>
		<td> <input type="text" id="name" name="name"></td>
	</tr>
	<tr>
		<td> 이메일 : </td>
		<td> <input type="text" id="email" name="email"></td>
	</tr>
	<tr>
		<td> 전화번호 : </td>
		<td><input type="text" name="phone" id="phone"  maxlength="13"></td>
	</tr>
	<tr>
		<td> <label for="result">당신의 아이디 :</label> </td>
		<td><input type="button" id="submit_bt" value="확인" class="btn btn-default"> <input type="text" id="result" ></td>
	</tr>
	<tr>
		<td><input type="button" value="비밀번호찾기" onClick="location.href='searchPWD.jsp'"  class="btn btn-default" ></td>
		<td><input type="button" value="로그인화면" onClick="location.href='naverlogin.jsp'"  class="btn btn-default"></td>
	</tr>
</table>
<br>
<br>
<br>

</body>

<script>
    function autoHypenPhone(str) { // 폰번호 하이픈 하는 함수
    	str = str.replace(/[^0-9]/g, '');
    	var tmp = '';
    	if (str.length < 4) {
    		return str;
    	} else if (str.length < 7) {
    		tmp += str.substr(0, 3);
    		tmp += '-';
    		tmp += str.substr(3);
    		return tmp;
    	} else if (str.length < 11) {
    		tmp += str.substr(0, 3);
    		tmp += '-';
    		tmp += str.substr(3, 3);
    		tmp += '-';
    		tmp += str.substr(6);
    		return tmp;
    	} else {
    		tmp += str.substr(0, 3);
    		tmp += '-';
    		tmp += str.substr(3, 4);
    		tmp += '-';
    		tmp += str.substr(7);
    		return tmp;
    	}
    	return str;
    }
	    var cellPhone = document.getElementById('phone');
	    
	    cellPhone.onkeyup = function(event) {
	   	event = event || window.event;
    	var val = this.value.trim();
    	this.value = autoHypenPhone(val);
   }
</script>

</html>