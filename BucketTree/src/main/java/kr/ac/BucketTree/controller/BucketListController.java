package kr.ac.BucketTree.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.BucketTree.util.BucketTreeCommon;



@Controller
public class BucketListController {
	@Autowired 
	BucketTreeCommon  bucketTreeCommon; 

	@RequestMapping(value = "/bucketList/list", method = RequestMethod.GET)
	public String list(Model model) {
		//어느 페이지에서나 채팅 기능을 쓰기위해 
		model=bucketTreeCommon.commonMessenger(model);
		
		return "bucketList/list";
	}
	
	


}
