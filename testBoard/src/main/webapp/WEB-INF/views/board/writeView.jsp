<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>게시판</title>



<style type="text/css">
	.fileDrop{
		width : 80%;
		height : 200px;
		border : 1px solid red;
		margin : auto;
	}
	
	.uploadedList {
		margin-top : 50px;
	}
	
	
	.uploadedList li{
		list-style : none;
	}
	.orifilename {
		overflow : hidden;
		white-space : nowrap;
		text-overflow : ellipsis;
	}

</style>
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
			<form action="/board/write" method="post">
				<!-- <table>
					<tbody>
						<tr>
							<td>
								<label for="title">제목</label>
								<input type="text" id="title" name="title"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="content">내용</label>
								<input type="text" id="content" name="content"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="writer">작성자</label>
								<input type="text" id="writer" name="writer"/>
							</td>
						</tr>
						<tr>
							<td>
								<button type="submit">작 성</button>
							</td>
						</tr>
					</tbody>
				</table>
			 -->
			 
			 <c:if test="${member.userId != null }">
				<div class="form-group">
					<label for="title">제목</label>
					<!-- for="title" 제목 클릭시 name="title"으로 포커스 가게... -->
					<input name="title" id="title" class="form-control check" title="제목을 입력하세요">
					<!-- input 태그가 한줄로 모서리 둥글게...class="form-control" -->

				</div>
				<div class="form-group">
					<label for="writer">작성자</label> 
					<input name="writer" id="writer" class="form-control check"  title="작성자를 입력하세요">
				</div>

				<div class="form-group">
					<label for="content">내용</label>
					<textarea rows="5" name="content" id="content" class="form-control check"  title="내용을 입력하세요"></textarea>
				</div>
				
				
				
				
			<div class="form-group">
				<label>업로드할 파일을 드랍시키세요.</label>
				<div class="fileDrop"></div>
				<ul class = "uploadedList  clearfix"></ul>
				<!-- 
					<li class= "col-xs-2">
						<a href="#"><img src="/resources/show.png"></a>
						<p class="orifilename"><a>aaaa.txt<span class="glyphicon glyphicon-trash"></span></a></p>
					</li>
				-->
			</div>
				
				<div class="form-group" align="right">
						<button id="writeBtn" class="btn btn-info">작 성</button>
						<button id ="listBtn" class="btn btn-warning" >목 록</button>
				</div>
			</c:if>
			<c:if test="${member.userId == null}">
								<p>로그인 후에 작성하실 수 있습니다.</p>
			</c:if>
			</form>
			
			
		</section>


	</div>
	
	
<script type="text/javascript">
	$(document).ready(function(){
		$("#writeBtn").click(function(){
			if(fn_validCheck()){
				return false;
			}
			$("form").submit();			
		});
		
		$("#listBtn").click(function(){
			location.assign("/board/list");
		});

		$(".fileDrop").on("drop", function(event){
			event.preventDefault();

			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];

			var formData = new FormData();

			formData.append("file", file);

			$.ajax({
				type : 'post',
				url : '/uploadajax',
				dataType : 'text',
				data : formData,
				processData : false,
				contentType : false,

				success : function(result){
					console.log(result);

					var str ='<li class="col-xs-2">';

					str += '<a href="/displayfile?filename='+getImageLink(result)+'">';

					// 이미지 파일이면 썸네일 만들고
					// 아니면 기본 아이콘으로 보이게
					if(checkImage(result)){
						str += '<img src ="/displayfile?filename='+result+'"/>';
					} else {
						str += '<img src = "/resources/imageShow.png"/>';
					}

					str += '</a>';
					str += '<p class="orifilename">';

					str += '<a href="'+result+'" class="deletefile"><span class="glyphicon glyphicon-trash"></span></a>';
					str += getOriginalName(result);
					str += '</p>';
					str += '</li>';	


					// 새로운것도 이이지게끔...append
					// 덮어쓰기는 .html 
					$(".uploadedList").append(str);	
				},
			});
		})
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