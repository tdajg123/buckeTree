package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.ImageDAO;
import kr.ac.BucketTree.service.ImageService;
import kr.ac.BucketTree.vo.ImageVO;

@Service
public class ImageServiceimpl implements ImageService {

	@Autowired
	ImageDAO dao;

	@Override
	public ImageVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(idx);
	}

	@Override
	public void insertImage(ImageVO iv) {
		// TODO Auto-generated method stub
		dao.insertImage(iv);
	}

	@Override
	public void deleteOrphan() {
		// TODO Auto-generated method stub
		dao.deleteOrphan();
	}

	

}
