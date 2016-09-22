package kr.ac.BucketTree.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.PageVO;
import kr.ac.BucketTree.vo.RecommendVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class BucketListController {
	@Autowired 
	BucketTreeCommon bucketTreeCommon; 
	
	@Autowired
	BucketListService bls;
	
	@Autowired
	UserService us;
	
	/*전체 버킷리스트 목록 출력 & 정렬-최신순*/
	@RequestMapping(value = "/bucketList/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) throws Exception {
		model=bucketTreeCommon.commonMessenger(model);
		
		System.out.println("<<<<<bucketList-List-GET>>>>>");
		
		/*pagination*/
		PageVO page = new PageVO();
		page.setCurrentPage(1);
		page.setPagesize(12);
		
		/*전체 리스트 불러오기*/
		List<BucketListVO> bl = new ArrayList();
		bl = bls.list(page);
		
		/*리스트 잘 들어왔는지 인덱스 확인*/
		System.out.println(bl.get(0).getIdx());

		/*리스트에 보여줄 객체*/
		model.addAttribute("list", bl);
		
		return "bucketList/list";
	}
	
	/*전체 : 정렬-인기순 */
	@RequestMapping(value = "/bucketList/list", method = RequestMethod.POST)
	public String listPOST(Model model, HttpServletRequest request) throws Exception {
		model=bucketTreeCommon.commonMessenger(model);
		
		System.out.println("<<<<<bucketList-List-POST>>>>>");
		
		/*pagination*/
		PageVO page = new PageVO();
		page.setCurrentPage(1);
		page.setPagesize(12);
		
		/*인기순으로 정렬한 리스트 불러오기*/
		List<BucketListVO> pbl = bls.popular_list(page);
		model.addAttribute("list", pbl);

		return "bucketList/list";
	}
	
	/*전체 : 버킷 담기 (카운트 업 / 마이버킷에 추가)*/
	@ResponseBody
	@RequestMapping(value = "/bucketList/countUp", method = RequestMethod.POST)
	public String countUp(@RequestParam("idx") int idx, @RequestParam("title") String title) throws Exception {
		
		System.out.println("<<<<<bucketList-COUNTUP-SYS-CHECK>>>>>");

		//현재 로그인 한 유저의 idx 값 가져오기
		UserVO user = us.getCurrentUser();
		int userIdx = user.getIdx();
		
		BucketListVO add = new BucketListVO();
		
		int when = add.getWhen();
		int who = add.getWho();
		int what = add.getWhat();
		
		System.out.println("title : " + title);
		System.out.println("userIdx : " + userIdx);
		
		boolean check = this.bls.titleCheck(title, userIdx);
		
		System.out.println("check : " + check);
		
		if(check == true){
			//BucketListVO bucket = new BucketListVO();
			System.out.println("<<<<<담기 실패! - 이미 해당하는 버킷이 있음>>>>>");
			
			
		}else{
			System.out.println("<<<<<담기 성공! - 담기 아이콘 눌러서 카운트업/버킷 추가>>>>>");
			bls.countUp(idx);
			
			HashMap<String, Object> addBucket = new HashMap<String, Object>();
			addBucket.put("title", title);
			addBucket.put("contents", "추가된 버킷리스트!");
			addBucket.put("user_idx", userIdx);
			//addBucket.put("when", when);
			//addBucket.put("who", who);
			//addBucket.put("what", what);
			
			bls.addBucket(addBucket);
		}
		
		return "redirect:/BucketTree/bucketList/list";
	}
	
	//검색
	@RequestMapping(value = "/bucketList/searchList", method = RequestMethod.POST)
	public String searchListPost(Model model, HttpServletRequest request) throws Exception {
		model=bucketTreeCommon.commonMessenger(model);
		
		System.out.println("<<<<<bucketList-SEARCH-LIST>>>>>");
		
		/*Ajax로 넘겨서 받아온 검색타입과 검색어*/
		int srchType = Integer.parseInt(request.getParameter("srchType"));
		String srchText = request.getParameter("srchText");
		
		System.out.println("srchType : " + srchType + "  /  srchText : " + srchText);
		
		/*Ajax로 넘겨서 받아온 카테고리 선택 값*/
		int when = Integer.parseInt(request.getParameter("when"));
		int who = Integer.parseInt(request.getParameter("who"));
		int what = Integer.parseInt(request.getParameter("what"));
	
		System.out.println("when : " + when + "  /  who : " + who + "  /  what : " + what);
		
		HashMap<String, Object> category = new HashMap<String, Object>();
		category.put("when", when);
		category.put("who", who);
		category.put("what", what);
		
		PageVO page = new PageVO();
		page.setSrchType(srchType);
		page.setSrchText(srchText);
		
		List<BucketListVO> list = bls.SearchList(category, page);
		
		model.addAttribute("list", list);
		model.addAttribute("srch", page);
		
		return "bucketList/list";
	}
	
	
	/**
	 * 마이 버킷 리스트 목록
	 * : 1. 친구가 추천해준 버킷리스트 목록 3개
	 *   2. 1이 없을 경우 관리자가 추천해준 버킷리스트 목록 3개
	 *   3. 내 버킷리스트 전체 목록 */
	@RequestMapping(value = "/bucketList/mylist", method = RequestMethod.GET)
	public String mylist(Model model) throws Exception {
		
		//어느 페이지에서나 채팅 기능을 쓰기위해 
		model=bucketTreeCommon.commonMessenger(model);
				
		System.out.println("<<<<<bucketlist-FRIEND-RECOMMEND-LIST>>>>>");
		
		/*친구가 추천한 리스트 불러오기*/
		List<RecommendVO> rbl = new ArrayList();
		rbl = bls.recommendList();
		
		System.out.println(rbl.get(0).getBucketList_idx());		/*리스트 잘 들어왔는지 인덱스 확인*/
		
		/*
		관리자가 추천한 리스트 불러오기 _ arbl : Admin Recommend Bucket List
		List<BucketListVO> arbl = new ArrayList();
		arbl = bls.adminRecommendList();
		
		System.out.println(arbl.get(0).getIdx());		리스트 잘 들어왔는지 인덱스 확인
		
		*/
		
		System.out.println("<<<<<bucketlist-MYLIST>>>>>");

		PageVO page = new PageVO();
		page.setCurrentPage(1);
		page.setPagesize(12);
		
		/*마이 리스트 불러오기*/
		List<BucketListVO> mbl = new ArrayList();
		mbl = bls.mylist(page);
		
		System.out.println(mbl.get(0).getIdx());		/*리스트 잘 들어왔는지 인덱스 확인*/

		/*리스트에 보여줄 객체(추천 목록, 내 목록) 2개*/
		model.addAttribute("recommendList", rbl);
		model.addAttribute("mylist", mbl);
		
		return "bucketList/mylist";
	}


}
