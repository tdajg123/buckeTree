package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.Journal_ImageDAO;
import kr.ac.BucketTree.service.Journal_ImageService;
import kr.ac.BucketTree.vo.Journal_ImageVO;

@Service
public class Journal_ImageServiceimpl implements Journal_ImageService {

	@Autowired
	Journal_ImageDAO dao;

	@Override
	public void insertJournal_Image(Journal_ImageVO jivo) {
		// TODO Auto-generated method stub
		dao.insertJournal_Image(jivo);
	}

	@Override
	public void deleteByJournal_idx(int journal_idx) {
		// TODO Auto-generated method stub
		dao.deleteByJournal_idx(journal_idx);
	}

}
