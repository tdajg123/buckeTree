package kr.ac.BucketTree.vo;

import java.util.Date;

public class BucketListVO {

	int idx;
	String title;
	String contents;
	String image;
	int count;
	Date date;
	int user_idx;
	int writer;
	float x;
	float y;
	String keyword;
	int when;
	int who;
	int what;
	int tree_idx;
	int state;
	String when_name;
	String who_name;
	String what_name;
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhen_name() {
		return when_name;
	}

	public void setWhen_name(String when_name) {
		this.when_name = when_name;
	}

	public String getWho_name() {
		return who_name;
	}

	public void setWho_name(String who_name) {
		this.who_name = who_name;
	}

	public String getWhat_name() {
		return what_name;
	}

	public void setWhat_name(String what_name) {
		this.what_name = what_name;
	}
	int row;
	
	/*�����ڷ� �⺻ �� ��������.*/
	public BucketListVO ()
	{
		/*��� ������ �� ���� ��Ŷ�� �߰� �Ǵ� �ֵ��� ���� null ���� ���� �ֵ��� ���⼭ �⺻ �������� ����*/
		contents = "�߰��� ��Ŷ����Ʈ!";
		image = null;
		count = 0;
		writer = 2;
		x = 0;
		y = 0;
		keyword = null;
		tree_idx = 0;
		state = 0;		
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getWhen() {
		return when;
	}
	public void setWhen(int when) {
		this.when = when;
	}
	public int getWho() {
		return who;
	}
	public void setWho(int who) {
		this.who = who;
	}
	public int getWhat() {
		return what;
	}
	public void setWhat(int what) {
		this.what = what;
	}
	public int getTree_idx() {
		return tree_idx;
	}
	public void setTree_idx(int tree_idx) {
		this.tree_idx = tree_idx;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	/*pagination*/
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
}
