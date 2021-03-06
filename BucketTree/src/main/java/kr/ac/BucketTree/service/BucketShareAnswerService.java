package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.BucketShareAnswerVO;

public interface BucketShareAnswerService {
	public List<BucketShareAnswerVO> selectByQuestion(int idx);
	public void insert(BucketShareAnswerVO bucketShareAnswerVO);
	public void update(BucketShareAnswerVO bucketShareAnswerVO);
	public void delete(int idx);
	public void adopt(BucketShareAnswerVO bucketShareAnswerVO);
	public BucketShareAnswerVO selectByIdx(int idx);
	public void deleteByQuestionIdx(int idx);
}
