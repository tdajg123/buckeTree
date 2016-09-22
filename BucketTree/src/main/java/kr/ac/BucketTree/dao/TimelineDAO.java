package kr.ac.BucketTree.dao;

import kr.ac.BucketTree.vo.TimelineVO;

public interface TimelineDAO {

	//user_idx로 타임라인 조회
	public TimelineVO selectByIdx(int user_idx);

}
