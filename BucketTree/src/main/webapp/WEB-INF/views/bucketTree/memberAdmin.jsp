<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<hr>
	<div class="row">
		<div class="col-md-12">	
		<c:forEach items="${list}" var="UserVO">

			
				<div class="blockquote-box blockquote-info clearfix"
					data-row="${UserVO.getRow()}" data-idx="${UserVO.getIdx()}">
					<c:if test = "${userVO.getImage() != null }">
						<div class="square pull-left" style="padding:0px">
							<img src="/BucketTree/Friend/${userVO.getIdx()}/profile" style="height:95px">
						</div>
					</c:if>
					<c:if test = "${userVO.getImage() == null }">
						<div class="square pull-left">
							<span class="glyphicon glyphicon-info-sign glyphicon-lg"></span>
						</div>
					</c:if>
					<h4>${UserVO.name}</h4>
					<p>${UserVO.email }</p>
					<p id="mbp">
						<button type="button" class="btn btn-default"
							aria-label="right Align" id="add" data-idx="${UserVO.getIdx()}">
							<span class="glyphicon glyphicon-plus"></span>
						</button>
					</p>
				</div>
				
			
		</c:forEach>
			</div>
	</div>