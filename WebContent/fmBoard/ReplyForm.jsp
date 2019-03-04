<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글 쓰기</title>
<% 
	request.setCharacterEncoding("utf-8");
	int num=0;
	int ref=1,re_seq=0,re_lev=0;
	if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref = Integer.parseInt(request.getParameter("board_re_ref"));
			re_seq=Integer.parseInt(request.getParameter("board_re_seq"));
			re_lev=Integer.parseInt(request.getParameter("board_re_lev"));
	}
%>
<style>  
body{
	padding : 30px;
	 background: #fff; 
}

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
<body>
<div class="container">
	<h2>게시판글등록</h2>
	<form action="reply" method="post" enctype="multipart/form-data" name="boardform">
	<input type ="hidden" name="num" value=<%=num %>>
	<input type ="hidden" name="ref" value=<%=ref %>>
	<input type ="hidden" name="re_seq" value=<%=re_seq %>>
	<input type ="hidden" name="re_lev" value=<%=re_lev %>>
		<table id="blueone">
			<tr>
				<th class="td_left"><label for="board_name">글쓴이</label></th>
				<th class="td_right"><input type="text" name="board_name" id="board_name"></th>
			</tr>
			<tr>
				<td class="td_left"><label for="board_pass">비밀번호</label></td>
				<td class="td_right"><input name="board_pass" type="password" id="board_pass"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_subject">제 목</label></td>
				<td class="td_right"><input name="board_subject" type="text" id="board_subject"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_content">내 용</label></td>
				<td><textarea id="board_content" name="board_content" cols="40" rows="15"></textarea></td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_file"> 파일 첨부 </label></td>
				<td class="td_right"><input name="board_file" type="file" id="board_file"></td>
			</tr>
			<tr>
				<td class="td_left"><input type="submit" value="등록"></td>
				<td class="td_right"> <input	type="reset" value="다시쓰기"></td>
			</tr>
		</table>
		
	</form>
</div>
</body>
</html>