package kr.ac.BucketTree.vo;

public class RecommendVO {

	int toUser;
	int fromUser;
	int BucketList_idx;
	String title;
	String contents;
	String image;

	public int getToUser() {
		return toUser;
	}

	public void setToUser(int toUser) {
		this.toUser = toUser;
	}

	public int getFromUser() {
		return fromUser;
	}

	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}

	public int getBucketList_idx() {
		return BucketList_idx;
	}

	public void setBucketList_idx(int bucketList_idx) {
		BucketList_idx = bucketList_idx;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
