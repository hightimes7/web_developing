package com.spring.plt.manufac.vo;

import org.springframework.stereotype.Component;

@Component("manufacVO")
public class ManufacVO {
	private String id;
	private String pwd;
	private String manuName;
	private String manuCeoName;
	private String manuEmail;
	private String manuBizNo;
	private String manuBizType;
	private String manuAddr;
	private String manuDetailAddr;
	private String manuTel;
	private String manuStart;
	private String manuDetail;
	private String manuImg;
	private int productPrice;
	private String manuAuth;
	private String type;
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
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getManuCeoName() {
		return manuCeoName;
	}
	public void setManuCeoName(String manuCeoName) {
		this.manuCeoName = manuCeoName;
	}
	public String getManuEmail() {
		return manuEmail;
	}
	public void setManuEmail(String manuEmail) {
		this.manuEmail = manuEmail;
	}
	public String getManuBizNo() {
		return manuBizNo;
	}
	public void setManuBizNo(String manuBizNo) {
		this.manuBizNo = manuBizNo;
	}
	public String getManuBizType() {
		return manuBizType;
	}
	public void setManuBizType(String manuBizType) {
		this.manuBizType = manuBizType;
	}
	public String getManuAddr() {
		return manuAddr;
	}
	public void setManuAddr(String manuAddr) {
		this.manuAddr = manuAddr;
	}
	public String getManuTel() {
		return manuTel;
	}
	public void setManuTel(String manuTel) {
		this.manuTel = manuTel;
	}
	public String getManuStart() {
		return manuStart;
	}
	public void setManuStart(String manuStart) {
		this.manuStart = manuStart;
	}
	public String getManuDetail() {
		return manuDetail;
	}
	public void setManuDetail(String manuDetail) {
		this.manuDetail = manuDetail;
	}
	public String getManuImg() {
		return manuImg;
	}
	public void setManuImg(String manuImg) {
		this.manuImg = manuImg;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getManuAuth() {
		return manuAuth;
	}
	public void setManuAuth(String manuAuth) {
		this.manuAuth = manuAuth;
	}
	public String getManuDetailAddr() {
		return manuDetailAddr;
	}
	public void setManuDetailAddr(String manuDetailAddr) {
		this.manuDetailAddr = manuDetailAddr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ManufacVO [id=" + id + ", pwd=" + pwd + ", manuName=" + manuName + ", manuCeoName=" + manuCeoName
				+ ", manuEmail=" + manuEmail + ", manuBizNo=" + manuBizNo + ", manuBizType=" + manuBizType
				+ ", manuAddr=" + manuAddr + ", manuDetailAddr=" + manuDetailAddr + ", manuTel=" + manuTel
				+ ", manuStart=" + manuStart + ", manuDetail=" + manuDetail + ", manuImg=" + manuImg + ", productPrice="
				+ productPrice + ", manuAuth=" + manuAuth + ", type=" + type + "]";
	}
}
