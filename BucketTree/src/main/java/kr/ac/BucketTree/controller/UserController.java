package kr.ac.BucketTree.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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

import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.AjaxUtil;
import kr.ac.BucketTree.util.BucketTreeCommon;
import kr.ac.BucketTree.util.Email;
import kr.ac.BucketTree.util.EmailSender;
import kr.ac.BucketTree.vo.PointVO;
import kr.ac.BucketTree.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	BucketTreeCommon bucketTreeCommon;
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
		UserVO user = us.selectByIdx(idx);
		return user;

	}

	// 비밀번호 찾기 -이메일,이름 검사
	@ResponseBody
	@RequestMapping(value = "user/searchUserAjax", method = RequestMethod.POST)
	public boolean searchUser(@RequestParam("password_email") String password_email,
			@RequestParam("password_name") String password_name, HttpServletResponse response) throws Exception {

		// 이메일이랑 이름이 맞는지 확인
		boolean isUserCheck = this.us.searchByEmail(password_email, password_name);

		// 이메일이랑 이름이 맞을시
		if (isUserCheck) {
			// 임시비밀번호 생성
			String randomPassword = this.us.randomPassword();
			// 임시비밀번호로 비밀번호 변경
			this.us.updatePassword(randomPassword, password_email);

			// 이메일 발송
			email.setContent(password_name + " 님의 BUCKETTREE 임시 비밀번호는 [ " + randomPassword + " ] 입니다.");
			email.setReciver(password_email);
			email.setSubject("[BUCKETTREE] " + password_name + " 님 요청하신 임시 비밀번호 입니다.");
			emailSender.SendEmail(email);
		}

		return isUserCheck;

	}

	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(Locale locale, HttpServletRequest request) throws Exception {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String sec = request.getParameter("secret");
		String res = request.getParameter("g-recaptcha-response");
		System.out.println("sec:" + sec + "res:" + res);
		UserVO user = new UserVO();
		user.setEmail(request.getParameter("create_email"));
		// String passwd =
		// MyAuthenticationProvider.encryptPasswd(request.getParameter("create_pw"));
		// //패스워드 암호화
		user.setPassword(request.getParameter("create_pw"));
		user.setName(request.getParameter("create_name"));
		String date = request.getParameter("create_birth");
		Date to = transFormat.parse(date);
		user.setBirth(to);

		//us.updatePoint(user.getIdx(), 1);
		us.insertUser(user);
		return "login";
	}

	@RequestMapping(value = "user/checkDuplicateEmailAjax", method = RequestMethod.POST)
	public void checkDuplicateUserID(@RequestParam String create_email, HttpServletResponse response) {
		System.out.println("컨트롤러 도착");
		System.out.println("받은 이메일:" + create_email);
		boolean isDuplicateEmail = this.us.checkEmail(create_email);
		/**
		 * Response로 응답하기 위해서 PrintWriter객체를 생성한다.
		 */
		AjaxUtil.sendResponse(response, isDuplicateEmail + "");
	}

	/* 마이페이지 정보 보기 */
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model, HttpServletResponse response) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);

		System.out.println("<<<<<MYPAGE-READ>>>>>");
		UserVO user = us.getCurrentUser();
		int idx = user.getIdx();

		model.addAttribute(us.read(idx));
		
		/*##point-test##*/
		/*us.upPoint(idx, 1);
		us.updatePlusPoint(idx, 1);
		us.downPoint(idx, 1);
		us.updateMinusPoint(idx, 1);*/
		
		return "user/mypage";
	}
	
	
	/*마이페이지에서 프로필 이미지 보여주기*/
	@RequestMapping("mypage/{idx}/profile")
    public void mypageImage(@PathVariable("idx") int idx, HttpServletResponse response) throws IOException {
		
		UserVO image = us.getCurrentUser();
		
		String fileName = URLEncoder.encode(image.getFileName(),"UTF-8");
		
        response.setContentType(image.getMimeType());									/*확장자 명*/
        response.setHeader("Content-Disposition", "filename=" + fileName + ";");
        try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
            output.write(us.getCurrentUser().getImage());								/*이미지 출력*/
        }
    }
	
	/* 마이페이지-회원 정보 보기 GET */
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String updateGET(Model model, HttpServletRequest request) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);

		System.out.println("<<<<<마이페이지 눌렀을 때 넘어온 회원 정보 보기 페이지>>>>>");

		UserVO user = us.getCurrentUser();
		int idx = user.getIdx();
		String password = request.getParameter("checkPassword");

		model.addAttribute(us.read(idx));

		boolean check = this.us.checkPassword(password, idx);
		System.out.println("입력한 현재 password와 로그인 된 유저 idx : " + check);

		if (check == true) {
			return "user/update";
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");

			return "user/mypage";
		}

	}

	/* 마이페이지-회원 정보 수정 POST */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(Model model, HttpServletRequest request) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);

		System.out.println("<<<<<회원 정보 수정 페이지-확인 버튼을 누르면 수정이 완료됨>>>>>");

		/* 현재 로그인한 유저의 idx 가져옴 */
		UserVO user = us.getCurrentUser();
		int idx = user.getIdx();
		user.setPassword(request.getParameter("newPassword")); /* 새로 받은 비밀번호 값 설정 */

		model.addAttribute(us.read(idx)); /* 기본 정보 보여줌 */

		String password = request.getParameter("newPassword");

		HashMap<String, Object> update = new HashMap<String, Object>();
		update.put("password", password);
		update.put("idx", idx);
		System.out.println("넘어온 password 값과 유저 idx : " + update);

		if (password == "") {
			System.out.println("변경할 비밀번호를 입력해 주세요.");

			return "user/update";
		} else {
			us.update(update);

			return "user/mypage";
		}
	}

	/* 회원 탈퇴 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model) throws Exception {
		model = bucketTreeCommon.commonMessenger(model);

		/* 현재 로그인한 유저의 idx 가져옴 */
		UserVO user = us.getCurrentUser();
		int idx = user.getIdx();

		System.out.println("탈퇴할 아이디 : " + idx);
		us.delete(idx);

		return "login";
	}

	/*프로필 수정 페이지에서 이미지 보여주기*/
	@RequestMapping("profile/{idx}/profile")
    public void profileImage(@PathVariable("idx") int idx, HttpServletResponse response) throws IOException {
		
		UserVO image = us.getCurrentUser();
		
		String fileName = URLEncoder.encode(image.getFileName(),"UTF-8");
        response.setContentType(image.getMimeType());
        response.setHeader("Content-Disposition", "filename=" + fileName + ";");
        try (BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
            output.write(us.getCurrentUser().getImage());
        }
    }
	
	/* 프로필 변경 페이지 (기본 이미지 / 변경할 이미지 선택) */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileTestGET(Model model) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);

		UserVO user = us.getCurrentUser();
		int idx = user.getIdx();

		model.addAttribute(us.read(idx));
		
		System.out.println("<<<<<마이 페이지에서 프로필 수정 페이지로 넘어옴-profile-GET>>>>>");

		return "user/profile";
	}

	/* 프로필 업로드 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String create(Model model, UserVO user, @RequestParam("file") MultipartFile uploadedFile) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);
		
		user = us.getCurrentUser();
		int idx = user.getIdx();

        String fileName = Paths.get(uploadedFile.getOriginalFilename()).getFileName().toString();		/*업로드 된 파일의 이름 가져오기*/
        System.out.println("fileName : " + fileName);
		// 파일이 있으면
		if (uploadedFile.getSize() > 0) {
			System.out.println("<<<<<프로필 업로드>>>>>");
			user.setFileName(fileName);						/*파일 이름 넣기*/
			user.setImage(uploadedFile.getBytes());			/*파일을 바이너리로 변환하여 저장*/
		} else{
			// 기본이미지로 변경
			//user.setFileName("PROFILE_image.png");
			//user.setImage();
		}

		model.addAttribute(us.read(idx));

		us.profileUpdate(user);								/*프로필 업데이트*/
		System.out.println("<<<<<프로필 업로드 완료>>>>>");
		
		return "user/mypage";
	}

	/* 포인트 내역 보여주기 */
	@RequestMapping(value = "/point", method = RequestMethod.GET)
	public String plusPointGET(Model model) throws Exception {

		model = bucketTreeCommon.commonMessenger(model);

		System.out.println("<<<<<포인트-GET>>>>>");

		UserVO user = us.getCurrentUser();
		int user_idx = user.getIdx();

		List<PointVO> plusPoint = us.readPlusPoint(user_idx);
		List<PointVO> minusPoint = us.readMinusPoint(user_idx);
		
		System.out.println("plusPoint : " + plusPoint + "minusPoint : " + minusPoint);
		
		model.addAttribute("plusPoint", plusPoint);
		model.addAttribute("minusPoint", minusPoint);
		
		return "user/point";
	}

}
	