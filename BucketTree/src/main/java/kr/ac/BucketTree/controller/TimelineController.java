package kr.ac.BucketTree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.vo.TimelineVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class TimelineController {
	@Autowired
	BucketTreeCommon bucketTreeCommon;
	@Autowired
	TimelineService ts;
	@Autowired
	UserService us;

	/* 타임라인 출력 */
	@RequestMapping(value = "/Timeline", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		// 어느 페이지에서나 채팅 기능을 쓰기위해
		model = bucketTreeCommon.commonMessenger(model);

		UserVO user = us.getCurrentUser();
		List<TimelineVO> tl = new ArrayList();
		tl = ts.timelineList(user.getIdx());
		model.addAttribute("list", tl);

		return "timeline/timeline";
	}

}
