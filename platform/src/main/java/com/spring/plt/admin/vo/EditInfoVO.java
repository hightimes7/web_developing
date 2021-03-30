package com.spring.plt.admin.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("editInfoVO")
public class EditInfoVO {
   private int no;
   private String id;
   private String pwd;
   private String name;
   private String ceoname;
   private String email;
   private String biztype;
   private String addr;
   private String detailaddr;
   private String tel;
   private String career;
   private String detail;
   private int price;
   private Date editdate;
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
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getCeoname() {
      return ceoname;
   }
   public void setCeoname(String ceoname) {
      this.ceoname = ceoname;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getBiztype() {
      return biztype;
   }
   public void setBiztype(String biztype) {
      this.biztype = biztype;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   public String getDetailaddr() {
      return detailaddr;
   }
   public void setDetailaddr(String detailaddr) {
      this.detailaddr = detailaddr;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getCareer() {
      return career;
   }
   public void setCareer(String career) {
      this.career = career;
   }
   public String getDetail() {
      return detail;
   }
   public void setDetail(String detail) {
      this.detail = detail;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public Date getEditdate() {
      return editdate;
   }
   public void setEditdate(Date editdate) {
      this.editdate = editdate;
   }
   public String getType() {
      return type;
   }
   public void setType(String type) {
      this.type = type;
   }
}