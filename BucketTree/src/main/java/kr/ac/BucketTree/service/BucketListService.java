package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListService {
	
	/*전체 버킷리스트*/
	public List<BucketListVO> list() throws Exception;
	public List<BucketListVO> popular_list() throws Exception;			/*정렬-최신순*/
	public void countUp(BucketListVO count) throws Exception;
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist() throws Exception;
	public List<RecommendVO> recommendList() throws Exception;			/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;	/*관리자 추천*/
	
	
}
