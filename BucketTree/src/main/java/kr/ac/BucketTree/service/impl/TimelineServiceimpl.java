package kr.ac.BucketTree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.BucketTree.dao.TimelineDAO;
import kr.ac.BucketTree.dao.UserDAO;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.vo.TimelineVO;

public class TimelineServiceimpl implements TimelineService {
	

	@Autowired
	TimelineDAO dao;

	@Override
	public TimelineVO selectByIdx(int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(user_idx);
	}

}
