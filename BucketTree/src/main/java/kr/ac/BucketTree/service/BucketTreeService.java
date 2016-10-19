package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.Tree_ImageVO;


public interface BucketTreeService {

	public List<BucketTreeVO> selectPage(Pagination pagination,int user_idx);
	public int selectCount(Pagination pagination);
	public List<BucketTreeVO> selectMyPage(Pagination pagination,int user_idx);
	public int selectMyCount(Pagination pagination,int user_idx);
	public List<BucketTreeVO> applyBucketTree(int user_idx);
	public List<BucketTreeVO> adminByReommend(int user_idx);
	public void insert(BucketTreeVO bucketTreeVO);
	public BucketTreeVO selectByBucketTree(int idx);
	
	/*스마트에디터 사용 - 이미지 업로드*/
	public void updateTreeImage(BucketTreeVO vo);
	public void insertTree_Image(Tree_ImageVO tivo);
	public void deleteByTree_idx(int tree_idx);
}
