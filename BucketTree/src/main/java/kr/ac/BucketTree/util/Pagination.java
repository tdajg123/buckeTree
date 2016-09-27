package kr.ac.BucketTree.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Pagination {


	int currentPage = 1;
	int pageSize = 10;
	int recordCount;
	int row;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	// 검색
	int srchType;
	String srchText;
	// 카테고리
	int categoryType;
	int when;
	int what;
	int who;

	// 타입에 따른 버킷쉐어 상태(채택x,채택o)
	int type;
	int state;
	// 정렬순서
	int orderType = 1;
	
	
	
	public String getQueryString() throws UnsupportedEncodingException {
		String temp = (srchText == null) ? "" : URLEncoder.encode(srchText, "UTF-8");
		return String.format("currentPage=%d&srchType=%d&srchText=%s&categoryType=%d&when=%d&what=%d&who=%d&type=%d", currentPage,  srchType, temp,categoryType,when,what,who,type);
	}

	
	
	public int getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getWhen() {
		return when;
	}

	public void setWhen(int when) {
		this.when = when;
	}

	public int getWhat() {
		return what;
	}

	public void setWhat(int what) {
		this.what = what;
	}

	public int getWho() {
		return who;
	}

	public void setWho(int who) {
		this.who = who;
	}

	public Pagination() {
		srchType = 0;
		srchText = "";
	}

	public int getSrchType() {
		return srchType;
	}

	public void setSrchType(int srchType) {
		this.srchType = srchType;
	}

	public String getSrchText() {
		return srchText;
	}

	public void setSrchText(String srchText) {
		this.srchText = srchText;
	}

	/* 화면 하단에 페이지 번호 링크들을 출력하기 위한 메소드와 클래스 */
	public List<Page> getPageList() {
		ArrayList<Page> list = new ArrayList<Page>();
		int pageCount = (recordCount + pageSize - 1) / pageSize;
		int basePage = ((currentPage - 1) / 10) * 10;
		if (basePage > 0)
			list.add(new Page("Prev", basePage));
		for (int i = 1; i <= 10 && basePage + i <= pageCount; ++i)
			list.add(new Page(basePage + i, currentPage == basePage + i));
		if (basePage + 11 <= pageCount)
			list.add(new Page("Next", basePage + 11));
		return list;
	}

	// 페이지번호
	public class Page {
		String label;
		int number;
		String cssClass;

		public Page(int number, boolean active) {
			this.label = "" + number;
			this.number = number;
			this.cssClass = active ? "active" : "";
		}

		public Page(String label, int number) {
			this.label = label;
			this.number = number;
			this.cssClass = "";
		}

		public Object getLabel() {
			return label;
		}

		public int getNumber() {
			return number;
		}

		public String getCssClass() {
			return cssClass;
		}

	}

}
