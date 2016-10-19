<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
input[type=checkbox]:checked {
	border: 1px solid gray;
}

#modifyComment:hover {
	color: #48cfc8;
}
</style>

<script>
	//짝수번째 li는 오른쪽으로 보이기
	$(function() {
		$("ul.timeline>li:nth-child(even)").addClass('timeline-inverted');
	});
</script>
<!-- 트리장만 볼 수 있는 관리 메뉴 탭 -->
<div class="side-menu" style="left: 100px; width: 200px; height: 200px">

	<nav class="navbar navbar-default" role="navigation"
		style="width: 200px">

		<!-- Main Menu -->
		<div class="side-menu-container">

			<%-- <c if --%>
			<ul class="nav navbar-nav">

				<li><a href="/BucketTree/bucketTree/treeAdmin"> 트리관리 <span
						class="fa fa-angle-right f_right"></span></a></li>
				<li><a href="/BucketTree/bucketTree/memberAdmin">회원관리 <span
						class="fa fa-angle-right f_right"></span></a></li>
			</ul>
		</div>
	</nav>
</div>

<!-- 댓글부분 수정해야함 -->
<div class="container">

	<div class="page-header">
		<h1 id="timeline">${vo.treeName}</h1>
	</div>
	<ul class="timeline">
		<li class="timeline-add">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading" id="tree_add">
					<p>
						<i class="fa fa-plus"></i> 글쓰기
					</p>
				</div>
			</div>
		</li>

		<!-- 미션 -->
		<c:forEach var="no" items="${notice}">
			<li class="timeline-inverted">
				<div class="timeline-badge timeline-mission"></div>
				<div class="timeline-panel timeline-mission">
					<div class="timeline-heading">
						<h2>MISSION!</h2>
						<p class="f_right">

							<small class="text-muted"><i
								class="glyphicon glyphicon-time"></i> ${no.date}</small>
						</p>
					</div>
					<div class="timeline-body">
						<p>${no.contents}</p>
					</div>
					<hr>
					<div class="timeline-footer">
						<div class="f_right">
							<button class="btn btn-default" title="수정" data-idx="${no.idx}">
								<i class="fa fa-pencil"></i>
							</button>
							<a class="btn btn-default" title="삭제" data-idx="${no.idx}"> <i
								class="fa fa-trash-o"></i>
							</a>
						</div>
					</div>
					<div class="right">
						<a class="btn btn-default" title="수정" data-toggle="collapse"
							data-target="#collapseComment${no.idx}">Comments <i
							class="fa fa-commenting-o"></i>
						</a>
					</div>
					<!-- comment -->
					<div class="timeline-footer">
						<div class="collapse" id="collapseComment${no.idx}">
							<div class="box-footer box-comments">

								<c:forEach var="c" items="${ no.comment}">
									<div class="box-comment">
										<!-- User image -->

										<div class="comment-text">
											<span class="username"> ${c.userName} <span
												class="text-muted pull-right post_date">${c.date} </span>
											</span>
											<!-- /.username -->
											${c.contents}
										</div>
										<!-- /.comment-text -->
									</div>
								</c:forEach>

								<!-- /.box-comment -->
							</div>
							<!-- /.box-footer -->
							<div class="box-footer">
								<form action="#" method="post">
									<div class="img-push"
										style="display: inline-block; width: 90%;">
										<input type="text" name="comment_contents"
											class="form-control input-sm" placeholder="...">

									</div>
									<button class="btn btn-default" name=comment
										data-idx="${vo.idx}">
										<i class="fa fa-check"></i>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</li>
		</c:forEach>
		<!-- /미션 -->


		<c:forEach var="vo" items="${ list }">
			<li>
				<div class="timeline-badge"></div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<p class="f_right">
							<small class="text-muted"><i
								class="glyphicon glyphicon-time"></i>${vo.date} </small>
						</p>
					</div>
					<div class="timeline-body">
						<p>${vo.contents}</p>
					</div>
					<hr>
					<div class="timeline-footer">
						<c:if test="${vo.user_idx eq user.idx}">
						<div class="f_right">
							<button class="btn btn-default" title="수정" data-idx="${vo.idx}">
								<i class="fa fa-pencil"></i>
							</button>
							<a class="btn btn-default" title="삭제" data-idx="${vo.idx}"> <i
								class="fa fa-trash-o"></i>
							</a>
						</div>
						</c:if>
					</div>

					<div class="right">
						<a class="btn btn-default" title="수정" data-toggle="collapse"
							data-target="#collapseComment${vo.idx}">Comments <i
							class="fa fa-commenting-o"></i>
						</a>
					</div>
					<!-- comment -->
					<div class="timeline-footer">
						<div class="collapse" id="collapseComment${vo.idx}">
							<div class="box-footer box-comments">

								<c:forEach var="c" items="${ vo.comment}">
									<div class="box-comment">
										<!-- User image -->

										<div class="comment-text">
											<span class="text-muted"> ${c.userName}</span>
											

												<div class="f_right">
													<span class="text-muted post_date">${c.date} </span> 
													<c:if test="${c.user_idx eq user.idx}"><span
														class="text-muted" id="modifyComment" data-idx="${c.idx}">수정
													</span> <a data-idx="${c.idx}" id="deleteComment" title="삭제"
														class="text-muted">삭제</a></c:if>
												</div>
											
											<!-- /.username -->
											<div>${c.contents}</div>
											<div class="modify">

												<div class="img-push">
													<div class="input-group">
														<input name="contents_modify" type="text"
															class="form-control" value="${c.contents}"> <span
															class="input-group-btn">
															<button type="submit" class="btn btn-default"
																id="commentModify" data-idx="${c.idx}">확인</button>
															<button type="reset" class="btn btn-default modifyCancel">취소</button>
														</span>
													</div>
												</div>

											</div>
										</div>
										<!-- /.comment-text -->
									</div>
								</c:forEach>

							</div>
							<!-- /.box-footer -->
							<div class="box-footer">
								<form action="#" method="get">
									<div class="input-group">
										<input type="text" name="comment_contents"
											class="form-control"> <span class="input-group-btn">
											<button class="btn btn-default" name="comment"
												data-idx="${vo.idx}">등록</button>
										</span>
									</div>
								</form>
							</div>

						</div>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>

<!-- 새로 작성하는 modal -->
<div class="modal fade" id="group_timeLine" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<form method="post" action="/BucketTree/bucketTree/write">
				<div class="modal-header" style="padding: 15px 50px;">
					<!-- 종료버튼 -->
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<!-- 제목 -->
					<h4>
						<span class="fa fa-pencil"></span> 버킷트리 글쓰기
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">

					<div class="form-group">

						<span>공지사항 </span> <input style="width: 50px" name="type"
							type="checkbox" value="1" class="form-control pull-right">

					</div>

					<div class="form-group">

						<span>내 여행일지에 추가</span> <input style="width: 50px" name="togeter"
							type="checkbox" class="form-control pull-right">
					</div>

					<div class="form-group">
						<input type="hidden" name="bucketTree_idx" value="${vo.idx}">
						<textarea id="body" name="contents" class="smarteditor2"
							style="width: 100%;"></textarea>
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success">
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
<div class="modal fade" id="tree_modify_modal" role="dialog">
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
					<input type="hidden" id="idx2">

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

<script type="text/javascript">
	$(function() {

		$("button[name=comment]").click(
				function(e) {
					e.preventDefault();
					$.ajax({
						url : "/BucketTree/bucketTree/commentCreate",
						type : "GET",
						sync : false,
						data : {
							idx : $(this).attr("data-idx"),
							contents : $(this).parent().parent().children(
									$("input[name=comment_contents]")).val()
						},
						success : function() {
							window.location.reload(true);
						}
					});

					$(this).parent().parent().children(
							$("input[name=comment_contents]")).val("");

				});

		$("a[id=deleteComment]").click(function() {
			$.ajax({
				url : "/BucketTree/bucketTree/commentDelete",
				type : "GET",
				sync : false,
				data : {
					idx : $(this).attr("data-idx")
				},
				success : function() {
					window.location.reload(true);
				}
			});

		});

		$("button[id=commentModify]").click(
				function() {

					$.ajax({
						url : "/BucketTree/bucketTree/commentModify",
						type : "GET",
						sync : false,
						data : {
							idx : $(this).attr("data-idx"),
							contents : $(this).parent().parent().children(
									$("input[name=contents_modify]")).val()
						},
						success : function() {
							window.location.reload(true);
						}
					});
				});

	});

	$("#tree_add").click(function() {
		$("#group_timeLine").modal();
	});

	$(function() {

		var tree_modal = $('#tree_modify_modal');

		$(".timeline-footer>.f_right>button").click(function() {

			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketTree/modify?idx=" + idx,
				dataType : "json",
				type : "GET",
				success : function(data) {
					oEditors.getById['body2'].exec("SET_CONTENTS", [ "" ]);
					tree_modal.find('#idx2').val(data.idx);
					htmlData = '<span>' + data.contents + '</span>';
					oEditors.getById['body2'].exec("PASTE_HTML", [ htmlData ]);
					tree_modal.modal('show');
				}
			});
		});

		// 수정하기 버튼 누르면 일지 업데이트됨
		$('#journal_m_submit').click(function() {
			var contents = oEditors.getById['body2'].getIR();
			$.ajax({
				url : "/BucketTree/bucketTree/modify",
				type : "POST",
				data : {
					idx : $('#idx2').val(),
					contents : contents
				},
				success : function() {
					window.location.reload(true);
				}
			});
		});

		/*-- 일지 삭제 --*/
		$(".timeline-footer>.f_right>a").click(function() {
			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketTree/delete",
				data : {
					idx : idx
				},
				type : "GET",
				success : function() {
					window.location.reload(true);
				}
			});
		});
	});

	$('span[id=modifyComment]').click(function() {
		$(this).parent().parent().children(".modify").addClass("modifyShow");
	})
	$('.modifyCancel').click(function() {
		$('.modify').removeClass("modifyShow");
	})
</script>