package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.NoticeVO;


public interface NoticeDAO {
	
	//공지사항 작성
	public void createNotice(NoticeVO notice); 
	
	//notice_idx가 매개변수인 Notice_image 테이블 레코드 삭제
	public void deleteByNoticeIdx(int notice_idx);
	
	public void insertNoticeImage(int notice_idx,int image_idx);
	
	public List<NoticeVO> noticeSelectAll(Pagination pagination);
		
	public int selectCount(Pagination pagination);
	
	public NoticeVO selectByIdx(int idx);
	
	public int updateNotice(NoticeVO notice);
	
	public void deleteNotice(int idx);
	
	public void deleteNoticeImage(int Notice_idx);
	// Notice_image 테이블 Notice_idx로 Image_idx 조회
	public int selectByImageIdx(int Notice_idx);
	
	public NoticeVO selectTop();
}
