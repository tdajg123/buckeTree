package kr.ac.BucketTree.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListService {
	
	/*전체 버킷리스트*/
	public List<BucketListVO> list(Pagination pagination) throws Exception;				/*전체 목록 및 정렬-최신순*/
	public List<BucketListVO> listAjax(Pagination p) throws Exception;					/*버킷리스트-무한스크롤*/
	int listCount(Pagination pagination);
	
	public void countUp(int idx) throws Exception;										/*담기-카운트업*/
	public void addBucket(HashMap<String, Object> addBucket) throws Exception;			/*담기-마이버킷에 추가*/
	public boolean titleCheck(String title, int userIdx) throws Exception;				/*담아올 버킷이 마이 버킷리스트에 있는지 중복 타이틀 검사*/
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist(Pagination pagination) throws Exception;
	public List<BucketListVO> mylistAjax(Pagination p) throws Exception;				/*마이리스트-무한스크롤*/
	public List<RecommendVO> recommendList() throws Exception;							/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;					/*관리자 추천*/
	
	public List<BucketListVO> bucketShare_MyBucketList(int user_idx);
}
