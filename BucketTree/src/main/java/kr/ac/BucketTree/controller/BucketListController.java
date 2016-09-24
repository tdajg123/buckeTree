package kr.ac.BucketTree.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class BucketListController {
	@Autowired 
	BucketTreeCommon bucketTreeCommon; 
	
	@Autowired 
	CategoryService cs;
	
	@Autowired
	BucketListService bls;
	
	@Autowired
	UserService us;
	
	/*전체 버킷리스트 목록&정렬&검색*/
	@RequestMapping(value = "/bucketList/list")
	public String list(Model model, Pagination pagination) throws Exception {
		model=bucketTreeCommon.commonMessenger(model);
		
		System.out.println("<<<<<bucketList-List-GET>>>>>");
		
		
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		
		System.out.println("controller pagination : " + pagination);
		
		pagination.setRecordCount(bls.listCount(pagination));
		/*리스트에 보여줄 객체*/
		model.addAttribute("list", bls.list(pagination));
		
		
		return "bucketList/list";
	}
	
	/*버킷리스트 무한스크롤, AJAX 활용*/
	@ResponseBody
	@RequestMapping(value="/bucketList/BucketListAjax", method = RequestMethod.POST)
	public List<BucketListVO> bucketListAjax (@RequestParam("row") String row, Pagination pagination, HttpServletResponse response, Model model) throws Exception{
		
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		
		int rowResult = Integer.parseInt(row);
		pagination.setRow(rowResult);
		pagination.setPageSize(5);
		
		System.out.println("controller 무한 스크롤 row  : " + row);
		
		pagination.setRecordCount(bls.listCount(pagination));
	    
		List<BucketListVO> list = bls.listAjax(pagination);
		
		return list;
	}
	
	/*전체 : 버킷 담기 (카운트 업 / 마이버킷에 추가)*/
	@ResponseBody
	@RequestMapping(value = "/bucketList/countUp", method = RequestMethod.POST)
	public String countUp(Model model, Pagination pagination, @RequestParam("idx") int idx, @RequestParam("title") String title, @RequestParam("when") int when, @RequestParam("who") int who, @RequestParam("what") int what) throws Exception {
		
		System.out.println("<<<<<bucketList-COUNTUP-SYS-CHECK>>>>>");

		//현재 로그인 한 유저의 idx 값 가져오기
		UserVO user = us.getCurrentUser();
		int userIdx = user.getIdx();
		
		System.out.println("title : " + title);
		System.out.println("userIdx : " + userIdx);
		System.out.println("category 값" + when + "/" + who + "/" + what);
		
		boolean check = this.bls.titleCheck(title, userIdx);
		System.out.println("마이리스트에 제목이 같은 리스트가 있는지 중복 체크 : " + check);
		
		if(check == true){
			System.out.println("<<<<<담기 실패! - 이미 해당하는 버킷이 있음>>>>>");
			
		}else{
			System.out.println("<<<<<담기 성공! - 담기 아이콘 눌러서 카운트업/버킷 추가>>>>>");
			bls.countUp(idx);
			
			HashMap<String, Object> addBucket = new HashMap<String, Object>();
			addBucket.put("title", title);
			addBucket.put("contents", "추가된 버킷리스트!");
			addBucket.put("user_idx", userIdx);
			addBucket.put("when", when);
			addBucket.put("who", who);
			addBucket.put("what", what);
			
			System.out.println(title  + userIdx + when + who + what);
			
			bls.addBucket(addBucket);
			pagination.setRecordCount(bls.listCount(pagination));
			/*리스트에 보여줄 객체*/
			model.addAttribute("list", bls.list(pagination));
		}
		
		return "bucketList/mylist";
	}
	
	/**
	 * 마이 버킷 리스트 목록
	 * : 1. 친구가 추천해준 버킷리스트 목록 3개
	 *   2. 1이 없을 경우 관리자가 추천해준 버킷리스트 목록 3개
	 *   3. 내 버킷리스트 전체 목록 */
	@RequestMapping(value = "/bucketList/mylist")
	public String mylist(Model model, Pagination pagination) throws Exception {
		
		//어느 페이지에서나 채팅 기능을 쓰기위해 
		model=bucketTreeCommon.commonMessenger(model);
				
		System.out.println("<<<<<bucketlist-FRIEND-RECOMMEND-LIST>>>>>");
		model.addAttribute("recommendList", bls.recommendList());
		//model.addAttribute("adminRecommendList", bls.adminRecommendList());
		
		System.out.println("<<<<<bucketlist-MYLIST>>>>>");
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		
		pagination.setRecordCount(bls.listCount(pagination));
		model.addAttribute("mylist", bls.list(pagination));
		
		return "bucketList/mylist";
	}
	
	/*마이리스트-무한스크롤*/
	@ResponseBody
	@RequestMapping(value="/bucketList/mylistAjax", method = RequestMethod.POST)
	public List<BucketListVO> mylistAjax (@RequestParam("row") String row, Pagination pagination, HttpServletResponse response, Model model) throws Exception{
		
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		
		int rowResult = Integer.parseInt(row);
		
		System.out.println("row 값  :" + row);
		System.out.println("rowResult : " + rowResult);
		
		pagination.setRow(rowResult);
		pagination.setPageSize(5);
		
		System.out.println("mycontroller 무한 스크롤 row  : " + row);
		
		pagination.setRecordCount(bls.listCount(pagination));
		List<BucketListVO> mylist = bls.mylistAjax(pagination);
		
		System.out.println("아직 컨트롤러");
		
		return mylist;
	}


}
