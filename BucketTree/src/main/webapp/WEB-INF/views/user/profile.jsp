<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.circle2 {
	background-color: #fff;
	border: 3px #48cfc8 solid;
	width: 200px;
	height: 200px;
	-webkit-border-radius: 100px;
	-moz-border-radius: 100px;
	text-align: center;
	margin: 0 auto;
	margin-bottom: 20px;
	overflow: hidden;
}
</style>

<!-- Form Module-->
<div class="all">
	<form action="profile">
	<c:if test = "${userVO.getImage() != null }">
		<div class="circle2">
			<img src="/BucketTree/profile/${userVO.getIdx()}/profile" style="width: 200px; height: 200px">
		</div>
	</c:if>
	
	<c:if test = "${userVO.getImage() == null }">
		<div class="circle2">
			<img src="/BucketTree/images/PROFILE_image.png" style="width: 200px; height: 200px">
		</div>
	</c:if>
	
	</form>
	<div class="module form-module">
		<div class="toggle2"></div>
		<div class="form" >
			<form action="/BucketTree/profile" method="post" enctype="multipart/form-data">
			
			<div style= "display: flex">
				<input type="button" value="기본 이미지" style="display: inline-block"/>
			</div>
			
			<div style= "display: flex">
				<input type="button" value="변경할 이미지" style="display: inline-block"/>
				<input type="file" name="file" value="변경할 이미지" style="display: inline-block"/>
			</div>
			
				<button type="submit">프로필 변경 </button>
			</form>
		</div>
	</div>
</div>