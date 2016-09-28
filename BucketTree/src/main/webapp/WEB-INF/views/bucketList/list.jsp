<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<div class="container">

	<div class="row">
		<!-- Search Form __ Start -->
		<div class="col-md-4 col-md-offset-5">
			<button id="view_when" type="button" class="btn btn-success">없음</button>
			<button id="view_who" type="button" class="btn btn-success">없음</button>
			<button id="view_what" type="button" class="btn btn-success">없음</button>
		</div>
		<form:form id="form_search" method="POST" modelAttribute="pagination"
			action="/BucketTree/bucketList/list">
			<div class="col-md-12">
				<div class="form-inline">
					<!-- Search Form __ Start -->
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

					<!-- 정렬 셀렉트 박스 -->
					<form:select path="orderType">
						<form:option value="1" label="최신순" />
						<form:option value="2" label="인기순" />
					</form:select>


				</div>
			</div>
		</form:form>
	</div>

	<!-- 버킷리스트 시작 -->
	<hr>
	<section id="pinBoot" class="bucketbox">
		<c:forEach items="${list}" var="BucketListVO">

			<article class="white-panel " style="width: 260px"
				data-row="${BucketListVO.getRow()}"
				data-idx="${BucketListVO.getIdx()}">

				<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do"><img
					src="/BucketTree/list/${BucketListVO.getIdx()}/firstImage" alt=""
					style="width: 260px" onclick=""></a>
				<h4>
					<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">${BucketListVO.title}</a>
				</h4>

				<form items="${countUp}" var="BucketListVO" role="form"
					method="post" style="display: flex">
					<div
						style="display: inline-block; padding-left: 180px; padding-right: 17px">${BucketListVO.count}</div>
					<div type="button" id="countUp" data_idx="${BucketListVO.getIdx()}"
						data_title="${BucketListVO.getTitle()}"
						data_when="${BucketListVO.getWhen()}"
						data_who="${BucketListVO.getWho()}"
						data_what="${BucketListVO.getWhat()}"
						style="background: transparent; border: none; display: inline-block">
						<img src="/BucketTree/images/bucket2.png"
							style="width: 40px; height: 40px">
					</div>
				</form>

			</article>
		</c:forEach>
	</section>
	<hr>

</div>

<!-- 버킷리스트 끝 -->

<!-- 카테고리 모달창 -->
<div class="modal fade" id="category_modal" role="dialog"
	style="z-index: 99999; position: fixed">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 15px 50px;">
				<!-- 종료버튼 -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<!-- 제목 -->
				<h4>
					<span class="fa fa-check-square-o"></span> 카테고리 선택하기
				</h4>
			</div>
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
				<select id="when_temp"></select> <select id="who_temp"></select> <select
					id="what_temp"></select>
			</div>
			<div class="modal-footer">
				<button type="submit" id="btn" class="btn btn-success"
					data-dismiss="modal">
					<span class="fa fa-check"></span> 확인
				</button>
				<button type="submit" id="categoryAble" class="btn btn-default">
					<span class="fa fa-check"></span><span id="categoryState">카테고리
						검색 비활성화</span>
				</button>

			</div>
		</div>
	</div>
</div>



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
											url : "/BucketTree/bucketList/BucketListAjax",
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

																		str += "<article class='white-panel' style='width: 260px' data-row='" +this.row+"'data-idx='"+this.idx+"'>"
																				+ "<a href='/BucketTree/bucketList/${BucketListVO.idx}/bucket.do'><img src= '/BucketTree/list/${BucketListVO.getIdx()}/firstImage' style='width: 260px' ></a>"
																				+ "<h4> <a href='/BucketTree/bucketList/${BucketListVO.idx}/bucket.do'>"
																				+ this.title
																				+ "</a> </h4>"
																				+ "<form items='${countUp}' var='BucketListVO' role='form'"
                                 							+ "method='post' style='display: flex'>"
																				+ "<div style='display: inline-block; padding-left: 180px; padding-right: 17px'>"
																				+ this.count
																				+ "</div>"
																				+ "<div type='button' id='countUp'"
                                 							+ "data_idx='"+this.idx+ "data_title='"+this.title+ "data_when='"+this.when+ "data_who='"+this.who+"data_what='"+this.what
                                 							+ "style='background: transparent; border: none; display: inline-block'>"
																				+ "<img src='/BucketTree/images/bucket2.png' style='width: 40px; height: 40px'></div></form></article>"
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
					$('#category').html('카테고리 X');
					$('#categoryState').html('카테고리 검색 비활성화');
					$('#view_when').hide();
					$('#view_who').hide();
					$('#view_what').hide();
					$('#categoryType').val(0);
				} else {
					$('#category').html('카테고리 O');
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

		$(document).on('click', '#countUp', function() {
			var evnetTarget = this;
			var eventIdx = $(this).attr('data_idx');
			var eventTitle = $(this).attr('data_title');
			var eventWhen = $(this).attr('data_when');
			var eventWho = $(this).attr('data_who');
			var eventWhat = $(this).attr('data_what');

			alert('마이 버킷리스트에도 추가되었습니다!')
			location.reload(); 
			
			$.ajax({
				url : "/BucketTree/bucketList/countUp",
				dataType : "json",
				type : "POST",
				data : {
					idx : eventIdx,
					title : eventTitle,
					when : eventWhen,
					who : eventWho,
					what : eventWhat
				}
			
			/* success : function(data) {
			if(data)
			 //$("#bucketBox").append(data);
			                     } */
			});
		});

	});
</script>