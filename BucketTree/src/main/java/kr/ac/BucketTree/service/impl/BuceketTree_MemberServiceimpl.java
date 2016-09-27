package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketTree_MemberDAO;
import kr.ac.BucketTree.service.BucketTree_MemberService;

@Service
public class BuceketTree_MemberServiceimpl implements BucketTree_MemberService{
	@Autowired 
	 BucketTree_MemberDAO dao;
	@Override
	public void apply(int bucketTree_idx, int user_idx, int state) {
		dao.apply(bucketTree_idx, user_idx, state);
		
	}

	@Override
	public void cancel(int bucketTree_idx, int user_idx) {
		dao.cancel(bucketTree_idx, user_idx);
		
	}

}
