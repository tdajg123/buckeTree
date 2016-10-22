package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTree_Message;

public interface BucketTree_MessageDAO {
	public void insert(BucketTree_Message bucketTree_MessageVO);

	public List<BucketTree_Message> list(int idx, Pagination pagination);

	public int listCount(int idx);

	public List<BucketTree_Message> noticeList(int idx);

	public BucketTree_Message selectByidx(int idx);

	public void update(BucketTree_Message bucketTree_MessageVO);

	public void updateType(BucketTree_Message bucketTree_MessageVO);

	public void delete(int idx);

	public int missionCount(int idx);
}
