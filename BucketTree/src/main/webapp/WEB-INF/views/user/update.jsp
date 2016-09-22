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
	<form action="mypage">
		<div class="circle2">
			<img src="/BucketTree/mypage/${userVO.getIdx()}/profile" style="width: 200px; height: 200px">
		</div>
	</form>
	<div class="module form-module">
		<div class="toggle2"></div>
		<div class="form">
			<form role="form" action="/BucketTree/update" onsubmit="return validate()" method="post" name="join">
				<div style= "display: flex">
					<input type="button" value="이름" style="display: inline-block; width: 100px"/>
					<input type="text" value="${userVO.name}" id="name" style="display: inline-block" readonly />
				</div> 
			
				<div style= "display: flex">
					<input type="button" value="아이디" style="display: inline-block; width: 100px"/>
					<input type="email" value="${userVO.email}" style="display: inline-block" readonly />
				</div>
			
				<div style= "display: flex">
					<input type="button" value="생년월일" style="display: inline-block; width: 100px"/>
					<input type="datetime" value="${userVO.birth}" style="display: inline-block" readonly />
				</div>
				
				<div style= "display: flex">
					<input type="button" value="비밀번호" style="display: inline-block; width: 100px"/>
					<input type="text" id="password" name="password" placeholder="새 비밀번호" style="display: inline-block"/> 
									
				</div>
					<span id="duplicateResult2" style="color: #ff1a53; margin-bottom: 10px; margin-left: 25px"> * 8~20자의 영문,숫자,특수문자 혼합 </span>
				
				<div style= "display: flex">
					<input type="button" value="확인" style="display: inline-block; width: 100px"/>
					<input type="text" id="newPassword" name="newPassword" placeholder="새 비밀번호 확인" style="display: inline-block"/>
				</div>
					<span id="duplicateResult3" style="color: #ff1a53; margin-bottom: 10px; margin-left: 25px"></span>
				
				<button type="submit" id="update">수정 완료</button>
			</form>
			
				<button id="delete" style= "background: #2aa09a">회원 탈퇴</button>
		</div>
	</div>
</div>

<script>

if($('#password').val() != ""){
   	$('#password').keyup();
};
if($('#newPassword').val() != ""){
   	$('#newPassword').keyup();
};
$('#password').keyup(function(){

	 var pw = $('#password').val();
	 var num = pw.search(/[0-9]/g);
	 var eng = pw.search(/[a-z]/ig);
	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

	 if((pw.length < 8 )||( pw.length > 20)){

	  $('#duplicateResult2').text("* 8 ~ 20자리 이내로 입력해주세요.");
	  
	 }else if(pw.search(" ") != -1){
		  document.getElementById("newPassword").style.marginTop="20px";
		  
	 }else if(num < 0 || eng < 0 || spe < 0 ){
		  document.getElementById("newPassword").style.marginTop="20px";
		  $('#duplicateResult2').text("* 영문, 숫자, 특수문자를 혼합하세요.");
	
	 }else{
		   
	 $('#duplicateResult2').text("* 사용가능한 비밀번호입니다.");
	 }

	});
	
$('#newPassword').keyup(function(){
	 var pass1 = document.getElementById('password');
     var pass2 = document.getElementById('newPassword');
     if(pass1.value!=pass2.value) {
    	 document.getElementById("name").style.marginTop="20px";
    	 $('#duplicateResult3').text("* 비밀번호가 일치하지 않습니다.");
  	}else{
  		 document.getElementById("name").style.marginTop="20px";
    	 $('#duplicateResult3').text("* 비밀번호가 일치합니다.");
  	}
	

});

/* 비밀번호 유효성 검사 */
function validate() {

	/**
	    회원 정보 수정 내 form 태그 내부 input 태그 값을 추출
	  form : id가 join인 태그
	**/
	
    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('newPassword');
	var form = document.join;
	
	/** 
		비밀번호 유효성 검사
	**/
	var num = pass1.value.search(/[0-9]/g); 
	var eng = pass1.value.search(/[a-z]/ig);
	var spe = pass1.value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
    var test = "Y";
        
    if(num < 0 || eng < 0 || spe < 0 ){
		alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
		form.password.focus();
		return false;
		  
	 	}else if((pass1.value.length < 8 )||( pass1.value.length > 20)){
		alert("8~ 20자리 이내로 입력해주세요.");
		form.password.focus();
		return false;

		 }else if(pass1.value.search(" ") != -1){
		alert("비밀번호는 공백없이 입력해주세요.");
		form.password.focus();백
		  return false;

		 }else if(pass1.value!=pass2.value) {
        alert("비밀번호가 일치하지 않습니다");
    	form.newPassword.focus();
        return false;
 	}
		
    
    /**
 		유효성 체크를 위한 함수 작성
    **/   
    
    function chk(re, e, msg) {
           if (re.test(e.value)) {
                   return true;
           }
           alert(msg);
           e.value = "";
           e.focus();
           return false;
    }
 }
 
$(function() {

	$(document).ready(function() {

		$(document).on('click', '#delete', function() {

			alert('정말로 탈퇴하시겠습니까?')

			$.ajax({
				url : "/BucketTree/delete",
				dataType : "json",
				type : "POST"
				
			});

		});

	});
});
</script>