<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
장바구니 내역 
<c:if test="${lists !='no'}">
	<table>
	<tr>
		<td>상품번호</td>
		<td>판매자아이디</td>
		<td>상품이름</td>
		<td>상품가격</td>
		<td></td>

	</tr>
	<c:forEach items="${lists }" var="list" >
	<tr>
		<td>${list.num }</td>
		<td>${list.userid }</td>
		<td>${list.title }</td>
		<td>${list.price }</td>
		<td><input type="button" value="삭제하기" onClick="location.href='goodsCartdel.do?id=${sessionScope.id}&goods=${list.num }'"></td>
	</tr>
	</c:forEach>
	</table>
</c:if>


<c:if test="${lists =='no'}">
 장바구니 담은게 없네?? 언넝담아
</c:if>

</body>
</html>