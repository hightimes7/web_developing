package com.spring.plt.expert.vo;

import org.springframework.stereotype.Component;

@Component("expertVO")
public class ExpertVO {
	private String id;
	private String pwd;
	private String expName;	
	private String expEmail;
	private String expBizField;	
	private String expTel;
	private String expCareer;
	private String expDetail;
	private String expAuth;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getExpName() {
		return expName;
	}
	public void setExpName(String expName) {
		this.expName = expName;
	}
	public String getExpEmail() {
		return expEmail;
	}
	public void setExpEmail(String expEmail) {
		this.expEmail = expEmail;
	}
	public String getExpBizField() {
		return expBizField;
	}
	public void setExpBizField(String expBizField) {
		this.expBizField = expBizField;
	}
	public String getExpTel() {
		return expTel;
	}
	public void setExpTel(String expTel) {
		this.expTel = expTel;
	}
	public String getExpCareer() {
		return expCareer;
	}
	public void setExpCareer(String expCareer) {
		this.expCareer = expCareer;
	}
	public String getExpDetail() {
		return expDetail;
	}
	public void setExpDetail(String expDetail) {
		this.expDetail = expDetail;
	}
	public String getExpAuth() {
		return expAuth;
	}
	public void setExpAuth(String expAuth) {
		this.expAuth = expAuth;
	}
	@Override
	public String toString() {
		return "ExpertVO [id=" + id + ", pwd=" + pwd + ", expName=" + expName + ", expEmail=" + expEmail
				+ ", expBizField=" + expBizField + ", expTel=" + expTel + ", expCareer=" + expCareer + ", expDetail="
				+ expDetail + ", expAuth=" + expAuth + ", type=" + type + "]";
	}
}
