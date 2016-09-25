package kr.ac.BucketTree.service;

public interface Question_ImageService {
	public void insert(int question_idx, int image_idx);

	public void deleteByQuestionIdx(int question_idx);
}
