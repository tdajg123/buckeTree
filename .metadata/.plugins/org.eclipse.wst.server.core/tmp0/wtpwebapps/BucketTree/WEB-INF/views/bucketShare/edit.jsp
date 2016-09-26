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
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							질문하기</a></li>

				</ul>
			</div>

		</nav>

	</div>



	<div class="box-group" id="accordion"
		style="height: 900px; width: 1200px; padding-top: 100px;">
		<div class="panel box box-primary">
			<form:form method="post" modelAttribute="question" id="question_Edit">
				<div class="modal-header" style="padding: 15px 50px;">

					<!-- 제목 -->
					<h4>
						<span class="fa fa-pencil"></span> 버킷쉐어
					</h4>
				</div>
				<div class="modal-body" style="height: 700px; padding: 40px 50px;">
					<!-- 제목 -->
					<div class="form-group">
						<h1>${question.title}</h1>
					</div>
					<!--버킷리스트 지정-->
					<div class="form-group">
						<form:input path="bucketList_idx" type="hidden" />
						<a id="searchBucketList_button" class="btn btn-success">나의
							버킷리스트 지정</a>
						<div id=share_BucketList style="display: inline-block;">
							<button type='button' class='btn btn-success'>${question.bucketListName}
							</button>
							<button type='button' class='btn btn-success'>${question.when}
							</button>
							<button type='button' class='btn btn-success'>${question.who}
							</button>
							<button type='button' class='btn btn-success'>${question.what}
							</button>
						</div>
						<div style="display: inline-block; margin-left: 300px">
							<button type="button" class="btn btn-success">포인트</button>
							<span>${question.point}</span>
						</div>
					</div>


					<div class="form-group">
						<form:textarea path="contents" class="smarteditor2"
							style="width: 100%; height: 450px" />

					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success">
						<span class="fa fa-check"></span> 작성하기
					</button>
					<a href="/BucketTree/bucketShare/list" class="btn btn-default">
						<span class="fa fa-remove"></span> 취소하기
					</a>
				</div>
			</form:form>
		</div>
	</div>



</div>

<!-- 수정하는  modal -->
<div class="modal fade" id="searchBucketList" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">

			<div class="modal-header" style="padding: 15px 50px;">
				<!-- 종료버튼 -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<!-- 제목 -->
				<h4>
					<span class="fa fa-pencil"></span> 나의 버킷리스트 목록
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">

				<div id="searchResult">
					<c:if test="${ list.size() > 0 }">
						<table class="table table-bordered">
							<tr>
								<td>타이틀</td>
								<td>담아간수</td>
								<td>상태</td>
								<td>WHEN</td>
								<td>WHO</td>
								<td>WHAT</td>
							</tr>
							<c:forEach var="bucket" items="${ list }">
								<tr data-id="${ bucket.idx }">
									<td>${ bucket.title }</td>
									<td>${ bucket.count }</td>
									<td><c:if test="${ bucket.state == 1 }">
										진행중
										</c:if> <c:if test="${ bucket.state == 0 }">
										완료
										</c:if></td>
									<td>${ bucket.when_name }</td>
									<td>${ bucket.who_name }</td>
									<td>${ bucket.what_name }</td>
								</tr>
							</c:forEach>

						</table>
					</c:if>

				</div>
			</div>
			<div class="modal-footer">
				<button id="BucketSelect" type="button" class="btn btn-success"
					data-dismiss="modal">
					<span class="fa fa-check"></span> 선택
				</button>
				<button type="reset" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-remove"></span> 닫기
				</button>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {

		$("#searchBucketList_button").click(function() {

			$('#searchBucketList').modal();
		});

		$("#searchResult tr").click(function() {
			$("#searchResult tr").removeClass("selected");
			$(this).addClass("selected");
		})

		$('#BucketSelect').click(
				function() {
					$('#share_BucketList').empty();
					var selectedTr = $("#searchResult tr.selected");
					var idx = selectedTr.attr("data-id");
					$('input[name=bucketList_idx]').val(idx);
					var bucketName = selectedTr.find("td:nth-child(1)").text();
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-success'>"
									+ bucketName + "</button>");
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-success'>"
									+ selectedTr.find("td:nth-child(4)").text()
									+ "</button>");
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-success'>"
									+ selectedTr.find("td:nth-child(5)").text()
									+ "</button>")
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-success'>"
									+ selectedTr.find("td:nth-child(6)").text()
									+ "</button>")

				});
		

	});
</script>