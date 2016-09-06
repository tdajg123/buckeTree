package kr.ac.BucketTree.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.ac.BucketTree.service.FriendService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class BucketTreeCommon {
	@Autowired
	FriendService fs;
	@Autowired
	UserService us;
	//어느 페이지에서나 메신저를 쓰기위해 모델에 추가
	public Model commonMessenger(Model model)
	{	
		//유저 정보가져오기
		UserVO user =us.getCurrentUser();
		//<!--메세지=>새로운 메세지를 보낸 친구목록 -->
		List<FriendVO> flist1=fs.FriendByNewMessagener(user.getIdx());
		//메세지=>새로운 메세지를 보낸 친구목록 객체에 담기
		model.addAttribute("flist1", flist1);
		//메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외) 
		List<FriendVO> flist2=fs.FriendByMessagener(user.getIdx(), new Pagination());
		//메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외)객체 담기 
		model.addAttribute("flist2", flist2);
		//유저정보
		model.addAttribute("user",user);
		return model;
	}

}
