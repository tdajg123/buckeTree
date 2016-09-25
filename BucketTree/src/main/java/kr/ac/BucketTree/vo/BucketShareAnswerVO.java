package kr.ac.BucketTree.vo;

public class BucketShareAnswerVO {
	int idx;
	int user_idx;
	String user_Name;
	String date;
	int BucketShare_Question_idx;
	String contents;
	int state;
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
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBucketShare_Question_idx() {
		return BucketShare_Question_idx;
	}
	public void setBucketShare_Question_idx(int bucketShare_Question_idx) {
		BucketShare_Question_idx = bucketShare_Question_idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

}
