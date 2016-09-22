package kr.ac.BucketTree.util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import com.google.gson.Gson;

import kr.ac.BucketTree.service.FileMessengerService;
import kr.ac.BucketTree.service.MessengerService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.vo.FileMessengerVO;
import kr.ac.BucketTree.vo.MessengerVO;
import kr.ac.BucketTree.vo.UserVO;

public class MyWebSocketHandler extends AbstractWebSocketHandler {
	@Autowired
	UserService us;
	@Autowired
	MessengerService ms;
	@Autowired
	FileMessengerService fms;
	// 방법일 일대일챗팅 map사용
	Map<Integer, WebSocketSession> sessions = new HashMap<Integer, WebSocketSession>();
	MessengerVO messengerVO;
	ByteArrayOutputStream bout = new ByteArrayOutputStream();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		// 로그인 유저 웹소켓 연결해제
		UserVO user = getUser(session);
		sessions.remove(user.getIdx());
		System.out.println("종료");
	
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		// 로그인 유저 웹소켓 연결
		UserVO user = getUser(session);
		sessions.put(user.getIdx(), session);

	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		messengerVO = MessengerVO.convertMessenger(message.getPayload());
		WebSocketSession toUser = sessions.get(messengerVO.getTo_user_idx());
		
		//파일이 존재할경우 유저가 있는경우
		if(messengerVO.getFileName()!=null  &&toUser != null)
		{	
			Gson gson = new Gson();
			String data = gson.toJson(messengerVO);
			ms.insertMessenger(messengerVO);
			toUser.sendMessage(new TextMessage(data));

		}
		//파일만 존재하는경우
		else if(messengerVO.getFileName()!=null && toUser == null)
		{
			ms.insertMessenger(messengerVO);
	
		}
		// 실시간채팅
		else if (toUser != null) {
			// 해당 유저에게 실시간 메세지 보내기
			messengerVO.setType(0);
			ms.insertMessenger(messengerVO);
			// json 형식 문자열로 만들기
			Gson gson = new Gson();
			String data = gson.toJson(messengerVO);
			toUser.sendMessage(new TextMessage(data));
		}
		// 메신저
		else {
			ms.insertMessenger(messengerVO);
		}

	}
	

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		WebSocketSession toUser = sessions.get(messengerVO.getTo_user_idx());
		if(toUser!=null)
		{	
			toUser.sendMessage(message);
			FileMessengerVO fmv=new FileMessengerVO();
			fmv.setFileName( messengerVO.getFileName());
			fmv.setMessenger_idx( messengerVO.getIdx());
			fmv.setFileSize(message.getPayloadLength());
			fmv.setData(message.getPayload().array());
			fms.insert(fmv);
		
		}
		else
		{	
			FileMessengerVO fmv=new FileMessengerVO();
			fmv.setFileName( messengerVO.getFileName());
			fmv.setMessenger_idx( messengerVO.getIdx());
			fmv.setFileSize(message.getPayloadLength());
			fmv.setData(message.getPayload().array());
			fms.insert(fmv);
	
		}
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		super.handleMessage(session, message);
	}
	

	// 로그인한 유저 정보 꺼내기
	private UserVO getUser(WebSocketSession session) {
		Map<String, Object> handshakeAttributes = session.getAttributes();
		SecurityContext context = (SecurityContext) handshakeAttributes.get("SPRING_SECURITY_CONTEXT");
		Authentication authentication = context.getAuthentication();
		if (authentication instanceof MyAuthenticationProvider.MyAuthenticaion) {

			return ((MyAuthenticationProvider.MyAuthenticaion) authentication).getUser();
		}
		return null;
	}

}