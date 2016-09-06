package kr.ac.BucketTree.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.FriendService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.PageVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class FriendController {

	@Autowired 
	BucketTreeCommon  bucketTreeCommon; 
	@Autowired
	FriendService fs;
	@Autowired
	UserService us;
	//메신저 친구목록 검색(새로운 메세지 제외)
	@ResponseBody
	@RequestMapping(value = "/Friend/MessengerFriendList", method = RequestMethod.POST)
	public List<FriendVO> srchTextByMessengerFriendList(Pagination p) {
		// 유저 정보가져오기
		UserVO user = us.getCurrentUser();
		// 검색에 따른 친구 목록
		List<FriendVO> list = fs.FriendByMessagener(user.getIdx(), p);
		return list;
	}
	
	//새로운 메신저 온거 갱신
	@ResponseBody
	@RequestMapping(value = "/Friend/NewMessengerFriendList", method = RequestMethod.POST)
	public List<FriendVO> NewMessengerFriendList()
	{
		// 유저 정보가져오기
		UserVO user = us.getCurrentUser();
		
		return fs.FriendByNewMessagener(user.getIdx());
	}
	@RequestMapping(value = "/Friend/searchFriendListPost", method = RequestMethod.POST)
	public String friendSearchPost(Model model,HttpServletRequest request) {
		
		System.out.println();
		int srchType = Integer.parseInt(request.getParameter("srchType"));
		String srchText = request.getParameter("srchText");
		PageVO page = new PageVO();
		page.setSrchType(srchType);
		page.setSrchText(srchText);
		page.setCurrentPage(1);
		page.setPagesize(10);
		List<FriendVO> list = fs.FriendSearch(page);
		model=bucketTreeCommon.commonMessenger(model);
		model.addAttribute("list", list);
		model.addAttribute("srch", page);
		return "friend/friendsearch";
	}
	@RequestMapping(value = "/Friend/searchFriendList", method = RequestMethod.GET)
	public String friendSearchGet(Model model,HttpServletRequest request) {
		model=bucketTreeCommon.commonMessenger(model);
		return "friend/friendsearch";
	}
	@ResponseBody
	@RequestMapping(value="/Friend/searchAjaxFriendList", method = RequestMethod.POST)
	public  List<FriendVO> friendsearchAjaxFriendList (FriendVO friendVO){
		System.out.println("도착");
		Integer bnoToStart = friendVO.getRow()+1; // row 가 5이면  6부터 시작하도록 함
		return fs.FriendAjaxSearch(bnoToStart);
	}
	

}
