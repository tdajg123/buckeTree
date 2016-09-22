package kr.ac.BucketTree.service;

import java.util.List;


import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;


public interface BucketShareService {
	List<BucketShareVO> selectPage(Pagination pagination);
	int selectCount(Pagination pagination);

}
