package kr.ac.BucketTree.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.BucketTreeService;
import kr.ac.BucketTree.service.BucketTree_MemberService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
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

		System.out.println(pagination.getCurrentPage());
		System.out.println(pagination.getPageSize());
		System.out.println(pagination.getSrchType());
		return bs.selectPage(pagination, us.getCurrentUser().getIdx());
	}
	
	
	@RequestMapping(value = "/bucketTree/apply")
	public String apply(Model model, Pagination pagination, @RequestParam("bucketTree_idx") int bucketTree_idx) throws Exception {
		btms.apply(bucketTree_idx, us.getCurrentUser().getIdx(), 1);
		pagination.setCurrentPage(1);
		
		
		return "redirect:/bucketTree/list?"+pagination.getQueryString();
	}
	@RequestMapping(value = "/bucketTree/cancel")
	public String cancel(Model model, Pagination pagination, @RequestParam("bucketTree_idx") int bucketTree_idx) throws Exception {
		btms.cancel(bucketTree_idx,us.getCurrentUser().getIdx());;
		pagination.setCurrentPage(1);
		
		return "redirect:/bucketTree/list?"+pagination.getQueryString();
	}
	
	@RequestMapping(value = "/bucketTree/myList")
	public String myList(Model model, Pagination pagination) throws Exception {
		
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		pagination.setRecordCount(bs.selectMyCount(pagination,us.getCurrentUser().getIdx()));
		model.addAttribute("list",bs.selectMyPage(pagination, us.getCurrentUser().getIdx()) );
		model.addAttribute("pageCount",pagination.getRecordCount()/pagination.getPageSize()+1);
		
		
		
		return "bucketTree/myList";
	}
	
}
