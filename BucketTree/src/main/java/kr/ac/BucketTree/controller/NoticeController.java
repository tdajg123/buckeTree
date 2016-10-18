package kr.ac.BucketTree.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.service.NoticeService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.NoticeVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class NoticeController {
	@Autowired
	BucketTreeCommon bucketTreeCommon;
	
	@Autowired
	UserService us;
	
	@Autowired
	BucketListService bls;
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	NoticeService ns;
	
	@Autowired
	ImageService is;
	
	@Secured("ROLE_관리자")
	//공지사항 작성 GET
	@RequestMapping(value="/notice/create")
	public String createNotice(Model model){
		return "notice/create";
	}
	@Secured("ROLE_관리자")
	//공지사항 작성 POST
	@RequestMapping (value="/notice/create",method = RequestMethod.POST)
	public String createNoticePost(Model model,NoticeVO notice,HttpServletRequest request){

		UserVO user = us.getCurrentUser();
		System.out.println(user.getIdx());
		notice.setUser_idx(user.getIdx());
		notice.setContents(request.getParameter("content"));
		ns.createNotice(notice);
		ns.updateNoticeImage(notice);
		is.deleteOrphan();
		return "notice/create";
	}
	
	//공지사항 리스트
	@RequestMapping(value="/notice/list")
	public String selectNotice(Model model,Pagination pagination){
		UserVO user = us.getCurrentUser();
		model = bucketTreeCommon.commonMessenger(model);
		pagination.setRecordCount(ns.selectCount(pagination));
		model.addAttribute("list", ns.noticeSelectAll(pagination));
		model.addAttribute("pagination", pagination);
		model.addAttribute("user",user );
		return "notice/list";
	}
	
	// 자세히보기
		@RequestMapping(value = "/notice/read")
		public String read(Model model, @RequestParam("idx") int idx) throws Exception {
			model = bucketTreeCommon.commonMessenger(model);
			UserVO user = us.getCurrentUser();
			model.addAttribute("list", ns.selectByIdx(idx));
			model.addAttribute("user", user);

			return "notice/read";
		}
		
	// 수정하기
		@Secured("ROLE_관리자")
		@RequestMapping(value = "/notice/edit")
		public String edit(Model model, @RequestParam("idx") int idx) throws Exception {
			model = bucketTreeCommon.commonMessenger(model);
			
	
			model.addAttribute("list", ns.selectByIdx(idx));


			return "notice/edit";
		}
	// 수정하기 POST	
		@Secured("ROLE_관리자")
		@RequestMapping(value ="/notice/editPost",method=RequestMethod.POST)
		public String editPost(Model model,HttpServletRequest request,@RequestParam("idx") int idx
				,@RequestParam("title") String title,@RequestParam("contents") String contents){
			NoticeVO notice = ns.selectByIdx(idx);
			notice.setTitle(title);
			notice.setContents(contents);
			ns.updateNotice(notice);
			ns.updateNoticeImage(notice);
			is.deleteOrphan();
			return "forward:/notice/list";
		}
		
	// 삭제하기
		@Secured("ROLE_관리자")
		@RequestMapping(value = "/notice/delete")
		public String delete(Model model, @RequestParam("idx") int idx) throws Exception {
			
			model = bucketTreeCommon.commonMessenger(model);
		
			
			int imageIdx = ns.selectByImageIdx(idx);
			if (imageIdx == 0) {
				ns.deleteNotice(idx);
			
			} else {
				ns.deleteNoticeImage(idx);
				bls.deleteImage(imageIdx);
				ns.deleteNotice(idx);
				is.deleteOrphan();
			}
		
			return "forward:/notice/list";
		}

	
}
