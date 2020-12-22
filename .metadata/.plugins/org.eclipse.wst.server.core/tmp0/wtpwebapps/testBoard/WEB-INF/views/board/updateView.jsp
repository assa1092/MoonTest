<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr />

		<div>
				<%@include file="nav.jsp" %>
		</div>
		<hr />


		<section id="container" class="container">
			<form action="/board/update" method="post">
				<input type="hidden" name="bno" value="${update.bno}">
				<div class="form-group">
					<label for="title">제목</label>
					<!-- for="title" 제목 클릭시 name="title"으로 포커스 가게... -->
					<input name="title" id="title" class="form-control check" title="제목을 입력하세요" value="${update.title }">
					<!-- input 태그가 한줄로 모서리 둥글게...class="form-control" -->

				</div>
				<div class="form-group">
					<label for="writer">작성자</label> <input name="writer" id="writer"
						class="form-control check" title="작셩자를 입력하세요" value="${update.writer }">
				</div>

				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control check" title="내용을 입력하세요">${update.content }</textarea>
				</div>

				<!-- <div class="form-group" align="right">
					<button class="btn btn-info" type="submit">작 성</button>
					<button class="btn btn-warning" >목 록</button>
				</div> -->
			</form>
			
			<div class="form-group" align="right">
					<button id="updateBtn" class="btn btn-info">수 정</button>
					<button id ="listBtn" class="btn btn-warning" >목 록</button>
			</div>
		</section>


	</div>
	
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateBtn").click(function(){
			if(fn_validCheck()){
				return false;
			}
			$("form").submit();
		});
		$("#listBtn").click(function(){
			location.assign("/board/list");
		});
	});


	// 제목, 작성자, 내용 Validation Check
	function fn_validCheck(){
		var isValid = $(".check").length;

		for(var i=0; i< isValid; i++){
			if($(".check").eq(i).val() == "" || $(".check").eq(i).val() == null){
				alert($(".check").eq(i).attr("title"));
				return true;
			}
		}
	}
</script>

</body>
</html>