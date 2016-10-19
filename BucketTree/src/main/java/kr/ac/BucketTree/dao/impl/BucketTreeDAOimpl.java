package kr.ac.BucketTree.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.BucketTreeDAO;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.Tree_ImageVO;

@Repository
public class BucketTreeDAOimpl implements BucketTreeDAO {
	@Autowired
	private SqlSession session;
	private static final String namespace = "kr.ac.BucketTree.BucketTreeMapper";
	
	
	@Override
	public List<BucketTreeVO> selectPage(Pagination pagination,int user_idx) {
		// TODO Auto-generated method stub
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectList(namespace+".selectPage", input);
	}

	@Override
	public int selectCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectCount", pagination);
	}

	@Override
	public List<BucketTreeVO> selectMyPage(Pagination pagination, int user_idx) {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectList(namespace+".selectMyPage", input);
	}

	@Override
	public int selectMyCount(Pagination pagination, int user_idx) {
		HashMap<String,Object> input = new HashMap<String, Object>();
		input.put("pagination", pagination);
		input.put("user_idx", user_idx);
		return session.selectOne(namespace+".selectMyCount", input);
	}

	@Override
	public List<BucketTreeVO> applyBucketTree(int user_idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".applyBucketTree", user_idx);
	}

	@Override
	public List<BucketTreeVO> adminByReommend(int user_idx) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".adminByReommend", user_idx);
	}

	@Override
	public void insert(BucketTreeVO bucketTreeVO) {
		session.insert(namespace+".insert",bucketTreeVO);
		
	}

	@Override
	public BucketTreeVO selectByBucketTree(int idx) {
		
		return session.selectOne(namespace+".selectByBucketTree", idx );
	}

	@Override
	public void insertTree_Image(Tree_ImageVO tivo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insertTree_Image", tivo);
	}

	@Override
	public void deleteByTree_idx(int tree_idx) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".deleteByTree_Idx", tree_idx);
	}
}
