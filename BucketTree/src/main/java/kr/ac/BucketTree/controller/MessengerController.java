package kr.ac.BucketTree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.ac.BucketTree.service.MessengerService;
import kr.ac.BucketTree.vo.MessengerVO;


@Controller
public class MessengerController {
	@Autowired
	MessengerService ms;
	
	//나와 상대방의 채팅내용
	@ResponseBody
	@RequestMapping(value = "/Messenger/MessengerYouAndMe", method = RequestMethod.POST)
	public List<MessengerVO> MessengerYouandMe(@RequestParam("me") int me,@RequestParam("you") int you ) {

		return ms.selectByMesseneger(me, you) ;
	}
	//읽음처리
	@ResponseBody
	@RequestMapping(value = "/Messenger/readMessenger", method = RequestMethod.POST)
	public void readMessenger(@RequestParam("me") int me,@RequestParam("you") int you ) {

		ms.readMessenger(me, you);
	}
	//두달 지난 메신저 삭제
	@ResponseBody
	@RequestMapping(value = "/Messenger/deleteByMyMesseneger", method = RequestMethod.POST)
	public void deleteByMyMesseneger(@RequestParam("idx") int idx)
	{
		ms.deleteByMyMesseneger(idx);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/Messenger/changeReadMessenger", method = RequestMethod.POST)
	public void changeReadMessenger(MessengerVO m)
	{	
	
		ms.changeReadMessenger(m);
	}

	
}
