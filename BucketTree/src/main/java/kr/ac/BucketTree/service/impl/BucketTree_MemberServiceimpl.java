package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketTree_MemberDAO;
import kr.ac.BucketTree.service.BucketTree_MemberService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTree_MemberVO;
import kr.ac.BucketTree.vo.UserVO;

@Service
public class BucketTree_MemberServiceimpl implements BucketTree_MemberService{
	@Autowired 
	 BucketTree_MemberDAO dao;
	@Override
	public void apply(int bucketTree_idx, int user_idx, int state) {
		dao.apply(bucketTree_idx, user_idx, state);
		
	}

	@Override
	public void cancel(int bucketTree_idx, int user_idx) {
		dao.cancel(bucketTree_idx, user_idx);
		
	}

	/*트리 회원관리 - 가입한 전체 회원 목록*/
	@Override
	public List<UserVO> MemberList(Pagination page, int idx) {
		// TODO Auto-generated method stub
		return dao.MemberList(page, idx);
	}

	/*트리 회원관리 - 가입 요청한 회원 목록*/
	@Override
	public List<UserVO> applyList(Pagination page, int idx) {
		// TODO Auto-generated method stub
		return dao.applyList(page, idx);
	}

	/*트리 회원관리 - 가입 요청 수락*/
	@Override
	public int addMember(BucketTree_MemberVO member) {
		// TODO Auto-generated method stub
		return dao.addMember(member);
	}

	/*트리 회원관리 - 가입 요청 거절*/
	@Override
	public int denyJoin(BucketTree_MemberVO deny) {
		// TODO Auto-generated method stub
		return dao.denyJoin(deny);
	}

	/*트리 회원관리 - 트리장 위임*/
	@Override
	public int mandate(BucketTree_MemberVO mandate) {
		// TODO Auto-generated method stub
		return dao.mandate(mandate);
	}

	/*트리 회원관리 - 트리장인지 확인*/
	@Override
	public int checkAdmin(BucketTree_MemberVO check) {
		// TODO Auto-generated method stub
		return dao.checkAdmin(check);
	}
	
}
