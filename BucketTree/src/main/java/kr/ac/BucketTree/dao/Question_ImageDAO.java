package kr.ac.BucketTree.dao;

public interface Question_ImageDAO {

	public void insert(int question_idx, int image_idx);

	public void deleteByQuestionIdx(int question_idx);
}
