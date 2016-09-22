package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.FriendDAO;
import kr.ac.BucketTree.service.FriendService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.PageVO;

@Service
public class FriendServiceimpl implements FriendService{
	@Autowired
	FriendDAO dao;
	//메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외) 
	public List<FriendVO> FriendByMessagener(int idx,Pagination p)
	{
		return dao.FriendByMessagener(idx, p);
	}
	//<!--메세지=>새로운 메세지를 보낸 친구목록 -->
	@Override
	public List<FriendVO> FriendByNewMessagener(int idx) {
		
		return dao.FriendByNewMessagener(idx);
	}
	
	@Override
	public List<FriendVO> FriendSearch(PageVO page){
		
		return dao.FriendSearch(page);
	}
	@Override
	public List<FriendVO> FriendAjaxSearch(Integer startRow){
		return dao.FriendAjaxSearch(startRow);
	}

}
