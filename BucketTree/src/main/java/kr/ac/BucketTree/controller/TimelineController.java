package kr.ac.BucketTree.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class TimelineController {

	@Autowired
	BucketTreeCommon bucketTreeCommon;
	@Autowired
	UserService us;
	@Autowired
	TimelineService ts;

	@RequestMapping(value = "/timeline", method = RequestMethod.GET)
	public String timeline(Model model) {

		// 어느 페이지에서나 채팅 기능을 쓰기위해
		model = bucketTreeCommon.commonMessenger(model);

		UserVO user = us.getCurrentUser();
		int user_idx = user.getIdx();
		ts.selectByIdx(user_idx);

		return "timeline/timeline";
	}

}