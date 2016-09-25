package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketShareDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;

@Repository
public class BucketShareDAOimpl implements BucketShareDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketShareMapper";
	@Override
	public List<BucketShareVO> selectPage(Pagination pagination) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectPage", pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectCount", pagination);
	}

	@Override
	public List<BucketShareVO> myselectPage(Pagination pagination,int user_idx) {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);

		return session.selectList(namespace+".myselectPage", input);
	}

	@Override
	public int myselectCount(Pagination pagination,int user_idx) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectOne(namespace+".myselectCount", input);
	}

	@Override
	public List<BucketShareVO> myAnswerList(Pagination pagination, int user_idx) {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectList(namespace+".myAnswerList", input);
	}
	
	@Override
	public int myAnswerListCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectOne(namespace+".myAnswerListCount", input);
	}

	@Override
	public BucketShareVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectByIdx", idx);
		                                   
	}

	@Override
	public void adoptQuestion(BucketShareVO bucketShareVO) {
		session.update(namespace+".adoptQuestion",bucketShareVO);
		
	}

	@Override
	public void insert(BucketShareVO bucketShareVO) {
		session.insert(namespace+".insert",bucketShareVO);
	}

	@Override
	public void update(BucketShareVO bucketShareVO) {
		// TODO Auto-generated method stub
		session.update(namespace+".update",bucketShareVO);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		session.update(namespace+".delete",idx);
	}

}
