package kr.ac.BucketTree.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketTreeDAO;
import kr.ac.BucketTree.service.BucketTreeService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.Tree_ImageVO;
@Service
public class BucketTreeServiceimpl implements BucketTreeService {
	@Autowired
	BucketTreeDAO dao;

	@Override
	public List<BucketTreeVO> selectPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectPage(pagination, user_idx);
	}

	@Override
	public int selectCount(Pagination pagination) {
		// TODO Auto-generated method stub
		return dao.selectCount(pagination);
	}

	@Override
	public List<BucketTreeVO> selectMyPage(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectMyPage(pagination, user_idx);
	}

	@Override
	public int selectMyCount(Pagination pagination, int user_idx) {
		// TODO Auto-generated method stub
		return dao.selectMyCount(pagination, user_idx);
	}

	@Override
	public List<BucketTreeVO> applyBucketTree(int user_idx) {
		// TODO Auto-generated method stub
		return dao.applyBucketTree(user_idx);
	}

	@Override
	public List<BucketTreeVO> adminByReommend(int user_idx) {
		// TODO Auto-generated method stub
		return dao.adminByReommend(user_idx);
	}

	@Override
	public void insert(BucketTreeVO bucketTreeVO) {
		dao.insert(bucketTreeVO);
		
	}
	
	@Override
	public BucketTreeVO selectByBucketTree(int idx) {
		
		return dao.selectByBucketTree(idx);
	}
	
	/*스마트에디터 사용 - 이미지 업로드*/
	@Override
	public void updateTreeImage(BucketTreeVO vo) {
		// TODO Auto-generated method stub
		
		dao.deleteByTree_idx(vo.getIdx());
		String pattern = "bucket/([0-9]+)/image";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(vo.getContents());
		while (m.find()) {
			int image_idx = Integer.parseInt(m.group(1));
			Tree_ImageVO tivo = new Tree_ImageVO();
			tivo.setTree_idx(vo.getIdx());
			tivo.setImage_idx(image_idx);
			dao.insertTree_Image(tivo);
		
		}
	}

	@Override
	public void insertTree_Image(Tree_ImageVO tivo) {
		// TODO Auto-generated method stub
		dao.insertTree_Image(tivo);
	}

	@Override
	public void deleteByTree_idx(int tree_idx) {
		// TODO Auto-generated method stub
		dao.deleteByTree_idx(tree_idx);
	}
	
	
}
