package com.spring.plt.admin.vo;

import org.springframework.stereotype.Component;

@Component("loginLogVO")
public class LoginLogVO {
   private int no;
   private String id;
   private String logintime;
   
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
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

}