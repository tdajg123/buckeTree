<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/BucketTree/css/bucketTree.css" rel="stylesheet"
	type="text/css" />

<div class="topbar" style="display: flex; margin-left: 280px">
	<!-- Search Form __ Start -->

	<div class="container_category"
		style="display: flex; width: 900px; z-index: 9">

		<div class="row_category" style="display: inline-block">

			<!-- 카테고리 모달창 -->
			<div class="modal fade" id="category_modal" role="dialog"
				style="z-index: 99999; position: fixed">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 15px 50px;"></div>
						<div class="modal-body" style="padding: 40px 50px;">

							<div style="display: flex; margin-left: 65px">
								<div style="display: inline-block">
									<h3>WHEN</h3>
								</div>
								<div style="display: inline-block; margin-left: 80px">
									<h3>WHO</h3>
								</div>
								<div style="display: inline-block; margin-left: 80px">
									<h3>WHAT</h3>
								</div>
							</div>
							<select id="when_temp"></select> <select id="who_temp"></select>
							<select id="what_temp"></select>


						</div>
						<div class="modal-footer">
							<button type="submit" id="categoryAble" class="btn btn-default">
								<span class="fa fa-check"></span><span id="categoryState">카테고리
									검색 비활성화</span>
							</button>
							<button type="submit" id="btn" class="btn btn-default"
								data-dismiss="modal">
								<span class="fa fa-check"></span> 확인
							</button>
						</div>
					</div>
				</div>
			</div>

		</div>


		<div class="row"
			style="margin-left: 0px; margin-right: 0px; width: 1100px">
			<div
				style="margin: auto; width: 250px; margin-bottom: 3px; margin-left: 750px">
				<button id="view_when" type="button" class="btn btn-success">없음</button>
				<button id="view_who" type="button" class="btn btn-success">없음</button>
				<button id="view_what" type="button" class="btn btn-success">없음</button>
			</div>
			<div class="form-inline">
				<!-- Search Form __ Start -->
				<form:form id="form_search" method="POST"
					modelAttribute="pagination" action="/BucketTree/bucketTree/list">

					<!-- 정렬 셀렉트 박스 -->
					<form:select path="orderType">
						<form:option value="1" label="최신순" />
						<form:option value="2" label="인기순" />
					</form:select>

					<!-- 카테고리 선택 버튼 -->
					<button id="category" class="btn btn-success">카테고리</button>

					<!-- 검색 조건 선택 셀렉트 박스 -->
					<form:select path="srchType">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="버킷트리" />
						<form:option value="2" label="작성자" />
					</form:select>

					<!-- 검색 input 박스 -->
					<div class="input-group"
						style="width: 400px; display: inline-block">

						<form:input path="srchText" type="text" class="form-control"
							placeholder="Search..." style="height: 40px" />
					</div>
					<button type="submit" class="btn btn-success">검색</button>

					<c:if
						test="${ (pagination.srchType != 0)  ||  (pagination.categoryType != 0)}">
						<a href="/BucketTree/bucketTree/list" class="btn btn-success">취소</a>
					</c:if>

					<!-- 선택된 카테고리 값 -->
					<form:input path="who" type="hidden" />
					<form:input path="when" type="hidden" />
					<form:input path="what" type="hidden" />
					<form:input path="categoryType" type="hidden" />
					<form:input path="currentPage" type="hidden" />

				</form:form>
			</div>


		</div>


	</div>

</div>

<!-- bucketList-listAll __ Start -->

<div class="container" style="padding-top: 20px; padding-bottom: 85px">
	<div class="row"
		style="margin-left: 0px; margin-right: 0px; width: 1100px">

		<div
			style="display: inline-block; margin-top: 10px; margin-bottom: 10px">
		</div>

		<!-- bucketList-Category & Type & Search __ End -->
		<hr>

		<section id="pinBoot" class="bucketbox">



			<c:forEach items="${list}" var="BucketListVO">

				<article class="white-panel " style="width: 260px"">

					<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">

					<c:if test="${BucketListVO.imageIdx !=0}">
						<img src="/BucketTree/bucket/${BucketListVO.imageIdx }/image/"
							alt="" style="width: 260px" onclick="">
					</c:if>
					</a>
					<h4>
						<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">${BucketListVO.title}</a>
					</h4>
					
					<c:if test="${BucketListVO.user_idx !=user.idx}">
					<form  role="form"
						method="post" style="display: flex">
						<div
							style="display: inline-block; padding-left: 180px; padding-right: 17px">${BucketListVO.count}</div>
						<div type="button" id="countUp" style="background: transparent; border: none; display: inline-block">
							<img src="/BucketTree/images/bucket2.png"
								style="width: 40px; height: 40px">
						</div>
					</form>
					</c:if>

				</article>
			</c:forEach>
		</section>

		<hr>
	</div>
</div>

<!-- bucketList-listAll __ End -->

<script>
$(function() {
	$(".bs-calltoaction").click(function() { location.href = $(this).attr("data-url"); });
	
	
	//카테고리 옵션으로 값뿌려주기
	<c:forEach items="${what}" var="what">
	$('#what_temp')
			.append(
					"<option value='${what.idx}' ${pagination.what==what.idx ? 'selected' : '' }> ${what.what} </option>");
	</c:forEach>
	<c:forEach items="${when}" var="when">
	$('#when_temp')
			.append(
					"<option value='${when.idx}' ${pagination.when==when.idx ? 'selected' : '' }> ${when.when} </option>");
	</c:forEach>
	<c:forEach items="${who}" var="who">
	$('#who_temp')
			.append(
					"<option value='${who.idx}' ${pagination.who==who.idx ? 'selected' : '' }> ${who.who} </option>");
	</c:forEach>
	//

	<c:if test="${pagination.categoryType==1}">
	$('#view_when').html($('#when_temp option:selected').text());
	$('#view_who').html($('#who_temp option:selected').text());
	$('#view_what').html($('#what_temp option:selected').text());
	$('#view_when').show();
	$('#view_who').show();
	$('#view_what').show();
	</c:if>

	<c:if test="${pagination.categoryType==0}">
	$('#view_when').hide();
	$('#view_who').hide();
	$('#view_what').hide();
	</c:if>

	$('#category').click(function(e) {
		e.preventDefault();
		$('#category_modal').modal();
	});

	$('#when_temp').change(function() {
		$('#view_when').html($('#when_temp option:selected').text());
		$('#when').val($('#when_temp option:selected').val());
	});
	$('#who_temp').change(function() {
		$('#view_who').html($('#who_temp option:selected').text());
		$('#who').val($('#who_temp option:selected').val());
	});
	$('#what_temp').change(function() {
		$('#view_what').html($('#what_temp option:selected').text());
		$('#what').val($('#what_temp option:selected').val());
	});

	$('#categoryAble').click(function() {

		if ($('#categoryState').html() == '카테고리 검색 활성화') {
			$('#category').html('카테고리X');
			$('#categoryState').html('카테고리 검색 비활성화');
			$('#view_when').hide();
			$('#view_who').hide();
			$('#view_what').hide();
			$('#categoryType').val(0);
		} else {
			$('#category').html('카테고리O');
			$('#categoryState').html('카테고리 검색 활성화');
			$('#view_when').show();
			$('#view_who').show();
			$('#view_what').show();
			$('#categoryType').val(1);
		}

	});
	

	var pageCount=${pageCount}
	//검색
	var pagination={};
	pagination.orderType=$('select[name=orderType] option:selected').val();
	pagination.srchType=$('select[name=srchType] option:selected').val();
	pagination.srchText=$('input[name=srchText]').val();
	pagination.who=$('input[name=who]').val();
	pagination.when=$('input[name=when]').val();
	pagination.what=$('input[name=what]').val();
	pagination.categoryType=$('input[name=categoryType]').val();
	

	$('#form_search').submit(function() {
		 $('input[name=currentPage]').val(1);
	});
	
	 //무한 스크롤
    $(window).scroll(function() {
   
                   if ($(window).scrollTop() >= $(document).height()- $(window).height()-3) {
                	  
                	   
                	   if($('input[name=currentPage]').val() <= pageCount)
                		   {
                		       $('input[name=currentPage]').val( parseInt($('input[name=currentPage]').val()) +1 );
                		       pagination.currentPage= $('input[name=currentPage]').val();
                		       
                		           
                		       $.ajax({
                                  url : "/BucketTree/bucketList/ajaxlist",
                                  dataType : "json",
                                  type : "POST",
                                  sync :false,
                                  contentType: "application/json",
                                  data :JSON.stringify(pagination),
                                  success : function(data) {
                					$(data).each(function() {
                               		var str ="<article class='white-panel ' style='width: 260px'>"+
                               		   "<a href='/BucketTree/bucketList/"+this.idx+"/bucket.do'>";
                    					
										if(this.imageIdx !=0)
											{
											 str+="<img src='/BucketTree/bucket/"+this.imageIdx +"/image/' alt='' style='width: 260px' onclick=''>";
											}
                    					
										str += "</a> <h4><a href='/BucketTree/bucketList/"+this.idx +"/bucket.do'>"+ this.title+"</a></h4>";
										if(this.user_idx != ${user.idx})
										{
											str +="<form  role='form' method='post' style='display: flex'> <div ";
											str +="style='display: inline-block; padding-left: 180px; padding-right: 17px'>"+this.count+"</div>";
											str +="<div type='button' id='countUp' style='background: transparent; border: none; display: inline-block'>";
											str +="<img src='/BucketTree/images/bucket2.png' style='width: 40px; height: 40px'> </div> </form>";
                    			
										}
                					
                    					$('.bucketbox').append(str);
                                 				
                					});
                                }
                               });
                		       
                		   }
            
                	   
                	   
                	   
                   }
                });
	 
	
});

   

  
</script>