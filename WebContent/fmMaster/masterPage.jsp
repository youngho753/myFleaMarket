<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&amp;subset=korean" rel="stylesheet">
<style>
.container{
	width: 75%;
	margin: 0 auto;
	padding: 40px;
	text-align: center;
}
.btnbtnBox{
	width: 100%;
	text-align: center;
}
</style>
</head>
<body>
<%@include file="../fm/logo.jsp"%>
<div class="container">
 <b> 관리자페이지 입니다 </b><br><br>
<input type="hidden" id="sign" value="${sign }">

<script>
 	$(document).ready(function(){
 		if($("#sign").val()=="")
 			location.href="master_data.do";
 			
 		$("#mem_div").hide();
 		$("#flea_div").hide();
 		$("#store_div").hide();
 		$("#graph").show();
 		
 		$("#total_graph").show();
 		$("#flea_graph").hide();
 		$("#store_graph").hide();
 		
		$("#member").click(function(){
			$("#mem_div").show();
			$("#flea_div").hide();
			$("#store_div").hide();
			$("#graph").hide();
			
			$.ajax({
				type:"post",
				url:"mem_manage.do",
				success:function(data){
					var data = JSON.parse(data);
					var htmlStr='';
					htmlStr+="<table border=1 class='table table-hover'>";
					htmlStr+="<thead>"
					htmlStr +="<tr><td>아이디</td><td>이름</td><td>이메일</td><td>주소</td><td>수익</td><td>순위</td><td>판매글 갯수</td></tr></thead><tbody>"
					for(var i=0;i<data.length;i++){
						htmlStr+="<tr>";	
						htmlStr+="<td onclick=window.open('memView.do?id="+data[i].userid+"','','width=500,height=500'); return false;>"+data[i].userid+"</td>";
						htmlStr+="<td>"+data[i].name+"</td>";
						htmlStr+="<td>"+data[i].email+"</td>";
						htmlStr+="<td>"+data[i].addr+"</td>";
						htmlStr+="<td>"+data[i].income+"</td>";
						htmlStr+="<td>"+data[i].rank+"</td>";
						htmlStr+="<td>"+data[i].sellcount+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</tbody></table>";
					$("#result").html(htmlStr);
					
				},
				error:function(e){
					
				},
			});
		});
		$("#fleamarket").click(function(){
			$("#mem_div").hide();
			$("#flea_div").show();
			$("#store_div").hide();
			$("#graph").hide();
			
			$.ajax({
				type:"post",
				url:"flea_manage.do",
				success:function(data){
					var data = JSON.parse(data);
					var htmlStr='';
					htmlStr+="<table border=1 class='table table-hover'>";
					htmlStr+="<thead>"
					htmlStr +="<tr><td>상품번호</td><td>카테고리ID</td><td>판매아이디</td><td>상품이름</td><td>가격</td></tr></thead><tbody>"
					for(var i=0;i<data.length;i++){
						htmlStr+="<tr>";
						htmlStr+="<td>"+data[i].num+"</td>";
						htmlStr+="<td>"+data[i].category+"</td>";
						htmlStr+="<td >"+data[i].userid+"</td>";
						htmlStr+="<td>"+data[i].title+"</td>";
						htmlStr+="<td>"+data[i].price+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</tbody></table>";
					
					$("#result").html(htmlStr);
					
				},
				error:function(e){
					
				},
			});
		});
		$("#store").click(function(){
			$("#mem_div").hide();
			$("#flea_div").hide();
			$("#store_div").show();
			$("#graph").hide();
			$.ajax({
				type:"post",
				url:"store_manage.do",
				success:function(data){
					var data = JSON.parse(data);
					var htmlStr='';
					htmlStr+="<table border=1 class='table table-hover'>";
					htmlStr+="<thead>"
					htmlStr +="<tr><td>상품번호</td><td>카테고리ID</td><td>판매아이디</td><td>상품이름</td><td>가격</td></tr></thead><tbody>"
					for(var i=0;i<data.length;i++){
						htmlStr+="<tr>";
						htmlStr+="<td>"+data[i].num+"</td>";
						htmlStr+="<td>"+data[i].category+"</td>";
						htmlStr+="<td>"+data[i].userid+"</td>";
						htmlStr+="<td>"+data[i].title+"</td>";
						htmlStr+="<td>"+data[i].price+"</td>";
						htmlStr+="</tr>";
					}
					htmlStr+="</tbody></table>";
					
					$("#result").html(htmlStr);
					
				},
				error:function(e){
					
				},
			});
		});
		
		$("#back").click(function(){
			location.href="../fm/main.jsp";
		})
		
		$("#member_delete_bt").click(function(){
			if($("#id").val()==""){
				alert("아이디를입력하세요");
				return false;
			}
			$.ajax({
				type:"post",
				url:"memberDelete.do?id="+$("#id").val(),
				success:function(data){
					if(data.trim()=="ok"){
						alert("삭제성공");
						$("#member").click();
						$("#id").val("");
					}
					else{
						alert("아이디를 다시확인해보세요");
					}
					
				},
				error:function(e){
					
				}
			});
		});
		$("#flea_delete_bt").click(function(){
			if($("#goods_num").val()==""){
				alert("번호를 입력하세요");
				return false;
			}
			$.ajax({
				type:"post",
				url:"goods_delete.do?goods_num="+$("#goods_num").val(),
				success:function(data){
					if(data.trim()=="ok"){
						alert("삭제성공");
						$("#fleamarket").click();
						$("#goods_num").val("");
						
					}
					else{
						alert("상품번호를 다시확인해보세요");
					}
					
				},
				error:function(e){
					
				}
			});
		});
		$("#store_delete_bt").click(function(){
			if($("#store_num").val()==""){
				alert("번호를 입력하세요");
				return false;
			}
			$.ajax({
				type:"post",
				url:"store_delete.do?store_num="+$("#store_num").val(),
				success:function(data){
					if(data.trim()=="ok"){
						alert("삭제성공");
						$("#store").click();
						$("#store_num").val("");
						
					}
					else{
						alert("상품번호를 다시확인해보세요");
					}
					
				},
				error:function(e){
					
				}
			});
		});
		$("#total_graph_bt").click(function(){
			$("#total_graph").show();
			$("#flea_graph").hide();
			$("#store_graph").hide();
		})
		$("#flea_graph_bt").click(function(){
			$("#total_graph").hide();
			$("#flea_graph").show();
			$("#store_graph").hide();
		})
		$("#store_graph_bt").click(function(){
			$("#total_graph").hide();
			$("#flea_graph").hide();
			$("#store_graph").show();
		})
		
	}); 
	


</script>

 

 <input type="button" class="btn btn-default" value="관리자페이지메인"  onclick="location.href='masterPage.jsp'"  >
 <input type="button" class="btn btn-default" value="회원관리" id="member" >
 <input type="button" class="btn btn-default" value="플리마켓관리" id="fleamarket">
 <input type="button" class="btn btn-default" value="스토어관리" id="store">
 <input type="button" class="btn btn-default" value="돌아가기" id="back">
 <br><br><br><br>
 
 <div id="result"></div>
 

<div id="graph" align ="left">


<div id="total_graph" style="width: 100%; height:300px"></div>
<div id="flea_graph" style="height: 300px; width: 100%; overflow:hidden"></div>
<div id="store_graph" style="height: 300px; width: 100%; overflow:hidden"></div>


<br>
<br>
<div class="btnbtnBox">
<input type="button" value="홈페이지  현황" class="btn btn-default" id="total_graph_bt">
<input type="button" value="FleaMarket 게시글 현황" class="btn btn-default" id="flea_graph_bt">
<input type="button" class="btn btn-default" value="Store 게시글 현황" id="store_graph_bt">
</div>
</div>
 
  <div id="mem_div" >
 삭제하실 ID를 정확하게 입력하세요 <input type="text" id="id" class="text"> <input type="button" class="btn btn-default" value="삭제하기" id="member_delete_bt">
 </div>
 
 <div id="flea_div">
삭제하실 플리마켓 상품번호를 정확하게 입력하세요 <input type="text" class="text" id="goods_num"> <input type="button" class="btn btn-default" value="삭제하기" id="flea_delete_bt">
 </div>
 
 <div id="store_div">
삭제하실 스토어 상품번호를 정확하게 입력하세요 <input type="text" class="text" id="store_num"> <input type="button" class="btn btn-default" value="삭제하기" id="store_delete_bt">

 </div>
 
 
 <input type="hidden" id="mem_total" value="${mem_total }" >
 <input type="hidden" id="flea_total" value="${flea_total }" >
 <input type="hidden" id="store_total" value="${store_total }" >
 <input type="hidden" id="cart_total" value="${cart_total }" >
 <input type="hidden" id="qna_total" value="${qna_total }" >
 
 
 
 
 
 
 <c:forEach items="${fleaArr }" var="list">
 	<input type="hidden" id="${list.userid }" value="${(list.num/flea_total)*100 }">
 </c:forEach>
 
 <c:forEach items="${storeArr }" var="list">
 <input type="hidden" id="${list.userid }" value="${(list.num/store_total)*100 }">
 </c:forEach>
  
 <script>
 Morris.Bar({
		element: 'total_graph',     
		data: [                              
		{ y: '총 회원  ', value:$("#mem_total").val() },
		{ y: 'FleaMarket 판매글', value:$("#flea_total").val() },
		{ y: 'Store 판매 글', value:$("#store_total").val() },
		{ y: '장바구니 등록 글', value:$("#cart_total").val()},
		{ y: 'QnA 등록 글', value:$("#qna_total").val()}
		],
		xkey: 'y',                          
		ykeys: ['value'],              
		labels: ['총 수']
	});
 
 Morris.Donut({
	 element: 'flea_graph',    
	 data: [                                    
	 {label: 'Fashion', value:Math.round($("#fashion").val()) },
	 {label: 'Hobby', value: Math.round($("#hobby").val()) },
	 {label: 'Living', value:Math.round($("#living").val()) },
	 {label: 'Food', value: Math.round($("#food").val()) },
	 {label: 'Pet', value:Math.round($("#pet").val())}
	 ],
	 colors: ["#30a1ec", "#76bdee", "#387bb4", "#c4dafe"],
	 formatter: function (y) { return y + "%" } 
	 });
 
 Morris.Donut({
	 element: 'store_graph',   
	 data: [                                    
	 {label: 'Foraml Dress', value:Math.round( $("#store1").val() )},
	 {label: 'Aesop', value:Math.round( $("#store2").val()) },
	 {label: 'Green Shop', value:Math.round( $("#store3").val()) },
	 {label: 'P.P Flower', value:Math.round( $("#store4").val()) }
	 ],
	 colors: ["#30a1ec", "#76bdee", "#387bb4", "#c4dafe"], 
	 formatter: function (y) { return y + "%" } 
	 });
 </script>
</div>
</body>
</html>