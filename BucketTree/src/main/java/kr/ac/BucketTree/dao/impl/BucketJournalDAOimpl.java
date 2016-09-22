package kr.ac.BucketTree.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketJournalDAO;
import kr.ac.BucketTree.vo.BucketJournalVO;

@Repository
public class BucketJournalDAOimpl implements BucketJournalDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// BucketJournalMapper namespace
	private static final String namespace = "kr.ac.BucketTree.BucketJournalMapper";

	// bucket_idx로 일지 리스트 조회
	@Override
	public List<BucketJournalVO> bucketJournalList(int bucket_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".bucketJournalList", bucket_idx);
	}

	// 일지 select
	@Override
	public BucketJournalVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByIdx", idx);
	}

	// 일지 insert
	@Override
	public void insertJournal(BucketJournalVO bj) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertJournal", bj);
	}

	// 일지 update
	@Override
	public void updateJournal(BucketJournalVO bj) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateJournal", bj);
	}

	// 일지 delete
	@Override
	public void deleteJournal(int idx) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteJournal", idx);
	}

}
