package kr.ac.BucketTree.dao.impl;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.FriendDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.UserVO;

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
	// 친구 찾기 검색 목록 ,AJAX 활용
		@Override
		public List<UserVO> FriendSearch(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".FriendSearch",input);
		}
		//친구 목록 내 검색 , AJAX 활용
		@Override
		public List<UserVO> SearchFriendList(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".SearchFriendList",input);
		}
		// 친구 찾기 무한스크롤 , AJAX 활용
		@Override
		public List<UserVO> FriendAjaxSearch(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".FriendAjaxSearch",input);
		}
		//친구 요청 삽입 from > to
		@Override
		public int InsertFriendFromRequest(FriendVO friend){
			return sqlSession.insert(namespace+".insertFriendFromRequest",friend);
		}
		//친구 요청 삽입 to > from
		@Override
		public int insertFriendToRequest(FriendVO friend){
			return sqlSession.insert(namespace+".insertFriendToRequest",friend);
		}
		//친구 삭제 from > to
		@Override
		public int deleteFromFriend(FriendVO friend){
			return sqlSession.delete(namespace+".deleteFromFriend",friend);
		}
		//친구 삭제 to > from
		@Override
		public int deleteToFriend(FriendVO friend){
			return sqlSession.delete(namespace+".deleteToFriend",friend);
		}
		//친구 목록
		@Override
		public List<UserVO> FriendList(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".FriendList",input);
		}
		//친구 목록 추가 조회 Ajax 활용 (무한 스크롤)
		public List<UserVO> FriendListAjax(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".FriendListAjax",input);
		}
		//받은 친구 요청 목록
		public List<UserVO> FriendRequestList(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".selectRequestFriend",input);
		}
		//보낸 친구 요청 목록
		public List<UserVO> FriendSendList(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".selectSendFriend", input);
		}
		//보낸 친구 요청 목록 Ajax 활용
		public List<UserVO> FriendSendAjaxList(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".FriendSendAjaxList", input);
		}
		//친구 수락 from > to
		public int FriendRequestFromUpdate(FriendVO friend){
			return sqlSession.update(namespace+".updateRequestFromFriend",friend);
		}
		//친구 수락 to > from
		public int FriendRequestToUpdate(FriendVO friend){
			return sqlSession.update(namespace+".updateRequestToFriend",friend);
		}
		//친구 거절 from > to
		public int FriendRequestFromDelete(FriendVO friend){
			return sqlSession.delete(namespace+".deleteRequestFromFriend", friend);
		}
		//친구 거절 to > from
		public int FriendRequestToDelete(FriendVO friend){
			return sqlSession.delete(namespace+".deleteRequestToFriend", friend);
		}
		//idx로 친구 조회
		public UserVO selectByIdFriend(int idx){
			return sqlSession.selectOne(namespace+".selectByIdFriend", idx);
	    }
		//친구가 아닌 유저 조회
		public List<UserVO> UserSearch(Pagination page,int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".UserSearch", input);
		}
		//친구가 아닌 유저 조회 Ajax
		public List<UserVO> UserSearchAjax(Pagination page, int idx){
			HashMap<String,Object> input=new HashMap<String,Object>();
			input.put("idx", idx);
			input.put("p", page);
			return sqlSession.selectList(namespace+".UserSearchAjax", input);
		}
}

