package kr.ac.BucketTree.vo;

public class ImageVO {

	int idx;
	String fileName;
	String fileTime;
	byte[] data;
	int fileSize;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileTime() {
		return fileTime;
	}

	public void setFileTime(String fileTime) {
		this.fileTime = fileTime;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getMimeType() {
		int index = fileName.lastIndexOf('.');
		if (index > 0) {
			String extension = fileName.substring(index + 1).toLowerCase();
			switch (extension) {
			case "png":
			case "bmp":
			case "gif":
				return "image/" + extension;
			}
		}
		return "image/jpeg";
	}

}
