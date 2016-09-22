package kr.ac.BucketTree.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.ImageDAO;
import kr.ac.BucketTree.vo.ImageVO;

@Repository
public class ImageDAOimpl implements ImageDAO {

	// 주입
	@Autowired
	SqlSession sqlSession;

	// BucketJournalMapper namespace
	private static final String namespace = "kr.ac.BucketTree.ImageMapper";

	@Override
	public ImageVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".selectByIdx", idx);
	}

	@Override
	public void insertImage(ImageVO iv) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertImage", iv);

	}

	@Override
	public void deleteOrphan() {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteOrphan");
	}

}
