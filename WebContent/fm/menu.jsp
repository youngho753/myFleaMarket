<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="menu">
	<div class="hamburger">
	    <div class="line"></div>
	    <div class="line"></div>
	    <div class="line"></div>
	</div>
	<div class="menu-inner">  
	    <ul>
	    	<li></li>
	    	<c:if test="${sessionScope.id==null}">
		    	<li><a href="../fmMember/naverlogin.jsp">로그인</a></li>
		    	<li><a href="../fmMember/joinForm.jsp">회원가입</a></li>
	    	</c:if>
	    	
	    	<c:if test = "${sessionScope.id!=null }">
	    		<li><a href="logout.do">로그아웃</a></li>
	    	</c:if>
	    	
	    	<c:if test="${sessionScope.id=='master'}">
	    		<li><a href="../fmMaster/masterPage.jsp">관리자모드</a></li>
	    		<li><a href="../fmBoard/noticeWrite.jsp">공지사항 작성</a></li>
	    	</c:if>
	    	
	        <li><a href="../fm/shop.jsp">플리마켓</a></li>
	        <li><a href="../fm/store.jsp">스토어</a></li>
	        <li><a href="boardList.bo">QnA</a></li> 
	        <li><a href="../fm/main.jsp">메인화면</a></li>
	        
	        <c:if test="${sessionScope.id !=null and sessionScope.id !='master'}">
	         	<li><a href="msgList.do">쪽지함<span id="newmsg">❣️</span></a></li>
	        </c:if>
	        
	         <c:if test="${sessionScope.id !=null and sessionScope.id !='master' and sessionScope.id !='store1' and sessionScope.id !='store2' and sessionScope.id !='store3' and sessionScope.id !='store4'}">
	        	<li><a href="myPage.do?id=${sessionScope.id }">마이페이지</a></li> 
	        </c:if>
	        
	    </ul>
	</div>
	<svg version="1.1" id="blob" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
	    <path id="blob-path" d="M60,500H0V0h60c0,0,20,172,20,250S60,900,60,500z"/>
	</svg>
</div>