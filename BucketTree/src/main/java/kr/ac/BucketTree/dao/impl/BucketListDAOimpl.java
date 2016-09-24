package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketListDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.RecommendVO;

@Repository
public class BucketListDAOimpl implements BucketListDAO {

	@Autowired
	private SqlSession session;

	// BucketListMapper namespace
	private static final String namespace = "kr.ac.BucketTree.BucketListMapper";

	/*전체 버킷리스트 목록*/
	@Override
	public List<BucketListVO> list(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".list", pagination);
	}
	/*버킷리스트 페이지 카운트*/
	@Override
	public int listCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".listCount", pagination);
	}

	/*버킷리스트-무한스크롤*/
	@Override
	public List<BucketListVO> listAjax(Pagination p) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("dao 무한스크롤 : "+p);
		return session.selectList(namespace+".listAjax", p);
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
	public List<BucketListVO> mylist(Pagination pagination) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".mylist", pagination);
	}
	
	/*마이리스트 무한스크롤*/
	@Override
	public List<BucketListVO> mylistAjax(Pagination p) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("dao 임플 : " + p);
		return session.selectOne(namespace+".mylistAjax", p);
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
