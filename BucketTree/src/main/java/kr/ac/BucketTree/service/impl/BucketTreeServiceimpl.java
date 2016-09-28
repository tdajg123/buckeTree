package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.BucketTree.dao.BucketTreeDAO;
import kr.ac.BucketTree.service.BucketTreeService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
@Service
public class BucketTreeServiceimpl implements BucketTreeService {
	@Autowired
	BucketTreeDAO dao;

	@Override
	public List<BucketTreeVO> selectPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectPage(pagination, user_idx);
	}

	@Override
	public int selectCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return dao.selectCount(pagination);
	}

	@Override
	public List<BucketTreeVO> selectMyPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectMyPage(pagination, user_idx);
	}

	@Override
	public int selectMyCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectMyCount(pagination, user_idx);
	}

	@Override
	public List<BucketTreeVO> applyBucketTree(int user_idx) {
		// TODO Auto-generated method stub
		return dao.applyBucketTree(user_idx);
	}

	@Override
	public List<BucketTreeVO> adminByReommend(int user_idx) {
		// TODO Auto-generated method stub
		return dao.adminByReommend(user_idx);
	}

	@Override
	public void insert(BucketTreeVO bucketTreeVO) {
		dao.insert(bucketTreeVO);
		
	}
	
	
}
