<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
.profileImage {
	background-color: #fff;
	border: 3px #48cfc8 solid;
	width: 60px;
	height: 60px;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	text-align: center;
	margin: 0 auto;
	margin-bottom: 20px;
	overflow: hidden;
}
</style>

<hr>
<div class="row">
	<div class="col-md-6">

		<div class="x_panel">
			<div class="x_content">
				<c:set var="applyList" value="${applyList}" />
				<c:set var="treeidx" value="${treeidx}" />
				
				<c:if test="${empty applyList}">
					<h4>새로 가입요청한 친구 없음</h4>
				</c:if>
				
				<c:forEach items="${applyList}" var="UserVO">
					<div class="blockquote-box blockquote-info clearfix"
						data-idx="${treeidx}">
						<c:if test="${UserVO.getImage() != null }">
							<div class="profileImage pull-left">
								<img
									src="/BucketTree/treeMember/${UserVO.getIdx()}/profileImage"
									style="width: 60px; height: 60px;">
							</div>
						</c:if>
						<c:if test="${UserVO.getImage() == null }">
							<div class="profileImage pull-left">
								<img src="/BucketTree/images/PROFILE_image.png"
									style="width: 60px; height: 60px">
							</div>
						</c:if>
						<h4>${UserVO.name}</h4>
						<p>${UserVO.email}</p>
						<p id="mbp">
							<button type="button" class="btn btn-default"
								aria-label="right Align" id="addMember"
								data-idx="${UserVO.getIdx()}"
								data-tree="${treeidx}">수락</button>
							<button type="button" class="btn btn-default"
								aria-label="right Align" id="deny"
								data-idx="${UserVO.getIdx()}"
								data-tree="${treeidx}">거절</button>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="col-md-6" id="slist">
		<div class="x_panel">
			<div class="x_title">
				<a name="sendlist"></a>
				<h2>트리 회원 전체 목록</h2>
			</div>
			<div class="x_content">
				<c:set var="memberList" value="${memberList}" />
				<c:if test="${empty memberList}">
					<h3>가입된 회원이 없습니다.</h3>
				</c:if>
				<c:forEach items="${memberList}" var="UserVO">

					<div class="blockquote-box blockquote-info clearfix"
						data-row="${BucketTreeVO.getRow()}"
						data-idx="${BucketTreeVO.getIdx()}">
						<c:if test="${UserVO.getImage() != null }">
							<div class="profileImage pull-left">
								<img
									src="/BucketTree/treeMember/${UserVO.getIdx()}/profileImage"
									style="width: 60px; height: 60px;">
							</div>
						</c:if>
						<c:if test="${UserVO.getImage() == null }">
							<div class="profileImage pull-left">
								<img src="/BucketTree/images/PROFILE_image.png"
									style="width: 60px; height: 60px">
							</div>
						</c:if>
						<h4>${UserVO.name}</h4>
						<p>${UserVO.email}</p>
						
						<button type="button" class="btn btn-default"
								aria-label="right Align" id="mandate"
								data-idx="${UserVO.getIdx()}"
								data-name="${UserVO.getName()}"
								data-tree="${treeidx}">위임</button>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>
</div>

<script>
$(document).on('click', '#addMember', function() {
	var eventTarget = this;
	var userIdx = $(this).attr('data-idx');
	var treeIdx = $(this).attr('data-tree');
	
	alert("트리 가입을 수락하시겠습니까?")

	$.ajax({
		url : "/BucketTree/bucketTree/treeAdmin/addMember",
		dataType : "json",
		type : "POST",
		data : {
			user_idx : userIdx,
			tree_idx : treeIdx
		},
		success : function(data) {
			if (data){
				alert('수락 완료!')
			/* $("#" + eventIdx).remove(); */
				window.location.reload();
			}
		}
	});

});

$(document).on('click', '#deny', function() {
	var eventTarget = this;
	var userIdx = $(this).attr('data-idx');
	var treeIdx = $(this).attr('data-tree');
	
	alert("트리 가입 요청을 거절하시겠습니까?")
	$.ajax({
		url : "/BucketTree/bucketTree/treeAdmin/denyMember",
		dataType : "json",
		type : "POST",
		data : {
			user_idx : userIdx,
			tree_idx : treeIdx
		},
		success : function(data) {
			if (data)
				alert('트리 가입 요청을 거절하였습니다.')
			/* $("#" + eventIdx).remove(); */
				window.location.reload();

		}
	});

});

$(document).on('click', '#mandate', function() {
	var eventTarget = this;
	var userIdx = $(this).attr('data-idx');
	var treeIdx = $(this).attr('data-tree');
	var userName = $(this).attr('data-name');
	
	alert("※ 트리장을 위임하시겠습니까? 트리장으로서의 모든 권한이 사라집니다.")

	$.ajax({
		url : "/BucketTree/bucketTree/treeAdmin/mandate",
		dataType : "json",
		type : "POST",
		data : {
			user_idx : userIdx,
			tree_idx : treeIdx
		},
		success : function(data) {
			if (data){
				alert(userName + '님에게 트리장을 위임하였습니다.')
				window.location.reload();
			}
		}
	});

});

</script>