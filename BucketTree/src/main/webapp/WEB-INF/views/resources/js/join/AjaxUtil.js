/*
 * AjaxUtil.js

/* 브라우저  버전에 따른 객체 생성 */
var XMLHttp = null;
function getXMLHttpRequest(){
	if(XMLHttp == null){
		var tryThese = [ function(){return new ActiveXObject('Microsoft.XMLHTTP');},
							function(){return new ActiveXObject('Msxml2.XMLHTTP');},
							function(){return new XMLHttpRequest();},
							function(){return new ActiveXObject('Msxml2.XMLHTTP.7.0');},
							function(){return new ActiveXObject('Msxml2.XMLHTTP.6.0');},
							function(){return new ActiveXObject('Msxml2.XMLHTTP.5.0');},
							function(){return new ActiveXObject('Msxml2.XMLHTTP.4.0');},
							function(){return new ActiveXObject('Msxml2.XMLHTTP.3.0');},
							function(){return new Exception('Your browser does not support XMLHtttpRequest');}
							];
		for(var i=0; i<tryThese.length; i++){
			XMLHttp = tryThese[i];
			var func = tryThese[i];
			try{
				return func();
			}catch(e){
				//pass
			} 
		}
	}else{
		return XMLHttp();
	}
}

//XMLHttpRequest 객체 호출및 생성
//URL, Param, Call Function
function xmlhttpPost(strURL, strSubmit, strResultFunc, returnType){
	xmlhttpReq(strURL, strSubmit, strResultFunc, returnType, "POST");
}
function xmlhttpReq(strURL, strSubmit, strResultFunc, returnType, sendType){	
	var xmlHttpReq = false;
	try{
		xmlHttpReq = getXMLHttpRequest();
	}catch(e){
		alert('Fail XmlRequest Object create : ' + e.message);
		return;
	}
	
	//xmlHttpReq.open('POST' OR 'GET', strURL, true(비동기) or false(동기));
	if(sendType == null){
		sendType = "POST";
	}
	xmlHttpReq.open(sendType, strURL, true);
	
	//POST방식일 경우 content-type을 정의해야 한다.
	xmlHttpReq.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	
	if('JSON' == returnType){
		xmlHttpReq.onreadystatechange = function(){
			//4는 정상상태
			if(xmlHttpReq.readyState == 4){
				try{
					eval(strResultFunc + '(eval(' + xmlHttpReq.responseText + ' ));');
				}catch(e){
					alert(e.message);
					document.write(xmlHttpReq.responseText);
				}
			}
		}		
	}else{
		xmlHttpReq.onreadystatechange = function() {
			//4 : 정상상태
			if(xmlHttpReq.readyState == 4) {
				eval(strResultFunc + '(xmlHttpReq);');
			}
		}
	}
	
	//서버로 데이터 전송
	try{
		xmlHttpReq.send(strSubmit);
	}catch(e){
		alert('Fail send data : ' + e.message + '\nstrSubmit : ' + strSubmit);
		return;
	}
}

function frmData2queryString(frmObj){
	return data2QueryString(frmObj.name, frmObj.value);
}
function data2QueryString(name, value){
	if(value != null && value != ''){
		return name + '=' + encodeURIComponent(value);
	}else{
		return name + '=';
	}
}
