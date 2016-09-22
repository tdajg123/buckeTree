<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<tiles:insertAttribute name="header" />
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>

	<!-- Form Module-->
	<div class="module form-module">
		<!-- 회원가입창으로 이동하는 아이콘  -->
		<div class="toggle">
			<i class="fa fa-times"></i>
			<div class="tooltip">JOIN US</div>
		</div>
		<!-- 로그인부분  -->
		<div class="form">
			<div class="login_logo">
				<img id="logo" src="/BucketTree/images/BUCKET_LOGO.png"
					onmouseover="this.src='/BucketTree/images/BUCKET_LOGO_HOVER.png'"
					onmouseout="this.src='/BucketTree/images/BUCKET_LOGO.png'"
					style="border: 0 solid">
			</div>
			<form method="POST" action="/BucketTree/login_processing">
				<input name="email" id="login_email" type="text"
					placeholder="Email Address" /> <input name="password"
					id="login_pw" type="password" placeholder="Password" />
				<button>Login</button>
				<div id="joinus">JOIN US</div>
				<div class="fpw">Forgot your password?</div>
			</form>
		</div>
		<!-- 회원가입부분  -->
	<div class="form1">
		<h2>CREATE AN ACCOUNT</h2>
		<form method="POST" action="user/create" onsubmit="return validate()" name="join"> 
			<input id="create_email" name="create_email" type="email" placeholder="Email Address" value="${UserVO.email}"/> 
			<span id="duplicateResult1">        
        	</span>
			<input id="create_pw" name="create_pw" type="password" placeholder="Password" /> 
			<span id="duplicateResult2">
				* 8~20자의 영문,숫자,특수문자 혼합
        	</span>
        	<input id="create_pw2" name="create_pw2" type="password" placeholder="Password identify" /> 
			<span id="duplicateResult3">        
        	</span>
			<input id="create_name" name="create_name" type="text"	placeholder="Username" /> 
			<input id="create_birth" name="create_birth" type="date" placeholder="BIRTH DAY" />
			<div class="g-recaptcha" data-sitekey="6LdPxigTAAAAADwG8VjJoQfXux6HIIZpr6vzEwrc"></div>
			<input type="hidden" id="idcheck" name="idcheck" value="N" />
			<button id="register" type="submit">Register</button>
		</form>
	</div>

		<!-- 비밀번호찾기부분  -->
		<div class="form2">
			<h2>FORGOT PASSWORD</h2>
			<form method="post">
				<input id="password_email" name="password_email" type="email"
					placeholder="Email Address" /> <input id="password_name"
					name="password_name" type="text" placeholder="Name" />
				<button type="button" id="search">Search</button>
			</form>
		</div>

		<!-- 누르면 비밀번호 찾기로 넘어가는 부분  -->
		<div class="cta">
			<div id="result"></div>
		</div>
	</div>


	<!-- JS  -->
	<script>
		$('#search').click(function() {

			$.ajax({
				url : "/BucketTree/user/searchUserAjax",
				dataType : "json",
				type : "POST",
				data : {
					password_email : $('#password_email').val(),
					password_name : $('#password_name').val()
				},
				success : function(data) {
					if (data) {
						$('#result').text("이메일로 임시비밀번호를 보냈습니다.")
					} else {
						$('#result').text("유효하지않은 이메일입니다.")
					}
				}
			});
		});

		//회원가입
		$('.toggle').attr('on', 'false');
		$('.form').attr('on', 'true');
		$('.form1').attr('on', 'false');
		$('.form2').attr('on', 'false');

		$('.toggle').click(
				function() {

					$('.toggle').attr('on', 'true');
					$('#result').text("");

					if ($('.form').attr('on') == 'false'
							&& $('.form1').attr('on') == 'true') {
						$('.form1').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");
						$('.form').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

						$('.form').attr('on', 'true');
						$('.form1').attr('on', 'false');

					}

					if ($('.form').attr('on') == 'false'
							&& $('.form2').attr('on') == 'true') {
						$('.form2').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");
						$('.form').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

						$('.form').attr('on', 'true');
						$('.form2').attr('on', 'false');

					}

					if ($('.toggle').attr('on') == 'true') {
						$('.toggle').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");
					}

				});

		$('#joinus').click(
				function() {
					$('.toggle').attr('on', 'false');
					$('#result').text("");

					if ($('.toggle').attr('on') == 'false') {
						$('.toggle').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

					}

					$('.form').attr('on', 'false');
					$('.form1').attr('on', 'true');

					if ($('.form').attr('on') == 'false'
							&& $('.form1').attr('on') == 'true') {
						$('.form').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");
						$('.form1').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

					}

				});
		//비밀번호찾기
		$('.fpw').click(
				function() {
					$('.toggle').attr('on', 'false');
					$('#result').text("");

					if ($('.toggle').attr('on') == 'false') {
						$('.toggle').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

					}

					$('.form').attr('on', 'false');
					$('.form2').attr('on', 'true');

					if ($('.form').attr('on') == 'false'
							&& $('.form2').attr('on') == 'true') {
						$('.form').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");
						$('.form2').animate({
							height : "toggle",
							'padding-top' : 'toggle',
							'padding-bottom' : 'toggle',
							opacity : "toggle"
						}, "slow");

					}

				});

		$('#find').click(function() {
			$('.al').attr('.al');
		});
		
		if($('#create_email').val() != ""){
		   	$('#create_email').keyup();
		};
		$('#create_email').keyup(function(){
		
			var email = $('#create_email').val();
			var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
			if(regex.test(email)==false){
				 document.getElementById("create_pw").style.marginTop="20px";
				 $('#duplicateResult1').text("* 올바르지 않은 형식입니다")
			}else{
			var result = $('#duplicateResult').val();
			$.post('<c:url value="/user/checkDuplicateEmailAjax"/>'
		            ,{'create_email' : $('#create_email').val()}
		            , function(data){
		            console.log(data);
		        
		        if(data =="true"){
		        	 document.getElementById("create_pw").style.marginTop="20px";
		        	 $('#idcheck').val('N');
		        	 $('#duplicateResult1').text("* 이미사용중인 이메일입니다.")
		            
		        }else{
		        	 document.getElementById("create_pw").style.marginTop="20px";
		        	 $('#idcheck').val('Y');
		        	 $('#duplicateResult1').text("* 사용가능한 이메일입니다.")
		            
		        }  	
		            })};
			
		})
		if($('#create_pw').val() != ""){
		   	$('#create_pw').keyup();
		};
		if($('#create_pw2').val() != ""){
		   	$('#create_pw2').keyup();
		};
		$('#create_pw').keyup(function(){

			 var pw = $('#create_pw').val();
			 var num = pw.search(/[0-9]/g);
			 var eng = pw.search(/[a-z]/ig);
			 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

			 

			 if((pw.length < 8 )||( pw.length > 20)){

			  $('#duplicateResult2').text("* 8 ~ 20자리 이내로 입력해주세요.");
			  

			 }else

			 if(pw.search(" ") != -1){
				  document.getElementById("create_pw2").style.marginTop="20px";
				  
			 }else if(num < 0 || eng < 0 || spe < 0 ){
				  document.getElementById("create_pw2").style.marginTop="20px";
				  $('#duplicateResult2').text("* 영문, 숫자, 특수문자를 혼합하세요.");
			
			 }else{
				   
			 $('#duplicateResult2').text("* 사용가능한 비밀번호입니다.");
			 }



			});
		$('#create_pw2').keyup(function(){
			 var pass1 = document.getElementById('create_pw');
		     var pass2 = document.getElementById('create_pw2');
		     if(pass1.value!=pass2.value) {
		    	 document.getElementById("create_name").style.marginTop="20px";
		    	 $('#duplicateResult3').text("* 비밀번호가 일치하지 않습니다.");
		  	}else{
		  		 document.getElementById("create_name").style.marginTop="20px";
		    	 $('#duplicateResult3').text("* 비밀번호가 일치합니다.");
		  	}
			

		});
			// 회원가입 폼 검사  (controller로 값을 넘겨주기 전에 이 부분에서 검사를 실시한다.)
		function validate() {

				/**
				    회원가입 form 태그 내부 input 태그 값을 추출
				  form : id가 join인 태그
				  val  : id가 idcheck인 태그의 value		
				**/
				
				var email = document.getElementById('create_email');
		        var pass1 = document.getElementById('create_pw');
		        var pass2 = document.getElementById('create_pw2');
		        var name = document.getElementById('create_name');
		        var birth = document.getElementById('create_birth');
		 	    var form = document.join;
		 	    var val = $('#idcheck').val();
		 	
		 	    /**
		 	       pass1.value의 정규식과 일치하는 문자의 자릿수를 리턴
		 		   num : 숫자 , eng : 영문 , spe : 특수문자 
		 	       test : 이메일 중복체크를 위한 값 , Y면 사용 가능한 이메일
		 		 **/
		 		
		 	    var num = pass1.value.search(/[0-9]/g); 
		 		var eng = pass1.value.search(/[a-z]/ig);
		 		var spe = pass1.value.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		        var test = "Y";
		 		
		 		/** 이메일 유효성,중복 검사
		           4글자 이상(\w = [a-zA-Z0-9_], [\w-\.]) @가 나오고
		           1글자 이상(주소). 글자 가 1~3번 반복됨
		        **/
		        
		        if(!chk(/^[\w]{4,}@[\w]+(\.[\w-]+){1,3}$/, email, "이메일 형식에 어긋납니다.")){
		               return false;}
		        else  if(val != test ){
		     		alert("중복된 이메일입니다.")
		     		return false;	
		     	}
		       
		 		
		 		/** 
		 			비밀번호 유효성 검사 , 스팸방지 코드 검사
		 		**/
		 		
		        if(num < 0 || eng < 0 || spe < 0 ){
					alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
					form.create_pw.focus();
					return false;
		  		  
		  	 	}else if((pass1.value.length < 8 )||( pass1.value.length > 20)){
					alert("8~ 20자리 이내로 입력해주세요.");
					form.create_pw.focus();
		  		  return false;

		  		 }else if(pass1.value.search(" ") != -1){
					alert("비밀번호는 공백없이 입력해주세요.");
					form.create_pw.focus();백
		  		  return false;

		  		 }else if(pass1.value!=pass2.value) {
		            alert("비밀번호가 일치하지 않습니다");
		        	form.create_pw2.focus();
		            return false;
		     	}else if (typeof(grecaptcha) != 'undefined') {
		            //캡차가 체크되지 않았을 경우
		            if (grecaptcha.getResponse() == "") {
		                alert("스팸방지코드를 확인해 주세요.");
		                return false;
		            }
		     	}	
		 		
		        /** 
		        	이름 유효성 검사       
		        **/               
		        
		           if(!chk(/^[가-힝]{2,}$/, name, "이름은 2글자 이상이여야 합니다")) {
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
	</script>
</body>
</html>