package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.CategoryVO;

public interface CategoryService {
	public List<CategoryVO> whoList();
	public List<CategoryVO> whenList();
	public List<CategoryVO> whatList();

}
