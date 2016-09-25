package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.Question_ImageDAO;
@Repository
public class Question_ImageDAOimpl implements Question_ImageDAO{
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.Question_ImageMapper";
	@Override
	public void insert(int question_idx, int image_idx) {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("question_idx", question_idx);
		input.put("image_idx", image_idx);
		session.insert(namespace+".insert", input);
	}

	
	@Override
	public void deleteByQuestionIdx(int question_idx) {
		session.insert(namespace+".deleteByQuestionIdx", question_idx);
		
	}

}
