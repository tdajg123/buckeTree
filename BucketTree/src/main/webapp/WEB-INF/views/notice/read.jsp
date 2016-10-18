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

					<li><a href="/BucketTree/notice/list">공지사항 <span
							class="fa fa-angle-right f_right"></span></a></li>
					
					<!-- 유저 타입이 관리자면 관리 메뉴 show -->
					<c:set var="check" value="${user.type}" />
					<c:set var="check2" value="관리자" />
					<c:if test="${check eq check2}">
					<li><a href="/BucketTree/notice/create">공지사항 작성 <span
							class="fa fa-angle-right f_right"></span></a></li>
					<li><a href="/BucketTree/userlist">회원관리 
					<span class="fa fa-angle-right f_right"></span></a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>

	<div class="f_right" style="margin: 10px;">

			<!-- 유저 타입이 관리자면 관리 메뉴 show -->
			<c:if test="${check eq check2}">
			<a href="/BucketTree/notice/edit?idx=${list.idx}"
				class="btn btn-default">수정</a>
			<a href="/BucketTree/notice/delete?idx=${list.idx}"
				class="btn btn-default">삭제</a>
			</c:if>

	</div>

	<div class="box-group">
		<div class="x_panel">
			<div class="x_title">
				<div class="f_right">
						<span id="w_info"> 관리자 </span> <span>
							${list.date} </span>
					</div>
				<hr>
				<h1 style="margin-left: 10px;">${list.title}</h1>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="x_contents" style="font-size: 20px">
					${list.contents}</div>
			</div>
		</div>
	</div>

</div>
<script>
	$('button[data-toggle=collapse]').click();

	$('.modifyButton').click(function() {

		$(this).parent().parent().children(".modify").addClass("modifyShow");
	})
	$('.modifyCancel').click(function() {

		$('.modify').removeClass("modifyShow");
	})
</script>
