package kr.ac.BucketTree.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.core.ParseException;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.AjaxUtil;
import kr.ac.BucketTree.util.Email;
import kr.ac.BucketTree.util.EmailSender;
import kr.ac.BucketTree.vo.UserVO;


@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	private Email email;
	@Autowired
	private EmailSender emailSender;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		return "login";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
	public UserVO selectByIdx(@RequestParam("idx") int idx) {
		UserVO user=us.selectByIdx(idx);
		return user;
		
	}
	
	// 비밀번호 찾기 -이메일,이름 검사
	@ResponseBody
	@RequestMapping(value = "user/searchUserAjax", method = RequestMethod.POST)
	public boolean searchUser(@RequestParam("password_email") String password_email,
			@RequestParam("password_name") String password_name, HttpServletResponse response) throws Exception {

		//이메일이랑 이름이 맞는지 확인
		boolean isUserCheck = this.us.searchByEmail(password_email, password_name);
		
		//이메일이랑 이름이 맞을시
		if (isUserCheck) {
			//임시비밀번호 생성
			String randomPassword = this.us.randomPassword();
			//임시비밀번호로 비밀번호 변경
			this.us.updatePassword(randomPassword, password_email);
			
			//이메일 발송
			email.setContent(password_name + " 님의 BUCKETTREE 임시 비밀번호는 [ " + randomPassword + " ] 입니다.");
			email.setReciver(password_email);
			email.setSubject("[BUCKETTREE] " + password_name + " 님 요청하신 임시 비밀번호 입니다.");
			emailSender.SendEmail(email);
		}

		return isUserCheck;

	}
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(Locale locale,HttpServletRequest request) throws ParseException, java.text.ParseException {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String sec = request.getParameter("secret");
		String res = request.getParameter("g-recaptcha-response");
		System.out.println("sec:"+sec+"res:"+res);
		UserVO user = new UserVO();
		user.setEmail(request.getParameter("create_email"));
		//String passwd = MyAuthenticationProvider.encryptPasswd(request.getParameter("create_pw")); //패스워드 암호화
		user.setPassword(request.getParameter("create_pw"));
		user.setName(request.getParameter("create_name"));
		String date = request.getParameter("create_birth");
		Date to =transFormat.parse(date);
		user.setBirth(to);
		
		us.insertUser(user);
		return "login";
	}	
	@RequestMapping(value="user/checkDuplicateEmailAjax" , method = RequestMethod.POST)
	    public void checkDuplicateUserID(@RequestParam String create_email, HttpServletResponse response){
	    System.out.println("컨트롤러 도착");    
		System.out.println("받은 이메일:"+create_email);
	    boolean isDuplicateEmail = this.us.checkEmail(create_email);
	        /**
	         * Response로 응답하기 위해서 PrintWriter객체를 생성한다.
	         */
	        AjaxUtil.sendResponse(response, isDuplicateEmail+"");
	    }
	
}
