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
function onclickAddFriend(){
	
}

//무한스크롤을 위한 스크롤 체크
$(document).ready(function () {
	$(document).scroll(function() {
		var maxHeight = $(document).height();
		var currentScroll = $(window).scrollTop() + $(window).height();
	    var lastrow = $(".blockquote-box blockquote-info clearfix:last").attr("data-row");
		if (maxHeight <= currentScroll + 100){
			$.ajax({
				type : 'post' ,
				url : '/BucketTree/Friend/searchAjaxFriendList',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'json',
				data : {row:lastrow},
				success : function(data){
					
	
				}
			});		
			
								 			  }
                                   })
           });
</script>
<div class="container">
<!-- leftMenu __ Start -->
<div class="menurow">

	<!-- Menu -->
	<div class="side-menu" style= "left: 100px; width: 200px; height: 200px">

		<nav class="navbar navbar-default" role="navigation" style= "width: 200px">
			
			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav2">

					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							친구 목록</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							친구 맺기</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
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
    <div class="row">    
        <div class="col-xs-8 col-xs-offset-2">
		    <form class="input-group" action="/BucketTree/Friend/searchFriendListPost" method="post">
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">검색 조건</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a onclick="onclickName()">이름</a></li>
                      <li><a onclick="onclickEmail()">이메일</a></li>
                    </ul>
                </div>
                <input type="hidden" name="srchType" value="${srch.getSrchType()}" id="search_param">         
                <input type="text" class="form-control" name="srchText" value="${srch.getSrchText()}">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                </span>
            </form>
        </div>
	</div>
</div>
		</div>
		<div class="col-md-6">
			<c:forEach items="${list}"  var="FriendVO">
			<div class="blockquote-box blockquote-info clearfix" data-num="${FriendVO.getRow()}">
				<div class="square pull-left">
					<span class="glyphicon glyphicon-info-sign glyphicon-lg"></span>
				</div>
				<h4>${FriendVO.name}</h4>
				<p>${FriendVO.email }</p>
		<p id="mbp">
					<button type="button" class="btn btn-default" onclick="onclickAddFriend();"
						aria-label="right Align">			
					<span class="glyphicon glyphicon-plus"></span>
					</button>
					</p>
			</div>
			</c:forEach>
		</div>
	</div>
	
</div>