<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 메인페이지 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여기에 제목을 입력하십시오</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../fm/script.js"></script>
</head>
<body>
<script>
	$(document).ready(function(){
		if($("#sign").val()!= "" )
			location.href="../fm/main.jsp";
	})
</script>

<div class="section">

<div class="login" align="right" >
<input type="hidden" id="sign" value="${sign }">
<input type="hidden" id="id" value="${id }">
	  <c:if test="${id==null}">
	   		<a href="../fmMember/naverlogin.jsp"><strong>로그인   | </strong></a><a href="../fmMember/joinForm.jsp"><strong>회원가입</strong></a>
	      	</c:if>
	   	<c:if test = "${id!=null }">
	   	  	${id}님 환영합니다 ♥<a href="logout.do"><strong>로그아웃</strong></a>
    	</c:if>

	</div> 
	<div id="logo">
		<img alt="로고그림" src="../images/logo4.png">
	</div>
	<div id="btnImage">
		<table> 
			<tr>
				<td>
					<figure class="snip1384">
					  <img src="../images/market.png" alt="market" width="564px" height="333.33px"/>
					  <figcaption>
					    <h3>플리마켓 바로가기</h3>
					    <p>직접 판매하고 구매하는 온라인 플리마켓</p><i class="ion-ios-arrow-right"></i>
					  </figcaption>
					  <a href="../fm/shop.jsp"></a>
					</figure>
				</td>
				<td>
					<figure class="snip1384"><img src="../images/store.png" alt="store" width="564px" height="333.33px" />
					  <figcaption>
					    <h3>스토어 바로가기</h3>
					    <p>사이트와 계약한 정규 스토어</p><i class="ion-ios-arrow-right"></i>

					  </figcaption>
					  <a href="../fm/store.jsp"></a>
					</figure>
				</td>
			</tr>
		</table>
		
	</div>
</div>
<div class="section">
	<div class="mainFirst">
		<img src="../images/mainimage3.png" width="100%" height="auto"/>
		<p>What is fleaMarket?</p>
	</div>
	<div class="mainSecond">
		<div class="squ1"></div>
		<div class="squ2"></div>
		<div class="pic1">
			<img src="../images/pic1.jpg" width="800px" height="auto"/>
		</div>
		<div class="pic3">
			<img src="../images/pic3.jpg" width="600px" height="auto"/>
		</div>
		<div class="text1">
			<h3>플리마켓(fleamarket)이란</h3>
			<p>플리마켓이란 안 쓰는 물건을</p>
			<p>직접 공원이나 광장에 가지고 나와서</p>
			<p>직접 교환이나 매매하는 시민운동의 하나입니다</p>
			<p>많은 청년들이 플리마켓을 통해 새로운 이익을 창출하고</p>
			<p>추억이 담긴 좋은 물건을 다른 사람에게 양도하는</p>
			<p>아름다운 순환을 기대하며</p>
			<p>이 사이트를 만들었습니다</p>
		</div>
		<div class="text2">
			<h3>mémoire FleaMarket</h3>
			<p>mémoire는 프랑스어로 추억을 뜻합니다</p>
			<p>간단히 사고 파는 흔한 물건이 아닌</p>
			<p>사람들의 인생을 잠시나마 거쳐간 </p>
			<p>물건보다는 추억을 거래한다는 뜻을 담아</p>
			<p>mémoire FleaMarket가 탄생했습니다</p>
			<p>당신의 소중한 mémoire에게 </p>
			<p>새로운 추억을 덧씌워드립니다</p>
		</div>
	</div>
</div>
	<%@include file="../fm/footer.jsp"%>
</body>
</html>