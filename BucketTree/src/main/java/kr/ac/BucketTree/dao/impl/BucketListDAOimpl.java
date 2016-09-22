package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.PageVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Repository
public class BucketListDAOimpl implements BucketListDAO {

	@Autowired
	private SqlSession session;

	// BucketListMapper namespace
	private static final String namespace = "kr.ac.BucketTree.BucketListMapper";

	/*전체 버킷리스트 목록 & 정렬-최신순*/
	@Override
	public List<BucketListVO> list(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list", page);
	}

	/*전체 : 정렬-인기순*/
	@Override
	public List<BucketListVO> popular_list(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".popular_list", page);
	}

	/*전체 : 담기_카운트 업*/
	@Override
	public void countUp(int idx) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".countUp", idx);
	}

	/*전체 : 버킷 버튼 클릭 시 마이 버킷에 추가*/
	@Override
	public void addBucket(HashMap<String, Object> addBucket) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".addBucket", addBucket);
	}
	
	
	//검색
	@Override
	public List<BucketListVO> SearchList(HashMap<String, Object> category, PageVO page) {
		// TODO Auto-generated method stub
		
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("category", category);
		input.put("p", page);
		
		return session.selectList(namespace+".searchList", input);
	}

	/*중복 타이틀 검사*/
	@Override
	public boolean titleCheck(String mtitle, int userIdx) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> check = new HashMap<String, Object>();
		
		check.put("title", mtitle);
		check.put("userIdx", userIdx);
		
		int count = session.selectOne(namespace+".titleCheck", check);
		System.out.println("count : " + count);
		
		return count > 0;
	}

	/*마이 버킷리스트 목록*/
	@Override
	public List<BucketListVO> mylist(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".mylist", page);
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
