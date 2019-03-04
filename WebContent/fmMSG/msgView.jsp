<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
     <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
	 <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
	 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
     <link rel="stylesheet" href="../fm/style.css" type="text/css">
     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="../fm/script.js"></script>
	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

function textCount(obj,target){
	var len =obj.value.length;//입력한글자수
	if(100<len){//글쓴이:20 내용:70
		alert("글자수 초과!");
		return;
	}
	$("#"+target).text(len);//target영역에 글자 수 출력
}

$(document).ready(function(){
	$("#msg").click(function(){
			$('#frm').submit();
			
	});
});
</script>
<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400);

.container {
    width: 400px;
    padding: 10px;
}

.message-blue {
    position: relative;
    margin-left: 20px;
    margin-bottom: 10px;
    padding: 10px;
    background-color: #084B8A;
    color:#fff;
    width: 200px;
    height: 100px;
    text-align: left;
    font: 400 .9em 'Open Sans', sans-serif;
    border: 1px solid #97C6E3;
    border-radius: 10px;
}

.message-orange {
    position: relative;
    margin-bottom: 10px;
    margin-left: calc(100% - 240px);
    padding: 10px;
    background-color: #FFBF00;
    width: 200px;
    height: 100px;
    text-align: left;
    font: 400 .9em 'Open Sans', sans-serif;
    border: 1px solid #dfd087;
    border-radius: 10px;
}

.message-content {
    padding: 0;
    margin: 0;
}

.message-timestamp-right {
    position: absolute;
    font-size: .85em;
    font-weight: 300;
    bottom: 5px;
    right: 5px;
}

.message-timestamp-left {
    position: absolute;
    font-size: .85em;
    font-weight: 300;
    bottom: 5px;
    left: 5px;
}

.message-blue:after {
    content: '';
    position: absolute;
    width: 0;
    height: 0;
    border-top: 15px solid #084B8A;
    border-left: 15px solid transparent;
    border-right: 15px solid transparent;
    top: 0;
    left: -15px;
}

.message-blue:before {
    content: '';
    position: absolute;
    width: 0;
    height: 0;
    border-top: 17px solid #97C6E3;
    border-left: 16px solid transparent;
    border-right: 16px solid transparent;
    top: -1px;
    left: -17px;
}
#write{
	background-color:#fff;
	 width:100%;
	 height:100px;
	 position: fixed;
	 bottom: 0;
}
.message-orange:after {
    content: '';
    position: absolute;
    width: 0;
    height: 0;
    border-bottom: 15px solid #FFBF00;
    border-left: 15px solid transparent;
    border-right: 15px solid transparent;
    bottom: 0;
    right: -15px;
}

.message-orange:before {
    content: '';
    position: absolute;
    width: 0;
    height: 0;
    border-bottom: 17px solid #dfd087;
    border-left: 16px solid transparent;
    border-right: 16px solid transparent;
    bottom: -1px;
    right: -17px;
}
</style>
</head>

<body>
<font size="5px"><strong>쪽지기록보기</strong></font>
<div class="container">
<c:forEach items="${lists }" var="list">
	<c:if test = "${list.userid eq sessionScope.id}">
	 <div class="message-orange">
        <p class="message-content">${list.content }</p>
           <div class="message-timestamp-right">${list.userid}</div>
    </div>
    </c:if>
    <c:if test ="${list.userid != sessionScope.id}">
    <div class="message-blue">
	  <div class="message-timestamp-left">${list.userid}</div>
	  <br>
        <p class="message-content">${list.content }</p>
    </div>
    </c:if>
   
</c:forEach>
<br>
    <br>
    <br>
</div>
<hr>
<div id="write">
	<form  action="message.do" name="frm" id="frm">
		<input type="hidden" value="${sessionScope.id }" name="id"> 
		<input type="hidden" value="${userid}" name="userid">
		<input type="text" class="form-control" id="content" name="content" onkeyup="textCount(this,'contentcount')">
		*100글자 이내
			(<span id="contentcount" style="color:green;">0</span>)
		<input type="button" value="쪽지보내기" id="msg" class='btn btn-default'>
</form>
</div>
</body>
</html>