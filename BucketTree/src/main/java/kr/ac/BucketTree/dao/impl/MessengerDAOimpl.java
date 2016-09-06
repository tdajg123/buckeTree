package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.MessengerDAO;
import kr.ac.BucketTree.vo.MessengerVO;
@Repository
public class MessengerDAOimpl implements MessengerDAO {
	//주입
	@Autowired
	SqlSession sqlSession;
	

	private static final String namespace = "kr.ac.BucketTree.MessengerMapper";
	
	@Override
	public void insertMessenger(MessengerVO m) {
	
		sqlSession.insert(namespace+".insertMessenger",m);
	}

	@Override
	public List<MessengerVO> selectByMesseneger(int me, int you) {
		
		
		HashMap<String,Object> input=new HashMap<String,Object>();
		input.put("me", me);
		input.put("you", you);
		
		return sqlSession.selectList(namespace+".selectByMesseneger",input);
	}

	@Override
	public void readMessenger(int me, int you) {
		HashMap<String,Object> input=new HashMap<String,Object>();
		input.put("me", me);
		input.put("you", you);
		sqlSession.update(namespace+".readMessenger",input);
	}

	@Override
	public void changeReadMessenger(MessengerVO m) {
		
		sqlSession.update(namespace+".changeReadMessenger", m);
	}

	@Override
	public void deleteByMyMesseneger(int idx) {
		sqlSession.delete(namespace+".deleteByMyMesseneger", idx);
		
	}

}
