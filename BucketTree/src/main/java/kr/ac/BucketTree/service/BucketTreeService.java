package kr.ac.BucketTree.service;

import java.util.List;


import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;


public interface BucketTreeService {

	public List<BucketTreeVO> selectPage(Pagination pagination,int user_idx);
	public int selectCount(Pagination pagination);
	public List<BucketTreeVO> selectMyPage(Pagination pagination,int user_idx);
	public int selectMyCount(Pagination pagination,int user_idx);
	public List<BucketTreeVO> applyBucketTree(int user_idx);
	public List<BucketTreeVO> adminByReommend(int user_idx);
	public void insert(BucketTreeVO bucketTreeVO);
}
