<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 취미 조회 된 페이지 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hobby</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../fm/script.js"></script>	
<script>
function getData(pageNum){
	$("#results").load("CaList.do",{"pageNum":pageNum,"field":$("#field option:selected").val(),"word":$("#word").val(),"category":"hobby"},function(data){
		$("#results").html(data);
	})
}
</script>
</head>
<body id="results">
	<%@include file="../fm/menu.jsp"%>
	<div class="mainImage">
		<p class="fb_text">hobby</p>
		<p class="fb_smallText">
			그 사람을 가장 잘 알 수 있는 법은 그 사람의 취미를 보는 것<br>
			가장 가까이 있던 추억마저 파는 플리마켓 hobby 카테고리
		</p>
		<div class="block"></div>
		<img alt="취미메인" src="../images/elec.png" class="faImage">
	</div>
	<div class="goodsList">
		<div class="goodsListBox">
			<c:forEach items="${lists }" var="list">
				<div class="goodsDiv" onclick="location.href='goodsView.do?num=${list.num}'">
					<div class="imageBox">
						<img alt="상품사진" src="../upload/${list.mainpic}">
					</div>
					<div class="pricingContent">
	                    <ul>
	                        <li><b>제목 :</b> ${list.title }</li>
	                        <li><b>PRICE :</b> ${list.price }</li>
	                        <li><b>판매자 :</b> ${list.userid }</li>
	                    </ul>
                    </div>
				</div>
			</c:forEach>
		</div>
	</div>
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
		<br><br><br>
	</div>
	<div class="searchBox">
		<div class="col-xs-2" id="sele">
		   <select id="field" class="form-control" name="field">
		      <option value="title"> 제목
		      <option value="userid"> 작성자
		   </select>
		</div>
		<div class="col-xs-6">
		   <input type='text' id='word' name='word' class="form-control" placeholder="검색어입력">
		</div>
		   <input type='button' class="btn btn-default" value="검색" onclick="javascript:getData(1)">
		   <c:if test="${sessionScope.id!=null }">
			 	<input type="button" class="btn btn-default" onclick="location.href='../fm/goodsInsert.jsp'" value="상품등록">
			</c:if>
	</div>
	<%@include file="../fm/footer.jsp"%>
</body>
</html>