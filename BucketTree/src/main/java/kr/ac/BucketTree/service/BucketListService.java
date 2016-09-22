package kr.ac.BucketTree.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.PageVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListService {
	
	/*전체 버킷리스트*/
	public List<BucketListVO> list(PageVO page) throws Exception;				/*전체 목록 및 정렬-최신순*/
	public List<BucketListVO> popular_list(PageVO page) throws Exception;		/*정렬-인기순*/
	public void countUp(int idx) throws Exception;
	public void addBucket(HashMap<String, Object> addBucket) throws Exception;
	
	//검색
	public List<BucketListVO> SearchList(HashMap<String, Object> category, PageVO page);
	
	/*담아올 버킷이 마이 버킷리스트에 있는지 중복 타이틀 검사*/
	public boolean titleCheck(String title, int userIdx) throws Exception;
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist(PageVO page) throws Exception;
	public List<RecommendVO> recommendList() throws Exception;			/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;	/*관리자 추천*/
	
	
}
