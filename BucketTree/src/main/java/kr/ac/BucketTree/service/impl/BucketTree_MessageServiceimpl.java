package kr.ac.BucketTree.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketTree_MessageDAO;
import kr.ac.BucketTree.service.BucketTree_MessageService;
import kr.ac.BucketTree.service.Message_ImageService;
import kr.ac.BucketTree.service.Question_ImageService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketShareVO;
import kr.ac.BucketTree.vo.BucketTree_Message;
@Service
public class BucketTree_MessageServiceimpl implements BucketTree_MessageService {
	@Autowired
	Message_ImageService image;
	@Autowired
	BucketTree_MessageDAO dao;
	@Override
	public void insert(BucketTree_Message bucketTree_Message) {
		
		dao.insert(bucketTree_Message);
		
	}
	@Override
	public void updateBucketTreeImage(BucketTree_Message bucketTree_Message) {
		image.deleteByMessageIdx(bucketTree_Message.getIdx());
		String pattern = "bucket/([0-9]+)/image";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(bucketTree_Message.getContents());
		while (m.find()) {
			int imageId = Integer.parseInt(m.group(1));
			image.insert(bucketTree_Message.getIdx(), imageId);
		}

	}
	@Override
	public List<BucketTree_Message> list(int idx,Pagination pagination){
		// TODO Auto-generated method stub
		return dao.list(idx,pagination);
	}
	@Override
	public int listCount(int idx) {
		// TODO Auto-generated method stub
		return dao.listCount(idx);
	}
	@Override
	public List<BucketTree_Message> noticeList(int idx) {
		// TODO Auto-generated method stub
		return dao.noticeList(idx);
	}
	@Override
	public BucketTree_Message selectByidx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByidx(idx);
	}
	@Override
	public void update(BucketTree_Message bucketTree_MessageVO) {
		// TODO Auto-generated method stub
		dao.update(bucketTree_MessageVO);
	}
	@Override
	public void delete(int idx) {
		// TODO Auto-generated method stub
		dao.delete(idx);
	}

}
