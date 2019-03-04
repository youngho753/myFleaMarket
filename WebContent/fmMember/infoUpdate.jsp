<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
 <script>
 $(document).ready(function(){
	 $("#update_bt").click(function(){
	    	if($("#phone").val()==""){
	    		alert("전화번호입력하시오")
	    		return false;
	    	}
	    	$("#update_frm").submit();
	 })
	 $("#btnZip").click(function(){
		window.open("zipcheck.jsp","","width=500 height =500");
	})
	
 })
 </script>
 ${sessionScope.id } 님 개인정보수정화면
 <form id="update_frm" action="infoupdate.do">
 <input type="hidden" name="id" value="${sessionScope.id }">
	<table id="blueone">
		<tr>
			<th></th>
			<th colspan=2 class="col-xs-8">
		</tr>
		<tr>
			<td>PHONE *</td>
			<td class="col-xs-4">
			<input type="text" name="phone" id="phone" class="form-control" maxlength="13"></td>
			<td></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td class="col-xs-3">
			<input type="text" name="zipcode" id="zipcode" class="form-control"></td>
			<td><input type="button" name="btnZip" id="btnZip" value='검색'
				class="btn btn-default"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td colspan=2 class="col-xs-5">
			<input type="text" name="addr" id="addr" class="form-control" size=30></td>
		</tr>
		<tr>
			<td></td>
			<td colspan=2>
			<input type="button" id="update_bt" value="확인" class="btn btn-default"> &nbsp;&nbsp;
			 <input type="button" value="취소" class="btn btn-default"></td>
		</tr>
	</table>
</form>
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
</body>
</html>