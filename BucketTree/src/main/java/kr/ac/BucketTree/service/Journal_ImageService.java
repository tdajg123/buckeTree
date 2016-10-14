package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.Journal_ImageVO;

public interface Journal_ImageService {

	public void insertJournal_Image(Journal_ImageVO jivo);

	public void deleteByJournal_idx(int journal_idx);

	public List<Journal_ImageVO> selectByBucket_idx(int bucket_idx);
}
