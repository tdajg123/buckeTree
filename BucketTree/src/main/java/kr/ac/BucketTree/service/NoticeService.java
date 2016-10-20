package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.NoticeVO;

public interface NoticeService {
	//공지사항 작성
	public void createNotice(NoticeVO notice);
	//파일 업로드
	public void updateNoticeImage(NoticeVO vo);
	public void deleteByNoticeIdx(int notice_idx);
	public void insertNoticeImage(int notice_idx,int image_idx);
	public List<NoticeVO> noticeSelectAll(Pagination pagination);
	int selectCount(Pagination pagination);
	public NoticeVO selectByIdx(int idx);
	public int updateNotice(NoticeVO notice);
	public void deleteNotice(int idx);
	public void deleteNoticeImage(int Notice_idx);
	/* Notice_idx에 해당하는 Notice_image 테이블의 image_idx 레코드 조회 */
	public int selectByImageIdx(int Notice_idx);
	public NoticeVO selectTop();
}
