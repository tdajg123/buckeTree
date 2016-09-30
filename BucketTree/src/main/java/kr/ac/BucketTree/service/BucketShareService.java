package kr.ac.BucketTree.service;

import java.util.List;


import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;
import kr.ac.BucketTree.vo.BucketTreeVO;


public interface BucketShareService {
	List<BucketShareVO> selectPage(Pagination pagination);
	int selectCount(Pagination pagination);
	List<BucketShareVO> myselectPage(Pagination pagination,int user_idx);
	int myselectCount(Pagination pagination,int user_idx);
	List<BucketShareVO> myAnswerList(Pagination pagination,int user_idx);
	int myAnswerListCount(Pagination pagination,int user_idx);
	public BucketShareVO selectByIdx(int idx);
	public void adoptQuestion(BucketShareVO bucketShareVO);
	public  void insert(BucketShareVO bucketShareVO);
	public  void update(BucketShareVO bucketShareVO);
	public  void delete(int idx);
	public void updateBucketShareImage(BucketShareVO bucketShareVO);

}
