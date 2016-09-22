package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.FileMessengerDAO;
import kr.ac.BucketTree.service.FileMessengerService;
import kr.ac.BucketTree.vo.FileMessengerVO;
@Service
public class FileMessengerServiceimpl implements FileMessengerService{
	@Autowired 
	FileMessengerDAO dao ;
	
	@Override
	public void insert(FileMessengerVO fileMessger) {
		dao.insert(fileMessger);
	}

	@Override
	public FileMessengerVO selectByMessenger(int messengerIdx) {
		// TODO Auto-generated method stub
		return dao.selectByMessenger(messengerIdx);
	}

}
