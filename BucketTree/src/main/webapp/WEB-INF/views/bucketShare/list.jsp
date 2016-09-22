<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />

<!-- Modal -->
<div class="modal fade" id="category_modal" role="dialog"
	style="z-index: 999999; position: fixed">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 15px 50px;"></div>
			<div class="modal-body" style="padding: 40px 50px;">

				<select id="when_temp"></select> <select id="who_temp"></select> <select
					id="what_temp"></select>


			</div>
			<div class="modal-footer">
				<button type="submit" id="categoryAble" class="btn btn-default">
					<span class="fa fa-check"></span><span id="categoryState">카테고리
						검색 비활성화</span>
				</button>
				<button type="submit" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-check"></span> 확인
				</button>
			</div>
		</div>
	</div>
</div>
<div class="container" style="padding-top: 110px; padding-bottom: 85px">
	<!-- Menu -->
	<div class="side-menu" style="left: 100px; width: 200px; height: 200px">

		<nav class="navbar navbar-default" role="navigation"
			style="width: 200px">

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">

					<li><a href="/kr/bucketshare/listAll"><span
							class="glyphicon glyphicon-user"></span> 전체질문</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							내가 쓴 질문</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							내가 쓴 답변</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							질문하기</a></li>

				</ul>
			</div>

		</nav>

	</div>


	<div class="row"
		style="margin-left: 0px; margin-right: 0px; width: 1100px">
		<div style="margin: auto; width: 250px; margin-bottom: 3px">
			<button id="view_when" type="button" class="btn btn-success">없음</button>
			<button id="view_who" type="button" class="btn btn-success">없음</button>
			<button id="view_what" type="button" class="btn btn-success">없음</button>
		</div>
		<div class="form-inline">
			<!-- Search Form __ Start -->
			<form:form id="form_search" method="POST" modelAttribute="pagination"
				action="/BucketTree/bucketShare/list">

				<button id="category" class="btn btn-success">카테고리</button>
				<form:select path="type">
					<form:option value="0" label="전체" />
					<form:option value="1" label="채택 O" />
					<form:option value="2" label="채택 X" />
				</form:select>
				<form:select path="srchType">
					<form:option value="0" label="검색조건" />
					<form:option value="1" label="제목" />
					<form:option value="2" label="제목+내용" />
					<form:option value="3" label="작성자" />
				</form:select>

				<div class="input-group"
					style="width: 400px; margin-left: 0px; display: inline-block">

					<form:input path="srchText" type="text" class="form-control"
						placeholder="Search..." style="height: 40px" />
				</div>
				<button type="submit" class="btn btn-success">검색</button>
				<c:if test="${ (pagination.srchType != 0)  ||  (pagination.categoryType != 0)}">
					<a href="/BucketTree/bucketShare/list" class="btn btn-success">취소</a>
				</c:if>
				<form:select path="orderType">
					<form:option value="1" label="개설순" />
					<form:option value="2" label="인기순" />
				</form:select>
				<form:input path="who" type="hidden" />
				<form:input path="when" type="hidden" />
				<form:input path="what" type="hidden" />
				<form:input path="categoryType" type="hidden" />
				<form:input path="currentPage" type="hidden" />

			</form:form>
		</div>

		<div class="menurow"></div>

		<div class="col-sm-12">
			<c:forEach var="question" items="${ list }">
				<div class="bs-calltoaction bs-calltoaction-default"
					href="/listDetail.jsp"
					style="margin-left: 55px; margin-bottom: 25px">
					<div class="row">
						<div class="col-md-9 cta-contents">
							<h1 class="cta-title">${question.title}</h1>

							<div class="cta-desc">
								<p style="font-size: 17px">작성자 : ${question.name}</p>

							</div>
						</div>
						<div class="col-md-3 time">
							<p>${question.date}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


	</div>




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
		//카테고리 옵션으로 값뿌려주기
		<c:forEach items="${what}" var="what">
		$('#what_temp').append("<option value='${what.idx}' ${pagination.what==what.idx ? 'selected' : '' }> ${what.what} </option>");
		</c:forEach>
		<c:forEach items="${when}" var="when">
		$('#when_temp').append("<option value='${when.idx}' ${pagination.when==when.idx ? 'selected' : '' }> ${when.when} </option>");
		</c:forEach>
		<c:forEach items="${who}" var="who">
		$('#who_temp').append("<option value='${who.idx}' ${pagination.who==who.idx ? 'selected' : '' }> ${who.who} </option>");
		</c:forEach>
		//
			
		<c:if test="${pagination.categoryType==1}">
		$('#view_when').html($('#when_temp option:selected').text());
		$('#view_who').html($('#who_temp option:selected').text());
		$('#view_what').html($('#what_temp option:selected').text());
		$('#view_when').show();
		$('#view_who').show();
		$('#view_what').show();
		</c:if>
		
		
		<c:if test="${pagination.categoryType==0}">
		$('#view_when').hide();
		$('#view_who').hide();
		$('#view_what').hide();
		</c:if>
		
		
			$('#category').click(function(e) {
			e.preventDefault();
			$('#category_modal').modal();
		});

		$('#when_temp').change(function() {
			$('#view_when').html($('#when_temp option:selected').text());
			$('#when').val($('#when_temp option:selected').val());
		});
		$('#who_temp').change(function() {
			$('#view_who').html($('#who_temp option:selected').text());
			$('#who').val($('#who_temp option:selected').val());
		});
		$('#what_temp').change(function() {
			$('#view_what').html($('#what_temp option:selected').text());
			$('#what').val($('#what_temp option:selected').val());
		});

		$('#categoryAble').click(function() {

			if ($('#categoryState').html() == '카테고리 검색 활성화') {
				$('#category').html('카테고리X');
				$('#categoryState').html('카테고리 검색 비활성화');
				$('#view_when').hide();
				$('#view_who').hide();
				$('#view_what').hide();
				$('#categoryType').val(0);
			} else {
				$('#category').html('카테고리O');
				$('#categoryState').html('카테고리 검색 활성화');
				$('#view_when').show();
				$('#view_who').show();
				$('#view_what').show();
				$('#categoryType').val(1);
			}

		});

		$("div.pagination a").click(function() {

			$("input[name=currentPage]").val($(this).attr("data-page"));
			$("#form_search").submit();

		});

	});
</script>