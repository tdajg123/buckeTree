package kr.ac.BucketTree.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.UserDAO;
import kr.ac.BucketTree.service.UserService;
import kr.ac.BucketTree.util.MyAuthenticationProvider;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.PointVO;
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
	public int insertUser(UserVO user) {
		return dao.insertUser(user);
	}

	// 비밀번호 찾기---------------
	@Override
	public boolean checkEmail(String create_email) {
		return this.dao.checkEmail(create_email);
	}

	// 회원 정보 보기
	@Override
	public UserVO read(int idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(idx);
	}

	// 회원 정보 수정 전 비밀번호 확인
	@Override
	public boolean checkPassword(String password, int idx) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.checkPassword(password, idx);
	}

	// 회원 정보 수정
	@Override
	public void update(HashMap<String, Object> update) throws Exception {
		// TODO Auto-generated method stub
		dao.update(update);
	}

	// 회원 탈퇴
	@Override
	public void delete(int idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(idx);
	}

	// 기본 이미지
	@Override
	public ImageVO basicImage() {
		return dao.basicImage();
	}

	// 프로필 기본
	@Override
	public void profileImage(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.profileImage(user);
	}

	// 프로필 업데이트
	@Override
	public void profileUpdate(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		dao.profileUpdate(user);
	}

	@Override
	public List<PointVO> readPointList(int user_idx) {
		// TODO Auto-generated method stub
		return dao.readPointList(user_idx);
	}

	// 적립된 포인트 내역 조회
	@Override
	public List<PointVO> readPlusPoint(int user_idx) {
		// TODO Auto-generated method stub
		return dao.readPlusPoint(user_idx);
	}

	// 소모된 포인트 내역 조회
	@Override
	public List<PointVO> readMinusPoint(int user_idx) {
		// TODO Auto-generated method stub
		return dao.readMinusPoint(user_idx);
	}

	// 포인트 적립 및 사용 업데이트
	/**
	 * point는 컨트롤러에서 적립 구분에 따라 나눠준 일종의 시퀀스. 따라서, 해당 시퀀스에 따라 point 값을 설정해준다.
	 * point == 1 : 회원 가입 완료 _ 1000 포인트 적립 point == 2 : 버킷 리스트 완료 _ 100 포인트 적립
	 * point == 3 : 버킷 쉐어 채택 시 _ 질문자가 건 자율 포인트로 적립 (100단위 선택) point == 4 : 출석
	 * 포인트 _ 10 포인트 적립 (1일 1회)
	 */
	@Override
	public UserVO upPoint(int idx, int point) throws Exception {
		// TODO Auto-generated method stub

		if (point == 1) {
			point = 1000;
		} else if (point == 2) {
			point = 100;
		} else if (point == 3) {
			point = 100; // 버킷 쉐어에 해당하는 부분;임의로 100이라 넣음
		} else if (point == 4) {
			point = 10;
		}

		return dao.upPoint(idx, point);
	}

	/**
	 * point == 1 : 트리 개설 시 _ 300 포인트 사용 point == 2 : 트리 내 인원 증대 시 1인당 _ 100 포인트
	 * 사용 point == 3 : 버킷 쉐어 질문 시 _ 질문자가 내건 자율 포인트만큼 사용 (100단위 선택) point == 4 :
	 * 템플릿 선택 시 버킷 리스트 당 _ 100 포인트 사용
	 */
	@Override
	public UserVO downPoint(int idx, int point) throws Exception {
		// TODO Auto-generated method stub
		if (point == 1) {
			point = 300;
		} else if (point == 2) {
			point = 100; // 트리 내 인원 증대 시 1인당 100포인트 사용이니 선택한 인원 수 곱하기 100. => 인원
							// 수 필요.
		} else if (point == 3) {
			point = 100; // 버킷 쉐어에 해당하는 부분;임의로 100이라 넣음
		} else if (point == 4) {
			point = 100;
		}

		return dao.downPoint(idx, point);
	}

	// 포인트 적립 내역 업데이트
	@Override
	public PointVO updatePlusPoint(int idx, int sq, int point) throws Exception {
		// TODO Auto-generated method stub
		PointVO plus = new PointVO();
		plus.setUser_idx(idx);

		if (sq == 1) {
			plus.setPoint(point);
			plus.setContents("회원 가입 축하 포인트!!!!!");
		} else if (sq == 2) {
			plus.setPoint(point);
			plus.setContents("버킷 리스트 완료 *0*b ");
		} else if (sq == 3) {
			plus.setPoint(point);
			plus.setContents("버킷 쉐어 답변 글 채택 ");
		} else if (sq == 4) {
			plus.setPoint(point);
			plus.setContents("출석 포인트");
		}

		return dao.updatePlusPoint(plus);
	}

	// 포인트 사용 내역 업데이트
	@Override
	public PointVO updateMinusPoint(int idx, int sq, int point) throws Exception {
		// TODO Auto-generated method stub
		PointVO minus = new PointVO();
		minus.setUser_idx(idx);

		if (sq == 1) {
			minus.setPoint(point);
			minus.setContents("버킷 트리 개설");
		} else if (sq == 2) {
			minus.setPoint(point);
			minus.setContents("버킷 트리 내 인원 증대");
		} else if (sq == 3) {
			minus.setPoint(point);
			minus.setContents("버킷 쉐어 질문 등록 ");
		} else if (sq == 4) {
			minus.setPoint(point);
			minus.setContents("버킷 리스트 템플릿 사용");
		}

		return dao.updateMinusPoint(minus);
	}

	@Override
	public int sumPoint(int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.sumPoint(user_idx);
	}

	@Override
	public List<UserVO> userSelectAll(Pagination pagination) {
		return dao.userSelectAll(pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {
		return dao.selectCount(pagination);
	}
}
