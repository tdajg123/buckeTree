package kr.ac.BucketTree.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.service.BucketListService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Service
public class BucketListServiceimpl implements BucketListService{

	@Autowired
	BucketListDAO dao;

	/*전체 버킷리스트 목록&정렬&검색*/
	@Override
	public List<BucketListVO> list(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(pagination);
	}

	/*버킷리스트 페이지 카운트*/
	@Override
	public int listCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return dao.listCount(pagination);
	}

	/*버킷리스트-무한스크롤*/
	@Override
	public List<BucketListVO> listAjax(Pagination p) throws Exception {
		// TODO Auto-generated method stub
		return dao.listAjax(p);
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


	//중복 검사
	@Override
	public boolean titleCheck(String mtitle, int userIdx) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.titleCheck(mtitle, userIdx);
	}


	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return dao.mylist(pagination);
	}
	
	/*마이리스트-무한스크롤*/
	@Override
	public List<BucketListVO> mylistAjax(Pagination p) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("서비스임플 : " + p);
		return dao.mylistAjax(p);
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
