<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!-- bucketList-listAll __ Start -->

<div class="topbar" style="display: flex; margin-left: 280px">
	<!-- Search Form __ Start -->

	<div class="container_category"
		style="display: flex; width: 900px; z-index: 9999">

		<div class="row_category" style="display: inline-block">

			<!-- 카테고리 모달창 -->
			<div class="modal fade" id="category_modal" role="dialog"
				style="z-index: 99999; position: fixed">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 15px 50px;"></div>
						<div class="modal-body" style="padding: 40px 50px;">

							<div style="display: flex; margin-left: 65px">
								<div style="display: inline-block">
									<h3>WHEN</h3>
								</div>
								<div style="display: inline-block; margin-left: 80px">
									<h3>WHO</h3>
								</div>
								<div style="display: inline-block; margin-left: 80px">
									<h3>WHAT</h3>
								</div>
							</div>
							<select id="when_temp"></select> <select id="who_temp"></select>
							<select id="what_temp"></select>

						</div>
						<div class="modal-footer">
							<button type="submit" id="categoryAble" class="btn btn-default">
								<span class="fa fa-check"></span><span id="categoryState">카테고리
									검색 비활성화</span>
							</button>
							<button type="submit" id="btn" class="btn btn-default"
								data-dismiss="modal">
								<span class="fa fa-check"></span> 확인
							</button>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div class="row"
			style="margin-left: 100px; margin-top: 25px; width: 1100px">
			<div
				style="margin: auto; width: 250px; margin-bottom: 3px; margin-left: 500px">
				<button id="view_when" type="button" class="btn btn-success">없음</button>
				<button id="view_who" type="button" class="btn btn-success">없음</button>
				<button id="view_what" type="button" class="btn btn-success">없음</button>
			</div>
			<div class="form-inline">
				<!-- Search Form __ Start -->
				<form:form id="form_search" method="POST"
					modelAttribute="pagination" action="/BucketTree/bucketList/mylist">

					<!-- 카테고리 선택 버튼 -->
					<button id="category" class="btn btn-success">카테고리</button>

					<!-- 검색 조건 선택 셀렉트 박스 -->
					<form:select path="srchType">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="제목" />
						<form:option value="2" label="제목+내용" />
						<form:option value="3" label="작성자" />
					</form:select>

					<!-- 검색 input 박스 -->
					<div class="input-group"
						style="width: 400px; display: inline-block">

						<form:input path="srchText" type="text" class="form-control"
							placeholder="Search..." style="height: 40px" />
					</div>
					<button type="submit" class="btn btn-success">검색</button>

					<c:if
						test="${ (pagination.srchType != 0)  ||  (pagination.categoryType != 0)}">
						<a href="/BucketTree/bucketList/list" class="btn btn-success">취소</a>
					</c:if>

					<!-- 선택된 카테고리 값 -->
					<form:input path="who" type="hidden" />
					<form:input path="when" type="hidden" />
					<form:input path="what" type="hidden" />
					<form:input path="categoryType" type="hidden" />
					<form:input path="currentPage" type="hidden" />

				</form:form>
			</div>
		</div>
	</div>
</div>

<div class="container" style="padding-top: 85px; padding-bottom: 5px">
		<div class="row" style="margin-left: 0px; margin-right: 0px">
			<div
				style="display: inline-block; margin-top: 10px; margin-bottom: 10px">
				<b>5 Completed BucketList<b> in 30 BucketList 
			</div>

			<!-- 친구 추천 버킷리스트 -->

			<div class="box box-default collapsed-box" style="width: 1140px">
				<div class="box-header withorder">
					<h3 class="box-title" style="margin-left: 860px">Recommends
						BUCKET</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-toggle="collapse" data-target="#collapseComment">
							<i class="fa fa-thumbs-o-up"></i>
						</button>
					</div>
				</div>
			</div>

			<!-- recommend-box-dropdown 추천 박스 라인 시작 -->

			<div class="collapse" id="collapseComment" >
				<section class="pinBoot">
	
							<div class="boxline" >
								<h4 style="margin-top: 50px">
									<b>친구 추천 버킷</b><i class="fa fa-hand-o-right"></i>
								</h4>
							</div>
							<c:forEach items="${recommendList}" var="RecommendVO" >
								<article class="recom-box" style="width: 260px; margin-left: 10px; display: inline-block">
									<%-- <img src="/BucketTree/list/${BucketListVO.getIdx()}/firstImage" alt="" style="width: 260px"> --%>
									<h4>
										<a href="#">${RecommendVO.title}</a>
									</h4>
								</article>
							</c:forEach>
					</section>
			</div>


			<!-- 관리자 추천 버킷 -->
			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title" style="margin-left: 880px">관리자 추천 버킷</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-toggle="collapse" data-target="#collapseAdmin">
							<i class="fa fa-thumbs-o-up"></i>
						</button>
					</div>
				</div>
			</div>

			<!-- recommend-box-dropdown 추천 박스 라인 시작 -->
			<div class="collapse" id="collapseAdmin">
				<div class="recommend recommend-box" style="height: 170px">
					<section class="bucketbox" style="dispaly: flex">


						<div class="boxline" style="display: inline-block">
							<h4 style="margin-top: 50px">
								<b>관리자 추천 버킷</b><i class="fa fa-hand-o-right"></i>
							</h4>
						</div>

						<c:forEach items="${adminRecommendList}" var="RecommendVO">
							<article class="recom-box" style="width: 260px; margin-left: 10px; display: inline-block">
								<%-- <img src="/BucketTree/list/${BucketListVO.getIdx()}/firstImage" alt="" style="width: 260px"> --%>
								<h4>
									<a href="#">${BucketListVO.title}</a>
								</h4>

							</article>
						</c:forEach>
					</section>
					</div>
				</div>
			</div>
			<!-- recommend-box-dropdown 추천 박스 라인 끝 -->
		</div>
	</div>
<!-- bucketList-MyList-Recommend-Box __ End -->

<section id="pinBoot" class="bucketbox"
	style="width: 1170px; margin: auto; margin-top: 10px">
	<article class="white-panel-add">
		<h4>
			<a href="/BucketTree/bucketList/bucketWrite" class="fa fa-plus" style="color: #fff; margin-left: 30px">
				버킷리스트 추가</a>
		</h4>
	</article>

	<c:forEach items="${mylist}" var="BucketListVO">
		<div class="white-panel" style="width: 260px"
			data-row="${BucketListVO.getRow()}">

			<img src="/BucketTree/list/${BucketListVO.getIdx()}/firstImage"
				alt="" style="width: 260px">
			<h4>
				<a href="#">${BucketListVO.title}</a>
			</h4>

			<button class="bucketOK pull-right" style="background: #48cfc8; width: 50px; height: 30px" type="submit">완료</button>
		</div>

	</c:forEach>

</section>
<hr>
<!-- bucketList-listAll __ End -->

<script>
	$(function() {

		//무한 스크롤
		$(window)
				.scroll(
						function() {
							if ($(window).scrollTop() >= $(document).height()
									- $(window).height()) {

								var lastrow = $(".white-panel:last").attr(
										"data-row");

								var str = '';
								$
										.ajax({
											url : "/BucketTree/bucketList/mylistAjax",
											dataType : "json",
											type : "POST",
											data : {
												row : lastrow
											},

											success : function(data) {
												if (data != "") {
													$(data)
															.each(

																	function() {

																		str += "<article class='white-panel' style='width: 260px' data-row='" +this.row+">"
																				+ "<img src= '/BucketTree/images/image7.jpg' style='width: 260px' >"
																				+ "<h4> <a href='#'>"
																				+ this.title
																				+ "</a> </h4>"
																				+ "<p style='width: 250px'>"
																				+ this.contents
																				+ "</p>"
																				+ "<button class='bucketOK pull-right' style='background: #48cfc8; width: 50px; height: 30px' type='submit'>완료</button>"

																		alert(str)
																	})
													$('.bucketbox').append(str);
												} else
													alert('더 이상 불러올 버킷리스트가 없습니다.')
											}
										});

							}
						});

		$(function() {
			//카테고리 옵션으로 값 뿌려주기
			<c:forEach items="${what}" var="what">
			$('#what_temp')
					.append(
							"<option value='${what.idx}' ${pagination.what==what.idx ? 'selected' : '' }> ${what.what} </option>");
			</c:forEach>
			<c:forEach items="${when}" var="when">
			$('#when_temp')
					.append(
							"<option value='${when.idx}' ${pagination.when==when.idx ? 'selected' : '' }> ${when.when} </option>");
			</c:forEach>
			<c:forEach items="${who}" var="who">
			$('#who_temp')
					.append(
							"<option value='${who.idx}' ${pagination.who==who.idx ? 'selected' : '' }> ${who.who} </option>");
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

	});
</script>