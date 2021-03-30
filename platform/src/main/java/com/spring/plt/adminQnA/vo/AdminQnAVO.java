package com.spring.plt.adminQnA.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("adminQnAVO")
public class AdminQnAVO {
	private int lvl;
	private int no;
	private int parentNO;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "AdminQnAVO [lvl=" + lvl + ", no=" + no + ", parentNO=" + parentNO + ", title=" + title
				+ ", content=" + content + ", writer=" + writer + ", writeDate=" + writeDate + "]";
	}
}
