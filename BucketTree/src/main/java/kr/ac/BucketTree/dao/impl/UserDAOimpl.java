package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.BucketTree.dao.UserDAO;
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
	public int insertUser(UserVO user){
		return sqlSession.insert(namespace+".insertUser", user);
	}
	@Override
	public boolean checkEmail(String create_email){
		int count = sqlSession.selectOne(namespace+".checkEmail",create_email);
		return count > 0;
	}
}
