package kr.ac.BucketTree.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.BucketTree.dao.FileMessengerDAO;
import kr.ac.BucketTree.vo.FileMessengerVO;
@Repository
public class FileMessengerDAOimpl implements FileMessengerDAO {

	@Autowired
	private SqlSession session;
	private static final String namespace="kr.ac.BucketTree.FileMessengerMapper";
	@Override
	public void insert(FileMessengerVO fileMessger) {
		session.insert(namespace+".insert",fileMessger);
		System.out.println("dao실행");
		
	}
	@Override
	public FileMessengerVO selectByMessenger(int messengerIdx) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".selectByMessenger", messengerIdx);
	}

}
