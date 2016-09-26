<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<script src="//code.jquery.com/jquery.min.js"></script>
    <meta charset="utf-8">

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services"></script>
<script src="/BucketTree/se2/js/HuskyEZCreator.js" type="text/javascript"></script>
<script src="/BucketTree/se2/init.js" type="text/javascript"></script>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<form action="/BucketTree/bucketList/bucketCreate" method="post" enctype="multipart/form-data">
			<div class="x_panel">
				<div class="x_title_m">
					<div class="right">
						<button type="submit" class="btn btn-success">작성하기</button>
						<button type="submit" class="btn btn-default">취소하기</button>
						<button type="button" class="btn btn-default" onclick="popupOpen()">장소지정</button>
					</div>
				</div>
				<div class="x_title">
					<input type="text" id="title" class="form-control"
						placeholder="버킷리스트 타이틀을 입력해주세요." name="title">
				</div>
				<textarea id="body" name="body" class="smarteditor2"></textarea>
				<input type="hidden" id="positionX" name="x">
				<input type="hidden" id="positionY" name="y">
			</div>
			</form>
		</div>
	</div>

</div>
<!-- 팝업 레이어 -->
<div id="popup" style="position:absolute;  visibility:hidden; height:535px; background-color:white";>
	<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white" style="font-weight:100px;">
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
<h1 style="margin-top:5px">현재 선택한 장소 : <input type="text" readOnly="readOnly" id="title2"> <span style="text-align:right">마커나 검색 목록을 클릭하여 선택하세요</span></h1>
</div>
<!-- //팝업 레이어 -->
<script type="text/javascript"	src="/BucketTree/js/bucketList/bucketWrite.js"></script>
	