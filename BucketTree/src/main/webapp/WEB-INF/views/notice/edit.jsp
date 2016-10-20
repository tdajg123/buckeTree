<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />

<!-- 사이드 바 메뉴 -->
<div class="container" style="padding-top: 110px; padding-bottom: 85px">
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



	<div class="box-group" id="accordion"
		style="height: 900px; width: 1200px; padding-top: 100px;">
		<div class="panel box box-primary">
			<form method="post" id="notice_Edit" action="/BucketTree/notice/editPost" onSubmit="return formChk()">
				<div class="modal-header" style="padding: 15px 50px;">

					<!-- 제목 -->
					<h4>
						<span class="fa fa-pencil"></span> 공지사항
					</h4>
				</div>
				<div class="modal-body" style="height: 700px; padding: 40px 50px;">
				<div class="x_panel">
					<div class="x_contents">
					<!-- 제목 -->
					<div class="form-group">
						<h1><input type="text" class="form-control" name="title" id="title" value="${list.title }"/></h1>
					</div>

					<div class="form-group">
						<textarea class="smarteditor2" id="body" name="contents" style="width: 100%; height: 450px">
						${list.contents }</textarea>

					</div>
					<input type="hidden" name="idx" value="${list.idx}"/>
					</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success">
						<span class="fa fa-check"></span> 작성하기
					</button>
					<a href="/BucketTree/notice/list" class="btn btn-default">
						<span class="fa fa-remove"></span> 취소하기
					</a>
				</div>
			</form>
		</div>
	</div>



</div>


<script>
function formChk() {
	
    var contentChk = $("#body").val();
    var value = $('input[name=title]').val();
	alert(contentChk)
		/*타이틀 유효성 체크*/
		if (value == ""
				|| value == null
				|| value == undefined
				|| (value != null
						&& typeof value == "object" && !Object
						.keys(value).length)) {
			alert('제목을 입력하세요');
			return false;
		
     /*내용 유효성 체크 */
	}else if( contentChk == ""  || contentChk == null || contentChk == '&nbsp;' || contentChk == '<p>&nbsp;</p>')  {
         alert("내용을 입력하세요.");
         return false;
    }else{
    	return true;
    }


	  };
</script>