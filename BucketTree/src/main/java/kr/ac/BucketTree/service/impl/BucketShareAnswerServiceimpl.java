package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketShareAnswerDAO;

import kr.ac.BucketTree.service.BucketShareAnswerService;
import kr.ac.BucketTree.vo.BucketShareAnswerVO;

@Service
public class BucketShareAnswerServiceimpl implements BucketShareAnswerService {

	@Autowired
	BucketShareAnswerDAO dao;

	@Override
	public List<BucketShareAnswerVO> selectByQuestion(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByQuestion(idx);
	}

	@Override
	public void insert(BucketShareAnswerVO bucketShareAnswerVO) {
		dao.insert(bucketShareAnswerVO);

	}

	@Override
	public void update(BucketShareAnswerVO bucketShareAnswerVO) {
		dao.update(bucketShareAnswerVO);

	}

	@Override
	public void delete(int idx) {
		dao.delete(idx);

	}

	@Override
	public void adopt(BucketShareAnswerVO bucketShareAnswerVO) {
		dao.adopt( bucketShareAnswerVO);

	}

	@Override
	public BucketShareAnswerVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(idx);
	}


}
