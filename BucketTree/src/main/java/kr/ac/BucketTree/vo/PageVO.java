package kr.ac.BucketTree.vo;

public class PageVO{
	
	int currentPage;
	int pageSize;
	int srchType;
	String srchText;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPagesize(int pagesize) {
		this.pageSize = pagesize;
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
	
	
}