package kr.ac.BucketTree.service;

import kr.ac.BucketTree.vo.TimelineVO;

public interface TimelineService {

	//user_idx로 타임라인 조회
	public TimelineVO selectByIdx(int user_idx);

}
