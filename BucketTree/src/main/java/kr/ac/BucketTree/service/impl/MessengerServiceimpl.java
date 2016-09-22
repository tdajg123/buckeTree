package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.MessengerDAO;
import kr.ac.BucketTree.service.MessengerService;
import kr.ac.BucketTree.vo.MessengerVO;

@Service
public class MessengerServiceimpl implements MessengerService {
	
	@Autowired
	MessengerDAO dao;
	@Override
	public void insertMessenger(MessengerVO m) {
		dao.insertMessenger(m);
	}
	@Override
	public List<MessengerVO> selectByMesseneger(int me, int you) {
		// TODO Auto-generated method stub
		return dao.selectByMesseneger(me, you);
	}
	@Override
	public void readMessenger(int me, int you) {
		dao.readMessenger(me, you);
		
	}
	@Override
	public void changeReadMessenger(MessengerVO m) {
		dao.changeReadMessenger(m);
		
	}
	@Override
	public void deleteByMyMesseneger(int idx) {
		dao.deleteByMyMesseneger(idx);
	}

}
