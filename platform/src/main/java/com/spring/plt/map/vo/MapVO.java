package com.spring.plt.map.vo;

import org.springframework.stereotype.Component;

@Component
public class MapVO {
	String manuName;
	String manuAddr;
	String manudetailaddr;
	String id;

	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
	}
	public String getManuAddr() {
		return manuAddr;
	}
	public void setManuAddr(String manuAddr) {
		this.manuAddr = manuAddr;
	}
	public String getManudetailaddr() {
		return manudetailaddr;
	}
	public void setManudetailaddr(String manudetailaddr) {
		this.manudetailaddr = manudetailaddr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "MapVO [manuName=" + manuName + ", manuAddr=" + manuAddr + ", manudetailaddr=" + manudetailaddr + ", id="
				+ id + "]";
	}
}
