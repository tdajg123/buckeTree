package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.BucketTree_Message;

public interface BucketJournalService {

	// bucket_idx로 일지 리스트 조회
	public List<BucketJournalVO> bucketJournalList(int bucket_idx);

	// 일지 select
	public BucketJournalVO selectByIdx(int idx);

	// 일지 insert
	public void insertJournal(BucketJournalVO bj);

	// 일지 update
	public void updateJournal(BucketJournalVO bj);

	// 일지 delete
	public void deleteJournal(int idx);

	public void updateJournalImage(BucketJournalVO bj);

	public BucketJournalVO createJournal(BucketTree_Message bm,int idx);

}