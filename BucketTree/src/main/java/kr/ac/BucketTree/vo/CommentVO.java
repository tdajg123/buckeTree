package kr.ac.BucketTree.vo;

import java.util.Date;

public class CommentVO {

	int idx;
	int bucketList_idx;
	int user_idx;
	String date;
	String contents;
	int author;
	String name;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBucketList_idx() {
		return bucketList_idx;
	}
	public void setBucketList_idx(int bucketList_idx) {
		this.bucketList_idx = bucketList_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int i) {
		this.author = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
