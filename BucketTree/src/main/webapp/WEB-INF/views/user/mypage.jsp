<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Form Module-->
<div class="all">
	<form action="profile">
		<div class="circle2">
			<button type="submit">
				<img src="/BucketTree/mypage/${userVO.getIdx()}/profile"
					style="width: 200px; height: 200px">
			</button>
		</div>
	</form>

	<div class="module form-module">
		<div class="toggle2"></div>
		<div class="form">
			<form action="/BucketTree/mypage" method="post">
				<div style="display: flex">
					<input type="button" value="이름" id="m_input" /> <input type="text"
						value="${userVO.name}" style="display: inline-block" readonly />
				</div>

				<div style="display: flex">
					<input type="button" value="아이디" id="m_input" /> <input
						type="email" value="${userVO.email}" style="display: inline-block"
						readonly />
				</div>

				<div style="display: flex">
					<input type="button" value="생년월일" id="m_input" /> <input
						type="text" value="${userVO.birth}" style="display: inline-block"
						readonly />
				</div>

				<div style="display: flex">
					<input type="button" value="비밀번호" id="m_input" /> <input
						type="password" placeholder="현재 비밀번호를 입력." id="checkPassword"
						name="checkPassword" style="display: inline-block" />
				</div>
				<button type="submit">확인</button>
			</form>
		</div>
	</div>
</div>