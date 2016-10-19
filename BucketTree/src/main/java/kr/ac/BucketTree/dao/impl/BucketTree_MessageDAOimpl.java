package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketTree_MessageDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTree_Message;

@Repository
public class BucketTree_MessageDAOimpl implements BucketTree_MessageDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketTree_MessageMapper";

	@Override
	public void insert(BucketTree_Message bucketTree_Message) {

		session.insert(namespace + ".insert", bucketTree_Message);

	}

	@Override
	public List<BucketTree_Message> list(int idx, Pagination pagination) {
		// TODO Auto-generated method stub
		HashMap<String, Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("idx", idx);
		return session.selectList(namespace + ".list", input);
	}

	@Override
	public int listCount(int idx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listCount", idx);
	}

	@Override
	public List<BucketTree_Message> noticeList(int idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".noticeList", idx);
	}

	@Override
	public BucketTree_Message selectByidx(int idx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectByidx", idx);
	}

	@Override
	public void update(BucketTree_Message bucketTree_MessageVO) {

		session.update(namespace + ".update", bucketTree_MessageVO);
	}
	
	@Override
	public void updateType(BucketTree_Message bucketTree_MessageVO) {

		session.update(namespace + ".updateType", bucketTree_MessageVO);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		session.update(namespace + ".delete", idx);
	}

	@Override
	public int missionCount(int idx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".missionCount", idx);
	}

}
