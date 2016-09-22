package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.vo.MessengerVO;

public interface MessengerDAO {
	public void insertMessenger(MessengerVO m);
	
	public List<MessengerVO> selectByMesseneger(int me,int you);
	
	public void readMessenger(int me,int you);
	
	public void changeReadMessenger(MessengerVO m);
	
	public void deleteByMyMesseneger(int idx);
}
