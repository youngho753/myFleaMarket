<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
 <link rel="stylesheet" href="../fm/style.css" type="text/css">
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" src="../fm/script.js"></script>
<style>

#blueone {
	border-collapse: collapse;
}

#blueone th {
	padding: 10px;
	color: #168;
	border-bottom: 3px solid #726B57;
	text-align: left;
}

#blueone td {
	color: #669;
	padding: 10px;
	border-bottom: 1px solid #726B57;
}

#blueone tr:hover td {
	color: #004;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

var emailPattern =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;

$(document).ready(function(){
    $("#password").keyup(function(){
        $("#pwd_check").val("");
        return false;
    });
    var pw_p= /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    $("#password").keyup(function(){
       $("#password_valid_div").remove();
       if(!$("#password").val().match(pw_p)){
          $("#password_valid_span").append("<div style='color:red' id='password_valid_div'>"+ "사용 불가능(특수문자,영어,숫자 각 1개 이상)</div>");
          
       }
       else{
          $("#password_valid_span").append("<div style='color:green' id='password_valid_div'>"+
                "사용가능 패스워드</div>");
          $("#password_valid").val("1");
       }
    });

    
    $("#pwd_check").keyup(function(){
       $("#password_check_div").remove();
       if($("#password").val()== $("#pwd_check").val()){
          $("#password_check_span").append("<div style='color:green' id= 'password_check_div' >일치!</div>");
       }
       else{   
          $("#password_check_span").append("<div style='color:red' id='password_check_div'>불일치!</div>");
       }
          
    });
    $("#insert_bt").click(function(){
    	if(!$("#password").val().match(pw_p)){
    		alert("비밀번호는 영어,특수문자를 포함해야합니다.")
    		return false;
    	}
        if ($("#pwd_check").val() != $("#pwd_check").val()) {
          	alert("비밀번호 맞지않음");
        	return false;
        }
        if($("#name").val()==""){
        	alert("이름입력"); 
        	return false;
        }
        if($("#userid").val()==""){
        	alert("아이디입력"); 
        	return false;
        }
        if(!$("#email").val().match(emailPattern)){
        	alert("이메일 형식이 아닙니다.");
        	return false;
        }
        if($("#email_valid").val()=="false"){
        	alert("이메일을 인증하세요");
        	return false;
        }
        if($("#userid").val()=="false"){
        	alert("아이디 중복확인 하세요");
        	return false;
        }
        if($("#phone").val()==""){
        	alert("전화번호 입력하세요");
        	return false;
        }
        $("#frm").submit();
     });
    $("#idcheck").click(function(){
    	window.open("IdCheck.jsp","confirm","width=500 height=150");
    	});
    $("#btnZip").click(function(){
		window.open("zipcheck.jsp","","width=500 height =500");
	})
	 $("#email_check_bt").click(function(){
		 if($("#email").val()==""){
			 alert("이메일을 입력하세요");
			 return false;
		 }
		window.open("emailcheck.do?email="+$('#email').val(),"","width=500 height=220");
	}) 
});
</script>
<body>
	<%@include file="../fm/menu.jsp"%>
	<%@include file="../fm/logo.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<h1>회원가입</h1>
	<br>
	<form name="frm" id="frm" action="join.do" method="post">
		<input type="hidden" name="userid" id="userid" value="false">
		<input type="hidden" name="password_valid">
		<input type="hidden" id="email_valid" value="false">
	
		
		<div align="center" class="container">
			<table id="blueone">
				<tr>
					<th></th>
					<th colspan=2 class="col-xs-8">
				</tr>
				<tr>
					<td>이름 *</td>
					<td class="col-xs-4"><input type="text" name="name" id="name" class="form-control"></td>
					<td></td>
				</tr>
				<tr>
					<td>ID *</td>
					<td class="col-xs-5"><input type="text" disabled id="id" name ="id" class="form-control"></td>
					<td><input type="button" id="idcheck" value="중복체크" class="btn btn-default"></td>
				</tr>
				<tr>
					<td>PASSWORD *</td>
					<td colspan=2 class="col-xs-3"><input type="password" id="password"	name="password" class="form-control" placeholder="(영문,특수기호포함)">
					<span id = 'password_valid_span'></span></td>
				</tr>
				<tr>
					<td>암호확인 *</td>
					<td><input type="password" id="pwd_check" class="form-control"></td>
					<td><span id = 'password_check_span'></span></td>
				</tr>

				<tr>
					<td>E-MAIL *</td>
					<td class="col-xs-4"><input type="email" name="email" id="email" class="form-control"></td>
					<td> <input type="button" value="e-mail 인증" id="email_check_bt" class="btn btn-default" >
						
					</td>
				</tr>
				<tr>
					<td>PHONE *</td>
					<td class="col-xs-4">
					<input type="text" name="phone" id="phone" class="form-control" maxlength="13">
					</td>
					<td ></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td class="col-xs-3"><input type="text" name="zipcode" id="zipcode" class="form-control"></td>
					<td><input type="button" name="btnZip" id="btnZip" value='검색' class="btn btn-default"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td colspan=2 class="col-xs-5"><input type="text" name="addr" id="addr" class="form-control"></td>
				</tr>
				<tr>
					<td></td>
					<td colspan=2><input type="button" id="insert_bt" value="확인" class="btn btn-default"> &nbsp;&nbsp; 
					<input type="button" value="취소" class="btn btn-default"></td>
				</tr>
			</table>
		</div>
	</form>
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