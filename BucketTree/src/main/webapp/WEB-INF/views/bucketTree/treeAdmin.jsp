<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/BucketTree/se2/js/HuskyEZCreator.js"
	type="text/javascript"></script>

<!-- 해당 버킷 트리 프로필 수정 -->
<div class="container" style="padding-top: 50px; padding-bottom: 85px">
	<div class="row">
		<div class="col-md-12">
			<h3>
				<i class="fa fa-chevron-right"></i> 버킷트리 관리하기
			</h3>
			<hr>
			<div class="x_panel">
				<button class="btn btn-default f_right" title="삭제"
					onclick="location.href='/BucketTree/bucketTree/treeAdmin/${tree.idx}/delete.do'">
					<i class="fa fa-trash-o"></i> 트리 삭제
				</button>

				<form id="treeAdmin_Modify"
					action="/BucketTree/bucketTree/treeAdmin/modify.do" method="post">

					<div class="x_title">
						<h3>${tree.treeName}</h3>
					</div>



					<div class="row">
						<div class="col-md-4">
							<div class="form-inline" id="select">
								<p type="button" class="btn btn-success">인원증가</p>
								<select name="point" id="srchType">
									<option value="0">증원하지 않음</option>
									<option value="5">5명</option>
									<option value="10">10명</option>
									<option value="15">15명</option>
									<option value="20">20명</option>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<!-- 트리 - 전체공개 / 회원공개 -->
							<div class="radiobutton">
								<div class="checks small">
									<p class="btn btn-success">공개범위</p>
									<input type="radio" id="all" name="author" value="1"> <label
										for="all">전체공개</label> <input type="radio" id="member"
										name="author" value="0"> <label for="member">회원공개</label>
								</div>
							</div>

						</div>
					</div>

					<div class="x_content">
						<textarea id="body" name="body" class="smarteditor2">${tree.contents}</textarea>
					</div>

					<div class="f_right" style="margin:10px 10px;">
						<input type="hidden" name="idx" value="${tree.idx}">
						<button type="submit" class="btn btn-success">
							<span class="fa fa-check"></span> 수정하기
						</button>
						<a href="/BucketTree/bucketTree/detail?idx=${tree.idx}" class="btn btn-default">
							<span class="fa fa-remove"></span> 취소하기
						</a>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$(".bt-calltoaction").click(function() {
			location.href = $(this).attr("data-url");
		});

		$("input:radio[name='author']:radio[value='1']").attr('checked', true); // 원하는 값(Y)을 체크

		/* 수정 부분 제출 */
		$("button[type=submit]").click(function() {
			$('#treeAdmin_Modify').submit();
		});

		$("#select tr").click(function() {
			$("#searchResult srchType").removeClass("selected");
			$(this).addClass("selected");
		})

		$('#treeAdmin_Modify').submit(function() {
			var point = 0;
			var user_point = $
			{
				user.idx
			}
			;
			var value = $('textarea[name=contents]').val();
			if (parseInt(point) < parseInt(value)) {
				alert('포인트가 부족합니다');
				return false;
			}

			return true;

		});
	});
</script>