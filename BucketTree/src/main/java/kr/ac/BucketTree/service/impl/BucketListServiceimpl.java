package kr.ac.BucketTree.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.CommentVO;
import kr.ac.BucketTree.vo.ImageVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Service
public class BucketListServiceimpl implements BucketListService{

	@Autowired
	BucketListDAO dao;

	/*전체 버킷리스트 목록&정렬&검색*/
	@Override
	public List<BucketListVO> list(Pagination pagination,int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(pagination,user_idx);
	}

	/*버킷리스트 페이지 카운트*/
	@Override
	public int listCount(Pagination pagination,int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(pagination,user_idx);
	}


	/*버킷리스트-첫번째 이미지*/
	@Override
	public int listImage(int bucket_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.listImage(bucket_idx);
	}

	/*전체 : 담기-카운트 업*/
	@Override
	public void countUp(int idx) throws Exception {
		// TODO Auto-generated method stub
		dao.countUp(idx);
	}
	
	
	/*전체 : 버킷 버튼 클릭 시 마이 버킷리스트에 타이틀 추가*/
	@Override
	public void addBucket(HashMap<String, Object> addBucket) throws Exception {
		// TODO Auto-generated method stub
		dao.addBucket(addBucket);
	}


	//중복 검사
	@Override
	public boolean titleCheck(String mtitle, int userIdx) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.titleCheck(mtitle, userIdx);
	}


	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist(Pagination pagination,int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.mylist(pagination,user_idx);
	}
	

	/*마이 : 친구 추천 목록*/
	@Override
	public List<BucketListVO> recommendList(int fromUser) throws Exception {
		// TODO Auto-generated method stub
		return dao.recommendList(fromUser);
	}

	/*마이 : 관리자 추천 목록*/
	@Override
	public List<BucketListVO> adminRecommendList(int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.adminRecommendList(user_idx);
	}

	@Override
	public List<BucketListVO> bucketShare_MyBucketList(int user_idx) {
		// TODO Auto-generated method stub
		return dao.bucketShare_MyBucketList(user_idx);
	}
	
	/*전체, 마이 : 버킷리스트 추가*/
	@Override
	public int insertBucketList(BucketListVO vo) throws Exception{
		return dao.insertBucketList(vo);
	}
	/*아이디로 버킷리스트 조회*/
	@Override
	public BucketListVO bucket(int idx) throws Exception{
		return dao.bucket(idx);
	}
	
	/*파일 업로드 */
	@Override
	public void updateBucketImage(BucketListVO vo){
		dao.deleteByBucketIdx(vo.getIdx());
		String pattern = "bucket/([0-9]+)/image";
		Pattern r= Pattern.compile(pattern);
		Matcher m = r.matcher(vo.getContents());
		while(m.find()){
			int imageId = Integer.parseInt(m.group(1));
			
			dao.insertblImage(vo.getIdx(), imageId);
		}
	}
	
	@Override
	public void insertImage(ImageVO image){
		dao.insertImage(image);
	}
	@Override
	public void insertblImage(int bucket_idx, int image_idx){
		dao.insertblImage(bucket_idx, image_idx);
	}
	
	@Override
	public ImageVO selectById(ImageVO image){
		return dao.selectById(image);
	}
	
	/* 버킷리스트 수정*/
	@Override
	public int editBucket(BucketListVO buck){
		return dao.editBucket(buck);
	}
	@Override
	public int deleteBucket(int idx){
		return dao.deleteBucket(idx);
	}
	@Override
	public int deleteByBucketIdx(int bucket_idx){
		return dao.deleteByBucketIdx(bucket_idx);
	}
	/* 버킷리스트 idx에 해당하는 BucketList_image 테이블의 image_idx 레코드 조회 */
	@Override
	public int selectByImageIdx(int idx){
		return dao.selectByImageIdx(idx);
	}
	/* Image 테이블 idx로 레코드 제거  */
	@Override
	public int deleteImage(int idx){
		return dao.deleteImage(idx);
	}
	
	/* 댓글 전체 조회 */
	@Override
	public List<CommentVO> selectComment(int idx){
		return dao.selectComment(idx);
	}
	
	/* 댓글 삽입 */
	@Override
	public int insertComment(CommentVO cvo){
		return dao.insertComment(cvo);
	}
	
	/* 댓글 idx로 조회 */
	@Override
	public CommentVO selectByIdxComment(int idx){
		return dao.selectByIdxComment(idx);
	}
	
	/* 버킷 삭제 시 댓글 삭제 */
	@Override
	public int deleteBucComment(int idx){
		return dao.deleteBucComment(idx);
	}
	
	/* 댓글 삭제 */
	@Override
	public int deleteComment(int idx){
		return dao.deleteComment(idx);
	}
	
	/*댓글 수정 */
	@Override
	public int updateComment(CommentVO cvo){
		return dao.updateComment(cvo);
	}

	@Override
	public List<BucketListVO> bucketTree_MyBucketList(int user_idx) {
		// TODO Auto-generated method stub
		return dao.bucketTree_MyBucketList(user_idx);
	}

	@Override
	public void updateTreeidx(BucketListVO bucketListVO) {
		dao.updateTreeidx(bucketListVO);
		
	}

	@Override
	public int mylistCount(Pagination pagination, int user_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.mylistCount(pagination, user_idx);
	}

	@Override
	public void completeBucket(int idx) {
		dao.completeBucket(idx);
		
	}

}
