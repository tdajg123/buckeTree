package kr.ac.BucketTree.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.BucketTree.service.BucketJournalService;
import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.service.Journal_ImageService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.CategoryVO;
import kr.ac.BucketTree.vo.CommentVO;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.ImageVO;
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

	@Autowired
	BucketJournalService bjs;

	@Autowired
	Journal_ImageService jis;

	@Autowired
	ImageService is;

	@Autowired
	TimelineService ts;

	/* 전체 버킷리스트 목록&정렬&검색 */
	@RequestMapping(value = "/bucketList/list")
	public String list(Model model, Pagination pagination) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

	

		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());

		pagination.setRecordCount(bls.listCount(pagination,us.getCurrentUser().getIdx()));
		/* 리스트에 보여줄 객체 */
		model.addAttribute("list", bls.list(pagination,us.getCurrentUser().getIdx()));
		model.addAttribute("pageCount", bls.listCount(pagination,us.getCurrentUser().getIdx()));
		
		return "bucketList/list";
	}
	//ajax로 가져올 데이터
		@ResponseBody
		@RequestMapping(value = "/bucketList/ajaxlist")
		public List<BucketListVO> ajaxlist(@RequestBody Pagination pagination) throws Exception {

			
			return  bls.list(pagination,us.getCurrentUser().getIdx());
		}
		
	//타이틀이 존재하는지 체크
	@ResponseBody
	@RequestMapping(value="/bucketList/searchTitle", method = RequestMethod.POST)
	public boolean searchTitle (@RequestParam("idx") int idx) throws Exception{
		boolean  a=bls.titleCheck(bls.bucket(idx).getTitle(), us.getCurrentUser().getIdx() );
		
		return a;
	}
	//카운트 업해주고 내 버킷에 추가
	@ResponseBody
	@RequestMapping(value="/bucketList/countUpAddBucket", method = RequestMethod.POST)
	public void countUpAddBucket (@RequestParam("idx") int idx) throws Exception{
			bls.countUp(idx);
			BucketListVO vo=bls.bucket(idx);
			vo.setUser_idx(us.getCurrentUser().getIdx());

	        bls.addBucket(vo);
			bls.updateBucketImage(vo);
			is.deleteOrphan();
			ts.BucketInsert_Timeline(us.getCurrentUser().getIdx(), vo.getTitle(), "BucketTree/bucketList/"+vo.getIdx()+"/bucket.do");
		
	}
	//myBucketList
	@RequestMapping(value = "/bucketList/mylist")
	public String mylist(Model model, Pagination pagination) throws Exception {
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		model = bucketTreeCommon.commonMessenger(model);
		
		//친구가 추천해준거

		model.addAttribute("friendBylist", bls.recommendList(us.getCurrentUser().getIdx()));
		model.addAttribute("adminBylist", bls.adminRecommendList(us.getCurrentUser().getIdx()));
		
		pagination.setRecordCount(bls.mylistCount(pagination,us.getCurrentUser().getIdx()));
		/* 리스트에 보여줄 객체 */
		model.addAttribute("mylist", bls.mylist(pagination,us.getCurrentUser().getIdx()));
		model.addAttribute("pageCount", bls.mylistCount(pagination,us.getCurrentUser().getIdx()));
		return "bucketList/mylist";
	}
	
	//ajax로 가져올 데이터
	@ResponseBody
	@RequestMapping(value = "/bucketList/ajaxMylist")
	public List<BucketListVO> ajaxMylist(@RequestBody Pagination pagination) throws Exception {

				
				return  bls.mylist(pagination,us.getCurrentUser().getIdx());
	}
	//버킷리스트 완료
	@RequestMapping(value = "/bucketList/completeBucket")
	public String completeBucket(Model model, Pagination pagination,@RequestParam("idx") int idx) throws Exception {
		pagination.setCurrentPage(1);
		bls.completeBucket(idx);
		BucketListVO vo=bls.bucket(idx);
		ts.BucketComplete_Timeline(us.getCurrentUser().getIdx(), vo.getTitle(), "BucketTree/bucketList/"+vo.getIdx()+"/bucket.do");
		return "redirect:/bucketList/mylist?"+pagination.getQueryString();
	}
	
	//버킷리스트 완료
	@RequestMapping(value = "/bucketList/ingBucket")
	public String ingBucket(Model model, Pagination pagination,@RequestParam("idx") int idx) throws Exception {
		pagination.setCurrentPage(1);
		bls.ingBucket(idx);
		return "redirect:/bucketList/mylist?"+pagination.getQueryString();
	}
	
	
	@RequestMapping(value = "/bucketList/bucketWrite", method = RequestMethod.GET)
	public String bucketWrite(Model model,Pagination pagination) throws Exception{
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		
		return "bucketList/buck_write";
	}
	
	@RequestMapping(value = "/bucketList/bucketCreate", method = RequestMethod.POST)
	public String bucketCreate(Model model, HttpServletRequest request,	BucketListVO vo,@RequestParam("x") float x,@RequestParam("y") float y) throws Exception {


		UserVO user = us.getCurrentUser();
		// vo.setTitle(request.getParameter("title"));
		vo.setUser_idx(user.getIdx());
		vo.setContents(request.getParameter("contents"));
	
		vo.setX(x);
		vo.setY(y);
	
		bls.insertBucketList(vo);
		bls.updateBucketImage(vo);
		is.deleteOrphan();


		return "forward:/bucketList/list";
	}
	@RequestMapping("/bucketList/{id}/image.do")
	public void image(@PathVariable("id") int id, HttpServletResponse response, Model model) throws IOException {

		ImageVO vo = new ImageVO();
		vo.setIdx(id);
		ImageVO image = bls.selectById(vo);
		model.addAttribute("image", vo);
		if (image == null)
			return;
		String fileName = URLEncoder.encode(image.getFileName(), "UTF-8");
		response.setContentType(image.getMimeType());
		response.setHeader("Content-Disposition", "idx=" + image.getIdx() + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(image.getData());

		}
	}

	@RequestMapping("/bucketList/{idx}/bucket.do")
	public String bucketDetail(@PathVariable("idx") int idx, Model model) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		UserVO user = us.getCurrentUser();
		BucketListVO bc = bls.bucket(idx);
		UserVO buser = us.selectByIdx(bc.getUser_idx());
		bc.setName(buser.getName());
		List<CategoryVO> ctlist = new ArrayList();
		ctlist.add(cs.whoName(bc.getWho()));
		ctlist.add(cs.whenName(bc.getWhen()));
		ctlist.add(cs.whatName(bc.getWhat()));
		
		bc.setName(buser.getName());
		List<CommentVO> clist = new ArrayList();
		clist = bls.selectComment(idx);
		model.addAttribute("bucket", bc);
		model.addAttribute("clist", clist);
		model.addAttribute("check", user);
		model.addAttribute("ctlist", ctlist);

		List<BucketJournalVO> bjl = new ArrayList();
		bjl = bjs.bucketJournalList(idx);
		model.addAttribute("list", bjl);

		return "bucketList/post";
	}

	@RequestMapping("/bucketList/{idx}/edit.do")
	public String bucketEdit(@PathVariable("idx") int idx, HttpServletResponse response,Model model,Pagination pagination) throws Exception {
		
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		UserVO user = us.getCurrentUser();
		BucketListVO vo = new BucketListVO();
		vo = bls.bucket(idx);
		vo.setName(user.getName());
		model.addAttribute("bucket", vo);
		System.out.println("에디트 컨트롤러 정상 작동 :"+idx);
		return "bucketList/buck_edit";
	}

	@RequestMapping("/bucketList/edit.do")
	public String bucketEditPost(HttpServletRequest request,Model model,@RequestParam("file") MultipartFile[] uploadedFiles) throws Exception{
		model = bucketTreeCommon.commonMessenger(model);

		int idx = Integer.parseInt(request.getParameter("idx"));
		BucketListVO vo = new BucketListVO();
		vo = bls.bucket(idx);
		vo.setContents(request.getParameter("body"));
		vo.setWhat(Integer.parseInt(request.getParameter("what")));
		vo.setWhen(Integer.parseInt(request.getParameter("when")));
		vo.setWho(Integer.parseInt(request.getParameter("who")));
		bls.editBucket(vo);
		bls.updateBucketImage(vo);
		is.deleteOrphan();

		for (MultipartFile uploadedFile : uploadedFiles) {
			ImageVO file = new ImageVO();
			if (uploadedFile.getSize() > 0) {
				file.setFileName(Paths.get(uploadedFile.getOriginalFilename()).getFileName().toString());
				file.setFileSize((int) uploadedFile.getSize());
				file.setData(uploadedFile.getBytes());
				bls.insertImage(file);
			}
		}

		return "forward:/bucketList/" + vo.getIdx() + "/bucket.do";
	}

	@RequestMapping("/bucketList/{idx}/delete.do")
	public String bucketDelete(@PathVariable("idx") int idx, HttpServletResponse response, Model model)
			throws Exception {

		// 버킷리스트 삭제
		int imageIdx = bls.selectByImageIdx(idx);
		if (imageIdx == 0) {
			bls.deleteBucket(idx);
			bls.deleteBucComment(idx);
		} else {
			bls.deleteByBucketIdx(idx);
			bls.deleteImage(imageIdx);
			bls.deleteBucket(idx);
			bls.deleteBucComment(idx);
			is.deleteOrphan();
		}
		// 해당 버킷리스트와 연관된 부분 삭제 필요

		return "forward:/bucketList/list";
	}

	@ResponseBody
	@RequestMapping(value = "/bucketList/addCommentRequestAjax", method = RequestMethod.POST)
	public List<CommentVO> addComment(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		UserVO user = us.getCurrentUser();
		CommentVO cvo = new CommentVO();
		CommentVO returnCVO = new CommentVO();
		int comment_Author;
		int bucketList_idx = Integer.parseInt(request.getParameter("bidx"));
		if (request.getParameter("author") == null) {
			comment_Author = 0;
			cvo.setAuthor(comment_Author);
		} else {
			comment_Author = Integer.parseInt(request.getParameter("author"));
			cvo.setAuthor(comment_Author);
		}
		cvo.setName(user.getName());
		cvo.setUser_idx(user.getIdx());
		cvo.setContents(request.getParameter("comment"));
		cvo.setBucketList_idx(bucketList_idx);
		bls.insertComment(cvo);

		returnCVO = bls.selectByIdxComment(cvo.getIdx());

		List<CommentVO> list = new ArrayList();
		list.add(returnCVO);
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/bucketList/deleteCommentRequestAjax", method = RequestMethod.POST)
	public boolean deleteCommentRequestAjax(@RequestParam("commentIdx") String cidx, HttpServletResponse response,
			Model model) {
		System.out.println("에이젝스 코멘트 딜리트");
		int cIdx = Integer.parseInt(cidx);
		bls.deleteComment(cIdx);

		return true;

	}

	@ResponseBody
	@RequestMapping(value = "/bucketList/editCommentRequestAjax", method = RequestMethod.POST)
	public CommentVO editComment(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		System.out.println("댓글 수정 컨트롤러 도착");
		UserVO user = us.getCurrentUser();
		int editIdx = Integer.parseInt(request.getParameter("editIdx"));
		CommentVO cvo = bls.selectByIdxComment(editIdx);
		String content = request.getParameter("editContent");
		System.out.println("수정된 내용:" + content + "idx" + editIdx);
		cvo.setContents(content);
		bls.updateComment(cvo);
		return cvo;
	}
	
	//버킷리스트 작성시 마이리스트에 타이틀이 존재하는지 체크
	@ResponseBody
	@RequestMapping(value="/bucketList/searchMylistTitle", method = RequestMethod.POST)
	public boolean searchMylistTitle (@RequestParam("title") String title) throws Exception{
		boolean  a=bls.titleCheck(title, us.getCurrentUser().getIdx() );
		
		return a;
	}

}
