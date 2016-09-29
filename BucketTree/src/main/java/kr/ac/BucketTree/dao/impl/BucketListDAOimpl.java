package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.CommentVO;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Repository
public class BucketListDAOimpl implements BucketListDAO {

	@Autowired
	private SqlSession session;

	// BucketListMapper namespace
	private static final String namespace = "kr.ac.BucketTree.BucketListMapper";

	/*전체 버킷리스트 목록*/
	@Override
	public List<BucketListVO> list(Pagination pagination,int user_idx) throws Exception {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectList(namespace+".list", input);
	}
	/*버킷리스트 페이지 카운트*/
	@Override
	public int listCount(Pagination pagination,int user_idx) throws Exception {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectOne(namespace + ".listCount", input);
	}


	/*버킷리스트-첫번째 이미지로 보이기*/
	@Override
	public int listImage(int bucket_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".listImage", bucket_idx);
	}
	/*전체 : 담기_카운트 업*/
	@Override
	public void countUp(int idx) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".countUp", idx);
	}

	/*전체 : 버킷 버튼 클릭 시 마이 버킷에 추가*/
	@Override
	public void addBucket(HashMap<String, Object> addBucket) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".addBucket", addBucket);
	}
	
	/*중복 타이틀 검사*/
	@Override
	public boolean titleCheck(String mtitle, int userIdx) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> check = new HashMap<String, Object>();
		
		check.put("title", mtitle);
		check.put("userIdx", userIdx);
		
		int count = session.selectOne(namespace+".titleCheck", check);
		
		return count > 0;
	}

	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist(Pagination pagination,int user_idx) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectList(namespace+".mylist",input);
	}
	

	/*마이 : 친구 추천 목록*/
	@Override
	public List<BucketListVO> recommendList(int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".recommendList", user_idx);
	}

	/*마이 : 관리자 추천 목록*/
	@Override
	public List<BucketListVO> adminRecommendList(int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".adminRecommendList",user_idx);
	}
	@Override
	public List<BucketListVO> bucketShare_MyBucketList(int user_idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".bucketShare_MyBucketList",user_idx);
	}
	
	/* 전체,마이 : 버킷리스트 추가 */
	@Override
	public int insertBucketList(BucketListVO vo) throws Exception {
		return session.insert(namespace + ".insertBucketList", vo);
	}
	
	/*아이디로 버킷리스트 조회 */
	@Override
	public BucketListVO bucket(int idx) throws Exception{
		return session.selectOne(namespace +".bucket", idx);
	}
	
	/*파일 업로드 */
	/*image 테이블 삽입 */
	@Override
	public int insertImage(ImageVO image){
		return session.insert(namespace +".insertbImage", image);		
	}; 
	
	/*BucketList_image 테이블 삽입*/
	@Override
	public int insertblImage(int bucket_idx, int image_idx){
		HashMap<String,Object> input=new HashMap<String,Object>();
		input.put("bucket_idx", bucket_idx);
		input.put("image_idx", image_idx);
		
		return session.insert(namespace +".insertblImage", input);
	}
	
	/*버킷리스트 idx와 일치하는 BucketList_image 테이블 삭제*/
	@Override
	public int deleteByBucketIdx(int bucket_idx){
		return session.delete(namespace +".deleteByBucketIdx", bucket_idx);
	}
	
	/*아이디로 이미지 테이블 조회*/
	@Override
	public ImageVO selectById(ImageVO vo){
		return session.selectOne(namespace +".selectById",vo);
	}
	
	/*버킷리스트 수정*/
	@Override
	public int editBucket(BucketListVO buck){
		return session.update(namespace +".editBucket",buck);
	}
	
	/*버킷리스트 삭제*/
	@Override
	public int deleteBucket(int idx){
		return session.delete(namespace +".deleteBucket",idx); 
	}
	/* 버킷리스트 idx에 해당하는 BucketList_image 테이블의 image_idx 레코드 조회 */
	@Override
	public int selectByImageIdx(int idx){
		
		if(session.selectOne(namespace +".selectByImageIdx", idx)==null){
			return 0;
		}else{
		return session.selectOne(namespace +".selectByImageIdx", idx);
		}
	}
	/* Image 테이블 idx로 레코드 제거  */
	@Override
	public int deleteImage(int idx){
		return session.delete(namespace +".deleteImage",idx);
	}
	
	@Override
	public List<CommentVO> selectComment(int idx){
		return session.selectList(namespace +".selectComment", idx);
	}
	
	@Override
	public int insertComment(CommentVO cvo){
		return session.insert(namespace +".insertComment",cvo);
	}
	
	@Override
	public CommentVO selectByIdxComment(int idx){
		return session.selectOne(namespace +".selectByIdxComment", idx);
	}
	
	@Override
	public int deleteBucComment(int idx){
		return session.delete(namespace +".deleteBucComment",idx);
	}
	
	@Override
	public int deleteComment(int idx){
		return session.delete(namespace +".deleteComment", idx);
	}
	
	@Override
	public int updateComment(CommentVO cvo){
		return session.update(namespace +".updateComment", cvo);
	}
	@Override
	public List<BucketListVO> bucketTree_MyBucketList(int user_idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".bucketTree_MyBucketList",user_idx);
	}
	@Override
	public void updateTreeidx(BucketListVO bucketListVO) {
		session.update(namespace + ".updateTreeidx",bucketListVO);
		
	}
	@Override
	public int mylistCount(Pagination pagination, int user_idx) throws Exception {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		
		return session.selectOne(namespace + ".mylistCount", input);
	}
	@Override
	public void completeBucket(int idx) {
		session.update(namespace + ".completeBucket",idx);
		
	}

}
