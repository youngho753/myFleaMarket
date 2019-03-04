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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>

<script>
<%String sendid=request.getParameter("sendid"); %>
</script>
<style> 
body{
	padding : 30px;
	 background: #fff; 
	font-family: "Nanum Gothic", sans-serif;
	}
	#blueone {
	  border-collapse: collapse;
	}  
	#blueone th {
	  padding: 10px;
	  color: #29220A;
	  border-bottom: 3px solid #29220A;
	  text-align: left;
	
	}
	#blueone td {
	  color: #29220A;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	
	}
	#blueone tr:hover td {
	  color: #DBA901;
	}
</style>
</head>

<body>
<form action="message.do">
<input type="hidden" id="userid" name="userid" value="${sessionScope.id}">
<table id="blueone">
<h3 align="left"><strong>쪽지 보내기</strong></h3>
	<tr>
		<th>보내는이:</th>
		<th>${sessionScope.id}</th>
	</tr>
	<tr>	
		<th>받을 사람 ID:</th>
		<th><input type="text" class ="form-control" id="id" name="id" value="<%=sendid %>"></th>
	</tr>
	<tr>
		<td>내용:</td>
		<td><textarea maxlength="200"  cols="55" rows="15" class ="form-control" id="content" name="content" onkeyup="textCount(this,'contentcount')"></textarea>	
		*200글자 이내
		(<span id="contentcount" style="color:green;">0</span>)</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="메세지 보내기" class="btn btn-default"></td>
	<tr>
</table>
</form>
</body>
</html>