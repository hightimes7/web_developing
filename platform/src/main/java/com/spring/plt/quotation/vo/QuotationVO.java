package com.spring.plt.quotation.vo;

import org.springframework.stereotype.Component;

@Component("quotationVO")
public class QuotationVO {
	private int no;
	private String compId;
	private String manuId;
	private String item = null;
	private int price = 0;
	private int quantity = 0;
	private int vat = 0;
	private String detail = null;
	private String fileName = null;
	private String tempSave;
	private String reqQuote = null;
	private int quoteStatus = 0;
	
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
	public String getManuId() {
		return manuId;
	}
	public void setManuId(String manuId) {
		this.manuId = manuId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTempSave() {
		return tempSave;
	}
	public void setTempSave(String tempSave) {
		this.tempSave = tempSave;
	}
	public String getReqQuote() {
		return reqQuote;
	}
	public void setReqQuote(String reqQuote) {
		this.reqQuote = reqQuote;
	}
	public int getQuoteStatus() {
		return quoteStatus;
	}
	public void setQuoteStatus(int quoteStatus) {
		this.quoteStatus = quoteStatus;
	}
	@Override
	public String toString() {
		return "QuotationVO [no=" + no + ", compId=" + compId + ", manuId=" + manuId + ", item=" + item + ", price="
				+ price + ", quantity=" + quantity + ", vat=" + vat + ", detail=" + detail + ", fileName=" + fileName
				+ ", tempSave=" + tempSave + ", reqQuote=" + reqQuote + ", quoteStatus=" + quoteStatus + "]";
	}
}
