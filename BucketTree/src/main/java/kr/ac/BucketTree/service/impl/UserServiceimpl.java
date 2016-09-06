package kr.ac.BucketTree.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.UserDAO;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.MyAuthenticationProvider;
import kr.ac.BucketTree.vo.UserVO;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserDAO dao;

	// 이메일로 사용자 정보 조회
	@Override
	public UserVO selectByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.selectByEmail(email);
	}

	// 로그인 유저 정보 꺼내오기
	@Override
	public UserVO getCurrentUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof MyAuthenticationProvider.MyAuthenticaion) {
			return ((MyAuthenticationProvider.MyAuthenticaion) authentication).getUser();
		}
		return null;
	}

	// 개인정보 변경후 세션에 로그인정보 변경하기
	@Override
	public void setCurrentUser(UserVO user) {
		((MyAuthenticationProvider.MyAuthenticaion) SecurityContextHolder.getContext().getAuthentication())
				.setUser(user);

	}

	@Override
	public UserVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(idx);
	}

	// 비밀번호 찾기-----------

	// 이메일로 조회한 사용자와 입력한 이름이 같은지 확인
	@Override
	public boolean searchByEmail(String email, String name) {
		// TODO Auto-generated method stub
		UserVO user = dao.selectByEmail(email);
		if (user.getName().equals(name)) {
			return true;
		} else {
			return false;
		}
	}

	// 임시비밀번호 생성
	@Override
	public String randomPassword() {

		int index = 0;
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'X' };

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			index = (int) (charSet.length * Math.random());
			sb.append(charSet[index]);
		}
		return sb.toString();
	}

	// 임시 비밀번호로 변경
	@Override
	public void updatePassword(String password, String email) {

		HashMap<String, Object> hash = new HashMap<>();
		hash.put("email", email);
		hash.put("password", password);

		dao.changePassword(hash);

	}
	@Override
	public int insertUser(UserVO user){
		return dao.insertUser(user);
	}
	// 비밀번호 찾기---------------
	@Override
	public boolean checkEmail(String create_email){
		return this.dao.checkEmail(create_email);
	}
}
