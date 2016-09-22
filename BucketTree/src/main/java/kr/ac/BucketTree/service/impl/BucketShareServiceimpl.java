package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketShareDAO;
import kr.ac.BucketTree.service.BucketShareService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;

@Service
public class BucketShareServiceimpl implements BucketShareService {
	@Autowired
	BucketShareDAO dao;
	
	@Override
	public List<BucketShareVO> selectPage(Pagination pagination) {

		return dao.selectPage(pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {

		return dao.selectCount(pagination);
	}

}
