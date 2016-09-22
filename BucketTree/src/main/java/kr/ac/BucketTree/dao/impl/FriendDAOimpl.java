package kr.ac.BucketTree.dao.impl;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.FriendDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.PageVO;

@Repository
public class FriendDAOimpl implements FriendDAO{
	@Autowired
	SqlSession sqlSession;
	private static final String namespace="kr.ac.BucketTree.FriendMapper"; 
	@Override
	public List<FriendVO> FriendByMessagener(int idx, Pagination p) {
		HashMap<String,Object> input=new HashMap<String,Object>();
		input.put("idx", idx);
		input.put("p", p);
		return sqlSession.selectList(namespace+".FriendByMessagener", input) ;
	}
	
	
	//<!--메세지=>새로운 메세지를 보낸 친구목록 -->
	@Override
	public List<FriendVO> FriendByNewMessagener(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".FriendByNewMessagener", idx) ;
	}
	
	@Override
	public List<FriendVO> FriendSearch(PageVO page){
		return sqlSession.selectList(namespace+".FriendSearch",page);
	}
	@Override
	public List<FriendVO> FriendAjaxSearch(Integer startRow){
		return sqlSession.selectList(namespace+".FriendAjaxSearch",startRow);
	}

}

