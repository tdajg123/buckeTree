<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>

function onclickName() {
	$('#search_param').val(1);
	$('#search_concept').text("작성자");
}
function onclickTitle() {
	$('#search_param').val(2);
	$('#search_concept').text("제목");
}


$(function() { 
	
	
	/* 검색 버튼 클릭 시 카테고리와 검색 값 넘겨줌 */
$(document).ready(function(){
		
	$(document).on('click', '#categorySelect', function(){
			
		/* 태그형식으로 카테고리 선택 값을 보여줌 */
		/* var when = categoryBox1.options[categoryBox1.selectedIndex].text;
		var who = categoryBox2.options[categoryBox2.selectedIndex].text;
		var what = categoryBox3.options[categoryBox3.selectedIndex].text; */
		
		var when =  $("#categoryBox1").val() - 1;
		var who =  $("#categoryBox2").val() - 1;
		var what =  $("#categoryBox3").val() - 1;
		
		var categoryWhen = categoryBox1.options[categoryBox1.selectedIndex].text;
		var categoryWho = categoryBox2.options[categoryBox2.selectedIndex].text;
		var categoryWhat = categoryBox3.options[categoryBox3.selectedIndex].text;
			
		alert("선택한 카테고리 : " + when + who + what);
		
		/* 태그형식으로 카테고리 선택 값을 보여줌 */
		$("#when").val(when);
		$("#who").val(who);
		$("#what").val(what); 
		
		
			
	});
	
	$(document).on('click', '#search', function(){
			
		var when = categoryBox1.options[categoryBox1.selectedIndex].text;
		var who = categoryBox2.options[categoryBox2.selectedIndex].text;
		var what = categoryBox3.options[categoryBox3.selectedIndex].text;
		
		alert("검색하러 감 ->  " + when + who + what);
		
	});
	
	$(document).on('click', '#countUp', function(){
		   var evnetTarget = this;
		   var eventIdx = $(this).attr('data_idx');
		   var eventTitle = $(this).attr('data_title');
		   
		   alert('마이 버킷리스트에도 추가되었습니다!')
		      
		   $.ajax({
		      url : "/BucketTree/bucketList/countUp",
		      dataType : "json",
		      type : "POST",
		      data : {
		    	  idx : eventIdx,
		    	  title : eventTitle
		      }
		      
		      /* success : function(data) {
		      if(data)
		    	  //$("#bucketBox").append(data);
		         
		      } */
		   });
		   
		   
		
	});
	
});
	
});
</script>

<!-- 태그형식으로 카테고리 선택 값을 보여줌 -->
<div style="display: flex; margin-left: 800px">
	<input type="button" name="when" style="background: #48c8cf; width: 80px; margin-right: 10px; display: inline-block; border: none" id="when"/>
	<input type="button" name="who" style="background: #48c8cf; width: 80px; margin-right: 10px; display: inline-block; border: none" id="who"/> 
	<input type="button" name="what" style="background: #48c8cf; width: 80px; margin-right: 10px; display: inline-block; border: none" id="what"/>
</div>
				
<div class="topbar" style="display: flex; margin-left: 500px">
	<!-- Search Form __ Start -->

	<div class="container_category"
		style="display: flex; width:900px; z-index: 9999">
		
		<div class="row_category" style= "display:inline-block">
			<!-- Button trigger modal -->
			<button class="btn btn-primary btn-lg"
				style="background: #48c8cf; border: none; margin-top: 10px" data-toggle="modal"
				data-target="#myModal">Category</button>

			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" style="width: 500px">
						<div class="modal-header" >
							<button type="button" class="close" data-dismiss="modal" >
								<span aria-hidden="true">×</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">카테고리 선택</h4>
						</div>


						<div class="row" >
							<div class="col-md-2">
								when
								<hr>
								
								<select name ="categoryBox1" id="categoryBox1">
									<option value="1">선택 없음</option> 
									<option value="2">10대</option>
									<option value="3">20대</option>
									<option value="4">30대</option>
									<option value="5">40대</option>
									<option value="6">50대 이상</option>
								</select>

							</div>

							<div class="col-md-2">
								who
								<hr>
								<select name ="categoryBox2" id="categoryBox2">
									<option value="1">선택 없음</option>
									<option value="2">혼자</option>
									<option value="3">가족</option>
									<option value="4">친구</option>
									<option value="5">직장</option>
								</select><br> <br>
							</div>

							<div class="col-md-2">
								what
								<hr>
								<select name ="categoryBox3" id="categoryBox3">
									<option value="1">선택 없음</option>
									<option value="2">여행</option>
									<option value="3">자기 계발</option>
									<option value="4">재미</option>
									<option value="5">건강</option>
									<option value="6">음식</option>
								</select><br> <br>
							</div>
						</div>
						<div style="margin-left: 405px">
							<button type="submit" class="btn btn-default" id="categorySelect"
								data-dismiss="modal" style="background: #48cfc8; color: #000">선택 완료</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	


	<!-- 폼 태그로 감싸서 값을 넘겨줄 검색 부분(검색 타입과 input) -->
	<form class="input-group" action="/BucketTree/bucketList/searchList"
		method="post" >
		<div id="searchtype" class="wrapper-dropdown-3" style= "display:flex; border:none; width: 600px; height: 40px">

			<div style="display: inline-block" >
				<!-- 검색 타입 버튼 -->
				<button data-toggle="dropdown" style= "width: 100px; height: 40px; background: #48cfc8">

					<!-- 검색 타입 값을 넘겨 받아 페이지가 넘어가도 검색 타입을 유지 -->
				<c:set var="srch" value="${srch}" />
                    	<c:choose>
						    <c:when test="${empty srch.getSrchType() }">
						    <span id="search_concept">검색 조건</span> <span class="caret"></span>
						    </c:when>
						    <c:when test="${srch.getSrchType() eq 1}">
						    <span id="search_concept">작성자</span> <span class="caret"></span>
						    </c:when>
						    <c:when test="${srch.getSrchType() eq 2}">
						    <span id="search_concept">제목</span> <span class="caret"></span>
						    </c:when>
						    
						</c:choose>
                    </button>

					<ul class="dropdown-menu" role="menu" style="width: 100px">
						<li><a onclick="onclickName()">작성자</a></li>
						<li><a onclick="onclickTitle()">제목</a></li>
					</ul>
				</div>

			<!-- 검색 부분 -->
			<div class="input-group"
				style="width: 500px; display: flex">

				
				<div style="display: none">
					<input type="hidden" id="when" name="when" value=""/>
					<input type="hidden" id="who" name="who" value=""/> 
					<input type="hidden" id="what" name="what" value=""/>
				</div>
				
				<input type="hidden" name="srchType" value="${srch.getSrchType()}" id="search_param"> 
				<input type="text" name="srchText" class="form-control" value="${srch.getSrchText()}" id="search_text"
					placeholder="Search..." style="height: 40px; width: 500px"> 
					
					<span class="input-group-btn" style="width: 40px; display: inline-block">

					<button type="submit" name="search" id="search"
						class="btn btn-search"
						style="background: #48c8cf; display:inline-block; height: 40px">
						<i class="fa fa-search"></i>
					</button>

				</span>
			</div>
			
			

		</div>

	</form>

</div>

</div>

<!-- bucketList-listAll __ Start -->

<div class="container" style="padding-top: 20px; padding-bottom: 85px">
	<div class="row"
		style="margin-left: 0px; margin-right: 0px; width: 1100px">

		<div pull-right
			style="margin-left: 980px; margin-top: 10px; display: flex">
			<form role="form" method="post">

				<div style="display: inline-block">
					<button type="submit"
						style="background: transparent; color: #0094d6; border: none">인기순</button>
				</div>
			</form>
			<div style="display: inline-block; margin-left: 10px">
				<button
					style="background: transparent; color: #0094d6; border: none">
					<a href="list">최신순</a>
				</button>
			</div>
		</div>

		<!-- ./Search Form __ End -->

		<!-- bucketList-Category & Type & Search __ End -->
		<hr>
		<section id="pinBoot" class="bucketbox">

			<c:forEach items="${list}" var="BucketListVO">
				<article class="white-panel" style="width: 260px"
					data-row="${BucketListVO.getRow()}">

					<img src="/BucketTree/images/image7.jpg" alt=""
						style="width: 260px">
					<h4>
						<a href="#">${BucketListVO.title}</a>
					</h4>
					<p style="width: 250px">${BucketListVO.contents}</p>

					<form items="${countUp}" var="BucketListVO" role="form"
						method="post" style="display: flex">
						<div
							style="display: inline-block; padding-left: 180px; padding-right: 17px">${BucketListVO.count}</div>
						<div type="button" id="countUp"
							data_idx="${BucketListVO.getIdx()}"
							data_title="${BucketListVO.getTitle()}"
							
							style="background: transparent; border: none; display: inline-block">
							<img src="/BucketTree/images/bucketicon.png"
								style="width: 40px; height: 40px">
						</div>
					</form>

				</article>

			</c:forEach>

		</section>

		<hr>
	</div>
</div>

<!-- bucketList-listAll __ End -->
