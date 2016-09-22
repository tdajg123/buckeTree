package kr.ac.BucketTree.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.BucketTree.dao.TimelineDAO;
import kr.ac.BucketTree.vo.TimelineVO;

public class TimelineDAOimpl implements TimelineDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// timelineMapper namespace
	private static final String namespace = "kr.ac.BucketTree.TimelineMapper";

	// user_idx로 타임라인 조회
	@Override
	public TimelineVO selectByIdx(int user_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByIdx", user_idx);
	}

}
