<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>

	<!-- bucketList-listAll __ Start -->

	<div class="container" style="padding-top: 85px; padding-bottom: 5px">
		<div class="row" style=" margin-left: 0px; margin-right: 0px">

			<!-- Search Form __ Start -->
			<form action="#" method="get" class="sidebar-form"
				style="margin-left: 300px; display: flex;">
				<div id="dd" class="wrapper-dropdown-3"
					style="margin-left: 0px; margin-right: 0px; width: 120px; height: 40px; display: inline-block">
					<span>검색 타입</span>
					<ul class="dropdown" style="z-index: 99999">
						<li><a href="#">작성자 </a></li>
						<li><a href="#">제목</a></li>
						<li><a href="#">없음</a></li>
					</ul>
				</div>

				<div class="input-group"
					style="width: 400px; margin-left: 0px; display: inline-block">

					<input type="text" name="q" class="form-control"
						placeholder="Search..." style="height: 40px"> <span
						class="input-group-btn" style="width: 40px; displqy: inline">

						<!-- <button type="submit" name="search" id="search-btn"
						style="top: 0px;" class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button> -->
					</span>
				</div>
			</form>

			<div>
				<div
					style="display: inline-block; margin-top: 10px; margin-bottom: 10px">
					<b>5 Completed BucketList<b> in 30 BucketList 
				</div>
			</div>

			<!-- ./Search Form __ End -->
			<!-- bucketList-Category & Type & Search __ End -->


			<!-- bucketList-MyList-Recommend-Box __ Start -->

			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title" style="margin-left: 880px">Recommends
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
			<div class="collapse" id="collapseComment">
				<div class="recommend recommend-box" style="height: 170px">
					<div class="dropdown-box" style="display: flex">

						<div class="boxline">
							<h4 style="margin-top: 50px">
								<b>친구 추천 버킷</b><i class="fa fa-hand-o-right"></i>
							</h4>
						</div>

						<c:forEach items="${recommendList}" var="RecommendVO">
							<div class="recom-box">
								<p>TITLE : ${RecommendVO.title}</p>
								<p>CONTENTS : ${RecommendVO.contents}</p>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
			<!-- recommend-box-dropdown 추천 박스 라인 끝 -->
		</div>
	</div>
	<!-- bucketList-MyList-Recommend-Box __ End -->

	<section id="pinBoot"
		style="width: 1170px; margin: auto; margin-top: 10px">
		<article class="white-panel-add">
			<h4>
				<a href="#" class="fa fa-plus" style="color: #fff; margin-left: 30px"> 버킷리스트 추가</a>
			</h4>
		</article>

		<c:forEach items="${mylist}" var="BucketListVO">
			<article class="white-panel" style="width: 260px" href="#">

				<img src="/BucketTree/images/image7.jpg" alt="" style="width: 260px">
				<h4>
					<a href="#">${BucketListVO.title}</a>
				</h4>
				<p style="width: 250px">${BucketListVO.contents}</p>
			</article>
		</c:forEach>

	</section>
	<hr>
	<!-- bucketList-listAll __ End -->

</body>
</html>