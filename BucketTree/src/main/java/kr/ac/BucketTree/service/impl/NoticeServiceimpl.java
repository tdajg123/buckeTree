package kr.ac.BucketTree.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.NoticeDAO;
import kr.ac.BucketTree.service.NoticeService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.NoticeVO;

@Service
public class NoticeServiceimpl implements NoticeService {

	@Autowired
	NoticeDAO nd;
	
	//공지사항 작성
	@Override
	public void createNotice(NoticeVO notice){
		
		nd.createNotice(notice);
		
	}
	
	@Override
	public void deleteByNoticeIdx(int notice_idx){
		nd.deleteByNoticeIdx(notice_idx);
	}
	
	/*파일 업로드 */
	@Override
	public void updateNoticeImage(NoticeVO vo){
		nd.deleteByNoticeIdx(vo.getIdx());
		System.out.println("중간이미지테이블아이디: "+vo.getIdx());
		String pattern = "bucket/([0-9]+)/image";
		Pattern r= Pattern.compile(pattern);
		Matcher m = r.matcher(vo.getContents());
		while(m.find()){
			int imageId = Integer.parseInt(m.group(1));
			
			nd.insertNoticeImage(vo.getIdx(), imageId);
		}
	}
	
	@Override
	public void insertNoticeImage(int notice_idx,int image_idx){
		nd.insertNoticeImage(notice_idx, image_idx);
	}
	
	@Override
	public List<NoticeVO> noticeSelectAll(Pagination pagination){
		return nd.noticeSelectAll(pagination);
	}
	
	@Override
	public int selectCount(Pagination pagination) {

		return nd.selectCount(pagination);
	}
	
	@Override
	public NoticeVO selectByIdx(int idx){
		return nd.selectByIdx(idx);
	}
	
	@Override
	public int updateNotice(NoticeVO notice){
		return nd.updateNotice(notice);
	}
	
	@Override
	public void deleteNotice(int idx){
		nd.deleteNotice(idx);
	}
	
	@Override
	public void deleteNoticeImage(int Notice_idx){
		nd.deleteNoticeImage(Notice_idx);
	}
	
	@Override
	public int selectByImageIdx(int idx){
		return nd.selectByImageIdx(idx);
	}
	
	@Override
	public NoticeVO selectTop(){
		return nd.selectTop();
	}
}
