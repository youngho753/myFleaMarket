<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	
<script>
function getData(pageNum){
	$("#results").load("boardList.bo",{"pageNum":pageNum},function(data){
		$("#results").html(data);
	})
}
</script>
<style>
.container{
	text-align: left;
}
.container #table11{
	margin-bottom: 130px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여기에 제목을 입력하십시오</title>
</head>
	<body>
		<%@include file="../fm/menu.jsp"%>
		<%@include file="../fm/logo.jsp"%>
			<br><br><br>
		<div class="container" id="results">
		
			<font size="5px" color="#610B21" ><strong>공지사항 </strong></font>
			<table class="table table-hover" id="table11">

				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${noticelists}" var="list" varStatus="i">
						<tr>	
							<td>${number-i.index }</td>
							<td>			
							<a href="#" onclick="location.href='view.do?BOARD_NUM=${list.BOARD_NUM}'"><font color="red">공지사항 : </font>${list.BOARD_SUBJECT }</a>
							<td>${list.BOARD_DATE }</td>
							<td>${list.BOARD_READCOUNT }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				
				
			<font size="5px" color="#610B21" ><strong>커뮤니티</strong></font>
			<table class="table table-hover" >
				<thead>
					<tr>
						<th>NO</th>
						<th>이름</th>
						<th>제목</th>
						<th>작성날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lists}" var="list" varStatus="i">
						<tr>	
							<td>${number-i.index }</td>
							<td>${list.BOARD_NAME }</td>
							<td>
							<c:if test ="${list.BOARD_RE_LEV gt 0}">
							<img src="../image/level.gif" width="${list.BOARD_RE_LEV*10}" height="16">
			 				<img src="../image/re.gif">
							</c:if>
							<c:if test ="${list.BOARD_RE_LEV  eq 0}">
							<img src="../image/level.gif" width="5" height="16">
							</c:if>
							<c:if test="${list.BOARD_OPEN eq '공개'}">
							<a href="#" onclick="location.href='view.do?BOARD_NUM=${list.BOARD_NUM}'">${list.BOARD_SUBJECT }</a>
							</c:if>
							<c:if test="${list.BOARD_OPEN eq '비공개'}">
								<c:if test="${sessionScope.id=='master'}">
									<a href="#" onclick="location.href='view.do?BOARD_NUM=${list.BOARD_NUM}'">비공개글입니다.</a>
								</c:if>
								<c:if test="${sessionScope.id!= 'master'}">
									비공개글입니다.
								</c:if>
							</c:if>
							</td>
							<td>${list.BOARD_DATE }</td>
							<td>${list.BOARD_READCOUNT }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div align="center">
			<!-- 이전 -->
			<c:if test="${startpage>blockpage }">
				<a href="javascript:getData(${startpage-blockpage })">[이전]</a>
			</c:if>
			<!-- 페이지출력 -->
			<c:forEach begin="${startpage }" end="${endpage }" var="i">
				<c:if test="${currentPage eq i}" >
					${i }
				</c:if>
				<c:if test="${currentPage ne i}" >
					<a href="javascript:getData(${i })">${i }</a>
				</c:if>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${endpage<totpage }">
				<a href="javascript:getData(${endpage+1 })">[다음]</a>
			</c:if>
			</div>
			<c:if test="${sessionScope.id!=null }">
				 <input type="button" value="글등록" class="btn btn-default" onclick="location.href='writeForm.jsp'">
			 </c:if>
			 <c:if test="${sessionScope.id==null }">
			 <br>
				로그인 후 글을 등록하실 수 있습니다.	 
			 </c:if>
		</div>	
	</body>
</html>