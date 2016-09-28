package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.CategoryDAO;
import kr.ac.BucketTree.service.CategoryService;
import kr.ac.BucketTree.vo.CategoryVO;

@Service
public class CategoryServiceimpl implements CategoryService{

	@Autowired
	CategoryDAO dao;


	@Override
	public List<CategoryVO> whenList() {
		// TODO Auto-generated method stub
		return dao.whenList();
	}

	@Override
	public List<CategoryVO> whatList() {
		// TODO Auto-generated method stub
		return dao.whatList();
	}

	@Override
	public List<CategoryVO> whoList() {
		// TODO Auto-generated method stub
		return dao.whoList();
	}
	
	@Override
	public CategoryVO whoName(int idx){
		return dao.whoName(idx);
	}
	@Override
	public CategoryVO whenName(int idx){
		return dao.whenName(idx);
	}
	@Override
	public CategoryVO whatName(int idx){
		return dao.whatName(idx);
	}
}
