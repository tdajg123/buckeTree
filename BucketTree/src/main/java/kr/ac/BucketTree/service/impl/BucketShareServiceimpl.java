package kr.ac.BucketTree.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketShareDAO;
import kr.ac.BucketTree.service.BucketShareService;
import kr.ac.BucketTree.service.Question_ImageService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BucketShareServiceimpl implements BucketShareService {
	@Autowired
	BucketShareDAO dao;
	@Autowired
	Question_ImageService image;

	@Override
	public List<BucketShareVO> selectPage(Pagination pagination) {

		return dao.selectPage(pagination);
	}

	@Override
	public int selectCount(Pagination pagination) {

		return dao.selectCount(pagination);
	}

	@Override
	public List<BucketShareVO> myselectPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myselectPage(pagination, user_idx);
	}

	@Override
	public int myselectCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myselectCount(pagination, user_idx);
	}

	@Override
	public List<BucketShareVO> myAnswerList(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myAnswerList(pagination, user_idx);
	}

	@Override
	public int myAnswerListCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.myAnswerListCount(pagination, user_idx);
	}

	@Override
	public BucketShareVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(idx);
	}

	@Override
	public void adoptQuestion(BucketShareVO bucketShareVO) {
		dao.adoptQuestion(bucketShareVO);

	}

	@Override
	public void insert(BucketShareVO bucketShareVO) {
		// TODO Auto-generated method stub
		dao.insert(bucketShareVO);
	}

	@Override
	public void update(BucketShareVO bucketShareVO) {
		// TODO Auto-generated method stub
		dao.update(bucketShareVO);
	}

	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		dao.delete(idx);
	}

	@Override
	public void updateBucketShareImage(BucketShareVO bucketShareVO) {
		image.deleteByQuestionIdx(bucketShareVO.getIdx());

		String pattern = "bucket/([0-9]+)/image";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(bucketShareVO.getContents());
		while (m.find()) {
			int imageId = Integer.parseInt(m.group(1));
			image.insert(bucketShareVO.getIdx(), imageId);
		}

	}

}
