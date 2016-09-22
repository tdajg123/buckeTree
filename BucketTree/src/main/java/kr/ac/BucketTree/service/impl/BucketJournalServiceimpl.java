package kr.ac.BucketTree.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketJournalDAO;
import kr.ac.BucketTree.dao.Journal_ImageDAO;
import kr.ac.BucketTree.service.BucketJournalService;
import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.Journal_ImageVO;

@Service
public class BucketJournalServiceimpl implements BucketJournalService {

	@Autowired
	BucketJournalDAO dao;
	@Autowired
	Journal_ImageDAO jidao;

	// bucket_idx로 일지 리스트 조회
	@Override
	public List<BucketJournalVO> bucketJournalList(int bucket_idx) {
		// TODO Auto-generated method stub
		return dao.bucketJournalList(bucket_idx);
	}

	// 일지 select
	@Override
	public BucketJournalVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return dao.selectByIdx(idx);
	}

	// 일지 insert
	@Override
	public void insertJournal(BucketJournalVO bj) {
		// TODO Auto-generated method stub
		dao.insertJournal(bj);
	}

	// 일지 update
	@Override
	public void updateJournal(BucketJournalVO bj) {
		// TODO Auto-generated method stub
		dao.updateJournal(bj);

	}

	// 일지 delete
	@Override
	public void deleteJournal(int idx) {
		// TODO Auto-generated method stub
		dao.deleteJournal(idx);
	}

	@Override
	public void updateJournalImage(BucketJournalVO bj) {
		// TODO Auto-generated method stub

		jidao.deleteByJournal_idx(bj.getIdx());
		String pattern = "bucket/([0-9]+)/image";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(bj.getContents());
		while (m.find()) {
			int image_idx = Integer.parseInt(m.group(1));
			Journal_ImageVO jivo = new Journal_ImageVO();
			jivo.setJournal_idx(bj.getIdx());
			jivo.setImage_idx(image_idx);
			jidao.insertJournal_Image(jivo);
		}
	}

}