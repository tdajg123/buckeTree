package kr.ac.BucketTree.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.BucketTreeService;
import kr.ac.BucketTree.service.BucketTree_MemberService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.BucketTreeVO;


@Controller
public class BucketTreeController {
	@Autowired
	BucketTreeCommon bucketTreeCommon;
	@Autowired
	CategoryService cs;
	@Autowired
	BucketTreeService bs;
	@Autowired
	UserService us;
	@Autowired 
	BucketTree_MemberService btms;
	@Autowired 
	BucketListService bls;
	@Autowired 
	TimelineService ts;
	
	// 전체목록
	@RequestMapping(value = "/bucketTree/list")
	public String list(Model model, Pagination pagination) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		pagination.setRecordCount(bs.selectCount(pagination));
		model.addAttribute("list",bs.selectPage(pagination, us.getCurrentUser().getIdx()) );
		model.addAttribute("pageCount",pagination.getRecordCount()/pagination.getPageSize()+1);
		return "bucketTree/list";
	}
	
	//ajax로 가져올 데이터
	@ResponseBody
	@RequestMapping(value = "/bucketTree/ajaxlist")
	public List<BucketTreeVO> ajaxlist(@RequestBody Pagination pagination) throws Exception {


		return bs.selectPage(pagination, us.getCurrentUser().getIdx());
	}
	
	
	@RequestMapping(value = "/bucketTree/apply")
	public String apply(Model model, Pagination pagination, @RequestParam("bucketTree_idx") int bucketTree_idx,@RequestParam("i") int i) throws Exception {
		btms.apply(bucketTree_idx, us.getCurrentUser().getIdx(), 1);
		pagination.setCurrentPage(1);
		if(i==1)
		{
			return "redirect:/bucketTree/list?"+pagination.getQueryString();
		}
		else
		{
			return "redirect:/bucketTree/myList?"+pagination.getQueryString();
		}
	}
	@RequestMapping(value = "/bucketTree/cancel")
	public String cancel(Model model, Pagination pagination, @RequestParam("bucketTree_idx") int bucketTree_idx,@RequestParam("i") int i) throws Exception {
		btms.cancel(bucketTree_idx,us.getCurrentUser().getIdx());;
		pagination.setCurrentPage(1);
		
		if(i==1)
		{
			return "redirect:/bucketTree/list?"+pagination.getQueryString();
		}
		else
		{
			return "redirect:/bucketTree/myList?"+pagination.getQueryString();
		}
	}
	
	@RequestMapping(value = "/bucketTree/myList")
	public String myList(Model model, Pagination pagination) throws Exception {
		
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		pagination.setRecordCount(bs.selectMyCount(pagination,us.getCurrentUser().getIdx()));
		
		
		model.addAttribute("pageCount",pagination.getRecordCount()/pagination.getPageSize()+1);
		model.addAttribute("list",bs.selectMyPage(pagination, us.getCurrentUser().getIdx()) );
		model.addAttribute("applyList",bs.applyBucketTree(us.getCurrentUser().getIdx()));
		model.addAttribute("listByAdmin", bs.adminByReommend(us.getCurrentUser().getIdx()));
		
		return "bucketTree/myList";
	}
	@ResponseBody
	@RequestMapping(value = "/bucketTree/ajaxMylist")
	public List<BucketTreeVO> ajaxMylist(@RequestBody Pagination pagination) throws Exception {


		return bs.selectMyPage(pagination, us.getCurrentUser().getIdx());
	}
	
	@RequestMapping(value = "/bucketTree/create",method = RequestMethod.GET)
	public String create (Model model) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		//버킷트리로 지정되지않은 리스트
		model.addAttribute("list",bls.bucketTree_MyBucketList(us.getCurrentUser().getIdx()));
		return "bucketTree/create";
	}
	
	@RequestMapping(value = "/bucketTree/create",method = RequestMethod.POST)
	public String create (Model model, BucketTreeVO bucketTreeVO) throws Exception {
		
		//1.등록
		bucketTreeVO.setMember_num(5);;
		bucketTreeVO.setUser_idx(us.getCurrentUser().getIdx());
		bs.insert(bucketTreeVO);
		//멤버에 추가되야함
		btms.apply(bucketTreeVO.getIdx(), us.getCurrentUser().getIdx(),2);
		//2 버킷리스트에 TREE_IDX 지정
		BucketListVO bucketListVO=new BucketListVO();
		bucketListVO.setIdx(bucketTreeVO.getBucketList_idx());
		bucketListVO.setTree_idx(bucketTreeVO.getIdx());
		bls.updateTreeidx(bucketListVO);
		//3 타임라인 지정
		ts.TreeCreate_Timeline(us.getCurrentUser().getIdx(), bucketTreeVO.getTreeName(),"/BucketTree/bucketTree/detail?idx="+bucketTreeVO.getIdx());
		//4 포인트
		us.updateMinusPoint(us.getCurrentUser().getIdx(),1, -100);
		
		return "redirect:/bucketTree/myList";
	}
	@RequestMapping(value = "/bucketTree/detail",method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("idx") int idx)throws Exception
	{
		
		model.addAttribute("vo",bs.selectByBucketTree(idx));
		return "bucketTree/detail";
	}
	
}
