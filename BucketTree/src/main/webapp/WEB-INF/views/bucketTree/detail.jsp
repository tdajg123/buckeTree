<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
input[type=checkbox]:checked {
	border: 1px solid gray;
}
</style>
<div class="container">

	<div class="page-header">
		<h1 id="timeline">${vo.treeName}</h1>
	</div>
	<ul class="timeline">
		<li class="timeline-inverted timeline-add">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading" id="tree_add">
					<p>
						<i class="fa fa-plus"></i> 글쓰기
					</p>
				</div>
			</div>
		</li>
		<c:forEach var="no" items="${notice}">
			<li>
				<div class="timeline-panel timeline-mission">
					<div class="timeline-heading">
						<h2>NEW NOTICE!</h2>
						<p>
							<small class="text-muted"><i
								class="glyphicon glyphicon-time"></i>${no.date}</small>
						</p>
					</div>
					<div class="timeline-body">

						<p>${no.contents}</p>
					</div>
					<hr>
					<div class="timeline-footer">
						<button class="btn btn-default" title="수정" data-idx="${no.idx}">
							<i class="fa fa-pencil"></i>
						</button>
						<a class="btn btn-default" title="삭제" data-idx="${no.idx}"> <i
							class="fa fa-trash-o"></i>
						</a>
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
								<div class="box-comment">
									<!-- User image -->
									<img src="/resources/img/user1-128x128.jpg"
										class="user-image" alt="User Image">

									<div class="comment-text">
										<span class="username"> Maria Gonzales <span
											class="text-muted pull-right post_date">2016.08.30</span>
										</span>
										<!-- /.username -->
										It is a long established fact that a reader will be distracted
										by the readable content of a page when looking at its layout.
									</div>
									<!-- /.comment-text -->
								</div>
								<!-- /.box-comment -->
								<div class="box-comment">
									<!-- User image -->
									<img src="/resources/img/user1-128x128.jpg"
										class="user-image" alt="User Image">

									<div class="comment-text">
										<span class="username"> Nora Havisham <span
											class="text-muted pull-right post_date">2016.08.30</span>
										</span>
										<!-- /.username -->
										The point of using Lorem Ipsum is that it has a more-or-less
										normal distribution of letters, as opposed to using 'Content
										here, content here', making it look like readable English.
									</div>
									<!-- /.comment-text -->
								</div>
								<!-- /.box-comment -->
							</div>
							<!-- /.box-footer -->
							<div class="box-footer">
								<form action="#" method="post">
									<div class="img-push">
										<input type="text" class="form-control input-sm"
											placeholder="Press enter to post comment">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</li>
		</c:forEach>
		<c:forEach var="vo" items="${ list }">
			<li>
				<div class="timeline-badge"></div>
				<div class="timeline-panel">
					<div class="timeline-heading">
						<p>
							<small class="text-muted"><i
								class="glyphicon glyphicon-time"></i>${vo.date} </small>
						</p>
					</div>
					<div class="timeline-body">
						<p>${vo.contents}</p>
					</div>
						<hr>
					<div class="timeline-footer">
						<button class="btn btn-default" title="수정" data-idx="${vo.idx}">
							<i class="fa fa-pencil"></i>
						</button>
						<a class="btn btn-default" title="삭제" data-idx="${vo.idx}"> <i
							class="fa fa-trash-o"></i>
						</a>
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
								<div class="box-comment">
									<!-- User image -->
									<img src="/resources/img/user1-128x128.jpg"
										class="user-image" alt="User Image">

									<div class="comment-text">
										<span class="username"> Maria Gonzales <span
											class="text-muted pull-right post_date">2016.08.30</span>
										</span>
										<!-- /.username -->
										It is a long established fact that a reader will be distracted
										by the readable content of a page when looking at its layout.
									</div>
									<!-- /.comment-text -->
								</div>
								<!-- /.box-comment -->
								<div class="box-comment">
									<!-- User image -->
									<img src="/resources/img/user1-128x128.jpg"
										class="user-image" alt="User Image">

									<div class="comment-text">
										<span class="username"> Nora Havisham <span
											class="text-muted pull-right post_date">2016.08.30</span>
										</span>
										<!-- /.username -->
										The point of using Lorem Ipsum is that it has a more-or-less
										normal distribution of letters, as opposed to using 'Content
										here, content here', making it look like readable English.
									</div>
									<!-- /.comment-text -->
								</div>
								<!-- /.box-comment -->
							</div>
							<!-- /.box-footer -->
							<div class="box-footer">
								<form action="#" method="post">
									<div class="img-push">
										<input type="text" class="form-control input-sm"
											placeholder="Press enter to post comment">
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
						<span class="fa fa-pencil"></span> 소모임 Timeline
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
	$("#tree_add").click(function() {
		$("#group_timeLine").modal();
	});
	$(function() {
		$("ul.timeline>li:nth-child(even)").addClass('timeline-inverted');
	});

	$(function() {

		var modify_modal = $('#journal_modify_modal');
	
		
		  
		$(".timeline-footer>button").click(function() {
			
			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketTree/modify?idx=" + idx,
				dataType : "json",
				type : "GET",
				success : function(data) {
					oEditors.getById['body2'].exec("SET_CONTENTS", [""]);
					modify_modal.find('#idx2').val(data.idx);
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
		$(".timeline-footer>a").click(function() {
			var idx = $(this).attr("data-idx");
			$.ajax({
				url : "/BucketTree/bucketTree/delete",
				data : {
					idx : idx,
				
				},
				type : "GET",
				success : function() {
					
					window.location.reload(true);
				}
			});
		});
	});
</script>