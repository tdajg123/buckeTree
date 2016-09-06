<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript"src="/BucketTree/js/menu/jquery.dlmenu.js"></script>
<script type="text/javascript" src="/BucketTree/js/menu/menu.js"></script>

<nav id="header" class="navbar navbar-fixed-top">
	<!-- /.container -->
	<div id="header-container" class="container navbar-container">


		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="brand" class="navbar-brand" href="#"> <img id="logo"
				src="/BucketTree/images/BUCKET_LOGO.png"
				onmouseover="this.src='/BucketTree/images/BUCKET_LOGO_HOVER.png'"
				onmouseout="this.src='/BucketTree/images/BUCKET_LOGO.png'"
				style="border: 0 solid">
			</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id="dl-menu-1" class="dl-menuwrapper"><a href="#"
					class="dl-trigger">버킷리스트</a>
					<ul class="dl-menu">
						<li><a href="#">마이버킷리스트</a></li>
						<li><a href="#">전체버킷리스트</a></li>
					</ul></li>
				<li id="dl-menu-2" class="dl-menuwrapper"><a href="#"
					class="dl-trigger">버킷트리</a>
					<ul class="dl-menu">
						<li><a href="#">마이버킷트리</a></li>
						<li><a href="#">전체버킷트리</a></li>
					</ul></li>
				<li id="dl-menu-3" class="dl-menuwrapper"><a href="#"
					class="dl-trigger">버킷쉐어</a>
					<ul class="dl-menu">
						<li><a href="#">마이버킷쉐어</a></li>
						<li><a href="/BucketTree/bucketshare/listAll">전체버킷쉐어</a></li>
					</ul></li>
			</ul>


			<div class="navbar-custom-menu">
				<!-- NAVBAR 오른쪽  -->

				<ul class="nav navbar-left">
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <img
							src="/BucketTree/images/user1-128x128.jpg" class="user-image"
							alt="User Image"> USER <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-fw fa-user"></i> 타임라인</a></li>
							<li><a href="/BucketTree/Friend/searchFriendList"><i class="fa fa-fw fa-group"></i> 친구</a></li>
							<li><a href="/BucketTree/mypage"><i
									class="fa fa-fw fa-gear"></i> 정보관리</a></li>
							<li class="divider"></li>
							<li><a href="/BucketTree/logout"><i
									class="fa fa-fw fa-power-off"></i> 로그아웃</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-left">
					<li><a href="#"> 1500 <i class="fa fa-tree"></i></a></li>

				</ul>
				<ul class="nav navbar-left">
					<li id="showRight"><a><i class="fa fa-comments-o"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.nav-collapse -->
</nav>

<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right"
	id="cbp-spmenu-s2">
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">NOTICE</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">공지사항입니다.</div>
		<!-- /.box-body -->
	</div>
	<div class="box box-solid box-default">
		<div class="box-header">
			<div class="input-group">
				<input name="q" class="form-control friend_search search"
					type="text"> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</div>
		<!-- /.box-header -->
		<div class="box-list MessengerFriendList">
			<!--새로운 메세지를 보낸 친구 목록-->
			<c:forEach var="friend" items="${flist1}">
				<div class="box-body addClass newMessenegerFriend"
					data-id="${friend.idx}">
					<img src="/BucketTree/images/user1-128x128.jpg" class="user-image"
						alt="User Image">
					<div class="chat_info">
						<span class="chat_name">${friend.name} </span> <span
							class="badge bg-green right">NEW</span>
						<p>${friend.email}</p>
					</div>
				</div>
			</c:forEach>

			<!--메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외)  -->
			<c:forEach var="friend" items="${flist2}">
				<div class="box-body addClass MessenegerFriend"
					data-id="${friend.idx}">
					<img src="/BucketTree/images/user1-128x128.jpg" class="user-image"
						alt="User Image">
					<div class="chat_info">
						<span class="chat_name">${friend.name} </span>
						<p>${friend.email}</p>
					</div>
				</div>
			</c:forEach>
		
			
		</div>

	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="message_modal" role="dialog"  style="z-index: 999999;">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header" style="padding: 15px 50px;">
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-check"></span> 확인
				</button>
			</div>
		</div>
	</div>
</div>



<script>
	$(function() {
		$('#dl-menu-1').dlmenu();
	});
	$(function() {
		$('#dl-menu-2').dlmenu();
	});
	$(function() {
		$('#dl-menu-3').dlmenu();
	});

	var menuRight = document.getElementById('cbp-spmenu-s2'), showRight = document
			.getElementById('showRight'), body = document.body;

	showRight.onclick = function() {
		classie.toggle(this, 'active');
		classie.toggle(menuRight, 'cbp-spmenu-open');
		disableOther('showRight');
	};

	function disableOther(button) {
		if (button !== 'showRight') {
			classie.toggle(showRight, 'disabled');
		}

	}
    $(function() {

        $('#showRight').click(function() {

            if ($('#cbp-spmenu-s2').hasClass('cbp-spmenu-open')) {
                messenger.from_user_idx = ${user.idx};
                connect();

            }
            if ($('#cbp-spmenu-s2').hasClass('cbp-spmenu-open') == false) {
                disconnect();
            }

        });
	 }); 
</script>

