package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.vo.BucketTree_Message;
import kr.ac.BucketTree.vo.BucketTree_Message_Comment;

public interface BucketTree_Message_CommentDAO {

	public List<BucketTree_Message_Comment> selectByidx(int idx);
	public void insert(BucketTree_Message_Comment BucketTree_Message_Comment);
	public void update(BucketTree_Message_Comment BucketTree_Message_Comment);
	public void delete(int idx);
	
}