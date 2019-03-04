<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
	 <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
	 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
     <link rel="stylesheet" href="../fm/style.css" type="text/css">
     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
     <script type="text/javascript" src="../fm/script.js"></script>
	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

	<%@include file="../fm/menu.jsp"%>
	<%@include file="../fm/logo.jsp"%>
	<br><br><br><br>
	<font size="10px" color="#0B3861"><strong>쪽지함</strong></font>
	<hr>
<c:if test="${list.key==null}">
	<font size="5px">쪽지 중인 상대가 없습니다.</font>
</c:if>
<div  align="center" style="width:700px;margin-left:600px;margin-top:100px;" >

<table class ="table table-hover" style="margin-left:100;">
	<c:forEach items="${lists}" var="list">
			<tr align="right">
				<td onclick ="window.open('msgView.do?userid=${list.key}','','top=300px, left=300px, height=450px, width=450px')"> <b style="color:#6E6E6E;size:5px;">
				<c:if test ="${list.value eq '안읽음'}">
					<div id="newmsg">📍<font color="red">(새로운메세지가도착했습니다)</font></div>
				</c:if>
				${list.key}님과의 쪽지입니다.</b>
				</td>
			<tr>
</c:forEach>
</table>

		<input type="button" value="쪽지쓰기" class="btn btn-default"  onclick="location.href='msgWrite.jsp'" >
</div>
</body>
</html>