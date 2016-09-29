package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.FriendDAO;
import kr.ac.BucketTree.service.FriendService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.UserVO;

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
	
	//친구 검색 목록
		@Override
		public List<FriendVO> FriendSearch(Pagination page,int idx){
			
			return dao.FriendSearch(page,idx);
		}
		//ajax 를 활용한 친구 검색 목록
		@Override
		public List<FriendVO> FriendAjaxSearch(Pagination page,int idx){
			return dao.FriendAjaxSearch(page,idx);
		}
		//ajax를 활용한 전송한 친구 찾기 내 검색 목록 추가 요청
		@Override
		public List<FriendVO> FriendSendAjaxList(Pagination page,int idx){
			return dao.FriendSendAjaxList(page,idx);
		}
		//ajax를 활용한 친구 목록 내 검색
		@Override
		public List<FriendVO> SearchFriendList(Pagination page,int idx){
			return dao.SearchFriendList(page, idx);
		}
		//친구 요청 from  > to
		@Override
		public int InsertFriendFromRequest(FriendVO friend){
			return dao.InsertFriendFromRequest(friend);
		}
		//친구 요청 to > from
		@Override
		public int insertFriendToRequest(FriendVO friend){
			return dao.insertFriendToRequest(friend);
		}
		//친구 삭제 from > to
		@Override
		public int deleteFromFriend(FriendVO friend){
			return dao.deleteFromFriend(friend);
		}
		//친구 삭제 to > from
		@Override
		public int deleteToFriend(FriendVO friend){
			return dao.deleteToFriend(friend);
		}
		//친구 목록
		@Override
		public List<FriendVO> FriendList(Pagination page,int idx){
			return dao.FriendList(page,idx);
		}
		//친구 목록 추가 조회 , ajax 활용
		@Override
		public List<FriendVO> FriendListAjax(Pagination page,int idx){
			return dao.FriendListAjax(page, idx);
		}
		//받은 친구 요청
		@Override
		public List<FriendVO> FriendRequestList(Pagination page,int idx){
			return dao.FriendRequestList(page,idx);
		}
		//보낸 친구 요청
		@Override
		public List<FriendVO> FriendSendList(Pagination page,int idx){
			return dao.FriendSendList(page,idx);
		}
		//친구 수락 from > to
		@Override
		public int FriendRequestFromUpdate(FriendVO friend){
			return dao.FriendRequestFromUpdate(friend);
		}
		//친구 수락 to > from
		@Override
		public int FriendRequestToUpdate(FriendVO friend){
			return dao.FriendRequestToUpdate(friend);
		}
		//친구 거절 from > to
		@Override
		public int FriendRequestFromDelete(FriendVO friend){
			return dao.FriendRequestFromDelete(friend);
		}
		//친구 거절 to > from
		@Override
		public int FriendRequestToDelete(FriendVO friend){
			return dao.FriendRequestToDelete(friend);
		}
		//idx로 친구 조회
		@Override
		public FriendVO selectByIdFriend(int idx){
			return dao.selectByIdFriend(idx);
		}
		
		//친구가 아닌 유저 조회
		@Override
		public List<FriendVO> UserSearch(Pagination page,int idx){
			return dao.UserSearch(page, idx);
		}
		//친구가 아닌 유저 조회 Ajax
		@Override
		public List<UserVO> UserSearchAjax(Pagination page ,int idx){
			return dao.UserSearchAjax(page, idx);
		}
}
