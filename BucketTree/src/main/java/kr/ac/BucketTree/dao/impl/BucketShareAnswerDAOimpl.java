package kr.ac.BucketTree.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketShareAnswerDAO;
import kr.ac.BucketTree.vo.BucketShareAnswerVO;
@Repository
public class BucketShareAnswerDAOimpl implements BucketShareAnswerDAO{
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketShareAnswerMapper";
	@Override
	public List<BucketShareAnswerVO> selectByQuestion(int idx) {
		
		return session.selectList(namespace+".selectByQuestion",idx);
	}
	@Override
	public void insert(BucketShareAnswerVO bucketShareAnswerVO) {
		session.insert(namespace+".insert",  bucketShareAnswerVO);
		
	}
	@Override
	public void update(BucketShareAnswerVO bucketShareAnswerVO) {
		session.update(namespace+".update",  bucketShareAnswerVO);
		
	}
	@Override
	public void delete(int idx) {
		session.delete(namespace+".delete", idx);
		
	}
	@Override
	public void adopt(BucketShareAnswerVO bucketShareAnswerVO) {
		session.update(namespace+".adopt", bucketShareAnswerVO);
		
	}
	@Override
	public BucketShareAnswerVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectByIdx",idx);
	}

}
