<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<% 
	request.setCharacterEncoding("utf-8");
	int num=0;
	int ref=1,re_seq=0,re_lev=0;

	if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_seq=Integer.parseInt(request.getParameter("re_seq"));
			re_lev=Integer.parseInt(request.getParameter("re_lev"));
	}
%>
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
    <%@include file="../fm/menu.jsp"%>
	<%@include file="../fm/logo.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<div class="container"  align="center">

	<font size="6. 26em">게시판</font>
	<br>
	<br>
	<form action="insert.do" method="post"name="boardform">
	<input type ="hidden" name="num" value=<%=num %>>
	<input type ="hidden" name="ref" value=0>
	<input type ="hidden" name="re_seq" value=0>
	<input type ="hidden" name="re_lev" value=0>
	<input type="hidden" name="board_pass" type="password" id="board_pass" class="form-control" value="${sessionScope.id }">
		<table id="blueone">
			<tr>
				<th  class="td_left"><label for="board_name">※공지사항※</label></th>
				<th class="td_right"><input type="hidden" name="board_name" id="board_name" class="form-control" value="※공지사항※"></th>
			</tr>
			<tr>
				<td class="td_left"><label for="board_subject">제 목</label></td>
				<td class="td_right"><input type="text" name="board_subject"  id="board_subject" class="form-control"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_content">내 용</label></td>
				<td><textarea id="board_content" name="board_content" cols="55" rows="15" class="form-control"></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><input type="radio" name="board_open" value="공개" checked>공개</td>
				<td class="td_right"> <input type="submit" value="등록" class="btn btn-default"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="다시쓰기" class="btn btn-default"></td>
			</tr>
		</table>
		<br>
		<br>
		<br>
	</form>
</div>
</body>
</html>