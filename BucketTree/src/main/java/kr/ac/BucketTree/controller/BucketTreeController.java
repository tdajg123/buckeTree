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
import kr.ac.BucketTree.service.BucketTree_MessageService;
import kr.ac.BucketTree.service.BucketTree_Message_CommentService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.service.Message_ImageService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.BucketTree_Message;
import kr.ac.BucketTree.vo.BucketTree_Message_Comment;


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
	@Autowired 
	BucketTree_MessageService  bms;
	@Autowired 
	ImageService is;
	@Autowired 
	Message_ImageService mi;
	@Autowired 
	BucketTree_Message_CommentService bmcs;
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
	public String detail(Model model, @RequestParam("idx") int idx,Pagination pagination)throws Exception
	{
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("vo",bs.selectByBucketTree(idx));
		
		
		pagination.setRecordCount(bms.listCount(idx));
		
		
		List<BucketTree_Message> list=bms.list(idx, pagination);
		
		for(BucketTree_Message vo : list)
		{
			vo.setComment(bmcs.selectByidx(vo.getIdx()));
		}
		List<BucketTree_Message> notice =bms.noticeList(idx);
		
		for(BucketTree_Message vo : notice)
		{
			vo.setComment(bmcs.selectByidx(vo.getIdx()));
		}
		
		
		model.addAttribute("list", list);
		model.addAttribute("notice", notice);
		
	
		
		
		
		return "bucketTree/detail";
	}
	
	@RequestMapping(value = "/bucketTree/write",method = RequestMethod.POST)
	public String write(Model model, BucketTree_Message bucketTree_Message)throws Exception
	{
		model = bucketTreeCommon.commonMessenger(model);
		bucketTree_Message.setUser_idx(us.getCurrentUser().getIdx());
		

		bms.insert(bucketTree_Message);
		bms.updateBucketTreeImage(bucketTree_Message);
		is.deleteOrphan();
		

		
		
		return "redirect:/bucketTree/detail?idx="+bucketTree_Message.getBucketTree_idx();
	}
	
	@ResponseBody
	@RequestMapping(value = "/bucketTree/modify",method = RequestMethod.GET)
	public  BucketTree_Message modify(Model model, @RequestParam("idx") int idx)throws Exception
	{

		BucketTree_Message bucketTree_Message =bms.selectByidx(idx);
		return  bucketTree_Message ;
	}
	@ResponseBody
	@RequestMapping(value = "/bucketTree/modify",method = RequestMethod.POST)
	public  void modify(Model model, @RequestParam("idx") int idx, @RequestParam("contents") String contents)throws Exception
	{
		
		BucketTree_Message vo =new BucketTree_Message();
		vo.setIdx(idx);
		vo.setContents(contents);
		bms.update(vo);
		bms.updateBucketTreeImage(vo);
		is.deleteOrphan();
		bms.update(vo);
	}
	@ResponseBody
	@RequestMapping(value = "/bucketTree/delete",method = RequestMethod.GET)
	public  void delete(Model model, @RequestParam("idx") int idx)throws Exception
	{	
		mi.deleteByMessageIdx(idx);
		bms.delete(idx);
		is.deleteOrphan();
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/bucketTree/commentCreate",method = RequestMethod.GET)
	public  void delete(Model model, @RequestParam("idx") int idx, @RequestParam("contents") String contents)throws Exception
	{	
		BucketTree_Message_Comment bucketTree_Message_Comment=new BucketTree_Message_Comment();
		bucketTree_Message_Comment.setUser_idx(us.getCurrentUser().getIdx());
		bucketTree_Message_Comment.setBucketTree_Message_idx(idx);
		bucketTree_Message_Comment.setContents(contents);
		
		
		bmcs.insert(bucketTree_Message_Comment);
		
	}
	
}
