package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.vo.CategoryVO;

public interface CategoryDAO {
	
	public List<CategoryVO> whoList();
	public List<CategoryVO> whenList();
	public List<CategoryVO> whatList();
	public CategoryVO whoName(int idx);
	public CategoryVO whenName(int idx);
	public CategoryVO whatName(int idx);
}
