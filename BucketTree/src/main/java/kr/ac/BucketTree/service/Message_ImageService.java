package kr.ac.BucketTree.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface Message_ImageService {

	public void insert(int message_idx, int image_idx);


	public void deleteByMessageIdx(int message_idx);
}
