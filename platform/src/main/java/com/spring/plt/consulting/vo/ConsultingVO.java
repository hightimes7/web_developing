package com.spring.plt.consulting.vo;

import org.springframework.stereotype.Component;

@Component("consultingVO")
public class ConsultingVO {
	private int no;
	private String compId;
	private String expId;
	private String title;
	private String content;
	private String fileName;
	private int price;
	private String reqDate;
	private int status;
	
	@Override
	public String toString() {
		return "ConsultingVO [no=" + no + ", compId=" + compId + ", expId=" + expId + ", title=" + title + ", content="
				+ content + ", fileName=" + fileName + ", price=" + price + ", reqDate=" + reqDate + ", status="
				+ status + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getReqdate() {
		return reqDate;
	}
	public void setReqdate(String reqdate) {
		this.reqDate = reqdate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
