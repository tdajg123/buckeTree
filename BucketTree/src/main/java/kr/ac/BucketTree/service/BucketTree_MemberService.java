package kr.ac.BucketTree.service;


public interface BucketTree_MemberService {
	public void apply(int bucketTree_idx,int user_idx,int state);
	public void cancel(int bucketTree_idx,int user_idx);
}
