package com.spring.plt.admin.vo;

import org.springframework.stereotype.Component;

@Component("adminVO")
public class AdminVO {
	private int no;
	private String id;
	private String pwd;
	private String adminName;
	private String ipNO;
	private String type;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getIpNO() {
		return ipNO;
	}
	public void setIpNO(String ipNO) {
		this.ipNO = ipNO;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AdminVO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", adminName=" + adminName + ", ipNO=" + ipNO
				+ ", type=" + type + "]";
	}
}
