<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<link rel="stylesheet" href="style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="script.js"></script>
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
		<div class="storeDiv">
			<figure class="snip1445 store1 store">
			  <img src="../images/store1.jpg" alt="store1" />
			  <figcaption>
			    <div>
			      <h4>formal dress</h4>
			    </div>
			  </figcaption>
			  <a href="StList.do?category=store1"></a>
			</figure>
			<figure class="snip1445 store2 store">
			  <img src="../images/store2.jpg" alt="store2" />
			  <figcaption>
			    <div>
			      <h4>Aesop</h4>
			    </div>
			  </figcaption>
			  <a href="StList.do?category=store2"></a>
			</figure>
			<figure class="snip1445 store3 store">
			  <img src="../images/store3.jpg" alt="store3" />
			  <figcaption>
			    <div>
			      <h4>The little green shop</h4>
			    </div>
			  </figcaption>
			  <a href="StList.do?category=store3"></a>
			</figure>
			<figure class="snip1445 store4 store">
			  <img src="../images/store4.jpg" alt="store4" />
			  <figcaption>
			    <div>
			      <h4>P.P flower</h4>
			    </div>
			  </figcaption>
			  <a href="StList.do?category=store4"></a>
			</figure>
		</div>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>