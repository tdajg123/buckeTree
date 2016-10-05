package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTree_Message;

public interface BucketTree_MessageService {
	public void insert(BucketTree_Message bucketTree_Message);
	public void updateBucketTreeImage(BucketTree_Message bucketTree_Message);
	public List<BucketTree_Message> list(int idx,Pagination pagination);
	public int listCount(int idx);
	public List<BucketTree_Message> noticeList(int idx);
	public BucketTree_Message selectByidx(int idx);
	public void update(BucketTree_Message bucketTree_MessageVO );
	public void delete(int idx);
}
