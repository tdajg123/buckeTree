<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<script>
   $(document).ready(
         function() {
            var fileTarget = $('.filebox #file');

            fileTarget.on('change', function() { // 값이 변경되면
               if (window.FileReader) { // modern browser
                  var filename = $(this)[0].files[0].name;
               } else { // old IE
                  var filename = $(this).val().split('/').pop().split(
                        '\\').pop(); // 파일명만 추출
               }
               // 추출한 파일명 삽입
               $(this).siblings('.upload-name').val(filename);
            });
         });
</script>

<div class="popup-box chat-popup" id="qnimate" style="z-index: 99999">
   <div class="popup-head">
      <div class="popup-head-left pull-left">
         <img src="/BucketTree/images/user1-128x128.jpg"
            alt="iamgurdeeposahan">
      </div>
      <div class="popup-head-right pull-right">
         <div class="btn-group"></div>

         <!-- Chat Exit Button -->
         <button data-widget="remove" id="removeClass"
            class="chat-header-button pull-right" type="button">
            <i class="glyphicon glyphicon-off"></i>
         </button>
      </div>
   </div>
   <div class="popup-messages">

      <div class="direct-chat-messages"></div>

   </div>
   <div class="popup-messages-footer">
      <div class="filebox">
         <label for="file"><i class="fa fa-upload"></i></label> <input
            type="file" id="file"> <input class="upload-name"
            disable="disable" value="파일 선택" />
      </div>

      <div class="input-group">
         <input type="text" name="message" placeholder="Type message..."
            class="form-control" id="status_message"> <span
            class="input-group-btn">
            <button type="button" class="btn btn-success" id="send_button">전송</button>
         </span>
      </div>

      <div class="btn-footer"></div>
   </div>
</div>