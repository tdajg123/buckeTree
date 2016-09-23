package kr.ac.BucketTree.service;

import java.util.List;


import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;


public interface BucketShareService {
	List<BucketShareVO> selectPage(Pagination pagination);
	int selectCount(Pagination pagination);
	List<BucketShareVO> myselectPage(Pagination pagination,int user_idx);
	int myselectCount(Pagination pagination,int user_idx);
	List<BucketShareVO> myAnswerList(Pagination pagination,int user_idx);
	int myAnswerListCount(Pagination pagination,int user_idx);

}
