<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services"></script>
<script src="/BucketTree/se2/js/HuskyEZCreator.js"
	type="text/javascript"></script>
<!-- 사이드 바 메뉴 -->
<div class="container">

	<div class="box-group" id="accordion" style="padding-top: 70px;">
		<h3>
			<i class="fa fa-chevron-right"></i> 버킷리스트 작성하기
		</h3>
		<hr>
		<div class="x_panel">
			<form name="formData" action="/BucketTree/bucketList/bucketCreate"
				method="post" enctype="multipart/form-data"
				onsubmit="formChk();return false;">
				<div class="x_title">
					<!--버킷리스트 지정-->
					<div class="row">
						<input type="hidden" class="form-control" name="bucketList_idx">
						<input type="hidden" id="positionX" name="x" value="0"> <input
							type="hidden" id="positionY" name="y" value="0"> <input
							id="who" name="who" type="hidden" value="1" /> <input id="when"
							name="when" type="hidden" value="1" /> <input id="what"
							name="what" type="hidden" value="1" /> <input id="writer"
							name="writer" type="hidden" value=0 /> <input id="view_keyword"
							name="keyword" type="hidden" value="" />

						<div class="col-md-4">
							<button id="category" class="btn btn-line">카테고리</button>

							<button id="view_when" type="button" class="btn btn-success">없음</button>
							<button id="view_who" type="button" class="btn btn-success">없음</button>
							<button id="view_what" type="button" class="btn btn-success">없음</button>

						</div>


						<div class="col-md-4">
							<button type="button" class="btn btn-line" onclick="popupOpen()">장소지정</button>
							<button id="view_map" type="button" class="btn btn-success">없음</button>
						</div>
						
						<div class="col-md-4">
							<button class="btn btn-line" onclick="return false;">공개범위</button>
							<select id="srch_type" 
								onchange="javascript:selectEvent(this)">
								<option value="0">전체 공개</option>
								<option value="1">친구 공개</option>
								<option value="2">나만 보기</option>
							</select>
						</div>

						<div id=share_BucketList style="display: inline-block;"></div>
					</div>
				</div>
				<div class="x_contents">
					<!-- 제목 -->
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							placeholder="Title" id="title">
					</div>

					<div class="form-group">
						<textarea id="body" name="contents" class="smarteditor2"
							style="width: 100%; height: 450px"></textarea>
					</div>
				</div>
			</form>
		</div>
		<div class="f_right">
			<button type="submit" class="btn btn-success">
				<span class="fa fa-check"></span> 작성하기
			</button>
			<a href="/BucketTree/bucketShare/list" class="btn btn-default"> <span
				class="fa fa-remove"></span> 취소하기
			</a>
		</div>
	</div>



</div>


<!-- 지도 모달창 -->
<div id="popup"
	style="position: absolute; visibility: hidden; height: 535px; background-color: white; text-align: right">
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

		<div id="menu_wrap" class="bg_white"
			style="font-weight: 100px; width: 360px; text-align: left">
			<div class="option">
				<div>
					<form onsubmit="searchPlaces(); return false;">
						키워드 : <input type="text" value="이태원 맛집" id="keyword" size="15">
						<button type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul id="placesList"></ul>
			<div id="pagination"></div>
		</div>
	</div>
	<span style="color: #48cfc8; margin-right: 560px">마커나 검색 목록을
		클릭하여 선택하세요</span> <input type="button" onclick="resetMap()"
		class="btn btn-default" value="초기화" /> <input type="button"
		class="btn btn-default" onclick="popupOpen()" value="확인"
		style="margin-left: 5px">
</div>
<!-- 지도 모달창 종료 -->
<!-- //팝업 레이어 -->
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
				<select id="when_temp"></select> <select id="who_temp"></select> <select
					id="what_temp"></select>


			</div>
			<div class="modal-footer">
				<button type="submit" id="btnCategory" class="btn btn-default"
					data-dismiss="modal" onclick="showCategory()">
					<span class="fa fa-check"></span> 확인
				</button>
			</div>
		</div>
	</div>
</div>

<script>
	function selectEvent(selectObj) {
		$('#writer').val(selectObj.value);
	}

	function showCategory() {
		$('#category').html('카테고리O');
		$('#categoryState').html('카테고리 검색 활성화');
		$('#view_when').show();
		$('#view_who').show();
		$('#view_what').show();
		$('#categoryType').val(1);
	}

	$(function() {
		$(".bs-calltoaction").click(function() {
			location.href = $(this).attr("data-url");
		});

		//카테고리 옵션으로 값뿌려주기
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

	});

	$('#view_map').hide();

	function formChk() {

		//	var inputTitle = $('#title').val();

		var contentChk = $("#body").val();
		var value = $('input[name=title]').val();
		//스마트 에디터 공백 체크 변수
		contentChk2 = contentChk.replace(/&nbsp;/gi, "");
		contentChk2 = contentChk2.replace(/<br>/gi, "");
		contentChk2 = contentChk2.replace(/ /gi, "");
		if (value == ""
				|| value == null
				|| value == undefined
				|| (value != null && typeof value == "object" && !Object
						.keys(value).length)) {
			alert('제목을 입력하세요');
			return false;

			// 스마트 에디터 공백체크
		} else if (contentChk2 == "<p><\/p>" || contentChk2 == "") {
			alert('내용을 입력하세요')
			return false;
		} else {

			$.ajax({

				url : "/BucketTree/bucketList/searchMylistTitle",
				dataType : "json",
				type : "POST",
				sync : false,
				data : {
					title : value
				},
				success : function(data) {

					if (true == data) {
						alert('이미 같은 이름의 버킷리스트가 있습니다');
						return false;
					} else {
						document.formData.submit();
						return true;
					}
				}
			})

		}
	};
</script>
<script type="text/javascript"
	src="/BucketTree/js/bucketList/bucketWrite.js"></script>