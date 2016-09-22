package kr.ac.BucketTree.vo;

import java.util.Date;

public class FileMessengerVO {

	int messenger_idx;
	String fileName;
	int fileSize;
	Date fileTime;
	byte[] data;

	public int getMessenger_idx() {
		return messenger_idx;
	}
	public void setMessenger_idx(int messenger_idx) {
		this.messenger_idx = messenger_idx;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public Date getFileTime() {
		return fileTime;
	}
	public void setFileTime(Date fileTime) {
		this.fileTime = fileTime;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
