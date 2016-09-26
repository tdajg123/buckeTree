<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />

<!-- 사이드 바 메뉴 -->
<div class="container" style="padding-top: 110px; padding-bottom: 85px">
	<!-- Menu -->
	<div class="side-menu" style="left: 100px; width: 200px; height: 200px">

		<nav class="navbar navbar-default" role="navigation"
			style="width: 200px">

			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">

					<li><a href="/BucketTree/bucketShare/list"><span
							class="glyphicon glyphicon-user"></span> 전체질문</a></li>
					<li><a href="/BucketTree/bucketShare/mylist"><span
							class="glyphicon glyphicon-user"></span> 내가 쓴 질문</a></li>
					<li><a href="/BucketTree/bucketShare/myAnswerlist"><span
							class="glyphicon glyphicon-user"></span> 내가 쓴 답변</a></li>
					<li><a href="/BucketTree/bucketShare/create"><span
							class="glyphicon glyphicon-user"></span> 질문하기</a></li>
				</ul>
			</div>

		</nav>

	</div>

	<div class="box-group" id="accordion"
		style="height: 500px; width: 1200px; padding-top: 100px;">
		<div class="panel box box-primary">
			<c:if test="${ question.state == 0 && question.user_idx==user.idx }">
				<div class="left">
				<a href="/BucketTree/bucketShare/edit?idx=${question.idx}"  class="btn btn-success">수정</a>
				<a href="/BucketTree/bucketShare/delete?idx=${question.idx}" class="btn btn-success">삭제</a>
				</div>
			</c:if>
			<div class="box-header with-border">
				<h4 class="box-title" style="font-size: 35px">
					<a> ${question.title} </a>
				</h4>
			
			</div>
			<div
				style="margin: auto; width: 250px; margin-bottom: 3px; margin-left: 820px">
				${question.bucketListName}
				<button id="view_when" type="button" class="btn btn-success">${question.when}</button>
				<button id="view_who" type="button" class="btn btn-success">${question.who}</button>
				<button id="view_what" type="button" class="btn btn-success">${question.what}</button>
			</div>
			<div class="writer"
				style="font-size: 16px; margin-left: 820px; margin-top: 15px">작성자
				: ${question.name}</div>

			<div class="time"
				style="font-size: 13px; margin-left: 822px; margin-bottom: 20px">${question.date}</div>

			<div id="collapseOne" class="panel-collapse collapse in"
				style="height: 300px">
				<div class="box-body" style="font-size: 20px">
					${question.contents}</div>
			</div>
		</div>
	</div>

	<!-- ##답글__ 시작## -->
	<div id="answer" class="collapse navbar-collapse">
		<div class="navbar-custom-comments">

			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title">Comments</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-toggle="collapse" data-target="#collapseComment">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="collapse" id="collapseComment">

					<c:forEach var="answer" items="${ answer }">
						<div class="comments-row" style="height: 150px">
							<!-- 답글 쓴 사람 이미지와 이름 -->
							<div class="col-xs-2 col-md-1"
								style="padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px">
								<img src="/BucketTree/images/user1-128x128.jpg"
									class="img-circle img-responsive" alt=""
									style="padding-top: 6px" />
								<div style="padding-top: 5px">${ answer.user_Name }</div>

							</div>
							<!-- 답글 부분 -->
							<div class="col-xs-10 col-md-11"
								style="width: 700px; padding-top: 10px">
								<div>
									<h4 style="padding-top: 10px">${ answer.contents }</h4>
								</div>
								<div class="modify">
									<form method="post"
										action="/BucketTree/bucketShare/answerModify">
										<div class="img-push">
											<div class="input-group">
												<input type="hidden" name="bucketShare_Question_idx"
													value="${answer.bucketShare_Question_idx}"> <input
													type="hidden" name="idx" value="${answer.idx}"> <input
													name="contents" type="text" class="form-control"> <span
													class="input-group-btn">
													<button type="submit" class="btn btn-default">확인</button>
													<button type="reset" class="btn btn-default modifyCancel">취소</button>
												</span>
											</div>
										</div>
									</form>
								</div>
								<div>${ answer.date }</div>
								<div>
									<!-- 답변 작성자만 수정하고, 삭제 할수있음 -->
									<c:if test="${ answer.user_idx ==user.idx && answer.state==0 }">
										<button type="button" class="btn btn-success modifyButton">수정</button>
										<a
											href="/BucketTree/bucketShare/answerDelete?idx=${answer.idx}"
											type="button" class="btn btn-success">삭제</a>
									</c:if>
									<!-- 질문작성자이면서, 댓글작성자가 질문작성자가 아닐때만 채택할 수있음 -->
									<c:if
										test="${ question.user_idx ==user.idx && answer.user_idx != user.idx && question.state==0}">
										<a
											href="/BucketTree/bucketShare/answerAdopt?idx=${answer.idx}"
											type="button" class="btn btn-success">채택</a>
									</c:if>
									<c:if test="${ answer.state == 1 }">
										<button type="button" class="btn btn-success">채택된 답변</button>
									</c:if>
								</div>
							</div>
							<!-- 수정 , 삭제 -->
						</div>
					</c:forEach>
					<!-- 답글 등록 버튼 -->
					<div class="box-footer">
						<form method="post" action="/BucketTree/bucketShare/answerInsert">
							<div class="img-push">
								<div class="input-group">
									<input type="hidden" name="idx" value="${question.idx}">
									<input name="contents" type="text" class="form-control">
									<span class="input-group-btn">
										<button type="submit" class="btn btn-default">등록</button>
									</span>
								</div>
							</div>
						</form>
					</div>
					<!-- /.box-footer -->
				</div>

			</div>

			<!-- /댓글 부분 -->

		</div>
	</div>

</div>
<script>
	$('.btn-box-tool').click();

	$('.modifyButton').click(function() {

		$(this).parent().parent().children(".modify").addClass("modifyShow");
	})
	$('.modifyCancel').click(function() {

		$('.modify').removeClass("modifyShow");
	})
</script>
