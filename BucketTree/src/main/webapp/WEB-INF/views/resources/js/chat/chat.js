//채팅& 메신저 가능한 친구 목록을 검색하는데 쓰는 객체
var pagination={};
//웹소켓 객체
var ws;
//내가 메신저 보낼때 사용하는 객체
var messenger = {};
//활성화한 상대방 객체
var to_user = {};

//친구목록을 갱신하는 ajax
function MessengerFriendUpdateAjax(pagination)
{
	
    $.ajax({
        url: "/BucketTree/Friend/MessengerFriendList",
        dataType: "json",
        type: "POST",
        data: pagination,
        success: function(data) {
        		
        	MessengerFriendUpdateTag(data)
        }
    });
}
//새로운 메신저 보낸 친구목록을 갱신하는 ajax
function NewMessengerFriendUpdateAjax()
{
    $.ajax({
    	url: "/BucketTree/Friend/NewMessengerFriendList",
    	dataType: "json",
        type: "POST",
        async: false,
        success: function(data) {
        		
        	NewMessengerFriendUpdateTag(data)

        }
        
    });

}

//친구 목록 업데이트 태그 
function MessengerFriendUpdateTag(data)
{
    $.each(data,function(entryIndex,entry) {
            $('.MessengerFriendList').append("<div class='box-body addClass MessenegerFriend' data-id=" + entry.idx + ">");
            $('.MessengerFriendList').append("</div>");
            $('.MessenegerFriend:last').append("<img src='/BucketTree/images/user1-128x128.jpg' class='user-image' alt='User Image'>");
            $('.MessenegerFriend:last').append("<div class='chat_info'> </div>");
            $('.chat_info:last').append("<span class='chat_name'>" +entry.name +"</span>");
            $('.chat_info:last').append("<p>" + entry.email +"</p>");
            });
}
//새로운 메신저 보낸 친구 목록 업데이트 태그 
function NewMessengerFriendUpdateTag(data)
{
	 $.each(data,function(entryIndex,entry) {
             $('.MessengerFriendList').prepend("<div class='box-body addClass newMessenegerFriend' data-id=" + entry.idx + ">");
             $('.MessengerFriendList').prepend("</div>");
             $('.newMessenegerFriend:first').append("<img src='/BucketTree/images/user1-128x128.jpg' class='user-image' alt='User Image'>");
             $('.newMessenegerFriend:first').append("<div class='chat_info'> </div>");
             $('.chat_info:first').append("<span class='chat_name'>" +entry.name +"</span>");
             $('.chat_info:first').append("<span class='badge bg-green right'>NEW</span>");
             $('.chat_info:first').append("<p>" +entry.email +"</p>");
         });
}
//메신저 받았을때 추가하는 태그
function receviceMessengerTag(message)
{
    $('.direct-chat-messages:last').append('<div class="direct-chat-msg doted-border">');
    $('.direct-chat-messages:last').append('</div>');
    $('.doted-border:last').append('<div class="direct-chat-info clearfix"> </div>');
    $('.direct-chat-info:last').append('<span class="direct-chat-name pull-left">' +to_user.name + '</span>');
    $('.doted-border:last').append('<img alt="iamgurdeeposahan" src="/BucketTree/images/user1-128x128.jpg" class="direct-chat-img">');
    $('.doted-border:last').append('<div class="direct-chat-text">' + message.contents +'</div>');
    $('.doted-border:last').append('<div class="direct-chat-info clearfix"> </div>');
    $('.direct-chat-info:last').append('<span class="direct-chat-timestamp pull-right">' +message.date.substring(11, 16) + '</span>');
}
//메신저 보낼때 추가하는 태그
function sendMessengerTag(messenger)
{
    //메세지 내용
    $('.direct-chat-messages:last').append('<div class="direct-chat-msg doted-border">');
    $('.direct-chat-messages:last').append('</div>');
    $('.doted-border:last').append('<div class="direct-chat-text-send pull-right">');
    $('.doted-border:last').append('</div>');
    $('.direct-chat-text-send:last').append('<span class="direct-chat-text-send ">' +messenger.contents + '</span>');
    //메세지 날짜
    $('.doted-border:last').append('<div class="direct-chat-info clearfix">')
    $('.doted-border:last').append('</div>');
    $('.direct-chat-info:last').append('<span class="direct-chat-timestamp pull-left">' +messenger.date.substring(11, 16) +'</span>');
    $("#status_message").val('');
}
//날짜 
function getDateStamp() {
    var d = new Date();
    var s = leadingZeros(d.getFullYear(), 4) + '-' +
        leadingZeros(d.getMonth() + 1, 2) + '-' +
        leadingZeros(d.getDate(), 2);
    return s;
}
//날짜 시간
function getTimeStamp() {
    var d = new Date();
    var s = leadingZeros(d.getFullYear(), 4) + '-' +
        leadingZeros(d.getMonth() + 1, 2) + '-' +
        leadingZeros(d.getDate(), 2) + ' ' +
        leadingZeros(d.getHours(), 2) + ':' +
        leadingZeros(d.getMinutes(), 2) + ':' +
        leadingZeros(d.getSeconds(), 2) + ':' +
        leadingZeros(d.getMilliseconds(), 3);

    return s;
}

function leadingZeros(n, digits) {
    var zero = '';
    n = n.toString();

    if (n.length < digits) {
        for (i = 0; i < digits - n.length; i++)
            zero += '0';
    }
    return zero + n;
}

//웹소켓 연결
  function connect() {
      ws = new SockJS('/BucketTree/Messeneger');
      ws.onopen = function() {

          //두달 지난 메세지 삭제하기
          //ajax구현	  
          $.ajax({
              url: "/BucketTree/Messenger/deleteByMyMesseneger",
              type: "POST",
              async: false,
              data: {
                  idx: messenger.from_user_idx
              },
              success: function(data) {},
              error: function(request, status, error) {
                  alert("code:" + request.status + "\n" + "message:" +
                      request.responseText + "\n" + "error:" +
                      error);
              }
          });
          //처음
          messenger.to_user_idx = -1;

      };
      ws.onmessage = function(message) {
          receiveMessage(message)
      };
      ws.onclose = function(event) {

      };

  }
  //웹소켓 연결 해제
  function disconnect() {
      if (ws) {
          ws.close();
          ws = null;
      }
  }
  
  
  //메세지 받으면 태그추가
  function receiveMessage(message) {
      var message = JSON.parse(message.data);
      //내가 활성화한 유저와의 채팅만 받기
      if (messenger.to_user_idx == message.from_user_idx) {
    	   
    	     receviceMessengerTag(message);
    	     
      } 
      else {
          //어떤이에게 새로운 메세지 왔다고 알림
          $.ajax({
              url: "/BucketTree/user/getUser",
              dataType: "json",
              type: "POST",
              async: false,
              data: {
                  idx: message.from_user_idx
              },
              success: function(data) {
                  $('.modal .modal-body').empty();
                  $('.modal .modal-body').append('<p>' + data.name + '님으로부터  새로운 메신저가 왔습니다</p>');

              }
       });
       //모달창 띄움
       $("#message_modal").modal();
        
       //활성화 한 유저 이외의 메신저 (새로운 메신저로 ) 바꾸기
          $.ajax({
              url: "/BucketTree/Messenger/changeReadMessenger",
              type: "POST",
              async: false,
              data: message,
              success: function(data) {

              }
          });

      }
      //스크롤 항상 아래로 유지
      $(".popup-messages").scrollTop($('.direct-chat-messages').height());
  }

//웹페이지가 로딩되면 실행되는 의미
$(function() {

//친구 검색창에 이름을 입력했을때 실행되는 이벤트
$('.friend_search').keyup(function(event) {
	  //친구 목록삭제
	   $('.MessenegerFriend').detach();
      //srchType=0
      var srchType = 0;
      //srchText 값가져오기	
      var srchText = $('.search').val();
      //srchText빈문자열이면 srchType=0;
      if (srchText == 0) {
          srchType = 0;
      }
      //그이외에는 srchType=1;
      else {
          srchType = 1;
      }
      //객체에 담기
      pagination = {
          srchType: srchType,
          srchText: srchText
      };
      MessengerFriendUpdateAjax(pagination);
});
//메세지 보내기 태그추가
$('#send_button').click(function() {
        //메세지 내용
        messenger.contents = $("#status_message").val()
        //메세지타입
        messenger.type = 1;
        //날짜
        messenger.date = getTimeStamp();
        ws.send(JSON.stringify(messenger));
        //메신저 보낸내용 추가하는 태그
        sendMessengerTag(messenger)
        
        $(".popup-messages").scrollTop($('.direct-chat-messages').height());

});
//입력하고 엔터키 눌르면 클릭효과
$("#status_message").keydown(function(key) {
    if (key.keyCode == 13) {
        $("#send_button").click();
    }
});
//to_user_idx정의
$(document).on("click", ".MessenegerFriend", function() {
    messenger.to_user_idx = $(this).attr("data-id");
});

//to_user_idx정의
$(document).on("click", ".newMessenegerFriend", function() {
    messenger.to_user_idx = $(this).attr("data-id");
});

//대화창 닫으면 모든 태그 지우기
$(document).on("click", "#removeClass", function() {
    $('.direct-chat-msg').detach();
    $('.chat-box-single-line').detach();
});



//누군가와 채팅이 아닐경우 목록을 갱신시켜준다
$("#message_modal button").click(function(){	
	//누군가와 채팅중이 아닐경우
	if( $("#qnimate").hasClass('popup-box-on')==false)
	{
		 //새로운 메세지 온 친구 목록 다 삭제
         $('.newMessenegerFriend').detach();
         //새로운 메세지 온 친구 갱신
         NewMessengerFriendUpdateAjax()
         
         //친구 목록 갱신(새로운 메세지 온거 제외)
         $('.MessenegerFriend').detach();
         //객체에 담기
         pagination = {
             srchType: 0,
             srchText: ''
         };
         //친구목록 갱신
         MessengerFriendUpdateAjax(pagination);

	}
});

//채팅창 띄우기
$(document).on("click",".addClass",function() {
            $('#qnimate').addClass('popup-box-on');
            $('.chat-popup .popup-head-left:last span').detach();
            //상대방 정보 가져오기 ajax이용
            //ajax구현	  
            to_user.idx = $(this).attr("data-id");
            $.ajax({
                url: "/BucketTree/user/getUser",
                dataType: "json",
                type: "POST",
                async: false,
                data: {
                    idx: to_user.idx
                },
                success: function(data) {
                    to_user = data;
                    $('.chat-popup .popup-head-left:last')
                        .append(
                            '<span>' + to_user.name +
                            '</span>');

                },
                error: function(request, status, error) {
                    alert("code:" + request.status + "\n" +
                        "message:" + request.responseText +
                        "\n" + "error:" + error);
                }
            });

            //메신저 읽음으로 처리
            $.ajax({
                url: "/BucketTree/Messenger/readMessenger",
                type: "POST",
                data: {
                    me: messenger.from_user_idx,
                    you: to_user.idx
                },
                async: false,
                success: function() {

                },
                error: function(request, status, error) {
                    alert("code:" + request.status + "\n" +
                        "message:" + request.responseText +
                        "\n" + "error:" + error);
                }
            });

            //친구와의 채팅 내역 가져오기
            //ajax구현	  
            var predate; //이전날짜 
            var currentdate; //현재날짜
            $.ajax({
                    url: "/BucketTree/Messenger/MessengerYouAndMe",
                    dataType: "json",
                    type: "POST",
                    data: {
                        me: messenger.from_user_idx,
                        you: to_user.idx
                    },
                    async: false,
                    success: function(data) {
                        $.each(data,function(entryIndex,entry) {
                                    predate = currentdate
                                    currentdate = entry.date.substring(0,10);
                                    if (predate != currentdate) {
                                        $('.direct-chat-messages:last').append('<div class="chat-box-single-line">');
                                        $('.direct-chat-messages:last').append('</div>');
                                        $('.chat-box-single-line:last').append('<abbr class="timestamp">' +currentdate);
                                        $('.chat-box-single-line:last').append('</abbr>');
                                    }
                                    //받은메세지
                                    if (entry.to_user_idx == messenger.from_user_idx) {
                                    	
                                    	receviceMessengerTag(entry);
                       
                                    }
                                    //보낸메세지
                                    if (entry.from_user_idx == messenger.from_user_idx) {
                                    	sendMessengerTag(entry)

                                    }

                                });

                    }
                });

            //현재날짜 --대화시작
            if (currentdate != getDateStamp()) {
                $('.direct-chat-messages:last').append(
                    '<div class="chat-box-single-line">');
                $('.direct-chat-messages:last')
                    .append('</div>');
                $('.chat-box-single-line:last').append(
                    '<abbr class="timestamp">' +
                    getDateStamp());
                $('.chat-box-single-line:last').append(
                    '</abbr>');
            }

            //스크롤 항상 아래로 유지
            $(".popup-messages").scrollTop(
                $('.direct-chat-messages').height());
        });



//채팅창 닫기
$("#removeClass").click(function() {
            messenger.to_user_idx = -1;
            $('#qnimate').removeClass('popup-box-on');
            $("#status_message").val('');
            //새로운 메세지 온 친구 목록 다 삭제
            $('.newMessenegerFriend').detach();
            //채팅창 닫았을때 새로운 메세지 온거 갱신
            //새로운 메세지 온 친구 갱신
            NewMessengerFriendUpdateAjax()
            //친구 목록 갱신(새로운 메세지 온거 제외)
            $('.MessenegerFriend').detach();
            //객체에 담기
            pagination = {
                srchType: 0,
                srchText: ''
            };
            //친구목록 갱신
            MessengerFriendUpdateAjax(pagination);
 

        });





});