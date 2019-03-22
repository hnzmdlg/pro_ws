package com.ws.bean;


import javax.persistence.Transient;
import java.io.Serializable;

public class Section implements Serializable {
    private static final long serialVersionUID = -6456521837836620288L;
    private Integer zid;
    private String zname;
    private Integer mid;

    @Transient
    private String mlname;
    private String sname;
    private String type;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMlname() {
        return mlname;
    }

    public void setMlname(String mlname) {
        this.mlname = mlname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
