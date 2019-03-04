<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:if test="${naver ==null}">
	<table border=1 class="table table-hover">
	<tr>
		<td>이름</td>
		<td>전화번호</td>
		<td>등급</td>
		<td>총 : 판매금액</td>
	</tr>
	<tr>
		<td>${member_info.name }</td>
		<td>${member_info.phone }</td>
		<td>${member_info.rank }</td>
		<td>${member_info.income }</td>
	</tr>
	</table>
	
</c:if>
<c:if test="${naver !=null }">
	<b>네이버 회원은 이름과 이메일만 제공됩니다</b><br><br>
	<table border=1 class="table table-hover">
	<tr>
		<td>이름</td>
		<td>email</td>
	</tr>
	<tr>
		<td>${naver_name}</td>
		<td>${naver_email}</td>

	</tr>
	</table>
	
</c:if>
<b>판매중인 상품</b>
	<table border=1 class="table table-hover">
	<tr>
		<td>판매상품</td>
		<td>판매가격</td>
	</tr>
	<c:forEach items="${sell_info }" var="list">
		<tr>
			<td>${list.title }</td>
			<td>${list.price }</td>
		</tr>
	</c:forEach>
	</table>
	<input type="button" class="btn btn-default" value="메세지보내기" id="msg_bt" onclick="location.href='../fmMSG/msgWrite.jsp?sendid=${member_info.userid}'">
	<input type="button" class="btn btn-default" value="닫기" onclick=self.close()>
</div>
</body>
</html>