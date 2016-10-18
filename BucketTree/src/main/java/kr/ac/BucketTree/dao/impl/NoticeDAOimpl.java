package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.ac.BucketTree.dao.NoticeDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.NoticeVO;

@Repository
public class NoticeDAOimpl implements NoticeDAO {
	
	@Autowired
	private SqlSession session;
	
	private static final String namespace = "kr.ac.BucketTree.NoticeMapper";
	
	@Override
	public void createNotice(NoticeVO notice){
		
		session.insert(namespace+".createNotice",notice);
	}
	
	@Override
	public void deleteByNoticeIdx(int notice_idx){
		session.delete(namespace+".deleteByNoticeIdx",notice_idx);
	}
  
	@Override
	public void insertNoticeImage(int notice_idx,int image_idx){
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("notice_idx", notice_idx);
		input.put("image_idx", image_idx);
		session.insert(namespace+".insertNoticeImage", input);
	}
	
	@Override
	public List<NoticeVO> noticeSelectAll(Pagination pagination){
		return session.selectList(namespace+".noticeSelectAll",pagination);
	}
	
	@Override
	public int selectCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectCount", pagination);
	}
	
	@Override
	public NoticeVO selectByIdx(int idx){
		return session.selectOne(namespace+".selectByIdx", idx);
	}
	
	@Override
	public int updateNotice(NoticeVO notice){
		return session.update(namespace+".updateNotice", notice);
	}
	
	@Override
	public void deleteNotice(int idx){
		session.delete(namespace+".deleteNotice", idx);
	}
	
	@Override
	public void deleteNoticeImage(int Notice_idx){
		session.delete(namespace+".deleteNoticeImage",Notice_idx);
	}
	
	/* Notice_idx에 해당하는 Notice_image 테이블의 image_idx 레코드 조회 */
	@Override
	public int selectByImageIdx(int Notice_idx){
		
		if(session.selectOne(namespace +".selectByImageIdx", Notice_idx)==null){
			return 0;
		}else{
		return session.selectOne(namespace +".selectByImageIdx", Notice_idx);
		}
	}
	
	@Override
	public NoticeVO selectTop(){
		return session.selectOne(namespace+".selectTop");
	}
}
