package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketTree_MemberDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.BucketTree_MemberVO;
import kr.ac.BucketTree.vo.UserVO;

@Repository
public class BucketTree_MemberDAOimpl implements BucketTree_MemberDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketTree_MemberMapper";
	@Override
	public void apply(int bucketTree_idx, int user_idx, int state) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("bucketTree_idx", bucketTree_idx);
		input.put("user_idx", user_idx);
		input.put("state",  state);
		session.insert(namespace+".apply",input);
	}

	@Override
	public void cancel(int bucketTree_idx, int user_idx) {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("bucketTree_idx", bucketTree_idx);
		input.put("user_idx", user_idx);
		session.delete(namespace+".cancel", input);
		
	}
	
	/*트리 회원관리 - 가입한 전체 회원 목록*/
	@Override
	public List<UserVO> MemberList(Pagination page, int idx) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String,Object>();
		input.put("p", page);
		input.put("idx", idx);
		
		return session.selectList(namespace + ".memberList", input);
	}

	/*트리 회원관리 - 가입 요청한 회원 목록*/
	@Override
	public List<UserVO> applyList(Pagination page, int idx) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input=new HashMap<String,Object>();
		input.put("p", page);
		input.put("idx", idx);
		
		return session.selectList(namespace + ".applyList", input);
	}

	/*트리 회원관리 - 가입 요청 수락*/
	@Override
	public int addMember(BucketTree_MemberVO member) {
		// TODO Auto-generated method stub
		return session.update(namespace + ".addMember", member);
	}

	/*트리 회원관리 - 가입 요청 거절*/
	@Override
	public int denyJoin(BucketTree_MemberVO deny) {
		// TODO Auto-generated method stub
		return session.delete(namespace + ".denyJoin", deny);
	}

	/*트리 회원관리 - 트리장 위임*/
	@Override
	public int mandate(BucketTreeVO mandate) {
		// TODO Auto-generated method stub
		return session.update(namespace + ".mandate", mandate);
	}

	/*트리 회원관리 - 트리장인지 확인*/
	@Override
	public int checkAdmin(BucketTree_MemberVO check) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkAdmin", check);
	}
	
	
}
