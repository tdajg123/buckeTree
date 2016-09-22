package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.vo.TimelineVO;

public interface TimelineDAO {

	// user_idx로 타임라인 리스트 조회
	public List<TimelineVO> timelineList(int user_idx);

	// 일지 select
	public TimelineVO selectByIdx(int idx);

	// 일지 insert
	public void insertTimeline(TimelineVO tlv);

}
