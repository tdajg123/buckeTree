package kr.ac.BucketTree.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.PageVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Service
public class BucketListServiceimpl implements BucketListService{

	@Autowired
	BucketListDAO dao;

	/*전체 버킷리스트 목록 & 정렬-최신순*/
	@Override
	public List<BucketListVO> list(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(page);
	}


	/*전체 : 정렬-인기순*/
	@Override
	public List<BucketListVO> popular_list(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return dao.popular_list(page);
	}
	

	/*전체 : 담기-카운트 업*/
	@Override
	public void countUp(int idx) throws Exception {
		// TODO Auto-generated method stub
		dao.countUp(idx);
	}
	
	
	/*전체 : 버킷 버튼 클릭 시 마이 버킷리스트에 타이틀 추가*/
	@Override
	public void addBucket(HashMap<String, Object> addBucket) throws Exception {
		// TODO Auto-generated method stub
		dao.addBucket(addBucket);
	}

	
	//검색
	@Override
	public List<BucketListVO> SearchList(HashMap<String, Object> category, PageVO page) {
		// TODO Auto-generated method stub
		return dao.SearchList(category, page);
	}


	//중복 검사
	@Override
	public boolean titleCheck(String mtitle, int userIdx) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.titleCheck(mtitle, userIdx);
	}


	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return dao.mylist(page);
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
