<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
				<select id="when_temp"></select> <select id="who_temp"></select> <select
					id="what_temp"></select>


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

<div class="container">
	<div class="row" style="margin: 25px 0 55px 0;">
		<div class="col-md-4 col-md-offset-5" style="margin-bottom: 3px;">
			<button id="view_when" type="button" class="btn btn-success">없음</button>
			<button id="view_who" type="button" class="btn btn-success">없음</button>
			<button id="view_what" type="button" class="btn btn-success">없음</button>
		</div>
		<form:form id="form_search" method="POST" modelAttribute="pagination"
			action="/BucketTree/bucketList/list">

			<div class="col-md-11 col-md-offset-1">
				<div class="form-inline">
					<!-- Search Form __ Start -->

					<!-- 카테고리 선택 버튼 -->
					<button id="category" class="btn btn-success">카테고리</button>

					<!-- 검색 조건 선택 셀렉트 박스 -->
					<form:select path="srchType">
						<form:option value="0" label="검색조건" />
						<form:option value="1" label="버킷리스트" />
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
				</div>
			</div>
			<div class="f_right">
				<!-- 정렬 셀렉트 박스 -->
				<form:select path="orderType">
					<form:option value="1" label="최신순" />
					<form:option value="2" label="좋아요순" />
				</form:select>
			</div>
		</form:form>
	</div>



	<!-- bucketList-listAll __ Start -->

	<div id="applyBucketList" class="box box-default collapse-box">
		<div class="box-header withorder" style="padding-left: 20px;">
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-default" data-toggle="collapse"
					data-target="#collapseFriend">
					<i class="fa fa-plus"></i>
				</button>
			</div>
			<h3 class="box_title">친구 추천 BucketList</h3>
			<!-- /.box-tools -->
		</div>
		<!-- /.box-header -->
		<div class="collapse" id="collapseFriend" style="padding: 5px 22px;">
			<section class="bucketbox">
				<c:forEach items="${friendBylist}" var="BucketListVO">
					<article style="width: 260px; margin: 0 5px; display: inline-Block">
						<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">
							<c:if test="${BucketListVO.imageIdx != 0 }">
								<img src="/BucketTree/bucket/${BucketListVO.imageIdx}/image"
									alt="" style="width: 260px" onclick="">
							</c:if>
						</a>
						<h4>
							<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">${BucketListVO.title}</a>
						</h4>
						<c:if test="${BucketListVO.user_idx !=user.idx}">
							<div class="f_right" id="select" data-id="${BucketListVO.idx}"
								style="background: transparent; border: none; display: inline-block">
								<div class="btn btn-success">여행담기 ${BucketListVO.count}</div>
							</div>
						</c:if>
						<c:if test="${BucketListVO.user_idx ==user.idx}">
							<div class="f_right"
								style="background: transparent; border: none; display: inline-block">
								<div class="btn btn-success">${BucketListVO.count}</div>
							</div>
						</c:if>
					</article>
				</c:forEach>
			</section>
		</div>
	</div>


	<!-- 가입신청한 버킷트리 -->
	<!--관리자가 추천하는 버킷리스트  -->
	<div id="adminBucketList" class="box box-default collapsed-box">
		<div class="box-header withorder" style="padding-left: 20px;">
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-default" data-toggle="collapse"
					data-target="#collapseAdmin">
					<i class="fa fa-plus"></i>
				</button>
			</div>
			<h3 class="box_title">관리자 추천 BucketList</h3>
			<!-- /.box-tools -->
		</div>
		<!-- /.box-header -->
		<div class="collapse" id="collapseAdmin" style="padding: 5px 22px;">
			<section class="bucketbox">
				<c:forEach items="${adminBylist}" var="BucketListVO">

					<article style="width: 260px; display: inline-Block">


						<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">
							<c:if test="${BucketListVO.imageIdx != 0 }">
								<img src="/BucketTree/bucket/${BucketListVO.imageIdx}/image"
									alt="" style="width: 260px" onclick="">
							</c:if>
						</a>
						<h4>
							<a href="/BucketTree/bucketList/${BucketListVO.idx}/bucket.do">${BucketListVO.title}</a>
						</h4>
						<c:if test="${BucketListVO.user_idx !=user.idx}">
							<div class="f_right" id="select" data-id="${BucketListVO.idx}"
								style="background: transparent; border: none; display: inline-block">
								<div class="btn btn-success">여행담기 ${BucketListVO.count}</div>
							</div>
						</c:if>
						<c:if test="${BucketListVO.user_idx ==user.idx}">
							<div class="f_right"
								style="background: transparent; border: none; display: inline-block">
								<div class="btn btn-success">${BucketListVO.count}</div>
							</div>
						</c:if>
					</article>
				</c:forEach>
			</section>
		</div>
	</div>
	<!-- 가입신청한 버킷트리 -->


	<!-- bucketList-Category & Type & Search __ End -->
	<div class="pinboot">
		<hr>

		<section id="pinBoot"
			style="width: 1170px; margin: auto; margin-top: 10px">
			<article class="white-panel-add">
				<h4>
					<a href="/BucketTree/bucketList/bucketWrite" class="fa fa-plus"
						style="color: #fff; margin-left: 30px"> 버킷리스트 추가</a>
				</h4>
			</article>


			<c:forEach items="${mylist}" var="BucketListVO">
				<article class="white-panel" style="width: 260px">

					<c:if test="${BucketListVO.getImageIdx() != 0}">
						<img src="/BucketTree/bucket/${BucketListVO.imageIdx}/image"
							alt="" style="width: 260px" onclick="">
					</c:if>
					<h4>
						<a href="#">${BucketListVO.title}</a>
					</h4>
					<div class="f_right">
						<button class="btn btn-success" type="submit">완료</button>
					</div>
				</article>
			</c:forEach>
		</section>

		<hr>
	</div>
	<!-- bucketList-listAll __ End -->
</div>
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
                						
                						var str="<article class='white-panel' style='width: 260px'>"
                							+"<a href='/BucketTree/bucketList/"+this.idx+"/bucket.do'> ";
                							
											if(this.imageIdx != 0)
												{
												str+="<img src='/BucketTree/bucket/"+this.imageIdx+"/image' alt='' style='width: 260px'>";
												}

                		
                							 str+="</a> <h4> <a href='/BucketTree/bucketList/"+this.idx+"/bucket.do'>"+this.title+"</a> </h4>";
                							if(this.user_idx != ${user.idx})
                								{
                								   str+="<div class='f_right' id='select' data-id='" +this.idx+"' style='background: transparent; border: none; display: inline-block'>";
                								   str+="<div class='btn btn-success'>여행담기"+ this.count+ "</div>";
                								   str+="</div>";
                								}
                							if(this.user_idx == ${user.idx})
                								{
                								  str+="<div class='f_right'  style='background: transparent; border: none; display: inline-block'>";
              								      str+="<div class='btn btn-success'"+ this.count+ "</div>";
              								      str+="</div>";
                								}
                							 
                								  str+="</article>";
                								  
                								  $('.bucketbox').append(str);
                					});
                                  }
                		       });
                		   }
                   }
    });
                
	
	
	
	
	$(document).on("click","#select",function(){
				
		    //같은 이름의 타이틀이 존재하는지 검사
		    var title_idx=$(this).attr("data-id");
		    
		       $.ajax({
                                  url : "/BucketTree/bucketList/searchTitle",
                                  dataType : "json",
                                  type : "POST",
                                  sync :false,
                                  data :{idx: title_idx},
                                  success : function(data) {
                				
								
                                 		if(true==data)
                                 			{
                                 			  alert('이미 같은 이름의 버킷리스트가 있습니다');
                                 			}
                                 		
                                 		else if(false==data)
                                 		{
                                 			
                                 	       $.ajax({
                                               url : "/BucketTree/bucketList/countUpAddBucket",
                                               dataType : "json",
                                               type : "POST",
                                               sync :false,
                                               data :{idx: title_idx},
                                               success : function(data) {
                             				
             										
                                            	
                                            	
                                                 }
                                    			});
                                 	       alert('담기에 성공하였습니다');
                                 	       location.href="/BucketTree/bucketList/list?${pagination.queryString}";

                                 		}
                				
                                }
                       });
		       
		       
		
		    
			
			
			
			//있으면 있다고 알려줌
			
			//없으면 count1 증가시켜주고, 버킷 담기
			
	});
	
	
});

   

  
</script>