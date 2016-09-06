<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<!-- bucketList-listAll __ Start -->

	<div class="container" style="padding-top: 110px; padding-bottom: 85px">
		<div class="row"
			style="margin-left: 0px; margin-right: 0px; width: 1100px">

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
						<!-- <i class="fa fa-search" style= "width: 40px; height: 40px"></i> -->
						<!-- <button type="submit" name="search" id="search-btn"
						style="top: 0px;" class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button> -->
					</span>
				</div>

			</form>

			<div pull-right style="margin-left: 980px; margin-top: 10px; display: flex">
				<form role="form" method="post">

					<div style="display: inline-block">
						<button type="submit" style= "background: transparent; color: #0094d6; border: none">인기순</button>
					</div>
				</form>
				<div style="display: inline-block; margin-left: 10px">
					<button style= "background: transparent; color: #0094d6; border: none"><a href="list">최신순</a></button>
				</div>
			</div>

			<!-- ./Search Form __ End -->

			<!-- bucketList-Category & Type & Search __ End -->
			<hr>
			<section id="pinBoot">
			
				<c:forEach items="${list}" var="BucketListVO">
					<article class="white-panel" style="width: 260px" href="#">

						<img src="/BucketTree/images/image7.jpg" alt=""
							style="width: 260px">
						<h4>
							<a href="#">${BucketListVO.title}</a>
							<form role="form" method="post">
								<button
									style="background: transparent; border: none; margin-left: 200px">
									<img src="/BucketTree/images/bucketicon.png"
										style="width: 40px; height: 40px">
								</button>
							</form>
						</h4>
						<p style="width: 250px">${BucketListVO.contents}</p>
						
					</article>

					<!-- ## 버킷리스트 작성 완료 후 이미지 등록 되면 이 article은 지울 것. 크기 맞추기 위해 임의로 넣어둠 ##-->
					<article class="white-panel" style="width: 260px">

						<img src="/BucketTree/images/image4.jpg" alt=""
							style="width: 260px">
						<h4>
							<a href="#">${BucketListVO.title}</a>
						</h4>
						<p style="width: 250px">${BucketListVO.contents}</p>
					</article>
					<!-- #### -->
				</c:forEach>

			</section>

			<hr>
		</div>
	</div>

	<!-- bucketList-listAll __ End -->
</body>
</html>