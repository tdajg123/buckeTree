package kr.ac.BucketTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import kr.ac.BucketTree.service.UserService;

@Controller
public class HomeController {


	@Autowired
	UserService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		return "login";
	}
	
}
