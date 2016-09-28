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
import kr.ac.BucketTree.vo.CommentVO;
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

		System.out.println("<<<<<bucketList-List-GET>>>>>");

		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());

		System.out.println("controller pagination : " + pagination);

		pagination.setRecordCount(bls.listCount(pagination));
		/* 리스트에 보여줄 객체 */
		model.addAttribute("list", bls.list(pagination));

		return "bucketList/list";
	}

	/* 버킷리스트 무한스크롤, AJAX 활용 */
	@ResponseBody
	@RequestMapping(value = "/bucketList/BucketListAjax", method = RequestMethod.POST)
	public List<BucketListVO> bucketListAjax(@RequestParam("row") String row, Pagination pagination,
			HttpServletResponse response, Model model) throws Exception {

		model.addAttribute("what", cs.whatList());
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

	/* 전체 : 버킷 담기 (카운트 업 / 마이버킷에 추가) */
	@ResponseBody
	@RequestMapping(value = "/bucketList/countUp", method = RequestMethod.POST)
	public String countUp(Model model, Pagination pagination, @RequestParam("idx") int idx,
			@RequestParam("title") String title, @RequestParam("when") int when, @RequestParam("who") int who,
			@RequestParam("what") int what) throws Exception {

		System.out.println("<<<<<bucketList-COUNTUP-SYS-CHECK>>>>>");

		// 현재 로그인 한 유저의 idx 값 가져오기
		UserVO user = us.getCurrentUser();
		int userIdx = user.getIdx();

		System.out.println("title : " + title);
		System.out.println("userIdx : " + userIdx);
		System.out.println("category 값" + when + "/" + who + "/" + what);

		boolean check = this.bls.titleCheck(title, userIdx);
		System.out.println("마이리스트에 제목이 같은 리스트가 있는지 중복 체크 : " + check);

		if (check == true) {
			System.out.println("<<<<<담기 실패! - 이미 해당하는 버킷이 있음>>>>>");

		} else {
			System.out.println("<<<<<담기 성공! - 담기 아이콘 눌러서 카운트업/버킷 추가>>>>>");
			bls.countUp(idx);

			HashMap<String, Object> addBucket = new HashMap<String, Object>();
			addBucket.put("title", title);
			addBucket.put("contents", "추가된 버킷리스트!");
			addBucket.put("user_idx", userIdx);
			addBucket.put("when", when);
			addBucket.put("who", who);
			addBucket.put("what", what);

			System.out.println(title + userIdx + when + who + what);

			bls.addBucket(addBucket);
			pagination.setRecordCount(bls.listCount(pagination));
			/* 리스트에 보여줄 객체 */
			model.addAttribute("list", bls.list(pagination));
		}

		return "bucketList/mylist";
	}

	/* 리스트에 해당하는 이미지 불러오기 */
	@RequestMapping("/list/{idx}/firstImage")
	public void listImage(@PathVariable("idx") int idx, HttpServletResponse response, Model model) throws Exception {

		ImageVO vo = new ImageVO();
		BucketListVO imageIdx = new BucketListVO();

		int listImageidx = bls.listImage(idx);
		System.out.println("해당 idx "+ idx + "의 imageIdx : " + listImageidx);

		vo.setIdx(listImageidx);
		imageIdx.setImageIdx(listImageidx);
		
		System.out.println("test : " + imageIdx.getImageIdx());

		if(listImageidx > 0){
		ImageVO image = bls.selectById(vo);
		model.addAttribute("image", vo);

		if (image == null) return;
		String fileName = URLEncoder.encode(image.getFileName(), "UTF-8");
		response.setContentType(image.getMimeType());
		response.setHeader("Content-Disposition", "idx=" + image.getIdx() + ";");
		try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
			output.write(image.getData());

		}
		}
	}

	/**
	 * 마이 버킷 리스트 목록 : 1. 친구가 추천해준 버킷리스트 목록 3개 2. 1이 없을 경우 관리자가 추천해준 버킷리스트 목록 3개
	 * 3. 내 버킷리스트 전체 목록
	 */
	@RequestMapping(value = "/bucketList/mylist")
	public String mylist(Model model, Pagination pagination) throws Exception {

		// 어느 페이지에서나 채팅 기능을 쓰기위해
		model = bucketTreeCommon.commonMessenger(model);

		System.out.println("<<<<<bucketlist-FRIEND-RECOMMEND-LIST>>>>>");

		UserVO user = us.getCurrentUser();
		int fromUser = user.getIdx();

		List<BucketListVO> recommendList = bls.recommendList(fromUser);
		model.addAttribute("recommendList", recommendList);

		List<BucketListVO> adminRecommendList = bls.adminRecommendList();
		model.addAttribute("adminRecommendList", adminRecommendList);

		System.out.println("<<<<<bucketlist-MYLIST>>>>>");
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());

		pagination.setRecordCount(bls.listCount(pagination));
		model.addAttribute("mylist", bls.mylist(pagination));

		return "bucketList/mylist";
	}

	/* 마이리스트-무한스크롤 */
	@ResponseBody
	@RequestMapping(value = "/bucketList/mylistAjax", method = RequestMethod.POST)
	public List<BucketListVO> mylistAjax(@RequestParam("row") String row, Pagination pagination,
			HttpServletResponse response, Model model) throws Exception {

		model.addAttribute("what", cs.whatList());
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

	@RequestMapping(value = "/bucketList/bucketWrite", method = RequestMethod.GET)
	public String bucketWrite(Model model) {

		return "bucketList/buck_write";
	}

	@RequestMapping(value = "/bucketList/bucketCreate", method = RequestMethod.POST)
	public String bucketCreate(Model model, HttpServletRequest request,
			@RequestParam("file") MultipartFile[] uploadedFiles, BucketListVO vo) throws Exception {

		UserVO user = us.getCurrentUser();
		String b = request.getParameter("body");
		// vo.setTitle(request.getParameter("title"));
		vo.setUser_idx(user.getIdx());
		vo.setContents(request.getParameter("body"));
		float x = Float.parseFloat(request.getParameter("x"));
		float y = Float.parseFloat(request.getParameter("y"));
		vo.setX(x);
		vo.setY(y);
		vo.setContents(b);

		bls.insertBucketList(vo);

		bls.updateBucketImage(vo);
		bls.deleteOrphan();
		System.out.println(request.getParameter("title") + "제목");
		System.out.println(vo.getX() + " " + vo.getY() + " " + vo.getTitle() + " " + b);
		for (MultipartFile uploadedFile : uploadedFiles) {
			ImageVO file = new ImageVO();
			if (uploadedFile.getSize() > 0) {
				file.setFileName(Paths.get(uploadedFile.getOriginalFilename()).getFileName().toString());
				file.setFileSize((int) uploadedFile.getSize());
				file.setData(uploadedFile.getBytes());
				bls.insertImage(file);
			}
		}

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
		bc.setName(user.getName());
		List<CommentVO> clist = new ArrayList();
		clist = bls.selectComment(idx);
		model.addAttribute("bucket", bc);
		model.addAttribute("clist", clist);
		model.addAttribute("check", user);

		List<BucketJournalVO> bjl = new ArrayList();
		bjl = bjs.bucketJournalList(idx);
		model.addAttribute("list", bjl);

		return "bucketList/post";
	}

	@RequestMapping("/bucketList/{idx}/edit.do")
	public String bucketEdit(@PathVariable("idx") int idx, HttpServletResponse response, Model model) throws Exception {
		UserVO user = us.getCurrentUser();
		BucketListVO vo = new BucketListVO();
		vo = bls.bucket(idx);
		vo.setName(user.getName());
		model.addAttribute("bucket", vo);
		return "bucketList/buck_edit";
	}

	@RequestMapping("/bucketList/edit.do")
	public String bucketEditPost(HttpServletRequest request, Model model,
			@RequestParam("file") MultipartFile[] uploadedFiles) throws Exception {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BucketListVO vo = new BucketListVO();
		vo = bls.bucket(idx);
		vo.setContents(request.getParameter("body"));
		bls.editBucket(vo);
		bls.updateBucketImage(vo);
		bls.deleteOrphan();

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
			bls.deleteOrphan();
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

}
