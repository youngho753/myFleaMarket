<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src = "upload1.js"></script>
<link rel="stylesheet" href="../fm/style.css" type="text/css">
<script type="text/javascript" src="../fm/script.js"></script>
<script>
$(document).ready(function() {
    $('#summernote').summernote({
         height: 300,          
         minHeight: null,       
         maxHeight: null,          
         focus: true,
         onImageUpload: function(files, editor, welEditable) {
       	  for (var i = files.length - 1; i >= 0; i--) {
                 sendFile(files[i], this);
               }
         } 
    });
});
function sendFile(files,editor,welEditable){
    // 파일 전송을 위한 폼생성
		data = new FormData();
		data.append("file", files);
	    $.ajax({ // ajax를 통해 파일 업로드 처리
	        data :data,
	        type :"POST",
	        url :"goodsUpdate.do",
	        cache : false,
	        contentType : false,
	        processData : false,
	       success: function(url) {
             editor.insertImage(welEditable, url);
      }
	    });
	}
</script>
<style>

.insertForm{
	width:75%;
	margin:0 auto;
}
.btnLine{
	width:50%;
	margin:0 auto;
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>여기에 제목을 입력하십시오</title>
</head>
<body>
<%@include file="../fm/menu.jsp"%>
<%@include file="logo.jsp"%>
<div class="container">
<form action="goodsUpdate.do" enctype="multipart/form-data" id ="frm" name="frm" method="post">
	<div class="insertForm">
		<div class="form-group">
			<b>작성자</b>
			<input type="hidden" id="num" name="num" value="${goods.num }">
			<input type="hidden" id="userid2" name="userid" value="${sessionScope.name }">
			<input type="text" class="form-control" id="userid" name="userid" value="${sessionScope.name }" disabled="disabled">
		</div>
		<div class="form-group">
			<b>제목</b>
			<input type="text" class="form-control" id="title" name ="title" value="${goods.title }">
		</div>
		<div class="form-group">
			<label for="noticeContent"><b>카테고리</b></label>
		    <select class="form-control" id="category" name="category">
				<option value="fashion">패션 / 뷰티</option>
				<option value="living">생활</option>
				<option value="hobby">취미</option>
				<option value="food">식품</option>
				<option value="pet">반려용품</option>
		    </select>
		</div>
		<div class="form-group">
			<b>가격을 입력</b>
			<input type="text" class="form-control" id="price" name ="price" value="${goods.price }">
		</div>
	    <div class="form-group">
			<textarea name="summernote" id="summernote"></textarea>
		</div>
		<div class="form-group">
			<input type="file" class="form-control-file" id="mainpic" name="mainpic"><b>메인으로 등록할 사진을 올려주세요 10mb 이하만 가능합니다</b>
		</div>
		<div class="btnLine">
			<button type="button" id="upload" class="btn btn-success">작성</button>
			<button type="reset" onclick="" class="btn btn-success">취소</button>
		</div>
	</div>
</form>
</div>
</body>
</html>