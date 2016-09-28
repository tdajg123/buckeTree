package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketTree_MemberDAO;

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

}
