package kr.ac.BucketTree.dao;

public interface BucketTree_MemberDAO {
		
	public void apply(int bucketTree_idx,int user_idx,int state);
	public void cancel(int bucketTree_idx,int user_idx);
	
}
