$(document).ready(function(){
	$("#upload").click(function(){
		if($("#title").val()==""){
			alert("제목을 입력하세요")
			$("#title").focus();
			return false;
		}
		if($("#summernote").val()==""){
			alert("내용을 입력하세요")
			$("#summernote").focus();
			return false;
		}
		if($("#mainpic").val()==""){
			alert("메인사진을 등록하세요")
			$("#main").focus();
			return false;
		}
		if($("#category").val()==""){
			alert("카테고리를 선택하세요")
			$("#category").focus();
			return false;
		}
		$("#frm").submit();
	});
})