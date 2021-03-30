package com.spring.plt.scrap.vo;

import org.springframework.stereotype.Component;

@Component("scrapVO")
public class ScrapVO {
	private String no;
	private String compid;
	private String expid;
	private String manuid;
	private String expName;
	private String expBizField;
	private String expTel;
	private String manuName;
	private String manuBizType;
	private String productPrice;
	private String manuImg;

	@Override
	public String toString() {
		return "ScrapVO [no=" + no + ", compid=" + compid + ", expid=" + expid + ", manuid=" + manuid + ", expName="
				+ expName + ", expBizField=" + expBizField + ", expTel=" + expTel + ", manuName=" + manuName
				+ ", manuBizType=" + manuBizType + ", productPrice=" + productPrice + ", manuImg=" + manuImg + "]";
	}

	public ScrapVO() {
		super();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getExpid() {
		return expid;
	}

	public void setExpid(String expid) {
		this.expid = expid;
	}

	public String getManuid() {
		return manuid;
	}

	public void setManuid(String manuid) {
		this.manuid = manuid;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
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

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getManuBizType() {
		return manuBizType;
	}

	public void setManuBizType(String manuBizType) {
		this.manuBizType = manuBizType;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getManuImg() {
		return manuImg;
	}

	public void setManuImg(String manuImg) {
		this.manuImg = manuImg;
	}
	
}
