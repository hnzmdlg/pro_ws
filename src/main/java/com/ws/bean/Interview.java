package com.ws.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Interview implements Serializable {
    private static final long serialVersionUID = 4029927864716203475L;
    private Integer wid;
    private String name;
    private Integer mid;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creadate;
    private Integer uid;
    private String pv;
    private String mname;
    private  String contont;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Date getCreadate() {
        return creadate;
    }

    public void setCreadate(Date creadate) {
        this.creadate = creadate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", mid=" + mid +
                ", creadate=" + creadate +
                ", uid=" + uid +
                ", pv='" + pv + '\'' +
                ", mname='" + mname + '\'' +
                ", contont='" + contont + '\'' +
                '}';
    }
}

