package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.Message_ImageDAO;
import kr.ac.BucketTree.service.Message_ImageService;

@Service
public class Message_ImageServiceImpl implements Message_ImageService{
	
	@Autowired
	Message_ImageDAO dao;
	@Override
	public void insert(int message_idx, int image_idx) {
		// TODO Auto-generated method stub
		dao.insert(message_idx, image_idx);
	}

	@Override
	public void deleteByMessageIdx(int message_idx) {
		// TODO Auto-generated method stub
		dao.deleteByMessageIdx(message_idx);
	}

}
