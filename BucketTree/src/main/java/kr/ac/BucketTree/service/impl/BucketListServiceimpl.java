package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Service
public class BucketListServiceimpl implements BucketListService{

	@Autowired
	BucketListDAO dao;

	/*전체 버킷리스트 목록 & 정렬-최신순*/
	@Override
	public List<BucketListVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	/*전체 : 정렬-인기순*/
	@Override
	public List<BucketListVO> popular_list() throws Exception {
		// TODO Auto-generated method stub
		return dao.popular_list();
	}
	

	/*전체 : 담기-카운트 업*/
	@Override
	public void countUp(BucketListVO count) throws Exception {
		// TODO Auto-generated method stub
		dao.countUp(count);
	}

	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist() throws Exception {
		// TODO Auto-generated method stub
		return dao.mylist();
	}

	/*마이 : 친구 추천 목록*/
	@Override
	public List<RecommendVO> recommendList() throws Exception {
		// TODO Auto-generated method stub
		return dao.recommendList();
	}

	/*마이 : 관리자 추천 목록*/
	@Override
	public List<BucketListVO> adminRecommendList() throws Exception {
		// TODO Auto-generated method stub
		return dao.adminRecommendList();
	}

}
