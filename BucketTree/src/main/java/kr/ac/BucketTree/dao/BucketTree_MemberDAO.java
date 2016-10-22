package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTree_MemberVO;
import kr.ac.BucketTree.vo.UserVO;

public interface BucketTree_MemberDAO {
		
	public void apply(int bucketTree_idx,int user_idx,int state);
	public void cancel(int bucketTree_idx,int user_idx);
	
	/*트리 회원관리-가입한 전체 회원 목록*/
	public List<UserVO> MemberList(Pagination page, int idx);
	/*트리 회원관리-가입 요청한 회원 목록*/
	public List<UserVO> applyList(Pagination page, int idx);
	/*트리 회원관리-가입 요청 수락*/
	public int addMember(BucketTree_MemberVO member);
	/*트리 회원관리 - 가입 요청 거절*/
	public int denyJoin(BucketTree_MemberVO deny);
	/*트리 회원관리 - 트리장 위임*/
	public int mandate(BucketTree_MemberVO mandate);
	/*트리 회원관리 - 트리장인지 확인*/
	public int checkAdmin(BucketTree_MemberVO check);
}
