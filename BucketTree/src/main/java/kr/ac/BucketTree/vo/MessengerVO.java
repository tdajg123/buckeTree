package kr.ac.BucketTree.vo;

import com.google.gson.Gson;

public class MessengerVO {
	int idx;
	int to_user_idx;
	int from_user_idx;
	String date;
	String contents;
	int type;

	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public static MessengerVO convertMessenger(String source) {
		MessengerVO messenger = new MessengerVO();
		Gson gson = new Gson();
		messenger = gson.fromJson(source, MessengerVO.class);
		return messenger;
	}

	public int getTo_user_idx() {
		return to_user_idx;
	}

	public void setTo_user_idx(int to_user_idx) {
		this.to_user_idx = to_user_idx;
	}

	public int getFrom_user_idx() {
		return from_user_idx;
	}

	public void setFrom_user_idx(int from_user_idx) {
		this.from_user_idx = from_user_idx;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
