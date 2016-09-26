package kr.ac.BucketTree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.service.BucketShareAnswerService;
import kr.ac.BucketTree.service.BucketShareService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.service.Question_ImageService;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareAnswerVO;
import kr.ac.BucketTree.vo.BucketShareVO;

@Controller
public class BucketShareController {
	@Autowired
	BucketTreeCommon bucketTreeCommon;
	@Autowired
	CategoryService cs;
	@Autowired
	BucketShareService bss;
	@Autowired
	UserService us;
	@Autowired
	BucketShareAnswerService bas;
	@Autowired
	TimelineService ts;
	@Autowired
	BucketListService bs;
	@Autowired 
	ImageService is;
	@Autowired
	Question_ImageService qis;

	// 전체질문
	@RequestMapping(value = "/bucketShare/list")
	public String list(Model model, Pagination pagination) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		pagination.setRecordCount(bss.selectCount(pagination));
		model.addAttribute("list", bss.selectPage(pagination));
		return "bucketShare/list";
	}

	// 나의 질문목록
	@RequestMapping(value = "/bucketShare/mylist")
	public String mylist(Model model, Pagination pagination) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		int user_idx = us.getCurrentUser().getIdx();
		pagination.setRecordCount(bss.myselectCount(pagination, user_idx));
		model.addAttribute("list", bss.myselectPage(pagination, user_idx));
		return "bucketShare/list";
	}

	// 내가 쓴 답변 목록
	@RequestMapping(value = "/bucketShare/myAnswerlist")
	public String myAnserlist(Model model, Pagination pagination) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what", cs.whatList());
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		int user_idx = us.getCurrentUser().getIdx();
		pagination.setRecordCount(bss.myAnswerListCount(pagination, user_idx));
		model.addAttribute("list", bss.myAnswerList(pagination, user_idx));
		return "bucketShare/list";
	}

	// 자세히보기
	@RequestMapping(value = "/bucketShare/read")
	public String read(Model model, @RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		model.addAttribute("question", bss.selectByIdx(idx));
		model.addAttribute("answer", bas.selectByQuestion(idx));

		return "bucketShare/read";
	}

	// 질문작성
	@RequestMapping(value = "/bucketShare/create",method = RequestMethod.GET)
	public String create(Model model) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("list", bs.bucketShare_MyBucketList(us.getCurrentUser().getIdx()));
		
		return "bucketShare/create";
	}
	//제목, 내용  빈칸인지 검사하고  , 해당유저가 포인트가 잇는지 체크해야함--아직안함
	// 질문작성 포스트
	@RequestMapping(value = "/bucketShare/create" , method = RequestMethod.POST)
	public String create(Model model ,BucketShareVO bucketShareVO) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		bucketShareVO.setState(0);
		bucketShareVO.setUser_idx(us.getCurrentUser().getIdx());
		us.updateMinusPoint(us.getCurrentUser().getIdx(), 3, -bucketShareVO.getPoint());
		ts.ShareQuestion_Timeline(us.getCurrentUser().getIdx(),bucketShareVO.getTitle() , "/BucketTree/bucketShare/read?idx=" +bucketShareVO.getIdx());
		bss.insert(bucketShareVO);
		bss.updateBucketShareImage(bucketShareVO);
		is.deleteOrphan();
		return "redirect:/bucketShare/read?idx="+bucketShareVO.getIdx();
	}
	
	//삭제
	@RequestMapping(value = "/bucketShare/delete" , method = RequestMethod.GET)
	public String create(Model model ,@RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		
		qis.deleteByQuestionIdx(idx);
		bss.delete(idx);
		is.deleteOrphan();
		
		return "redirect:/bucketShare/list";
	}
	
	//수정
	@RequestMapping(value = "/bucketShare/edit" , method = RequestMethod.GET)
	public String edit(Model model ,@RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		model.addAttribute("list", bs.bucketShare_MyBucketList(us.getCurrentUser().getIdx()));
		model.addAttribute("question", bss.selectByIdx(idx));
		
		return "bucketShare/edit";
	}
	
	@RequestMapping(value = "/bucketShare/edit" , method = RequestMethod.POST)
	public String edit(Model model ,BucketShareVO bucketShareVO) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		bss.update(bucketShareVO);
		bss.updateBucketShareImage(bucketShareVO);
		is.deleteOrphan();
		return "redirect:/bucketShare/read?idx=" +bucketShareVO.getIdx();
	}
	
	// 댓글쓰기
	@RequestMapping(value = "/bucketShare/answerInsert")
	public String answerCreate(Model model, @RequestParam("idx") int idx, BucketShareAnswerVO answer) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		answer.setState(0);
		answer.setUser_idx(us.getCurrentUser().getIdx());
		answer.setBucketShare_Question_idx(idx);
		bas.insert(answer);

		BucketShareVO question = bss.selectByIdx(idx);

		// 질문자 타임라인에 저장
		if (answer.getUser_idx() != question.getUser_idx()) {
			ts.ShareAnswer_Timeline(question.getUser_idx(), question.getTitle(),
					"/BucketTree/bucketShare/read?idx=" + idx);
		}
		return "redirect:/bucketShare/read?idx=" + idx;

	}

	// 댓글수정
	@RequestMapping(value = "/bucketShare/answerModify")
	public String answerModify(Model model, BucketShareAnswerVO answer) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		bas.update(answer);
		return "redirect:/bucketShare/read?idx=" + answer.getBucketShare_Question_idx();

	}

	// 댓글삭제
	@RequestMapping(value = "/bucketShare/answerDelete")
	public String answerDelete(Model model, @RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);
		BucketShareAnswerVO answer = bas.selectByIdx(idx);
		bas.delete(idx);

		return "redirect:/bucketShare/read?idx=" + answer.getBucketShare_Question_idx();

	}

	// 채택
	@RequestMapping(value = "/bucketShare/answerAdopt")
	public String answerAdopt(Model model, @RequestParam("idx") int idx) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		// 답변업데이트
		BucketShareAnswerVO answer = bas.selectByIdx(idx);
		answer.setState(1);
		bas.adopt(answer);

		// 질문 업데이트
		BucketShareVO question = bss.selectByIdx(answer.getBucketShare_Question_idx());
		question.setState(1);
		bss.adoptQuestion(question);

		// 타임라인
		ts.ShareSelect_Timeline(answer.getUser_idx(), answer.getContents(),
				"/BucketTree/bucketShare/read?idx=" + question.getIdx());
		// 포인트
		us.updatePlusPoint(answer.getUser_idx(), 3, question.getPoint());
		return "redirect:/bucketShare/read?idx=" + answer.getBucketShare_Question_idx();

	}
	
	//포인트 계산
	@ResponseBody
	@RequestMapping(value = "/bucketShare/userPoint")
	public int userPoint(Model model, @RequestParam("idx") int idx) throws Exception {
		return us.sumPoint(idx);
	}



}
