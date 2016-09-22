package kr.ac.BucketTree.dao.impl;

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

}
