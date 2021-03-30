package com.spring.plt.expert.vo;

import java.sql.Date;

public class ExpImageVO {
	private int imageFileNO;
	private String imageFileName;
	private Date regDate;
	private String id;
	public int getImageFileNO() {
		return imageFileNO;
	}
	public void setImageFileNO(int imageFileNO) {
		this.imageFileNO = imageFileNO;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ExpImageVO [imageFileNO=" + imageFileNO + ", imageFileName=" + imageFileName + ", regDate=" + regDate
				+ ", id=" + id + "]";
	}
}
