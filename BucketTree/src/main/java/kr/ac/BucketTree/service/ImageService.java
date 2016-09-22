package kr.ac.BucketTree.service;

import kr.ac.BucketTree.vo.ImageVO;

public interface ImageService {

	public ImageVO selectByIdx(int idx);

	public void insertImage(ImageVO iv);

	public void deleteOrphan();

}
