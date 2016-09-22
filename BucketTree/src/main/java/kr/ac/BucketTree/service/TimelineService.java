package kr.ac.BucketTree.service;

import java.util.List;

import kr.ac.BucketTree.vo.BucketJournalVO;
import kr.ac.BucketTree.vo.BucketListVO;
import kr.ac.BucketTree.vo.FriendVO;
import kr.ac.BucketTree.vo.TimelineVO;
import kr.ac.BucketTree.vo.UserVO;

public interface TimelineService {

	// user_idx로 타임라인 리스트 조회
	public List<TimelineVO> timelineList(int user_idx);

	// 1. 친구 추가시
	public void Friendnsert_Timeline(FriendVO fv, UserVO uv);

	// 2. 버킷리스트 추가시
	public void BucketInsert_Timeline(BucketListVO blv, UserVO uv);

	// 3. 일지 추가시
	public void JournalInsert_Timeline(BucketJournalVO bjv, UserVO uv);

	// 4. 버킷리스트 완료시
	public void BucketComplete_Timeline(BucketListVO blv, UserVO uv);

	// 5. 버킷리스트 수정시
	public void BucketUpdate_Timeline(BucketListVO blv, UserVO uv);

	// 6. 친구에게 찌름 당했을 시
	public void FriendPointing_Timeline(FriendVO fv, UserVO uv);

	// 7. 버킷트리에 가입했을 시
	public void TreeJoin_Timeline(UserVO uv);

	// 8. 버킷트리에서 탈퇴했을 시
	public void TreeLeave_Timeline(UserVO uv);

	// 9. 버킷트리 미션이 올라왔을 시
	public void TreeMission_Timeline(UserVO uv);

	// 10. 버킷트리에서 추방당했을 시
	public void TreeOut_Timeline(UserVO uv);

	// 11. 버킷쉐어에 질문 작성 시
	public void ShareQuestion_Timeline(UserVO uv);

	// 12. 버킷쉐어 질문에 답변이 달렸을 시
	public void ShareAnswer_Timeline(UserVO uv);

	// 13. 버킷쉐어에 답변한 게 채택되었을 시
	public void ShareSelect_Timeline(UserVO uv);

}