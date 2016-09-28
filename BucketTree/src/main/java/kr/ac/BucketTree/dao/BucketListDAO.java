package kr.ac.BucketTree.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.CommentVO;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.RecommendVO;

public interface BucketListDAO {

	/*전체 버킷리스트*/
	public List<BucketListVO> list(Pagination pagination,int user_idx) throws Exception;/*전체 목록 및 정렬,검색*/
	public List<BucketListVO> listAjax(Pagination p) throws Exception;					/*버킷리스트-무한스크롤*/
	int listCount(Pagination pagination,int user_idx) throws Exception;
	public int listImage(int bucket_idx) throws Exception;								/*버킷리스트-첫번째 이미지로 보이기*/
	
	public void countUp(int idx) throws Exception;										/*담기_카운트 업*/
	public void addBucket(HashMap<String, Object> addBucket) throws Exception;			/*버킷 버튼 클릭 -> 마이 버킷에 추가*/
																						
	public boolean titleCheck(String mtitle, int userIdx) throws Exception;				/*담아올 버킷이 마이 버킷리스트에 있는지 중복 타이틀 검사*/
	
	/*마이 버킷리스트*/
	public List<BucketListVO> mylist(Pagination pagination) throws Exception;
	public List<BucketListVO> mylistAjax(Pagination p) throws Exception;				/*버킷리스트-무한스크롤*/
	public List<BucketListVO> recommendList(int fromUser) throws Exception;				/*친구 추천*/
	public List<BucketListVO> adminRecommendList() throws Exception;					/*관리자 추천*/
	
    public List<BucketListVO> bucketShare_MyBucketList(int user_idx);	
    public List<BucketListVO> bucketTree_MyBucketList(int user_idx);	
    /*버킷리스트 추가*/
	public int  insertBucketList(BucketListVO vo)throws Exception;
	
	/*아이디로 버킷리스트 조회*/
	public BucketListVO bucket(int idx) throws Exception;
	
	/*파일 업로드*/
	/*image 테이블 삽입(이미지 업로드)*/
	public int insertImage(ImageVO image); 
	
	/*잔여 이미지 삭제*/
	public int deleteOrphan();
	
	/*BJTS_image 테이블 삽입 (이미지 업로드)*/
	int insertblImage(int bucket_idx,int imag_idx); 
	
	/*버킷리스트 idx에 해당하는 BucketList_image 테이블 삭제*/
	int deleteByBucketIdx(int bucketIdx);

	/*아이디로 이미지 조회*/
	public ImageVO selectById(ImageVO vo);
	
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
	
	/*댓글 삽입*/
	public int insertComment(CommentVO cvo);
	
	/*댓글 idx로 조회 */
	public CommentVO selectByIdxComment(int idx);
	
	/*버킷 삭제 시 댓글 삭제 */
	public int deleteBucComment(int idx);
	
	/* 댓글 삭제 */
	public int deleteComment(int idx);
	
	
	/* 댓글 수정 */
	public int updateComment(CommentVO cvo);
	
	
	public void updateTreeidx(BucketListVO bucketListVO);
}
