<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
	 <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
      <link rel="stylesheet" href="tabs.css">	
      <link rel="stylesheet" href="style.css" type="text/css">
     <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
<style>
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
	
	
.pricingTable{
	margin-left:30px;
	margin-top:50px;
    text-align: center;
    border: 1px solid #dbdbdb;
    position: relative;
    overflow: hidden;
}
.pricingTable .pricingTable-header h3{
    color: #9999a5;
    font-size: 18px;
    text-transform: uppercase;
}
.pricingTable .price-value {
    background: #fafafa;
    color: #666;
    font-weight: 900;
    padding: 15px 0;
}
.pricingTable .price-value span {
    color: #666;
    display: inline-block;
    font-size: 70px;
    font-weight: normal;
    line-height: normal;
}
.pricingTable .price-value small{
    font-size: 20px;
    position: relative;
    top: -30px;
    left:0;
}
.pricingTable .price-value .subtitle{
    color: #82919F;
    display: block;
    font-size: 16px;
    font-weight: 100;
    font-style: italic;
}
.pricingTable .best-offer{
    background-color: #3498db;
    color: #fff;
    padding: 6px 50px;
    font-size: 10px;
    line-height: 12px;
    text-transform: uppercase;
    position: absolute;
    top: 20px;
    right: -55px;
    transform: rotate(45deg);
}
.pricingTable .pricingContent ul{
    list-style: none;
    padding: 0;
    margin-bottom: 0;
}
.pricingTable .pricingContent ul li{
    border-bottom:1px solid #ededed;
    color: #9999A5;
    padding: 10px 0 ;
}
.pricingTable .pricingContent ul li:first-child {
    border-top:1px solid #ededed;
}
.pricingTable .pricingTable-sign-up{
    padding: 25px 0;
}
.pricingTable .btn-block{
    background:#666;
    border-radius: 0px;
    border:0px none;
    color:#fff;
    width: 50%;
    padding: 10px 5px;
    margin: 0 auto;
    text-transform: capitalize;
    transition:all 0.3s ease 0s;
}
.pricingTable .btn-block:after{
    content: "\f090";
    font-family: "Font Awesome 5 Free"; font-weight: 900;
    padding-left: 10px;
    font-size: 15px;
}
.pricingTable .btn-block:hover{
    background: #282828;
    color:#fff;
}
@media screen and (max-width:990px){
    .pricingTable{
        margin-bottom: 20px;
    }
}
.design-process-content{
	margin: 0 auto;
	padding: 0;
	
}
</style>

</head>

<body>
	<%@include file="menu.jsp"%>
	<%@include file="logo.jsp"%>
	<br>
	<br>
	<br>

  <section class="design-process-section" id="process-tab">
  <div class="container">
    <div class="row">
      <div class="col-xs-12"> 
        <!-- design process steps--> 
        <!-- Nav tabs -->
        <ul class="nav nav-tabs process-model more-icon-preocess" role="tablist">
          <li role="presentation" class="active"><a href="#discover" aria-controls="discover" role="tab" data-toggle="tab"><i class="fa fa-search" aria-hidden="true"></i>
            <p>내정보</p>
            </a></li>
          <li role="presentation"><a href="#product" aria-controls="strategy" role="tab" data-toggle="tab"><i class="fa fa-send-o" aria-hidden="true"></i>
            <p>내상품</p>
            </a></li>
          <li role="presentation"><a href="#cart" aria-controls="optimization" role="tab" data-toggle="tab"><i class="fa fa-qrcode" aria-hidden="true"></i>
            <p>장바구니</p>
            </a></li>
          <li role="presentation" ><a href="#content" aria-controls="content" role="tab" data-toggle="tab"><i class="fa fa-newspaper-o" aria-hidden="true"></i>
            <p>내등급</p>
            </a></li>
        </ul>
        <!-- end design process steps--> 
        <!-- Tab panes -->
        <div class="tab-content" >
          <div role="tabpanel" class="tab-pane active" align="center" id="discover">
            <div class="design-process-content"  >
              <div class="container">
   				 <div class="row">
       				 <div class="col-xs-9" style="padding-left: 55px;">
           				 <div class="pricingTable">
            		  	  <div class="pricingTable-header">
                 		   <h3>내정보</h3>
             				   </div>
            		    <div class="price-value">
                  	  <span>${sessionScope.id}</span>
                  	  <span class="subtitle">${mdto.name}</span>
               			 </div>
                	<div class="pricingContent">
                    <ul>
                        <li><b>E-MAIL:</b>${mdto.email}</li>
                        <li><b>PHONE:</b>${mdto.phone}</li>
                        <li><b>ADDRESS:</b>${mdto.addr} ${mdto.zipcode}</li>
                        <li><b>INCOME</b>${mdto.income} 원 </li>
                    </ul>
             	   </div><!-- /  CONTENT BOX-->
             	   <div class="pricingTable-sign-up"><!-- BUTTON BOX-->
             	       <a href="../fmMember/infoUpdate.jsp" class="btn btn-block btn-default">정보수정</a>
             	       <a href="../fmMember/pwdUpdate.jsp" class="btn btn-block btn-default">비밀번호변경</a>
          		      		</div><!-- BUTTON BOX-->
       		    			 </div>
     				   </div>
   				 </div>
			</div>
             </div>
          </div>
          <div role="tabpanel" class="tab-pane" id="product" >
            	<div class="design-process-content" align="center">
            		<br><br>
              		<font size="5px">내가 판매중인 상품</font> 
              		<br>
					<c:if test="${prodArr !=null}">
						<table class='table table-hover'>

							<tr>
								<td><b>카테고리</b></td>
								<td><b>상품이름</b></td>
								<td><b>상품가격</b></td>
								<td></td>

							</tr>
						<c:forEach items="${prodArr}" var="list" >
							<tr>
								<td>${list.category }</td>
								<td>${list.title }</td>
								<td>${list.price }</td>
							</tr>
						</c:forEach>
						</table>
					</c:if>
					<c:if test="${lists ==null}">
						<br><b>판매중상품없음</b>
					</c:if>
              </div>
          </div>
          <div role="tabpanel" class="tab-pane" id="cart">
           	 	<div class="design-process-content" align="center">
           	 		<br><br>
					<font size="5px">CART</font> 
					<br>
					<c:if test="${lists !='no'}">
						<table class='table table-hover'>
							<tr>
								<th>상품번호</th>
								<th>판매자아이디</th>
								<th>상품이름</th>
								<th>상품가격</th>
								<th>선택</th>
							</tr>
						<c:forEach items="${cartArr}" var="list" >
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
					  장바구니가 비어있습니다.
					</c:if>
               </div>
          </div>
          <div role="tabpanel" class="tab-pane" id="content">
            <div class="design-process-content">
              <h3 class="semi-bold">서비스 준비중입니다.^^</h3>
                       
              </div>
          </div>

      </div>
    </div>
  </div>
</section>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>

    <script src="tabs.js"></script>

</body>
</html>
