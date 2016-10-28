<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  BucketShare -->
<link href="/BucketTree/css/bucketShare.css" rel="stylesheet"
	type="text/css" />


<div class="container" style="padding-top: 50px; padding-bottom: 85px">

	<div class="box-group">
		<h3>
			<i class="fa fa-chevron-right"></i> 버킷쉐어 질문하기
		</h3>
		<hr>
		<form id="question_Create" method="post">
			<div class="x_panel">

				<div class="x_title">
					<div class="form-group">
						<input type="hidden" class="form-control" name="bucketList_idx">
						<a id="searchBucketList_button" class="btn btn-success">나의
							버킷리스트 지정</a>
						<div id=share_BucketList style="display: inline-block;"></div>
						<div class="form-inline f_right">
							<p type="button" class="btn btn-success">포인트</p>
							<select name="point" id="srchType">
								<option value="100">100</option>
								<option value="100">200</option>
								<option value="100">300</option>
								<option value="100">400</option>
								<option value="100">500</option>
							</select>
						</div>
					</div>
				</div>
				<div class="x_contents">
					<!-- 제목 -->
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							placeholder="Title">
					</div>
					<!--버킷리스트 지정-->
					<div class="form-group">
						<textarea id="body" name="contents" class="smarteditor2"
							style="width: 100%; height: 450px"></textarea>
					</div>
				</div>

			</div>
			<div class="f_right" style="margin-bottom: 10px;">
				<button type="submit" class="btn btn-success">
					<span class="fa fa-check"></span> 작성하기
				</button>
				<a href="/BucketTree/bucketShare/list" class="btn btn-default">
					<span class="fa fa-remove"></span> 취소하기
				</a>
			</div>
		</form>
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
						<table class="table jambo_table">
							<thead>
								<tr class="headings">
									<td>타이틀</td>
									<td>담아간수</td>
									<td>상태</td>
									<td>WHEN</td>
									<td>WHO</td>
									<td>WHAT</td>
								</tr>
							</thead>
							<c:forEach var="bucket" items="${ list }">
								<tbody>
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
								</tbody>
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
		var user_point = $
		{
			user.idx
		}
		;
		$("button[type=submit]").click(function() {
			$('#question_Create').submit();
		});
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
							"<button type='button' class='btn btn-default'>"
									+ bucketName + "</button>");
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-default'>"
									+ selectedTr.find("td:nth-child(4)").text()
									+ "</button>");
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-default'>"
									+ selectedTr.find("td:nth-child(5)").text()
									+ "</button>")
					$('#share_BucketList').append(
							"<button type='button' class='btn btn-default'>"
									+ selectedTr.find("td:nth-child(6)").text()
									+ "</button>")

				});
		$('#question_Create')
				.submit(
						function() {
							var point = 0;
							var value = $('input[name=title]').val();

							if (value == ""
									|| value == null
									|| value == undefined
									|| (value != null
											&& typeof value == "object" && !Object
											.keys(value).length)) {
								alert('제목을 입력하세요');
								return false;
							}
							value = $('input[name=bucketList_idx]').val();

							if (value == ""
									|| value == null
									|| value == undefined
									|| (value != null
											&& typeof value == "object" && !Object
											.keys(value).length)) {
								alert('버킷리스트를 지정하세요');
								return false;
							}
							$.ajax({
								url : "/BucketTree/bucketShare/userPoint",
								type : "GET",
								async : false,
								data : {
									idx : user_point
								},
								success : function(data) {
									point = data;

								},
								error : function(request, status, error) {
									alert("code:" + request.status + "\n"
											+ "message:" + request.responseText
											+ "\n" + "error:" + error);
								}
							});

							if (parseInt(point) < parseInt(value)) {
								alert('포인트가 부족합니다');
								return false;
							}

							return true;

						});

	});
</script>