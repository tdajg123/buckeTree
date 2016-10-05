package kr.ac.BucketTree.vo;

public class BucketTree_Message_Comment {
	int BucketTree_Message_idx;
	int idx;
	int user_idx;
	String contents;
	String date;
	String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBucketTree_Message_idx() {
		return BucketTree_Message_idx;
	}
	public void setBucketTree_Message_idx(int bucketTree_Message_idx) {
		BucketTree_Message_idx = bucketTree_Message_idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
