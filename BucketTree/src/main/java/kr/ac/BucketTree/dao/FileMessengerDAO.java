package kr.ac.BucketTree.dao;

import kr.ac.BucketTree.vo.FileMessengerVO;

public interface FileMessengerDAO {
	void insert(FileMessengerVO fileMessger);
	public FileMessengerVO selectByMessenger(int messengerIdx);
}
