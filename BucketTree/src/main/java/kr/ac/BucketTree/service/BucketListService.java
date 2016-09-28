package kr.ac.BucketTree.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.CommentVO;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListService {
	
	/*전체 버킷리스트*/
	public List<BucketListVO> list(Pagination pagination) throws Exception;				/*전체 목록 및 정렬-최신순*/
	public List<BucketListVO> listAjax(Pagination p) throws Exception;					/*버킷리스트-무한스크롤*/
	int listCount(Pagination pagination);
	public int listImage(int bucket_idx) throws Exception;								/*버킷리스트-첫번째 이미지*/
	
	public void countUp(int idx) throws Exception;										/*담기-카운트업*/
	public void addBucket(HashMap<String, Object> addBucket) throws Exception;			/*담기-마이버킷에 추가*/
	public boolean titleCheck(String title, int userIdx) throws Exception;				/*담아올 버킷이 마이 버킷리스트에 있는지 중복 타이틀 검사*/
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist(Pagination pagination) throws Exception;
	public List<BucketListVO> mylistAjax(Pagination p) throws Exception;				/*마이리스트-무한스크롤*/
	public List<BucketListVO> recommendList(int fromUser) throws Exception;							/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;					/*관리자 추천*/
	
	public List<BucketListVO> bucketShare_MyBucketList(int user_idx);
	
	/*버킷리스트 추가*/
	public int insertBucketList(BucketListVO vo) throws Exception;
	
	/*아이디로 버킷리스트 조회 */
	public BucketListVO bucket(int idx) throws Exception;
	
	
	/*파일 업로드 */
	/*image 테이블 삽입(이미지 업로드)*/
	public void insertImage(ImageVO image);
	/*BucketList_image 테이블 삽입 (이미지 업로드)*/
	public void insertblImage(int bucket_idx, int image_idx);
	public void updateBucketImage(BucketListVO vo);
	
	/*아이디로 이미지 조회*/
	public ImageVO selectById(ImageVO vo);

	/*BucketList_image 테이블 값 제거*/
	public int deleteByBucketIdx(int bucket_idx);
	
	/*버킷리스트 수정*/
	public int editBucket(BucketListVO buck);
	
	/*버킷리스트 삭제*/
	public int deleteBucket(int idx);
	
	/* 버킷리스트 idx에 해당하는 BucketList_image 테이블의 image_idx 레코드 조회 */
	public int selectByImageIdx(int idx);
	/* Image 테이블 idx로 레코드 제거  */
	public int deleteImage(int idx);
	
	/* 댓글 전체 조회 */
	public List<CommentVO> selectComment(int idx);
	
	/* 댓글 삽입 */
	public int insertComment(CommentVO cvo);
	 
	/* 댓글 idx로 조회 */
	public CommentVO selectByIdxComment(int idx);
	
	/* 버킷 삭제 시 댓글 삭제 */
	public int deleteBucComment(int idx);
	
	/* 댓글 삭제 */
	public int deleteComment(int idx);
	
	/* 댓글 수정 */
	public int updateComment(CommentVO cvo);
	
	public List<BucketListVO> bucketTree_MyBucketList(int user_idx);
	public void updateTreeidx(BucketListVO bucketListVO);
}
