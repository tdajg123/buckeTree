<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



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
					<!-- 유저 타입이 관리자 이면 메뉴 show -->
					<c:set var="check" value="${user.type}" />
					<c:set var="check2" value="관리자" />
					<c:if test="${check eq check2}">
					<li><a href="/BucketTree/notice/create">공지사항 작성 
					<span class="fa fa-angle-right f_right"></span></a></li>
					<li><a href="/BucketTree/userlist">회원관리 
					<span class="fa fa-angle-right f_right"></span></a></li>
					</c:if>
				</ul>
			</div>
		</nav>
	</div>


	<div class="row">
	
		<form:form id="form_search" method="POST" modelAttribute="pagination">

			<div class="col-md-12">

				<div class="form-inline">
					<!-- Search Form __ Start -->

					<!-- 검색 조건 선택 셀렉트 박스 -->
					<form:select path="srchType">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="제목" />
						<form:option value="2" label="제목+내용" />
					</form:select>
					
					<form:input path="currentPage" type="hidden" />
					
					<!-- 검색 input 박스 -->
					<div class="input-group"
						style="width: 400px; display: inline-block">

						<form:input path="srchText" type="text" class="form-control"
							placeholder="Search..." style="height: 40px" />
					</div>
					<button type="submit" class="btn btn-success">검색</button>


				</div>
			</div>

		</form:form>
		<br />

		<!-- 공지사항 리스트 출력 -->
		<div class="col-sm-12" style="margin-top: 20px;">
			<c:forEach var="notice" items="${ list }">
				<div class="bs-calltoaction bs-calltoaction-default"
					data-url="/BucketTree/notice/read?idx=${notice.idx}"
					style="margin-left: 55px; margin-bottom: 25px">
					<div class="row">
						<div class="col-md-9 cta-contents">
							<h1 class="cta-title">${notice.title}</h1>
						</div>

						<div class="col-md-3 cta-body">
							<p style="font-size: 17px">관리자</p>
							<p>${notice.date}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- 리스트 하단 페이지 넘버 -->
	<div class="pagination pagination-small pagination-centered">
		<ul>
			<c:forEach var="page" items="${ pagination.pageList }">
				<li class='${ page.cssClass }'><a data-page="${ page.number }">${ page.label }</a></li>
			</c:forEach>
		</ul>
	</div>
</div>

<script>
	$(function() {

		$(".bs-calltoaction").click(function() {
			location.href = $(this).attr("data-url");
		});


		
		$("div.pagination a").click(function() {

			$("input[name=currentPage]").val($(this).attr("data-page"));
			$("#form_search").submit();

		});

	});
	

</script>