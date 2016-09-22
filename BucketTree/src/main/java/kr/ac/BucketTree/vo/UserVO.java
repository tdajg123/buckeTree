package kr.ac.BucketTree.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVO {
	int idx;
	String email;
	String password;
	String name;
	Date birth;
	byte[] image;
	String type;
	int point;
	String fileName;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/*Ȯ���� Ÿ�� ����*/
	public String getMimeType() {
	if(fileName!=null){
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
	}
        return "image/jpeg";

    }
	
}
