package kr.ac.BucketTree.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;



@Controller
public class BucketListController {
	@Autowired 
	BucketTreeCommon  bucketTreeCommon; 
	
	@Autowired
	BucketListService bls;

	/* 전체 버킷리스트  목록 & 정렬-최신순 */
	@RequestMapping(value = "/bucketList/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		//어느 페이지에서나 채팅 기능을 쓰기위해 
		model=bucketTreeCommon.commonMessenger(model);
		
		System.out.println("<<<<<bucketlist-LIST-sys-check>>>>>");

		/*전체 리스트 불러오기*/
		List<BucketListVO> bl = new ArrayList();
		bl = bls.list();
		
		/*리스트 잘 들어왔는지 인덱스 확인*/
		System.out.println(bl.get(0).getIdx());

		/*리스트에 보여줄 객체*/
		model.addAttribute("list", bl);
		
		return "bucketList/list";
	}
	
	/*전체 : 정렬-인기순 : 정렬만 하고 보여지기 때문에 list로 해줌*/
	@RequestMapping(value="/bucketList/list", method = RequestMethod.POST)
	public String popular_list(Model model) throws Exception {
		
		//어느 페이지에서나 채팅 기능을 쓰기위해 
		model=bucketTreeCommon.commonMessenger(model);
				
		System.out.println("<<<<<bucketlist-POPULAR-LIST-sys-check>>>>>");
		
		/*인기순으로 정렬된 전체 리스트 불러오기*/
		List<BucketListVO> pbl = new ArrayList();
		pbl = bls.popular_list();
		
		/*리스트 잘 들어왔는지 인덱스 확인*/
		System.out.println(pbl.get(0).getIdx());

		/*리스트에 보여줄 객체*/
		model.addAttribute("list", pbl);
		
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
				
		System.out.println("<<<<<bucketlist-FRIEND-RECOMMEND-LIST-sys-check>>>>>");

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
		
		System.out.println("<<<<<bucketlist-MYLIST-sys-check>>>>>");
		/*마이 리스트 불러오기*/
		List<BucketListVO> mbl = new ArrayList();
		mbl = bls.mylist();
		
		System.out.println(mbl.get(0).getIdx());		/*리스트 잘 들어왔는지 인덱스 확인*/

		/*리스트에 보여줄 객체(추천 목록, 내 목록) 2개*/
		model.addAttribute("recommendList", rbl);
		model.addAttribute("mylist", mbl);
		
		return "bucketList/mylist";
	}


}
