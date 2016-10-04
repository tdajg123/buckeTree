package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.Message_ImageDAO;
@Repository
public class Message_ImageDAOimpl implements Message_ImageDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.Message_ImageMapper";
	@Override
	public void insert(int message_idx, int image_idx) {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("message_idx", message_idx);
		input.put("image_idx", image_idx);
		session.insert(namespace+".insert", input);
		
	}

	@Override
	public void deleteByMessageIdx(int message_idx) {
		session.insert(namespace+".deleteByMessageIdx", message_idx);
		
	}

}
