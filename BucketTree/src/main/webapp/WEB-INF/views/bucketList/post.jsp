<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="x_panel">
				<div class="right">
									
					<c:set var="check" value="${check.idx}" />
					<c:set var="check2" value="${bucket.user_idx}" />
					<c:if test="${check eq check2}">
					    <button class="btn btn-default" title="수정" onclick="location.href='/BucketTree/bucketList/${bucket.idx}/edit.do'">
						<i class="fa fa-pencil"></i>
						</button>
					    <button class="btn btn-default" title="삭제" onclick="location.href='/BucketTree/bucketList/${bucket.idx}/delete.do'">
						<i class="fa fa-trash-o"></i>
					</button>
					</c:if>

				</div>
				<div class="x_title">
					<h2>${bucket.title}</h2>
				</div>
				<div class="x_title_m">
					<span class="post_writer">${bucket.name}</span> <span class="post_date">${bucket.date }</span>

					<div class="right">
						<span class="tag">20대</span> <span class="tag">혼자</span> <span
							class="tag">여행</span>
					</div>

				</div>

				<div class="x_content">
						${bucket.contents}
				</div>
			</div>
			<!-- 작업일지 부분 -->
			<div class="box box-default collapsed-box">
				<div class="box-header withorder">
					<h3 class="box-title">Timeline</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-toggle="collapse" data-target="#collapseTimeline">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="collapse" id="collapseTimeline">
					<ul class="timeline">
						<li>
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">첫번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>Lorem ipsum dolor sit amet, consectetur adipiscing
										elit, sed do eiusmod tempor incididunt ut labore et dolore
										magna aliqua. Ut enim ad minim veniam, quis nostrud
										exercitation ullamco laboris nisi ut aliquip ex ea commodo
										consequat.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">두번쨰일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>
										<p>
											<img src="/kr/resources/img/photo1.png" class="timeline-img"
												align="center">
										</p> "Duis aute irure dolor in reprehenderit in voluptate velit
										esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
										occaecat cupidatat non proident, sunt in culpa qui officia
										deserunt mollit anim id est laborum."
									</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">세번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">

									<span>
										<p>
											<img src="/kr/resources/img/photo2.jpg" class="timeline-img"
												align="center">
										</p> 정당은 그 목적·조직과 활동이 민주적이어야 하며, 국민의 정치적 의사형성에 참여하는데 필요한 조직을 가져야
										한다. 이 헌법중 공무원의 임기 또는 중임제한에 관한 규정은 이 헌법에 의하여 그 공무원이 최초로 선출 또는
										임명된 때로부터 적용한다. 국회나 그 위원회의 요구가 있을 때에는 국무총리·국무위원 또는 정부위원은
										출석·답변하여야 하며, 국무총리 또는 국무위원이 출석요구를 받은 때에는 국무위원 또는 정부위원으로 하여금
										출석·답변하게 할 수 있다.
									</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">네번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>대법원장의 임기는 6년으로 하며, 중임할 수 없다. 국무회의는 대통령·국무총리와 15인
										이상 30인 이하의 국무위원으로 구성한다. 국가안전보장에 관련되는 대외정책·군사정책과 국내정책의 수립에 관하여
										국무회의의 심의에 앞서 대통령의 자문에 응하기 위하여 국가안전보장회의를 둔다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">다섯번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>법률안에 이의가 있을 때에는 대통령은 제1항의 기간내에 이의서를 붙여 국회로 환부하고, 그
										재의를 요구할 수 있다. 국회의 폐회중에도 또한 같다. 국방상 또는 국민경제상 긴절한 필요로 인하여 법률이
										정하는 경우를 제외하고는, 사영기업을 국유 또는 공유로 이전하거나 그 경영을 통제 또는 관리할 수 없다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge "></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">여섯번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다. 정부는 회계연도마다
										예산안을 편성하여 회계연도 개시 90일전까지 국회에 제출하고, 국회는 회계연도 개시 30일전까지 이를 의결하여야
										한다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">일곱번째 일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>대통령은 법률안의 일부에 대하여 또는 법률안을 수정하여 재의를 요구할 수 없다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">여덟번째 일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>모든 국민은 통신의 비밀을 침해받지 아니한다. 공무원인 근로자는 법률이 정하는 자에 한하여
										단결권·단체교섭권 및 단체행동권을 가진다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li>
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">아홉번째 일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>예비비는 총액으로 국회의 의결을 얻어야 한다. 예비비의 지출은 차기국회의 승인을 얻어야
										한다. 국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다.
										누구든지 체포 또는 구속을 당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 국민의 모든 자유와 권리는
										국가안전보장·질서유지 또는 공공복리를 위하여 필요한 경우에 한하여 법률로써 제한할 수 있으며, 제한하는 경우에도
										자유와 권리의 본질적인 내용을 침해할 수 없다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
						<li class="timeline-inverted">
							<div class="timeline-badge"></div>
							<div class="timeline-panel">
								<div class="timeline-heading">
									<h4 class="timeline-title">열번째일지</h4>
									<p>
										<small class="text-muted"><i
											class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
									</p>
								</div>
								<div class="timeline-body">
									<span>선거에 관한 경비는 법률이 정하는 경우를 제외하고는 정당 또는 후보자에게 부담시킬 수
										없다. 대통령은 국무총리·국무위원·행정각부의 장 기타 법률이 정하는 공사의 직을 겸할 수 없다.</span>
								</div>
								<hr>
								<div class="timeline-footer">
									<a class="btn btn-default" title="수정"><i
										class="fa fa-pencil"></i></a> <a class="btn btn-default"
										title="삭제"><i class="fa fa-trash-o"></i></a>
								</div>
							</div>
						</li>
					</ul>

				</div>
			</div>
			<!-- /작업일지 부분 -->
			<!-- 댓글 부분 -->
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
					<div class="box-footer box-comments">
						<c:forEach items="${clist}"  var="CommentVO">
						<div class="box-comment" id="${CommentVO.idx}">
							<!-- User image -->

							<div class="comment-text" id=d${CommentVO.idx}>
								<span class="username" id=n${CommentVO.idx}>${CommentVO.name }<span style="margin-left:30px">${CommentVO.date}</span>
								<a class=e${CommentVO.idx} id="cedit" style="margin-left:600px" data-idx="${CommentVO.idx }">수정</a>
								<a class=d${CommentVO.idx} id="cdelete" data-idx="${CommentVO.idx }">삭제</a>
								</span>
								<!-- /.username -->
								<span id=c${CommentVO.idx}>${CommentVO.contents}</span>
							</div>
							<!-- /.comment-text -->
						</div>
						</c:forEach>

					</div>
					<!-- /.box-footer -->
					<div class="box-footer">
						<form method="post" id="formData" name="formData">
							<div class="img-push">
								<div class="input-group">
									<input type="text" class="form-control" name="comment"> <span
										class="input-group-btn" id="comment">
										<button type="button" class="btn btn-default" id="addComment" data-idx="${bucket.idx}">등록</button>
									</span>
								</div>
							</div>
							<input type="hidden" name="bidx" value="${bucket.idx }">
							<input name="author" type="checkbox" id="check" value=1>작성자만 보기</input>
						</form>
					</div>
				</div>
			</div>
			<!-- /댓글 부분 -->
		</div>
	</div>
</div>
<script>

$(document).on('click', '#addComment', function(){
	alert('에이젝스 돌입')
	var formData =$('#formData').serialize();
	var str='';
	alert(formData)
	jQuery.ajax({
		
		url : "/BucketTree/bucketList/addCommentRequestAjax",
		type : "POST",
		data : formData,
		cache: false,
		success :  function(data) {
			if(data !=""){
				$(data).each(
			
				function(){

					str+='<div class="box-comment" data-idx="'+this.idx+'">'
					+'<img src="/kr/resources/img/user1-128x128.jpg" class="user-image" alt="User Image">'
					+'<div class="comment-text">'
					+'<span class="username">'+this.name+'<a href="" id="cedit" style="margin-left:790px">수정</a><a href="" id="cdelete" style="margin-left:10px">삭제</a><span class="text-muted pull-right post_date">'+this.date+'</span></span>'
					+ this.contents
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

});

$(document).on('click', '#cdelete', function(){
	var evnetTarget = this;
	var eventIdx = $(this).attr('data-idx');
	alert(eventIdx)
	jQuery.ajax({
		method :"POST",
		url : "/BucketTree/bucketList/deleteCommentRequestAjax",
		type : "JSON",
		data : {
			commentIdx : eventIdx,
		},
		success :  function(data) {
			if(data==true){
				$('div').remove('#'+eventIdx)
			}
				}

	});
	
	
});

$(document).on('click', '#commentEdit', function(){
	alert('에이젝스 댓글 수정돌입')
	var formData =$('#formEdit').serialize();
	var str='';
	alert(formData)
	jQuery.ajax({
		
		url : "/BucketTree/bucketList/editCommentRequestAjax",
		type : "POST",
		data : formData,
		cache: false,
		success :  function(data) {
			var insertIdx = 'd'+this.idx;
			if(data !=""){
				$(data).each(
			
				function(){

					str+='<div class="box-comment" data-idx="'+this.idx+'">'
					+'<div class="comment-text">'
					+'<span class="username">'+this.name+'<a href="" id="cedit" style="margin-left:780px">수정</a><a href="" id="cdelete" style="margin-left:10px">삭제</a><span class="text-muted pull-right post_date">'+this.date+'</span></span>'
					+ this.contents
					+'</div>'
					+'</div>';      					    
				}		
				)  
				  $('#'+insertIdx).html(str);
				  $('#addComment').val("");
				  }else
					  alert('불러올 데이터가 없습니다')
				}

	});

});



$(document).on('click', '#cedit', function(){
	alert('도착')
	var evnetTarget = this;
	var eventIdx = $(this).attr('data-idx');
	var eventIdx2 = 'c'+eventIdx;
	var eventDiv = 'd'+eventIdx;
	var eventNspan = 'n'+eventIdx;
	var ceditIdx = 'cedit_'+eventIdx;
	var cdeleteIdx = 'cdelte_'+eventIdx;
	var eclass ='e'+eventIdx;
	var dclass ='d'+eventIdx;

	var content =document.getElementById(eventIdx2);
	var content2 = $(content).html();
	alert(content2)
	var str='';
	var str2='';
	str+="<a id='cCancle' style='margin-left:630px'>취소</a>";
	str2+="<form id='formEdit'><input type='text' name='editContent' style='width:746px; height:46px; margin-top:15px' value='"+content2+"'></input>"
		+ "<button id='commentEdit' style='height:46px; width:146px' vertical-align:middle>등록</button>"
		+ "<input type='hidden' name='editIdx' value='"+eventIdx+"'></input>";

	//div 아래부터 다 지우고 텍스트 형식으로 붙여넣기 해서 삽입 시 vo 값이 잘 나오는가가 중요함.
	alert(str)
	$('.'+eclass).remove();
	$('.'+dclass).remove();
	$('#'+eventNspan).append(str);
	$('#'+eventIdx2).remove();
	$('#'+eventDiv).append(str2);
	
});
</script>