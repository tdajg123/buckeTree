package kr.ac.BucketTree.service;

import kr.ac.BucketTree.vo.Journal_ImageVO;

public interface Journal_ImageService {

	public void insertJournal_Image(Journal_ImageVO jivo);

	public void deleteByJournal_idx(int journal_idx);

}
