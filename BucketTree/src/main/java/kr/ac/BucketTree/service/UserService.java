package kr.ac.BucketTree.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.vo.PointVO;
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

	// 사용자 등록
	public int insertUser(UserVO user);

	public boolean checkEmail(String create_email);

	// 회원 정보 보기
	public UserVO read(int idx) throws Exception;

	// 회원 정보 수정 전 비밀번호 확인
	public boolean checkPassword(String password, int idx) throws Exception;

	// 회원 정보 수정
	public void update(HashMap<String, Object> update) throws Exception;

	// 회원 탈퇴
	public void delete(int idx) throws Exception;

	//프로필 기본
	public void profileImage(UserVO user) throws Exception;
	
	// 프로필 업데이트
	public void profileUpdate(UserVO user) throws Exception;
	
	//적립된 포인트 내역 조회
	public List<PointVO> readPlusPoint(int user_idx);
	
	//소모된 포인트 내역 조회
	public List<PointVO> readMinusPoint(int user_idx);
	
	//포인트 적립 및 사용 업데이트
	public UserVO upPoint(int idx, int point) throws Exception;
	public UserVO downPoint(int idx, int point) throws Exception;
	
	//포인트 적립 및 사용 내역 업데이트
	public PointVO updatePlusPoint(int idx, int sq, int point) throws Exception;
	public PointVO updateMinusPoint(int idx, int sq, int point) throws Exception;
	
	public int sumPoint(int user_idx) throws Exception;
}
