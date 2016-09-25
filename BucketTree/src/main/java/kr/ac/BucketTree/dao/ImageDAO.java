package kr.ac.BucketTree.dao;


import kr.ac.BucketTree.vo.ImageVO;

public interface ImageDAO {

	public ImageVO selectByIdx(int idx);

	public void insertImage(ImageVO iv);

	public void deleteOrphan();
 
	public void deleteOrphan_Question();
}
