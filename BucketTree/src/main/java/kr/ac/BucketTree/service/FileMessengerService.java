package kr.ac.BucketTree.service;

import kr.ac.BucketTree.vo.FileMessengerVO;

public interface FileMessengerService {
	public void insert(FileMessengerVO fileMessger);
	public FileMessengerVO selectByMessenger(int messengerIdx);
}
