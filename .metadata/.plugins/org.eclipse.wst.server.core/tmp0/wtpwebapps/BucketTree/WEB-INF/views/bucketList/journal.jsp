<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	//짝수번째 li는 오른쪽으로 보이기
	$(function() {
		$("ul.timeline>li:nth-child(even)").addClass('timeline-inverted');
	});
</script>

<div class="container">
	<div class="page-header">
		<h1 id="timeline">이탈리아 베네치아로 여행가기</h1>
	</div>
	<ul class="timeline">
		<!-- 일지쓰기 부분 -->
		<li class="timeline-add">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading" id="journal_create">
					<p>
						<i class="fa fa-plus"></i>일지쓰기
					</p>
				</div>
			</div>
		</li>

		<!-- 일지 부분 -->
		<c:forEach items="${list}" var="BucketJournalVO">
			<li><input type="hidden" value="${BucketJournalVO.bucket_idx }"
				id="bucket_idx">
				<div class="timeline-badge"></div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<h4 class="timeline-title">${BucketJournalVO.title }</h4>
						<p>
							<small class="text-muted  f_right"><i
								class="glyphicon glyphicon-time"></i> ${BucketJournalVO.date} </small>
						</p>
					</div>
					<div class="timeline-body">
						<span> ${BucketJournalVO.contents} </span>
					</div>
					<hr />
					<div class="timeline-footer">
						<button class="btn btn-default" title="수정"
							data-idx="${BucketJournalVO.idx}">
							<i class="fa fa-pencil"></i>
						</button>
						<a class="btn btn-default" title="삭제"
							data-idx="${BucketJournalVO.idx}"> <i class="fa fa-trash-o"></i>
						</a>
					</div>
				</div></li>
		</c:forEach>
	</ul>
</div>

<!-- 새로 작성하는 modal -->
<div class="modal fade" id="journal_create_modal" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<form method="post">
				<div class="modal-header" style="padding: 15px 50px;">
					<!-- 종료버튼 -->
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4>
						<span class="fa fa-pencil"></span> 버킷리스트
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							id="journal_title" placeholder="Title">
					</div>
					<div class="form-group">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right"
								id="journal_date" name="date" placeholder="Date">
						</div>
					</div>
					<div class="form-group">
						<textarea id="body" name="body" class="smarteditor2"
							style="width: 100%;"></textarea>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						id="journal_c_submit">
						<span class="fa fa-check"></span> 작성하기
					</button>
					<button type="reset" class="btn btn-default" data-dismiss="modal">
						<span class="fa fa-remove"></span> 취소하기
					</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- 수정하는  modal -->
<div class="modal fade" id="journal_modify_modal" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<form>
				<div class="modal-header" style="padding: 15px 50px;">
					<!-- 종료버튼 -->
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4>
						<span class="fa fa-pencil"></span> 버킷리스트 수정하기
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<input type="hidden" id="idx2"> <input type="hidden"
						id="bucket_idx2">
					<div class="form-group">
						<input type="text" class="form-control" name="title"
							id="journal_title2">
					</div>
					<div class="form-group">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right"
								id="journal_date2" name="date">
						</div>
					</div>
					<div class="form-group" id="textarea">
						<textarea id="body2" name="body2" class="smarteditor2"
							style="width: 100%;"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal"
						id="journal_m_submit">
						<span class="fa fa-check"></span> 수정하기
					</button>
					<button type="reset" class="btn btn-default" data-dismiss="modal">
						<span class="fa fa-remove"></span> 취소하기
					</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
	/*-- 일지 생성 --*/

	//버킷작성 모달 
	$("#journal_create").click(function() {
		$('#journal_create_modal').modal();
	});

	// 저장하기 버튼 누르면 작성된 일지 저장됨
	$('#journal_c_submit').click(function() {
		var contents = oEditors.getById['body'].getIR();
		var param = window.location.search;
		param = param.replace(/[^0-9]/g, "");
		$.ajax({
			url : "/BucketTree/bucketList/journal/createAjax",
			dataType : "json",
			type : "POST",
			data : {
				bucket_idx : param,
				title : $('#journal_title').val(),
				contents : contents,
				date : $('#journal_date').val()
			},
			success : function() {
				window.location.reload(true);
			}
		});
	});

	/*-- 일지 수정 --*/

	$(function() {

		var modify_modal = $('#journal_modify_modal');

		// 수정 버튼 누르면 저장된 일지 내용 가져옴
		$(".timeline-footer>button").click(function() {
			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketList/journal/modifyAjax?idx=" + idx,
				dataType : "json",
				type : "GET",
				success : function(data) {

					modify_modal.find('#idx2').val(data.idx);
					modify_modal.find('#bucket_idx2').val(data.bucket_idx);
					modify_modal.find('#journal_title2').val(data.title);
					modify_modal.find('#journal_date2').val(data.date);

					htmlData = '<span>' + data.contents + '</span>';
					oEditors.getById['body2'].exec("PASTE_HTML", [ htmlData ]);

					modify_modal.modal('show');

				}
			});
		});

		// 수정하기 버튼 누르면 일지 업데이트됨
		$('#journal_m_submit').click(function() {
			var contents = oEditors.getById['body2'].getIR();
			$.ajax({
				url : "/BucketTree/bucketList/journal/modifyAjax",
				dataType : "json",
				type : "POST",
				data : {
					idx : $('#idx2').val(),
					bucket_idx : $('#bucket_idx2').val(),
					title : $('#journal_title2').val(),
					contents : contents,
					date : $('#journal_date2').val()
				},
				success : function() {
					window.location.reload(true);
				}
			});
		});

		/*-- 일지 삭제 --*/
		$(".timeline-footer>a").click(function() {
			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketList/journal/deleteAjax?idx=" + idx,
				dataType : "json",
				type : "GET",
				success : function() {
					window.location.reload(true);
				}
			});
		});
	});
</script>
