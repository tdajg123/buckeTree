package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.UserDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.PointVO;
import kr.ac.BucketTree.vo.UserVO;

@Repository
public class UserDAOimpl implements UserDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// userMapper namespace
	private static final String namespace = "kr.ac.BucketTree.UserMapper";

	// 이메일로 사용자 조회
	@Override
	public UserVO selectByEmail(String email) {

		return sqlSession.selectOne(namespace + ".selectByEmail", email);
	}

	@Override
	public UserVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByIdx", idx);
	}

	// 임시비밀번호로 비밀번호 변경
	@Override
	public void changePassword(HashMap<String, Object> paramMap) {
		sqlSession.update(namespace + ".updatePassword", paramMap);
	}

	@Override
	public int insertUser(UserVO user) {
		return sqlSession.insert(namespace + ".insertUser", user);
	}

	@Override
	public boolean checkEmail(String create_email) {
		int count = sqlSession.selectOne(namespace + ".checkEmail", create_email);
		return count > 0;
	}

	// 회원 정보 보기
	@Override
	public UserVO read(int idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".read", idx);
	}

	// 회원 정보 수정 전 비밀번호 확인
	@Override
	public boolean checkPassword(String password, int idx) {
		// TODO Auto-generated method stub

		HashMap<String, Object> check = new HashMap<String, Object>();

		check.put("password", password);
		check.put("idx", idx);

		int count = sqlSession.selectOne(namespace + ".checkPassword", check);
		System.out.println("check : " + count);

		return count > 0;
	}

	// 회원 정보 수정
	@Override
	public void update(HashMap<String, Object> update) {
		// TODO Auto-generated method stub

		sqlSession.update(namespace + ".update", update);
	}

	// 회원 탈퇴
	@Override
	public void delete(int idx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", idx);
	}

	// 기본이미지
	@Override
	public ImageVO basicImage() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".basicProfile");
	}

	// 프로필 기본
	@Override
	public void profileImage(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".profileImage", user);
	}

	// 프로필 업데이트
	@Override
	public void profileUpdate(UserVO user) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".profileUpdate", user);
	}

	@Override
	public List<PointVO> readPointList(int user_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".pointList", user_idx);
	}

	/* 적립된 포인트 내역 조회 */
	@Override
	public List<PointVO> readPlusPoint(int user_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".plusPoint", user_idx);
	}

	/* 소모된 포인트 내역 조회 */
	@Override
	public List<PointVO> readMinusPoint(int user_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".minusPoint", user_idx);
	}

	// 포인트 적립 업데이트
	@Override
	public UserVO upPoint(int idx, int point) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> update = new HashMap<String, Object>();

		update.put("idx", idx);
		update.put("point", point);

		return sqlSession.selectOne(namespace + ".upPoint", update);
	}

	// 포인트 사용 업데이트
	@Override
	public UserVO downPoint(int idx, int point) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> update = new HashMap<String, Object>();

		update.put("idx", idx);
		update.put("point", point);

		return sqlSession.selectOne(namespace + ".downPoint", update);
	}

	// 포인트 적립 내역 업데이트
	@Override
	public PointVO updatePlusPoint(PointVO plus) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".updatePlusPoint", plus);
	}

	// 포인트 사용 내역 업데이트
	@Override
	public PointVO updateMinusPoint(PointVO minus) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".updateMinusPoint", minus);
	}

	@Override
	public int sumPoint(int user_idx) throws Exception {
		// TODO Auto-generated method stub
		if (sqlSession.selectOne(namespace + ".sumPoint", user_idx) == null) {
			return 0;
		}
		return sqlSession.selectOne(namespace + ".sumPoint", user_idx);
	}

	@Override
	public List<UserVO> userSelectAll(Pagination pagination) {
		return sqlSession.selectList(namespace + ".userSelectAll", pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {
		return sqlSession.selectOne(namespace + ".selectCount", pagination);
	}

}
