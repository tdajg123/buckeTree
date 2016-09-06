package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.MessengerVO;

public interface MessengerService {
	public void insertMessenger(MessengerVO m);
	public List<MessengerVO> selectByMesseneger(int me, int you);
	public void readMessenger(int me, int you);
	public void changeReadMessenger(MessengerVO m);
	public void deleteByMyMesseneger(int idx);
}
