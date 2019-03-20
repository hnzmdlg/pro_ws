package com.ws.bean;

import javax.persistence.Transient;
import java.io.Serializable;

public class Node implements Serializable {
    private static final long serialVersionUID = -343078194272527823L;

    private Integer sid;
    private String sname;
    private Integer zid;
    private Integer type;
    @Transient
    private String zname;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }
}
