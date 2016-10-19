package kr.ac.BucketTree.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.BucketTree.dao.BucketJournalDAO;
import kr.ac.BucketTree.dao.TimelineDAO;
import kr.ac.BucketTree.service.TimelineService;
import kr.ac.BucketTree.util.Pagination;
import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.TimelineVO;
import kr.ac.BucketTree.vo.UserVO;

@Service
public class TimelineServiceimpl implements TimelineService {

	@Autowired
	TimelineDAO dao;
	@Autowired
	BucketJournalDAO bjdao;

	Date dtime = new Date();
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String stime = transFormat.format(dtime);

	// user_idx로 타임라인 리스트 조회
	@Override
	public List<TimelineVO> timelineList( Pagination page,int user_idx) {
		// TODO Auto-generated method stub
		return dao.timelineList(page, user_idx);
	}

	// 1. 친구 추가시
	@Override
	public void Friendnsert_Timeline(UserVO fv, UserVO uv) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());
		tv.setToUser(fv.getIdx());

		// 친구 이름 삽입
		String friend_name = fv.getName();
		String message = " [ " + friend_name + " ] 님과 친구가 되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 2. 버킷리스트 추가시
	@Override
	public void BucketInsert_Timeline(int user_idx, String title, String url) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// bucket title 삽입
		String bucket_title = title;
		String message = " 버킷리스트 " + " [ " + bucket_title + " ] 이 추가되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 3. 일지 추가시
	@Override
	public void JournalInsert_Timeline(BucketJournalVO bjv, UserVO uv) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// bucketList title 삽입 ** 수정해야함 (journal title로 되어있음)
		String bucket_title = bjdao.selectByIdx(bjv.getIdx()).getTitle();
		String message = "버킷리스트 [ " + bucket_title + " ] 에 일지 [ " + bucket_title + " ] 이 추가되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/bucketList/journal?bucket_idx=" + bjv.getBucket_idx();
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 4. 버킷리스트 완료시
	@Override
	public void BucketComplete_Timeline(int user_idx, String title, String url) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// bucket title 삽입

		String message = "버킷리스트 " + " [ " + title + " ] 를 완료되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 5. 버킷리스트 수정시
	@Override
	public void BucketUpdate_Timeline(BucketListVO blv, UserVO uv) {
		// TODO Auto-generated method stub
		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// bucket title 삽입
		String bucket_title = blv.getTitle();
		String message = "버킷리스트 " + " [ " + bucket_title + " ] 이 수정되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 6. 친구에게 찌름 당했을 시
	@Override
	public void FriendPointing_Timeline(UserVO fv, UserVO uv) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(fv.getIdx());

		// 친구 이름 삽입
		String friend_name = uv.getName();
		String message = "친구 [ " + friend_name + " ] 님이 " + fv.getName() + "님을 지목하였습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);
		tv.setToUser(uv.getIdx());

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 7. 버킷트리에 가입했을 시
	@Override
	public void TreeJoin_Timeline(UserVO uv) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// 버킷 트리 이름 삽입
		String tree_name = "";
		String message = "버킷트리 [ " + tree_name + " ] 에 가입되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 8. 버킷트리에서 탈퇴했을 시
	@Override
	public void TreeLeave_Timeline(UserVO uv) {
		// TODO Auto-generated method stub
		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// 버킷 트리 이름 삽입
		String tree_name = "";
		String message = "버킷트리 [ " + tree_name + " ] 에서 탈퇴되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 9. 버킷트리 미션이 올라왔을 시
	@Override
	public void TreeMission_Timeline(UserVO uv) {
		// TODO Auto-generated method stub
		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// 버킷 트리 이름 삽입
		String tree_name = "";
		String message = "버킷트리 [ " + tree_name + " ] 에 새로운 미션이 올라왔습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 10. 버킷트리에서 추방당했을 시
	@Override
	public void TreeOut_Timeline(UserVO uv) {
		// TODO Auto-generated method stub
		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(uv.getIdx());

		// 버킷 트리 이름 삽입
		String tree_name = "";
		String message = "버킷트리 [ " + tree_name + " ] 에서 추방되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		String url = "/BucketTree/";
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 11. 버킷쉐어에 질문 작성 시
	@Override
	public void ShareQuestion_Timeline(int user_idx,String title, String url) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// 버킷 쉐어 제목 삽입
		
		String message = "버킷쉐어에 [ " + title + " ] 에 관한 질문을 작성하였습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 12. 버킷쉐어 질문에 답변이 달렸을 시
	@Override
	public void ShareAnswer_Timeline(int user_idx,String title, String url) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// 버킷 쉐어 제목 삽입
		String message = "버킷쉐어에 질문한 [ " + title + " ] 에 관한 답변이 달렸습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	// 13. 버킷쉐어에 답변한 게 채택되었을 시
	@Override
	public void ShareSelect_Timeline(int user_idx,String title, String url) {
		// TODO Auto-generated method stub

		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// 버킷 쉐어 제목 삽입
		String message = "버킷쉐어에 답변한 [ " + title + " ] 이 채택되었습니다.";
		tv.setMessage(message);

		// 현재 시간 삽입
		tv.setDate(stime);

		// url 삽입
		tv.setUrl(url);

		dao.insertTimeline(tv);

	}

	@Override
	public void TreeCreate_Timeline(int user_idx, String title, String url) {
		TimelineVO tv = new TimelineVO();

		// user idx 삽입
		tv.setUser_idx(user_idx);

		// 버킷 쉐어 제목 삽입
		String message = "버킷트리 [ " + title + " ] 을 만들었습니다.";
		tv.setMessage(message);
		// 현재 시간 삽입
		tv.setDate(stime);
		// url 삽입
		tv.setUrl(url);

		dao.insertTimeline(tv);
		
	}
	
	@Override
	public boolean checkDate(int user_idx,int toUser){
		int result = dao.checkDate(user_idx, toUser);
		return result>0;
	}
	

}
