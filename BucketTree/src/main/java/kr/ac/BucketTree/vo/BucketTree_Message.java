package kr.ac.BucketTree.vo;

import java.util.List;

public class BucketTree_Message {
	
	int idx;
	int bucketTree_idx;
	String contents;
	int user_idx;
	int type;
	String date;
	int together;
	List<BucketTree_Message_Comment> comment;
	
	public List<BucketTree_Message_Comment> getComment() {
		return comment;
	}
	public void setComment(List<BucketTree_Message_Comment> comment) {
		this.comment = comment;
	}
	public int getTogether() {
		return together;
	}
	public void setTogether(int together) {
		this.together = together;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public int getBucketTree_idx() {
		return bucketTree_idx;
	}
	public void setBucketTree_idx(int bucketTree_idx) {
		this.bucketTree_idx = bucketTree_idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
