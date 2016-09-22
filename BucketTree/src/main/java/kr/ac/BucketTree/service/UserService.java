package kr.ac.BucketTree.service;

import kr.ac.BucketTree.vo.UserVO;

public interface UserService {
	// 이메일로 사용자 정보 조회
	public UserVO selectByEmail(String email);

	// idx로 사용자 정보조회
	public UserVO selectByIdx(int idx);

	public UserVO getCurrentUser();

	public void setCurrentUser(UserVO user);

	// 비밀번호 찾기-----------
	// 이메일로 조회한 사용자와 입력한 이름이 같은지 확인
	public boolean searchByEmail(String email, String name);

	// 임시비밀번호 생성
	public String randomPassword();

	// 임시 비밀번호로 변경
	public void updatePassword(String password, String email);
	// 비밀번호 찾기---------------
	
	//사용자 등록
	public int insertUser(UserVO user);
	
	public boolean checkEmail(String create_email);
}
