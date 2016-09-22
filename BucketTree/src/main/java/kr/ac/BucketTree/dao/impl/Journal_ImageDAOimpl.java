package kr.ac.BucketTree.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.Journal_ImageDAO;
import kr.ac.BucketTree.vo.Journal_ImageVO;

@Repository
public class Journal_ImageDAOimpl implements Journal_ImageDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// BucketJournalMapper namespace
	private static final String namespace = "kr.ac.BucketTree.Journal_ImageMapper";

	@Override
	public void insertJournal_Image(Journal_ImageVO jivo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertJournal_Image", jivo);
	}

	@Override
	public void deleteByJournal_idx(int journal_idx) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteByJournal_Idx", journal_idx);

	}

}
