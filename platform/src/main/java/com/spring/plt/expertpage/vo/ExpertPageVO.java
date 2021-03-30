package com.spring.plt.expertpage.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("expertPageVO")
public class ExpertPageVO {
	int no;
	String expname;
	String compname;
	int status;
	Date reqdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getExpname() {
		return expname;
	}
	public void setExpname(String expname) {
		this.expname = expname;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getReqdate() {
		return reqdate;
	}
	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}
}
