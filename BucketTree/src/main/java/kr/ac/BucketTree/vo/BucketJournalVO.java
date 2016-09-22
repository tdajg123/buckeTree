package kr.ac.BucketTree.vo;

public class BucketJournalVO {

	int idx;
	int bucket_idx;
	String title;
	String contents;
	String date;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBucket_idx() {
		return bucket_idx;
	}
	public void setBucket_idx(int bucket_idx) {
		this.bucket_idx = bucket_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
