package com.sheng.vo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable {
    private String eid;
    private Long did;
    private String lid;
    private String ename;
    private Double sal;
    private String phone;
    private String password;
    private String photo;
    private String text;
    private Date hiredate;
    private String ineid;
    private Integer locked;

    @Override
    public String toString() {
        return "Emp{" +
                "eid='" + eid + '\'' +
                ", did=" + did +
                ", lid='" + lid + '\'' +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", text='" + text + '\'' +
                ", hiredate=" + hiredate +
                ", ineid='" + ineid + '\'' +
                ", locked=" + locked +
                '}';
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getIneid() {
        return ineid;
    }

    public void setIneid(String ineid) {
        this.ineid = ineid;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }
}
