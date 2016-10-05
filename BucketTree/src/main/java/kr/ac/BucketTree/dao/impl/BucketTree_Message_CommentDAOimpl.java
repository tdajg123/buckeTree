package kr.ac.BucketTree.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketTree_Message_CommentDAO;
import kr.ac.BucketTree.vo.BucketTree_Message;
import kr.ac.BucketTree.vo.BucketTree_Message_Comment;

@Repository
public class BucketTree_Message_CommentDAOimpl implements BucketTree_Message_CommentDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketTree_Message_CommentMapper";
	@Override
	public List<BucketTree_Message_Comment> selectByidx(int idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectByidx",idx);
	}

	@Override
	public void insert(BucketTree_Message_Comment BucketTree_Message_Comment) {
		session.insert(namespace+".insert",BucketTree_Message_Comment);
		
	}

	@Override
	public void update(BucketTree_Message_Comment BucketTree_Message_Comment) {
		session.update(namespace+".update",BucketTree_Message_Comment);
		
	}

	@Override
	public void delete(int idx) {
		session.delete(namespace+".delete",idx);
		
	}

}
