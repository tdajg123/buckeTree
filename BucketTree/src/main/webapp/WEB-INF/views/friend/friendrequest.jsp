<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
.profileImage {
	background-color: #fff;
	border: 3px #48cfc8 solid;
	width: 70px;
	height: 70px;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	text-align: center;
	margin: 0 auto;
	margin-bottom: 20px;
	margin-right: 10px;
	overflow: hidden;
}
</style>
<script>
	function onclickName() {
		$('#search_param').val(1);
		$('#search_concept').text("이름");
	}
	function onclickEmail() {
		$('#search_param').val(2);
		$('#search_concept').text("이메일");
	}
	//친구 삭제 이벤트
	$(document).on('click', '#deleteRequest', function() {
		var evnetTarget = this;
		var eventIdx = $(this).attr('data-idx');
		alert("요청 삭제")
		$.ajax({
			url : "/BucketTree/friend/deleteRequestAjax",
			dataType : "json",
			type : "POST",
			data : {
				delete_idx : eventIdx

			},
			success : function(data) {
				if (data)
					alert('거절 완료!')
				$("#" + eventIdx).remove();

			}
		});

	});

	$(document).on('click', '#addFriend', function() {
		var evnetTarget = this;
		var eventIdx = $(this).attr('data-idx');

		$.ajax({
			url : "/BucketTree/friend/addFriendAjax",
			dataType : "json",
			type : "POST",
			data : {
				add_idx : eventIdx
			},
			success : function(data) {
				if (data)
					alert('수락 완료!')
				$("#" + eventIdx).remove();

			}
		});

	});

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
										url : "/BucketTree/Friend/sendFriendRequestAjaxList",
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
																			+ "<div class='profileImage pull-left'>"
																			+ "<img src='/BucketTree/images/PROFILE_image.png' style='width: 70px; height: 70px'>"
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
												$('#slist').append(str);
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

	<h3 style="margin-bottom: 50px;">
		<i class="fa fa-chevron-right"></i> 친구 맺기
	</h3>
	<div class="row">
		<div class="col-md-6">

			<div class="x_panel">
				<div class="x_title">
					<span><h1>받은 친구 요청</h1></span>
				</div>
				<div class="x_content">
					<c:set var="rlist" value="${rlist}" />
					<c:if test="${empty rlist}">
						<h3>새로운 친구요청 없음</h3>
					</c:if>
					<c:forEach items="${rlist}" var="UserVO">
						<div class="blockquote-box blockquote-info clearfix"
							data-num="${UserVO.getRow()}" id="${UserVO.getIdx()}" style="width:100%">
							<div class="profileImage pull-left">
								<img src="/BucketTree/images/PROFILE_image.png"
									style="width: 70px; height: 70px">
							</div>
							<h4>${UserVO.name}</h4>
							<p>${UserVO.email }</p>
							<p id="mbp">
								<button type="button" class="btn btn-default"
									aria-label="right Align" id="addFriend"
									data-idx="${UserVO.getIdx()}">확인</button>
								<button type="button" class="btn btn-default"
									aria-label="right Align" id="deleteRequest"
									data-idx="${UserVO.getIdx()}">거절</button>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="col-md-6" id="slist">
			<div class="x_panel">
				<div class="x_title">
					<a name="sendlist"></a>

					<h1>전송한 친구 요청</h1>
				</div>
				<div class="x_content">
					<c:set var="slist" value="${slist}" />
					<c:if test="${empty slist}">
						<h3>새로운 친구요청 없음</h3>
					</c:if>
					<c:forEach items="${slist}" var="UserVO">
						<div class="blockquote-box blockquote-info clearfix"
							data-num="${UserVO.getRow()}" id="${UserVO.getIdx()}" style="width:100%">
							<c:if test = "${UserVO.getImage() != null }">
						<div class="profileImage pull-left" style="padding:0px">
							<img src="/BucketTree/Friend/${UserVO.getIdx()}/profile" style="height:95px"> 
						</div>
					</c:if>
					<c:if test = "${UserVO.getImage() == null }">
						<div class="profileImage pull-left">
							<img src="/BucketTree/images/PROFILE_image.png"
									style="width: 70px; height: 70px">
						</div>
					</c:if>
							<h4>${UserVO.name}</h4>
							<p>${UserVO.email }</p>
							<p id="mbp">
								<button type="button" class="btn btn-default"
									aria-label="right Align" id="deleteRequest"
									data-idx="${UserVO.getIdx()}">요청 취소</button>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

