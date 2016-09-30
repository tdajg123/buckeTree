<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="container">

	<div class="page-header">
		<h1 id="timeline"><% %></h1>
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
		<li>
			<div class="timeline-badge timeline-mission"></div>
			<div class="timeline-panel timeline-mission">
				<div class="timeline-heading">
					<h2>NEW MISSION!</h2>
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<img src="/kr/resources/img/photo3.jpeg" class="timeline-img">
					<p>9월 한 달동안 책 5권 읽기!</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment1">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment1">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li class="timeline-inverted">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
						occaecat cupidatat non proident, sunt in culpa qui officia
						deserunt mollit anim id est laborum."</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment2">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment2">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li>
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>정당은 그 목적·조직과 활동이 민주적이어야 하며, 국민의 정치적 의사형성에 참여하는데 필요한 조직을 가져야
						한다. 이 헌법중 공무원의 임기 또는 중임제한에 관한 규정은 이 헌법에 의하여 그 공무원이 최초로 선출 또는 임명된
						때로부터 적용한다. 국회나 그 위원회의 요구가 있을 때에는 국무총리·국무위원 또는 정부위원은 출석·답변하여야 하며,
						국무총리 또는 국무위원이 출석요구를 받은 때에는 국무위원 또는 정부위원으로 하여금 출석·답변하게 할 수 있다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment3">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment3">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li class="timeline-inverted">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>대법원장의 임기는 6년으로 하며, 중임할 수 없다. 국무회의는 대통령·국무총리와 15인 이상 30인 이하의
						국무위원으로 구성한다. 국가안전보장에 관련되는 대외정책·군사정책과 국내정책의 수립에 관하여 국무회의의 심의에 앞서
						대통령의 자문에 응하기 위하여 국가안전보장회의를 둔다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment4">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment4">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li>
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>법률안에 이의가 있을 때에는 대통령은 제1항의 기간내에 이의서를 붙여 국회로 환부하고, 그 재의를 요구할 수
						있다. 국회의 폐회중에도 또한 같다. 국방상 또는 국민경제상 긴절한 필요로 인하여 법률이 정하는 경우를 제외하고는,
						사영기업을 국유 또는 공유로 이전하거나 그 경영을 통제 또는 관리할 수 없다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment5">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment5">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li class="timeline-inverted">
			<div class="timeline-badge "></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>헌법재판소의 장은 국회의 동의를 얻어 재판관중에서 대통령이 임명한다. 정부는 회계연도마다 예산안을 편성하여
						회계연도 개시 90일전까지 국회에 제출하고, 국회는 회계연도 개시 30일전까지 이를 의결하여야 한다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment6">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment6">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li>
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>대통령은 법률안의 일부에 대하여 또는 법률안을 수정하여 재의를 요구할 수 없다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment7">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment7">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li class="timeline-inverted">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>모든 국민은 통신의 비밀을 침해받지 아니한다. 공무원인 근로자는 법률이 정하는 자에 한하여 단결권·단체교섭권
						및 단체행동권을 가진다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment8">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment8">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li>
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>예비비는 총액으로 국회의 의결을 얻어야 한다. 예비비의 지출은 차기국회의 승인을 얻어야 한다. 국회의원이
						회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한 국회의 요구가 있으면 회기중 석방된다. 누구든지 체포 또는 구속을
						당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 국민의 모든 자유와 권리는 국가안전보장·질서유지 또는
						공공복리를 위하여 필요한 경우에 한하여 법률로써 제한할 수 있으며, 제한하는 경우에도 자유와 권리의 본질적인 내용을
						침해할 수 없다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment9">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment9">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
		<li class="timeline-inverted">
			<div class="timeline-badge"></div>
			<div class="timeline-panel">
				<div class="timeline-heading">
					<p>
						<small class="text-muted"><i
							class="glyphicon glyphicon-time"></i> 2016.08.26 11:14</small>
					</p>
				</div>
				<div class="timeline-body">
					<p>선거에 관한 경비는 법률이 정하는 경우를 제외하고는 정당 또는 후보자에게 부담시킬 수 없다. 대통령은
						국무총리·국무위원·행정각부의 장 기타 법률이 정하는 공사의 직을 겸할 수 없다.</p>
				</div>
				<hr>
				<div class="right">
					<a class="btn btn-default" title="수정" data-toggle="collapse"
						data-target="#collapseComment10">Comments <i
						class="fa fa-commenting-o"></i>
					</a>
				</div>
				<!-- comment -->
				<div class="timeline-footer">
					<div class="collapse" id="collapseComment10">
						<div class="box-footer box-comments">
							<div class="box-comment">
								<!-- User image -->
								<img src="/kr/resources/img/user1-128x128.jpg"
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
								<img src="/kr/resources/img/user1-128x128.jpg"
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
	</ul>
</div>

<!-- Modal -->
<div class="modal fade" id="tree_add_modal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 15px 50px;">
				<!-- 종료버튼 -->
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<!-- 제목 -->
				<h4>
					<span class="fa fa-pencil"></span> 버킷트리 글쓰기
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form role="form">
					<div class="form-group">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right"
								id="datepicker" placeholder="Date">
						</div>
					</div>
					<div class="form-group">
						<textarea class="form-control" name="contents"
							placeholder="Contents" rows="5" style="margin-bottom: 10px;"></textarea>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-check"></span> 작성하기
				</button>
				<button type="submit" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-remove"></span> 취소하기
				</button>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$("#tree_add").click(function() {
		$("#tree_add_modal").modal();
	});
</script>