package kr.ac.BucketTree.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.vo.PointVO;
import kr.ac.BucketTree.vo.UserVO;

public interface UserDAO {
	//이메일로 사용자 정보 조회
	public UserVO selectByEmail(String email);
	//idx로 사용자 정보조회
	public UserVO selectByIdx(int idx);

	// 임시비밀번호로 비밀번호변경
	public void changePassword(HashMap<String, Object> paramMap);
	
	//사용자 등록
	public int insertUser(UserVO user);
	//이메일 중복체크
	public boolean checkEmail(String create_email);
	
	
	//회원 정보 보기
	public UserVO read(int idx) throws Exception;
	
	//회원 정보 수정 전 비밀 번호 확인
	public boolean checkPassword(String password, int idx);
	
	//회원 정보 수정
	public void update(HashMap<String, Object> update);
	
	//회원 탈퇴
	public void delete(int idx) throws Exception;
	
	//프로필 기본
	public void profileImage(UserVO user) throws Exception;
	//프로필 업데이트
	public void profileUpdate(UserVO user) throws Exception;
		
	//포인트 내역 조회
	public List<PointVO> readPlusPoint(int user_idx);
	public List<PointVO> readMinusPoint(int user_idx);
	
	//포인트 적립 및 사용 업데이트
	public UserVO upPoint(int idx, int point) throws Exception;
	public UserVO downPoint(int idx, int point) throws Exception;
	
	//포인트 적립 및 사용 내역 업데이트
	public PointVO updatePlusPoint(PointVO plus) throws Exception;
	public PointVO updateMinusPoint(PointVO minus) throws Exception;
	
	public int sumPoint(int user_idx) throws Exception;
	
}
