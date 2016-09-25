package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.Question_ImageDAO;
import kr.ac.BucketTree.service.Question_ImageService;

@Service
public class Question_ImageServiceimpl implements Question_ImageService {
	
	@Autowired
	Question_ImageDAO dao;
	@Override
	public void insert(int question_idx, int image_idx) {
		dao.insert(question_idx, image_idx);
		
	}

	@Override
	public void deleteByQuestionIdx(int question_idx) {
		dao.deleteByQuestionIdx(question_idx);
		
	}
	

}
