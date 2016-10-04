package kr.ac.BucketTree.dao;

public interface Message_ImageDAO {

	public void  insert(int message_idx,int image_idx);
	public void deleteByMessageIdx(int message_idx);

}
