package kr.ac.BucketTree.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Repository
public class BucketListDAOimpl implements BucketListDAO {

	@Autowired
	private SqlSession session;

	// BucketListMapper namespace
	private static final String namespace = "kr.ac.BucketTree.BucketListMapper";

	/*전체 버킷리스트 목록 & 정렬-최신순*/
	@Override
	public List<BucketListVO> list() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list");
	}

	/*전체 : 정렬-인기순*/
	@Override
	public List<BucketListVO> popular_list() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".popular_list");
	}

	/*전체 : 담기_카운트 업*/
	@Override
	public void countUp(BucketListVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".countUp", vo);
	}

	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".mylist");
	}

	/*마이 : 친구 추천 목록*/
	@Override
	public List<RecommendVO> recommendList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".recommendList");
	}

	/*마이 : 관리자 추천 목록*/
	@Override
	public List<BucketListVO> adminRecommendList() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".adminRecommendList");
	}

}
