package com.spring.plt.expertQnA.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("expertQnAVO")
public class ExpertQnAVO {
	private int level;
	private int no;
	private int parentNO;
	private String id;
	private String content;
	private Date writeDate;
	private String expId;
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
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
	}
	@Override
	public String toString() {
		return "ExpertQnAVO [level=" + level + ", no=" + no + ", parentNO=" + parentNO + ", id=" + id + ", content="
				+ content + ", writeDate=" + writeDate + ", expertId=" + expId + "]";
	}
}
