package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;

public interface BucketShareDAO {
	List<BucketShareVO> selectPage(Pagination pagination);
	int selectCount(Pagination pagination);
}
