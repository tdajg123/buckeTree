package kr.ac.BucketTree.util;

public class Pagination {
	int srchType;
	String srchText;
	
	public Pagination()
	{
		srchType=0;
		srchText="";
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
