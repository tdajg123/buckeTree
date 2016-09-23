package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketShareDAO;
import kr.ac.BucketTree.service.BucketShareService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;

@Service
public class BucketShareServiceimpl implements BucketShareService {
	@Autowired
	BucketShareDAO dao;
	
	@Override
	public List<BucketShareVO> selectPage(Pagination pagination) {

		return dao.selectPage(pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {

		return dao.selectCount(pagination);
	}

	@Override
	public List<BucketShareVO> myselectPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myselectPage(pagination, user_idx);
	}

	@Override
	public int myselectCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myselectCount(pagination, user_idx);
	}

	@Override
	public List<BucketShareVO> myAnswerList(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myAnswerList(pagination, user_idx);
	}

	@Override
	public int myAnswerListCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myAnswerListCount(pagination, user_idx);
	}

}
