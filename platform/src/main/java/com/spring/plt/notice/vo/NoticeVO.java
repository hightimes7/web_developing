package com.spring.plt.notice.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("noticeVO")
public class NoticeVO {
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int cnt;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "NoticeVO [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writeDate=" + writeDate + ", cnt=" + cnt + "]";
	}
}
