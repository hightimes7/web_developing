package com.spring.plt.manufacQnA.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("manufacQnAVO")
public class ManufacQnAVO {
	private int level;
	private int no;
	private int parentNO;
	private String id;
	private String content;
	private Date writeDate;
	private String manuId;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getParentNO() {
		return parentNO;
	}
	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getManuId() {
		return manuId;
	}
	public void setManuId(String manuId) {
		this.manuId = manuId;
	}
	@Override
	public String toString() {
		return "ManufacQnAVO [level=" + level + ", no=" + no + ", parentNO=" + parentNO + ", id=" + id + ", content=" + content + ", writeDate=" + writeDate + ", manuId=" + manuId + "]";
	}
}
