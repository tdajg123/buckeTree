<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="circle2">
			<button type="submit"><img src="/BucketTree/mypage/${userVO.getIdx()}/profile" style="width: 200px; height: 200px"></button>
		</div>
	</form>
	
	<div class="module form-module">
		<div class="toggle2"></div>
		<div class="form" >
			<form action="/BucketTree/mypage" method="post">
			<div style= "display: flex">
				<input type="button" value="이름" style="display: inline-block; width: 100px"/>
				<input type="text" value="${userVO.name}" style="display: inline-block" readonly />
			</div> 
			
			<div style= "display: flex">
				<input type="button" value="아이디" style="display: inline-block; width: 100px"/>
				<input type="email" value="${userVO.email}" style="display: inline-block" readonly />
			</div>
			
			<div style= "display: flex">
				<input type="button" value="생년월일" style="display: inline-block; width: 100px"/>
				<input type="text" value="${userVO.birth}" style="display: inline-block" readonly />
			</div>
			
			<div style= "display: flex">
				<input type="button" value="비밀번호" style="display: inline-block; width: 100px"/>
				<input type="password" placeholder="현재 비밀번호를 입력." id="checkPassword" name="checkPassword" style="display: inline-block"/> 
			</div>
				<button type="submit">확인 </button>
			</form>
		</div>
	</div>
</div>