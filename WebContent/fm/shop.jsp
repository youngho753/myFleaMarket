<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../fm/script.js"></script>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여기에 제목을 입력하십시오</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<%@include file="logo.jsp"%>
    <div class="cat">
    	<div class="squ1"></div>
		<div class="squ2"></div>
		<div class="squ3"></div>
		
		<figure class="snip1445 cate1">
		  <img src="../images/feshion.png" alt="fashion" />
		  <figcaption>
		    <div>
		      <h4>fashion & beauty</h4>
		    </div>
		  </figcaption>
		  <a href="CaList.do?category=fashion"></a>
		</figure>
		
		<figure class="snip1445 cate2">
		  <img src="../images/living.png" alt="living" />
		  <figcaption>
		    <div>
		      <h4>living</h4>
		    </div>
		  </figcaption>
		  <a href="CaList.do?category=living"></a>
		</figure>
		
		<figure class="snip1445 cate3">
		  <img src="../images/elec.png" alt="hobby" />
		  <figcaption>
		    <div>
		      <h4>hobby</h4>
		    </div>
		  </figcaption>
		  <a href="CaList.do?category=hobby"></a>
		</figure>
		
		<figure class="snip1445 cate4">
		  <img src="../images/food.png" alt="food" />
		  <figcaption>
		    <div>
		      <h4>food</h4>
		    </div>
		  </figcaption>
		  <a href="CaList.do?category=food"></a>
		</figure>
		
		<figure class="snip1445 cate5">
		  <img src="../images/pet.png" alt="pet" />
		  <figcaption>
		    <div>
		      <h4>pet</h4>
		    </div>
		  </figcaption>
		  <a href="CaList.do?category=pet"></a>
		</figure>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>