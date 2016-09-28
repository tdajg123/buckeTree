<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script>
	function onclickName() {
		$('#search_param').val(1);
		$('#search_concept').text("이름");
	}
	function onclickEmail() {
		$('#search_param').val(2);
		$('#search_concept').text("이메일");
	}
	$(document).on('click', '#add', function() {
		var evnetTarget = this;
		var eventIdx = $(this).attr('data-idx');

		$.ajax({
			url : "/BucketTree/friend/addFriendRequestAjax",
			dataType : "json",
			type : "POST",
			data : {
				add_idx : eventIdx

			},
			success : function(data) {
				if (data) {
					alert('신청 완료!')
					$(evnetTarget).text("요청 완료 ");
				}
			}
		});

	});

	//무한스크롤을 위한 스크롤 체크

	$(window)
			.scroll(
					function() {
						if ($(window).scrollTop() >= $(document).height()
								- $(window).height()) {

							var lastrow = $(
									".blockquote-box.blockquote-info.clearfix:last")
									.attr("data-row");
							var srchType = $("#search_param").val();
							var srchText = $("#search_text").val();

							var str = '';
							$
									.ajax({
										url : "/BucketTree/Friend/searchAjaxFriendList",
										dataType : "json",
										type : "POST",
										data : {
											row : lastrow,
											srchType : srchType,
											srchText : srchText

										},
										success : function(data) {
											if (data != "") {
												$(data)
														.each(

																function() {
																	str += "<div class='blockquote-box blockquote-info clearfix' data-row='"+this.row+"'data-idx='"+this.idx+"'>"
																			+ "<div class='square pull-left'>"
																			+ "<span class='glyphicon glyphicon-info-sign glyphicon-lg'></span>"
																			+ "</div>"
																			+ "<h4>"
																			+ this.name
																			+ "</h4>"
																			+ "<p>"
																			+ this.email
																			+ "</p>"
																			+ "<p id='mbp'>"
																			+ "<button type='button' class='btn btn-default' aria-label='right Align' id='add' data-idx='"+this.idx+"'>"
																			+ "<span class='glyphicon glyphicon-plus'></span>"
																			+ "</button>"
																			+ "</p>"
																			+ "</div>";
																})
												$('.col-md-6').append(str);
											} else
												alert('불러올 데이터가 없습니다')
										}
									});

						}
					});
</script>

<div class="container" style="padding-top: 50px; padding-bottom: 85px">
	<!-- leftMenu __ Start -->
	<!-- Menu -->
	<div class="side-menu" style="left: 100px; width: 200px; height: 160px">

		<nav class="navbar navbar-default" role="navigation"
			style="width: 200px">

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">

					<li><a href="/BucketTree/Friend/FriendList"> 친구 목록 <span
							class="fa fa-angle-right f_right"></span></a></li>
					<li><a href="/BucketTree/Friend/FriendRequestList"> 친구 맺기
							<span class="fa fa-angle-right f_right"></span>
					</a></li>
					<li><a href="/BucketTree/Friend/searchFriendList"> 친구 찾기 <span
							class="fa fa-angle-right f_right"></span>
					</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- leftMenu __ End -->
	<h3>
		<i class="fa fa-chevron-right"></i> 친구 찾기
	</h3>
	<div class="row">
		<div class="col-xs-5 col-xs-offset-7">
			<form class="input-group"
				action="/BucketTree/Friend/searchFriendListPost" method="post">
				<div class="input-group-btn search-panel">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<c:set var="srch" value="${srch}" />
						<c:choose>
							<c:when test="${empty srch.getSrchType()}">
								<span id="search_concept">검색 조건</span>
								<span class="caret"></span>
							</c:when>
							<c:when test="${srch.getSrchType() eq 1}">
								<span id="search_concept">이름</span>
								<span class="caret"></span>
							</c:when>
							<c:when test="${srch.getSrchType() eq 2}">
								<span id="search_concept">이메일</span>
								<span class="caret"></span>
							</c:when>
						</c:choose>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a onclick="onclickName()">이름</a></li>
						<li><a onclick="onclickEmail()">이메일</a></li>
					</ul>
				</div>
				<input type="hidden" name="srchType" value="${srch.getSrchType()}"
					id="search_param"> <input type="text" class="form-control"
					name="srchText" value="${srch.getSrchText()}" id="search_text">
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</form>
		</div>
	</div>
	<hr>
	<div class="row">
		<c:forEach items="${list}" var="FriendVO">

			<div class="col-md-6">
				<div class="blockquote-box blockquote-info clearfix"
					data-row="${FriendVO.getRow()}" data-idx="${FriendVO.getIdx()}">
					<div class="square pull-left">
						<span class="glyphicon glyphicon-info-sign glyphicon-lg"></span>
					</div>
					<h4>${FriendVO.name}</h4>
					<p>${FriendVO.email }</p>
					<p id="mbp">
						<button type="button" class="btn btn-default"
							aria-label="right Align" id="add" data-idx="${FriendVO.getIdx()}">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</p>
				</div>
			</div>
		</c:forEach>

	</div>
</div>
