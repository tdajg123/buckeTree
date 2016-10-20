<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />

<!-- 사이드 바 메뉴 -->
<div class="container" style="padding-top: 50px; padding-bottom: 85px">
	<!-- Menu -->
	<div class="side-menu" style="left: 100px; width: 200px; height: 200px">

		<nav class="navbar navbar-default" role="navigation"
			style="width: 200px">

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">

					<li><a href="/BucketTree/notice/list"> 공지사항 <span
							class="fa fa-angle-right f_right"></span></a></li>
					<li><a href="/BucketTree/notice/create">공지사항 작성 <span
							class="fa fa-angle-right f_right"></span></a></li>
					<li><a href="/BucketTree/userlist">회원관리 
					<span class="fa fa-angle-right f_right"></span></a></li>		
				</ul>
			</div>
		</nav>
	</div>
	<div class="box-group">
		<h3>
			<i class="fa fa-chevron-right"></i> 공지사항 작성
		</h3>
		<hr>
		<form id="notice_Create" method="post" action="/BucketTree/notice/create" enctype="multipart/form-data"
		onSubmit="return formChk()">
		<div class="x_panel">
			
				<div class="x_contents">
					<!-- 제목 -->
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							placeholder="Title">
					</div>
					<!--버킷리스트 지정-->
					<div class="form-group">
						<textarea id="body" name="content" class="smarteditor2"
							style="width: 100%; height: 450px"></textarea>
					</div>
				</div>

		</div>
		<div class="f_right" style="margin-bottom: 10px;">
			<button type="submit" class="btn btn-success">
				<span class="fa fa-check"></span> 작성하기
			</button>
			<a href="/BucketTree/bucketShare/list" class="btn btn-default"> <span
				class="fa fa-remove"></span> 취소하기
			</a>
		</div>
	</form>
	</div>
</div>


<script>


function formChk() {

    var contentChk = $("#body").val();
    var value = $('input[name=title]').val();
	//스마트 에디터 공백 체크 변수
    contentChk2 = contentChk.replace(/&nbsp;/gi,"");
	contentChk2 = contentChk2.replace(/<br>/gi,"");
	contentChk2 = contentChk2.replace(/ /gi,"");
		if (value == ""
				|| value == null
				|| value == undefined
				|| (value != null
						&& typeof value == "object" && !Object
						.keys(value).length)) {
			alert('제목을 입력하세요');
			return false;
		
     // 스마트 에디터 공백체크
	}else if(contentChk2 =="<p><\/p>" || contentChk2 ==""){
		alert('내용을 입력하세요')
		return false;
    }else{
    	return true;
    }

}


</script>