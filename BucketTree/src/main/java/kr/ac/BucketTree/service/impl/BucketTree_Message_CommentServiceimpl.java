package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketTree_Message_CommentDAO;
import kr.ac.BucketTree.service.BucketTree_Message_CommentService;
import kr.ac.BucketTree.vo.BucketTree_Message_Comment;
@Service
public class BucketTree_Message_CommentServiceimpl implements BucketTree_Message_CommentService{
	@Autowired
	BucketTree_Message_CommentDAO dao;
	@Override
	public List<BucketTree_Message_Comment> selectByidx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByidx(idx);
	}

	@Override
	public void insert(BucketTree_Message_Comment BucketTree_Message_Comment) {
		// TODO Auto-generated method stub
		dao.insert(BucketTree_Message_Comment);
	}

	@Override
	public void update(BucketTree_Message_Comment BucketTree_Message_Comment) {
		// TODO Auto-generated method stub
		dao.update(BucketTree_Message_Comment);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		dao.delete(idx);
	}

}
