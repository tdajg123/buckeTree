package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;

public interface BucketTreeDAO {
	
	public List<BucketTreeVO> selectPage(Pagination pagination,int user_idx);
	public int selectCount(Pagination pagination);
	


}
