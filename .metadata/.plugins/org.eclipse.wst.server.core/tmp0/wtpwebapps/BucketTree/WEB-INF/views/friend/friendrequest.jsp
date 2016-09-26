<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script>
function onclickName(){
	$('#search_param').val(1);	
	 $('#search_concept').text("이름");
}
function onclickEmail(){
	$('#search_param').val(2);
	$('#search_concept').text("이메일");
}
//친구 삭제 이벤트
$(document).on('click', '#deleteRequest', function(){
	var evnetTarget = this;
	var eventIdx = $(this).attr('data-idx');
		alert("요청 삭제")
	$.ajax({
		url : "/BucketTree/friend/deleteRequestAjax",
		dataType : "json",
		type : "POST",
		data : {
			delete_idx : eventIdx

		},
		success : function(data) {
		if(data)
			alert('거절 완료!')
			$("#" + eventIdx).remove();
			
		}
	});

});

$(document).on('click', '#addFriend', function(){
	var evnetTarget = this;
	var eventIdx = $(this).attr('data-idx');
		
	$.ajax({
		url : "/BucketTree/friend/addFriendAjax",
		dataType : "json",
		type : "POST",
		data : {
			add_idx : eventIdx
		},
		success : function(data) {
		if(data)
			alert('수락 완료!')
			$("#" + eventIdx).remove();
			
		}
	});

});

$(window).scroll(function(){
	if  ($(window).scrollTop() >= $(document).height() - $(window).height()){

    var lastrow = $(".blockquote-box.blockquote-info.clearfix:last").attr("data-row");
    var srchType = $("#search_param").val();
    var srchText = $("#search_text").val();
    
  
    	var str='';
    	$.ajax({
    		url : "/BucketTree/Friend/sendFriendRequestAjaxList",
    		dataType : "json",
    		type : "POST",
    		data : {
    			row : lastrow,
				srchType : srchType,
				srchText : srchText
				
    		},
    		success :  function(data) {
    			if(data !=""){
    				$(data).each(
				
					function(){
						str +="<div class='blockquote-box blockquote-info clearfix' data-row='"+this.row+"'data-idx='"+this.idx+"'>"								
						+ "<div class='square pull-left'>"
						+ "<span class='glyphicon glyphicon-info-sign glyphicon-lg'></span>"
						+ "</div>"
						+ "<h4>"+this.name+"</h4>"
						+ "<p>"+this.email+"</p>"
						+ "<p id='mbp'>"
						+ "<button type='button' class='btn btn-default' aria-label='right Align' id='add' data-idx='"+this.idx+"'>"
				        + "<span class='glyphicon glyphicon-plus'></span>"
				        + "</button>"
				        + "</p>"
				        + "</div>";					      					    
					}		
					)  
					  $('#slist').append(str);
    				  }else
    					  alert('불러올 데이터가 없습니다')
    				}
    			});			
    
    }
	});
           
</script>
<body>
<div class="container">
<!-- leftMenu __ Start -->
<div class="menurow">

	<!-- Menu -->
	<div class="side-menu" style= "left: 100px; width: 200px; height: 100px">

		<nav class="navbar navbar-default" role="navigation" style= "width: 200px">
			
			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav2">

					<li><a href="/BucketTree/Friend/FriendList"><span class="glyphicon glyphicon-user"></span>
							친구 목록</a></li>
					<li><a href="/BucketTree/Friend/FriendRequestList"><span class="glyphicon glyphicon-user"></span>
							친구 맺기</a></li>
					<li><a href="/BucketTree/Friend/searchFriendList"><span class="glyphicon glyphicon-user"></span>
							친구 찾기</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

	</div>
</div>
<!-- leftMenu __ End -->
	<div class="row">
		<div class="headBar">
			<p id="hbp"></p>
			<div class="container">
</div>
		</div>
		<div class="col-md-6">
			<span><h1>받은 친구 요청</h1><a href="#sendlist">전송한 친구 요청 보기</a></span>
			<c:set var="rlist" value="${rlist}" />
			<c:if test="${empty rlist}">
			<h3>새로운 친구요청 없음</h3>
			</c:if>			
			<c:forEach items="${rlist}"  var="FriendVO">
			<div class="blockquote-box blockquote-info clearfix" data-num="${FriendVO.getRow()}" id="${FriendVO.getIdx()}">
				<div class="square pull-left">
					<span class="glyphicon glyphicon-info-sign glyphicon-lg"></span>
				</div>
				<h4>${FriendVO.name}</h4>
				<p>${FriendVO.email }</p>
				<p id="mbp">
				<button type="button" class="btn btn-default"
						aria-label="right Align" id="addFriend" data-idx="${FriendVO.getIdx()}">		
					확인
				</button>
				<button type="button" class="btn btn-default"
						aria-label="right Align" id="deleteRequest" data-idx="${FriendVO.getIdx()}">		
					거절
				</button>
					</p>
			</div>
			</c:forEach>
		</div>
				<div class="col-md-6" id="slist">
				<a name="sendlist"></a>
				<p><h1>전송한 친구 요청</h1></p>	
			<c:set var="slist" value="${slist}" />
			<c:if test="${empty slist}">
			<h3>새로운 친구요청 없음</h3>
			</c:if>				
			<c:forEach items="${slist}"  var="FriendVO">
			<div class="blockquote-box blockquote-info clearfix" data-num="${FriendVO.getRow()}" id="${FriendVO.getIdx()}">
				<div class="square pull-left">
					<span class="glyphicon glyphicon-info-sign glyphicon-lg"></span>
				</div>
				<h4>${FriendVO.name}</h4>
				<p>${FriendVO.email }</p>
				<p id="mbp">
					<button type="button" class="btn btn-default"
						aria-label="right Align" id="deleteRequest" data-idx="${FriendVO.getIdx()}">		
					요청 취소
				</button>
					</p>
			</div>
			</c:forEach>
		</div>
	</div>
	
</div>
</body>