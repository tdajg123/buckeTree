package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.TimelineDAO;
import kr.ac.BucketTree.vo.TimelineVO;

@Repository
public class TimelineDAOimpl implements TimelineDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// timelineMapper namespace
	private static final String namespace = "kr.ac.BucketTree.TimelineMapper";

	// user_idx로 타임라인 리스트 조회
	@Override
	public List<TimelineVO> timelineList(int user_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".timelineList", user_idx);
	}

	// idx로 타임라인 조회
	@Override
	public TimelineVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByIdx", idx);
	}

	// 타임라인 insert
	@Override
	public void insertTimeline(TimelineVO tlv) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertTimeline", tlv);
	}
	
	@Override
	public int checkDate(int user_idx,int toUser){
		TimelineVO ti = new TimelineVO();
		ti.setUser_idx(user_idx);
		ti.setToUser(toUser);
		return sqlSession.selectOne(namespace +".checkDate",ti);
	}
}
