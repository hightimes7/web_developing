package com.spring.plt.message.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("messageVO")
public class MessageVO {
	private int NO;
	private String sendId;
	private String receiveId;
	private String content;
	private Date writeDate;
	private int seAva;
	private int reAva;
	private int seRead;
	private int reRead;
	public int getNO() {
		return NO;
	}
	public void setNO(int NO) {
		this.NO = NO;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
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
	public int getSeAva() {
		return seAva;
	}
	public void setSeAva(int seAva) {
		this.seAva = seAva;
	}
	public int getReAva() {
		return reAva;
	}
	public void setReAva(int reAva) {
		this.reAva = reAva;
	}
	public int getSeRead() {
		return seRead;
	}
	public void setSeRead(int seRead) {
		this.seRead = seRead;
	}
	public int getReRead() {
		return reRead;
	}
	public void setReRead(int reRead) {
		this.reRead = reRead;
	}
	@Override
	public String toString() {
		return "MessageVO [NO=" + NO + ", sendId=" + sendId + ", receiveId=" + receiveId + ", content="
				+ content + ", writeDate=" + writeDate + ", seAva=" + seAva + ", reAva=" + reAva + ", seRead=" + seRead
				+ ", reRead=" + reRead + "]";
	}
}
