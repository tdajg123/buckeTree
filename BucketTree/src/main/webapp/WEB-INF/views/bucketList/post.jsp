<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services"></script>
<script src="/BucketTree/se2/js/HuskyEZCreator.js"
	type="text/javascript"></script>
<script>
	//짝수번째 li는 오른쪽으로 보이기
	$(function() {
		$("ul.timeline>li:nth-child(even)").addClass('timeline-inverted');
	});
</script>
<div class="container" style="margin-top:50px;">
	<div class="row">
		<div class="col-md-12">
			<div class="x_panel">
				<div class="right">

					<c:set var="check" value="${check.idx}" />
					<c:set var="check2" value="${bucket.user_idx}" />
					<c:if test="${check eq check2}">
						<div class="f_right">
							<button class="btn btn-default" title="수정"
								onclick="location.href='/BucketTree/bucketList/${bucket.idx}/edit.do'">
								<i class="fa fa-pencil"></i>
							</button>
							<button class="btn btn-default" title="삭제"
								onclick="location.href='/BucketTree/bucketList/${bucket.idx}/delete.do'">
								<i class="fa fa-trash-o"></i>
							</button>
							<button class="btn btn-default" data-target="#layerpop"
								data-toggle="modal" style="width: 60px; height: 30px">추천</button>
								<button class="btn btn-default" title="PDF"
                        onclick="location.href='/BucketTree/bucketList/${bucket.idx}/pdfdown.do'">
                        <i class="fa fa-book"></i>
                     </button>
							<br />
						</div>
					</c:if>

					<c:set var="check3" value="${user.type}" />
					<c:set var="check4" value="관리자" />
					<c:if test="${check3 eq check4}">
						<div class="f_right">
							<button class="btn btn-default" title="수정"
								onclick="location.href='/BucketTree/bucketList/${bucket.idx}/edit.do'">
								<i class="fa fa-pencil"></i>
							</button>
							<button class="btn btn-default" title="삭제"
								onclick="location.href='/BucketTree/bucketList/${bucket.idx}/delete.do'">
								<i class="fa fa-trash-o"></i>
							</button>
							<button class="btn btn-default" data-target="#layerpop"
								data-toggle="modal" style="width: 60px; height: 30px">추천</button>
							<br />
						</div>
					</c:if>

				</div>
				<div class="x_title">
					<h2>${bucket.title}</h2>
				</div>
				<div class="x_title_m">
					<div class="f_left">
						<span class="tag">${ctlist.get(0).who}</span> <span class="tag">${ctlist.get(1).when}</span>
						<span class="tag">${ctlist.get(2).what}</span>
						<c:set var="checkMap" value="${bucket.x}" />
						<c:if test="${checkMap ne 0}">
							<span class="tag" onclick="popupOpen()">버킷 장소</span>
						</c:if>
					</div>

					<div class="f_right">
						<input type="hidden" id="positionX" value="${bucket.x}"> <input
							type="hidden" id="positionY" value="${bucket.y}"> <span
							class="post_writer">${bucket.name}</span> <span class="post_date">${bucket.date }</span>
					</div>
				</div>

				<div class="x_content">${bucket.contents}</div>
			</div>
			<!-- 작업일지 부분 -->
			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title">Timeline</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-default"
							data-toggle="collapse" data-target="#collapseTimeline">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="collapse" id="collapseTimeline">
					<ul class="timeline">
						<!-- 일지쓰기 부분 -->
						<c:if test="${check eq check2}">
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
						</c:if>

						<!-- 일지 부분 -->
						<c:forEach items="${list}" var="BucketJournalVO">
							<li><input type="hidden"
								value="${BucketJournalVO.bucket_idx }" id="bucket_idx">
								<div class="timeline-badge"></div>
								<div class="timeline-panel">
									<div class="timeline-heading">
										<h4 class="timeline-title">${BucketJournalVO.title }</h4>
										<p>
											<small class="text-muted  f_right"><i
												class="glyphicon glyphicon-time"></i>
												${BucketJournalVO.date} </small>
										</p>
									</div>
									<div class="timeline-body">
										<span> ${BucketJournalVO.contents} </span>
									</div>
									<c:if test="${check eq check2}">
										<hr />
										<div class="timeline-footer">
											<div class="f_right">
												<button class="btn btn-default" title="수정"
													data-idx="${BucketJournalVO.idx}">
													<i class="fa fa-pencil"></i>
												</button>
												<a class="btn btn-default" title="삭제"
													data-idx="${BucketJournalVO.idx}"> <i
													class="fa fa-trash-o"></i>
												</a>
											</div>
										</div>
									</c:if>
								</div></li>
						</c:forEach>
					</ul>

				</div>
			</div>
			<!-- /작업일지 부분 -->
			<!-- 댓글 부분 -->
			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title">Comments</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-default"
							data-toggle="collapse" data-target="#collapseComment">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="collapse" id="collapseComment">
					<div class="box-footer box-comments">
						<c:forEach items="${clist}" var="CommentVO">

							<c:set var="check3" value="${CommentVO.user_idx}" />
							<c:set var="viewCheck" value="${CommentVO.author}" />
							<c:choose>

								<c:when test="${viewCheck eq 1}">
									<c:if test="${check eq check2}">
										<div class="box-comment" id="${CommentVO.idx}">
											<!-- User image -->

											<div class="comment-text" id=d${CommentVO.idx}>
												<span class="username" id=n${CommentVO.idx}>${CommentVO.name }
													<a class=d${CommentVO.idx} id="cdelete"
													data-idx="${CommentVO.idx }" style="margin-left: 850px">삭제</a>
													<span style="margin-left: 10px"
													class="text-muted pull-right post_date">${CommentVO.date}</span>
												</span>

												<!-- /.username -->
												<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
											</div>
											<!-- /.comment-text -->
										</div>
									</c:if>
								</c:when>
								<c:when test="${viewCheck eq 1}">
									<c:if test="${check eq check3}">
										<div class="box-comment" id="${CommentVO.idx}">
											<!-- User image -->

											<div class="comment-text" id=d${CommentVO.idx}>
												<span class="username" id=n${CommentVO.idx}>${CommentVO.name }
													<a class=e${CommentVO.idx} id="cedit"
													style="margin-left: 790px" data-idx="${CommentVO.idx }">수정</a>

													<a class=d${CommentVO.idx} id="cdelete"
													data-idx="${CommentVO.idx }">삭제</a> <span
													style="margin-left: 10px"
													class="text-muted pull-right post_date">${CommentVO.date}</span>
												</span>

												<!-- /.username -->
												<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
											</div>
											<!-- /.comment-text -->
										</div>
									</c:if>
								</c:when>
								<c:when test="${check eq check2}">
									<c:if test="${check eq check3}">
										<div class="box-comment" id="${CommentVO.idx}">
											<!-- User image -->

											<div class="comment-text" id=d${CommentVO.idx}>
												<span class="username" id=n${CommentVO.idx}>${CommentVO.name }
													<a class=e${CommentVO.idx} id="cedit"
													style="margin-left: 790px" data-idx="${CommentVO.idx }">수정</a>

													<a class=d${CommentVO.idx} id="cdelete"
													data-idx="${CommentVO.idx }">삭제</a> <span
													style="margin-left: 10px"
													class="text-muted pull-right post_date">${CommentVO.date}</span>
												</span>

												<!-- /.username -->
												<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
											</div>
											<!-- /.comment-text -->
										</div>
									</c:if>
								</c:when>
								<c:when test="${check eq check2}">
									<div class="box-comment" id="${CommentVO.idx}">
										<!-- User image -->

										<div class="comment-text" id=d${CommentVO.idx}>
											<span class="username" id=n${CommentVO.idx}>${CommentVO.name }
												<a class=d${CommentVO.idx} id="cdelete"
												data-idx="${CommentVO.idx }" style="margin-left: 850px">삭제</a>
												<span style="margin-left: 10px"
												class="text-muted pull-right post_date">${CommentVO.date}</span>
											</span>

											<!-- /.username -->
											<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
										</div>
										<!-- /.comment-text -->
									</div>

								</c:when>

								<c:when test="${check eq check3}">
									<div class="box-comment" id="${CommentVO.idx}">
										<!-- User image -->

										<div class="comment-text" id=d${CommentVO.idx}>
											<span class="username" id=n${CommentVO.idx}>${CommentVO.name }
												<a class=e${CommentVO.idx} id="cedit"
												style="margin-left: 790px" data-idx="${CommentVO.idx }">수정</a>

												<a class=d${CommentVO.idx} id="cdelete"
												data-idx="${CommentVO.idx }">삭제</a> <span
												style="margin-left: 10px"
												class="text-muted pull-right post_date">${CommentVO.date}</span>
											</span>

											<!-- /.username -->
											<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
										</div>
										<!-- /.comment-text -->
									</div>
								</c:when>
							</c:choose>
						</c:forEach>

					</div>
					<!-- /.box-footer -->
					<div class="box-footer">
						<form method="post" id="formData" name="formData">
							<div class="img-push">
								<div class="input-group">
									<input type="text" class="form-control" name="comment"
										id="inputComment"> <span class="input-group-btn"
										id="comment">
										<button type="button" class="btn btn-default" id="addComment"
											data-idx="${bucket.idx}">등록</button>
									</span>
								</div>
							</div>
							<input type="hidden" id="bidx" name="bidx" value="${bucket.idx }">
							<input name="author" type="checkBox" id="check" value="1"
								style="width: 20px; height: 20px">작성자만

						</form>
					</div>
				</div>
			</div>
			<!-- /댓글 부분 -->
		</div>
	</div>
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
<!-- 지도 모달창 -->
<div id="popup"
	style="position: absolute; visibility: hidden; height: 535px; background-color: white; background-color: #f1f6f7; text-align: right">
	<span style="margin-right: 400px">버킷리스트 </span>
	<button onclick="popupOpen()">닫기</button>
	<div id="staticMap" style="width: 1000px; height: 500px;"></div>
</div>
<!-- 지도 모달창 종료 -->

<!-- 검색 모달 창 시작 -->
<div class="modal fade" id="layerpop">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- header -->
			<div class="modal-header">
				<!-- 닫기(x) 버튼 -->
				<button type="button" class="close" data-dismiss="modal">×</button>
				<!-- header title -->
				<h4 class="modal-title">버킷 친구 추천</h4>
			</div>
			<!-- body -->
			<div class="modal-body">
				<div class="input-group-btn search-panel">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<c:set var="srch" value="${srch}" />
						<c:choose>
							<c:when test="${empty srch.getSrchType()}">
								<span id="search_concept">검색 조건</span>
								<span class="caret"></span>
							</c:when>
							<c:when test="${srch.getSrchType() eq 1}">
								<span id="search_concept">이름</span>
								<span class="caret"></span>
							</c:when>
							<c:when test="${srch.getSrchType() eq 2}">
								<span id="search_concept">이메일</span>
								<span class="caret"></span>
							</c:when>
						</c:choose>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a onclick="onclickName()">이름</a></li>
						<li><a onclick="onclickEmail()">이메일</a></li>
					</ul>
					<input type="hidden" name="srchType" value="${srch.getSrchType()}"
						id="search_param"> <input type="text" class="form-control"
						name="srchText" value="${srch.getSrchText()}" id="search_text"
						style="display: inline; width: 430px; vertical-align: middle">
					<span class="input-group-btn" style="display: inline">
						<button class="btn btn-default" id="sub">
							<span class="glyphicon glyphicon-search" onclick="return false"></span>
						</button>
					</span>
				</div>
				<table class="table" style="margin-top: 30px">

				</table>

			</div>
			<!-- Footer -->
			<div class="modal-footer">
				<span style="margin-right: 330px">추천할 친구를 선택해주세요</span>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>



<script>

$(document).on('click', '#addComment', function(){
	var input = $('#inputComment').val();
	if(input!=""){
	var formData =$('#formData').serialize();
	var str='';
	jQuery.ajax({
		
		url : "/BucketTree/bucketList/addCommentRequestAjax",
		type : "POST",
		data : formData,
		cache: false,
		success :  function(data) {
			if(data !=""){
				$(data).each(
			
				function(){

					str+='<div class="box-comment" id="'+this.idx+'" data-idx="'+this.idx+'">'
					+'<div class="comment-text" id="d'+this.idx+'">'
					+'<span class="username" id="n'+this.idx+'">'+this.name+'<a class="e'+this.idx+'" id="cedit" style="margin-left:790px" data-idx="'+this.idx+'">수정</a><a id="cdelete"  class="e'+this.idx+'"  data-idx="'+this.idx+'" style="margin-left:10px">삭제</a><span class="text-muted pull-right post_date">'+this.date+'</span></span>'
					+'<span id="c'+this.idx+'">'+this.contents+'</span>'
					+'</div>'
					+'</div>';      					    
				}		
				)  
				  $('.box-footer.box-comments').append(str);
				  $('#addComment').val("");
				  }else
					  alert('불러올 데이터가 없습니다')
									}

								});
	
	}else{
		alert('내용을 입력해주세요')
	}

					});

	$(document).on('click', '#cdelete', function() {
		var evnetTarget = this;
		var eventIdx = $(this).attr('data-idx');
		alert(eventIdx)
		jQuery.ajax({
			method : "POST",
			url : "/BucketTree/bucketList/deleteCommentRequestAjax",
			type : "JSON",
			data : {
				commentIdx : eventIdx,
			},
			success : function(data) {
				if (data == true) {
					$('div').remove('#' + eventIdx)
				}
			}

		});

	});

	$(document)
			.on(
					'click',
					'#commentEdit',
					function() {
						var formData = $('#formEdit').serialize();
						var str = '';
						alert(formData)
						jQuery
								.ajax({

									url : "/BucketTree/bucketList/editCommentRequestAjax",
									type : "POST",
									data : formData,
									cache : false,
									success : function(data) {
										var insertIdx = 'd' + this.idx;
										if (data != "") {
											$(data)
													.each(

															function() {

																str+='<div class="box-comment" id="'+this.idx+'" data-idx="'+this.idx+'">'
																+'<div class="comment-text" id="d'+this.idx+'">'
																+'<span class="username">'+this.name+'<a class="e'+this.idx+'" id="cedit" style="margin-left:790px" data-idx="'+this.idx+'">수정</a><a id="cdelete" style="margin-left:10px" class="e'+this.idx+'"  data-idx="'+this.idx+'">삭제</a><span class="text-muted pull-right post_date">'+this.date+'</span></span>'
																+'<span id="c'+this.idx+'">'+this.idx+'</span>'
																+'</div>'
																+'</div>'; 
															})
											$('#' + insertIdx).html(str);
											$('#addComment').val("");
										} else
											alert('불러올 데이터가 없습니다')
									}

								});

					});

	$(document)
			.on(
					'click',
					'#cedit',
					function() {
						var evnetTarget = this;
						var eventIdx = $(this).attr('data-idx');
						var eventIdx2 = 'c' + eventIdx;
						var eventDiv = 'd' + eventIdx;
						var eventNspan = 'n' + eventIdx;
						var ceditIdx = 'cedit_' + eventIdx;
						var cdeleteIdx = 'cdelte_' + eventIdx;
						var eclass = 'e' + eventIdx;
						var dclass = 'd' + eventIdx;

						var content = document.getElementById(eventIdx2);
						var content2 = $(content).html();
						alert(content2)
						var str = '';
						var str2 = '';
					//	str += "<a id='cCancle' style='margin-left:850px'>취소</a>";
						str2 += "<form id='formEdit'><input type='text' name='editContent' style='width:973px; height:46px; margin-top:15px' value='"+content2+"'></input>"
								+ "<button id='commentEdit' style='height:46px; width:100px' vertical-align:middle>등록</button>"
								+ "<input type='hidden' name='editIdx' value='"+eventIdx+"'></input>";

						//div 아래부터 다 지우고 텍스트 형식으로 붙여넣기 해서 삽입 시 vo 값이 잘 나오는가가 중요함.
						alert(str)
						$('.' + eclass).remove();
						$('.' + dclass).remove();
					//	$('#' + eventNspan).append(str);
						$('#' + eventIdx2).remove();
						$('#' + eventDiv).append(str2);

					});

	/*-- 일지 생성 --*/

	//버킷작성 모달 
	$("#journal_create").click(function() {
		$('#journal_create_modal').modal();
	});

	// 저장하기 버튼 누르면 작성된 일지 저장됨
	$('#journal_c_submit').click(function() {
		var contents = oEditors.getById['body'].getIR();
		 $.ajax({
		 	url : "/BucketTree/bucketList/journal/createAjax",
		 	dataType : "json",
		 	type : "POST",
		 	data : {
		 			bucket_idx : ${bucket.idx},
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
		$(".timeline-footer>.f_right>button").click(function() {
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
		$(".timeline-footer>.f_right>a").click(function() {
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
	
	
	function popupOpen(){
		 //추가부분
		 var $layerPopupObj = $('#popup');
		 var left = ( $(window).scrollLeft() + ($(window).width() - $layerPopupObj.width()) / 2 );
		 var top = ( $(window).scrollTop() + ($(window).height() - $layerPopupObj.height()) / 2 );
		 $layerPopupObj.css({'left':left,'top':top, 'position':'absolute'});
		 $('body').css('position','relative').append($layerPopupObj);
		  //추가부분
		 
		 
		    if(document.all.popup.style.visibility=="hidden") {
		        document.all.popup.style.visibility="visible";
		        return false;
		    }else{
		        document.all.popup.style.visibility="hidden";
		        return false;   
		    }
		}
	var px = $('#positionX').val();
	var py = $('#positionY').val();
	// 이미지 지도에 표시할 마커입니다
	// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
	var markers = [
	    
	    {
	        position: new daum.maps.LatLng(px, py), 
	        text: '클릭하면 다음 지도로 이동합니다'     
	    }
	];

	var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
	    staticMapOption = { 
	        center: new daum.maps.LatLng(px, py), // 이미지 지도의 중심좌표
	        level: 3, // 이미지 지도의 확대 레벨
	        marker: markers // 이미지 지도에 표시할 마커 
	    };    

	// 이미지 지도를 생성합니다
	var staticMap = new daum.maps.StaticMap(staticMapContainer, staticMapOption);
	
	
	function onclickName() {
		$('#search_param').val(1);
		$('#search_concept').text("이름");
	}
	function onclickEmail() {
		$('#search_param').val(2);
		$('#search_concept').text("이메일");
	}
	
	
	$(document).on('click', '#sub', function(){
		
		var srchType = $('#search_param').val();
		var srchText = $('#search_text').val();

		var str='';
		var table="<tr><td>이름</td><td>이메일</td><td style='text-align:center'>추천</td></tr>";
		jQuery.ajax({
			
			url : "/BucketTree/Friend/fRecommendRequestAjax",
			type : "POST",
			dataType : "json",
			data : {sText : srchText,
					sType : srchType,	},
			cache: false,
			success :  function(data) {
				if(data !=""){
					$(data).each(
						function(){
							str+="<tr data-idx='"+this.idx+"'><td>"+this.name+"</td>"
							+"<td>"+this.email+"</td>"
							+"<td style='text-align:center'><button class='btn btn-default' id='rec' data-idx='"+this.idx+"'>추천하기</button></td></tr>"
							;
						})
						$('.table').html(table);
						$('.table').append(str);
					 		 }else{
					 			 alert('검색 결과가 없습니다')
					 		 }						
									}

									});		
													}
						);
	//친구 추천 ajax
	$(document).on('click', '#rec', function() {
		var evnetTarget = this;
		var eventIdx = $(this).attr('data-idx');
		var bidx = $('#bidx').val();

		jQuery.ajax({
			method : "POST",
			url : "/BucketTree/bucketList/friendRecommendAjax",
			type : "JSON",
			data : {
				friendIdx : eventIdx,
				bidx : bidx,
			},
			success : function(data) {
				if (data == true) {
					alert('추천이 완료되었습니다')
				}else{
					alert('이미 추천되었습니다')
				}
				
			}

		});

	});
	
</script>