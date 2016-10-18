<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <meta charset="utf-8">
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services"></script>
<script src="/BucketTree/se2/js/HuskyEZCreator.js" type="text/javascript"></script>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="x_panel">
			<form action="/BucketTree/bucketList/edit.do"  method="post" enctype="multipart/form-data">
				<div class="right">
					<input type="submit" class="btn btn-default" value="수정완료">						
					<input type="hidden" name="idx" value="${bucket.idx}">
					<input type="hidden" id="positionX" name="x"  value="${bucket.x}">
					<input type="hidden" id="positionY" name="y"  value="${bucket.y}">
					<button type="button" class="btn btn-default" onclick="popupOpen()">장소지정</button>
				</div>
				<div class="x_title">
					<h2>${bucket.title}</h2>
				</div>
				<div class="x_title_m">
					<span class="post_writer">${bucket.name}</span> <span class="post_date">${bucket.date}</span>

					<div class="right">
					<!--버킷리스트 지정-->
					<div class="form-group">
						<input type="hidden" class="form-control" name="bucketList_idx">
						<div
							style="margin: auto; width: 500px; margin-bottom: 3px; margin-left: 750px">
							<button id="view_when" type="button" class="btn btn-success">없음</button>
							<button id="view_who" type="button" class="btn btn-success">없음</button>
							<button id="view_what" type="button" class="btn btn-success">없음</button>
							<button id="view_map" type="button" class="btn btn-success">없음</button>
						</div>
						<input type="hidden" id="positionX" name="x">
						<input type="hidden" id="positionY" name="y">
						<input id="who" name="who" type="hidden" value="${bucket.who}"/>
						<input id="when" name="when" type="hidden" value="${bucket.when}"/>
						<input id="what" name="what" type="hidden" value="${bucket.what}"/>
						<input id="writer" name="writer" type="hidden" value=0 />
						<input id="view_keyword" name="keyword" type="hidden" />
						<button id="category" class="btn btn-success" style="margin-left:0px">카테고리</button>
						<button type="button" class="btn btn-success" onclick="popupOpen()" style="height:40px">장소지정</button>
						<button class="btn btn-success" style="width:82px; height:40px" onclick="return false;">공개 범위</button>
						<select id="checkWriter" style="margin-left:0px; width:82px; height:32px" onchange="javascript:selectEvent(this)">
							<option value="0">전체 공개</option>
							<option value="1">친구 공개</option>
							<option value="2">나만 보기</option>
						</select>

						<div id=share_BucketList style="display: inline-block;"></div>
					</div>

					</div>

				</div>
				<div class="x_content">
					<textarea id="body" name="body" class="smarteditor2">${bucket.contents}</textarea>
				</div>
			</form>
			</div>
			
			
		</div>
	</div>
</div>

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

<!-- 지도 모달창 -->
<div id="popup" style="position:absolute;  visibility:hidden; height:535px; background-color:white; text-align:right">
	<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white" style="font-weight:100px; width:360px; text-align:left">
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
<span style="color:#48cfc8; margin-right:560px">마커나 검색 목록을 클릭하여 선택하세요</span>
<input type="button" onclick="resetMap()" class="btn btn-default" value="초기화"/>
<input type="button" class="btn btn-default" onclick="popupOpen()" value="확인" style="margin-left:5px">
</div>
<!-- 지도 모달창 종료 -->
<script>
	function selectEvent(selectObj) {
		$('#writer').val(selectObj.value); 
	}
	
	function showCategory(){
		$('#category').html('카테고리O');
		$('#categoryState').html('카테고리 검색 활성화');
		$('#view_when').show();
		$('#view_who').show();
		$('#view_what').show();
		$('#categoryType').val(1);
	}
	
	
	$(function() {
		$(".bs-calltoaction").click(function() { location.href = $(this).attr("data-url"); });
		
		
		
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
</script>
<script type="text/javascript"	src="/BucketTree/js/bucketList/bucketWrite.js"></script>
