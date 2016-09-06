package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListDAO {

	/*전체 버킷리스트*/
	public List<BucketListVO> list() throws Exception;
	public List<BucketListVO> popular_list() throws Exception;			/*정렬_인기순*/
	public void countUp(BucketListVO vo) throws Exception;				/*담기_카운트 업*/
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist() throws Exception;
	public List<RecommendVO> recommendList() throws Exception;			/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;	/*관리자 추천*/
	
}
