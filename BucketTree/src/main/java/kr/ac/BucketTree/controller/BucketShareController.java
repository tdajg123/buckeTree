package kr.ac.BucketTree.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.ac.BucketTree.service.BucketShareService;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Pagination;


@Controller
public class BucketShareController {
	@Autowired 
	BucketTreeCommon  bucketTreeCommon; 
	@Autowired 
	CategoryService cs;
	@Autowired
	BucketShareService bss;

	@RequestMapping(value = "/bucketShare/list")
	public String list(Model model,Pagination pagination) throws Exception {

		model=bucketTreeCommon.commonMessenger(model);
		model.addAttribute("what",cs.whatList() );
		model.addAttribute("who", cs.whoList());
		model.addAttribute("when", cs.whenList());
		pagination.setRecordCount(bss.selectCount(pagination));
		model.addAttribute("list",bss.selectPage(pagination));
		return "bucketShare/list";
	}
	
}
