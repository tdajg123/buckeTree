package kr.ac.BucketTree.dao;

import kr.ac.BucketTree.vo.Journal_ImageVO;

public interface Journal_ImageDAO {

	public void insertJournal_Image(Journal_ImageVO jivo);

	public void deleteByJournal_idx(int journal_idx);

}
