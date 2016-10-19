package kr.ac.BucketTree.dao;

import java.util.List;

import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketTreeVO;
import kr.ac.BucketTree.vo.Tree_ImageVO;

public interface BucketTreeDAO {
	
	public List<BucketTreeVO> selectPage(Pagination pagination,int user_idx);
	public int selectCount(Pagination pagination);
	public List<BucketTreeVO> selectMyPage(Pagination pagination,int user_idx);
	public int selectMyCount(Pagination pagination,int user_idx);
	public List<BucketTreeVO> applyBucketTree(int user_idx);
	public List<BucketTreeVO> adminByReommend(int user_idx);
	public void insert(BucketTreeVO bucketTreeVO);
	public BucketTreeVO selectByBucketTree(int idx);

	/*스마트 에디터 사용 - 트리 생성 및 이미지 업로드*/
	public void insertTree_Image(Tree_ImageVO tivo);
	public void deleteByTree_idx(int tree_idx);
}
