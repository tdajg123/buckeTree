package kr.ac.BucketTree.dao;
import java.util.List;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.PageVO;

public interface FriendDAO {
	//메신저에서 쓸 친구 목록(새로운메세지 보낸 친구 제외) 
	public List<FriendVO> FriendByMessagener(int idx,Pagination p);
	//<!--메세지=>새로운 메세지를 보낸 친구목록 -->
	public List<FriendVO> FriendByNewMessagener(int idx);
	
	public List<FriendVO> FriendSearch(Pagination page,int idx);
	//친구 목록 내 검색
	public List<FriendVO> SearchFriendList(Pagination page,int idx);
	//친구 검색 Ajax 활용(무한 스크롤)
	public List<FriendVO> FriendAjaxSearch(Pagination page,int idx);
	//전송된 친구 요청 Ajax 활용(무한 스크롤)
	public List<FriendVO> FriendSendAjaxList(Pagination page,int idx);	
	//친구 요청 from > to 
	public int InsertFriendFromRequest(FriendVO friend);
	//친구 요청 to > from
	public int insertFriendToRequest(FriendVO friend);
	//친구 삭제 from > to
	public int deleteFromFriend(FriendVO friend);
	//친구 삭제 to > from
	public int deleteToFriend(FriendVO friend);
	//친구 목록
	public List<FriendVO> FriendList(Pagination page,int idx);
	//친구 목록 추가 조회 Ajax 활용(무한스크롤)
	public List<FriendVO> FriendListAjax(Pagination page,int idx);
	//받은 친구 요청 목록
	public List<FriendVO> FriendRequestList(Pagination page,int idx);
	//보낸 친구 요청 목록
	public List<FriendVO> FriendSendList(Pagination page,int idx);
	//친구 수락 from > to
	public int FriendRequestFromUpdate(FriendVO friend);
	//친구 수락 to > from
	public int FriendRequestToUpdate(FriendVO friend);
	//친구 거절 from > to
	public int FriendRequestFromDelete(FriendVO friend);
	//친구 거절 to > from
	public int FriendRequestToDelete(FriendVO friend);
}
