<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//code.jquery.com/jquery.min.js"></script>
    <meta charset="utf-8">
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=c979b1f9a00bdf157a46346b59a630f4&libraries=services"></script>
<script src="/BucketTree/se2/js/HuskyEZCreator.js" type="text/javascript"></script>
<script src="/BucketTree/se2/init.js" type="text/javascript"></script>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="x_panel">
			<form action="/BucketTree/bucketList/edit.do"  method="post" enctype="multipart/form-data">
				<div class="right">
					<input type="submit" class="btn btn-default" value="수정완료">						
					<input type="hidden" name="idx" value="${bucket.idx}">
					<input type="hidden" id="positionX" name="x"  value="${bucket.x}">
					<input type="hidden" id="positionY" name="y"  value="${bucket.y}">
					<button type="button" class="btn btn-default" onclick="popupOpen()">장소지정</button>
				</div>
				<div class="x_title">
					<h2>${bucket.title}</h2>
				</div>
				<div class="x_title_m">
					<span class="post_writer">${bucket.name}</span> <span class="post_date">${bucket.date}</span>

					<div class="right">
						<span class="tag">20대</span> <span class="tag">혼자</span> <span
							class="tag">여행</span>
					</div>

				</div>
				<div class="x_content">
					<textarea id="body" name="body" class="smarteditor2">${bucket.contents}</textarea>
				</div>
			</form>
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
						<div class="box-comment">
							<!-- User image -->
							<img src="/kr/resources/img/user1-128x128.jpg" class="user-image"
								alt="User Image">

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
							<img src="/kr/resources/img/user1-128x128.jpg" class="user-image"
								alt="User Image">

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
								<div class="input-group">
									<input type="text" class="form-control"> <span
										class="input-group-btn">
										<button type="button" class="btn btn-default">등록</button>
									</span>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /댓글 부분 -->
		</div>
	</div>
</div>
<div id="popup" style="position:absolute;  visibility:hidden; height:535px; background-color:white";>
	<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white" style="font-weight:100px;">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="이태원 맛집" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
</div>
<h1 style="margin-top:5px">현재 선택한 장소 : <input type="text" readOnly="readOnly" id="title2"> <span style="text-align:right">마커나 검색 목록을 클릭하여 선택하세요</span></h1>
</div>
<!-- //팝업 레이어 -->
<script type="text/javascript"	src="/BucketTree/js/bucketList/bucketWrite.js"></script>
