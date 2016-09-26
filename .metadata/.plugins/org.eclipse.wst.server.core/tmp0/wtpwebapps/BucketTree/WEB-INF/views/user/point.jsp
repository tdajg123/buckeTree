<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<div class="container">
	<div class="login-signup">
		<!-- 포인트 적립 & 사용 탭 -->
		<div class="row">
			<div class="col-sm-6 nav-tab-holder" style= "margin-left :270px; margin-bottom :40px; margin-top: 50px">
				<ul class="nav nav-tabs row" role="tablist">
					<li role="presentation" class="active col-sm-6"><a
						href="#home" aria-controls="home" role="tab" data-toggle="tab">PLUS</a></li>
					<li role="presentation" class="col-sm-6"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab">MINUS</a></li>
				</ul>
			</div>
		</div>
		<!-- 포인트 적립 내역 시작 -->
		<div class="tab-content" >
			<div role="tabpanel" class="tab-pane active" id="home">
				<div class="row">
					<article role="login">
						<h2 class="text-center" >
							<i class="fa fa-plus-circle"></i>   포인트 적립
						</h2>

						<div class="container">
							<div class="row col-md-6 col-md-offset-2 custyle">

								<table class="table table-striped custab" style= "margin-top: 50px">
									<thead>
										<tr>
											<th>적립 일자</th>
											<th>적립 내역</th>
											<th>적립된 포인트</th>
										</tr>
									</thead>
									<c:forEach items="${plusPoint}" var="PointVO">
										<tr>
											<td>${PointVO.date}</td>
											<td>${PointVO.contents}</td>
											<td>${PointVO.point}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>

					</article>
				</div>
				<!-- end of row -->
			</div>
			<!-- end of home -->
			<!-- 포인트 사용 내역 시작 -->
			<div role="tabpanel" class="tab-pane" id="profile">
				<div class="row">
					<article role="login">
						<h2 class="text-center" >
							<i class="fa fa-minus-circle"></i>   포인트 사용
						</h2>

						<div class="container">
							<div class="row col-md-6 col-md-offset-2 custyle">

								<table class="table table-striped custab" style= "margin-top: 50px">
									<thead>
										<tr>
											<th>사용 일자</th>
											<th>사용 내역</th>
											<th>사용한 포인트</th>
										</tr>
									</thead>
									<c:forEach items="${minusPoint}" var="PointVO">
										<tr>
											<td>${PointVO.date}</td>
											<td>${PointVO.contents}</td>
											<td>${PointVO.point}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>

					</article>
				</div>
			</div>
		</div>
	</div>
</div>
