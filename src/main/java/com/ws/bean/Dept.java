package com.ws.bean;

import java.io.Serializable;

public class Dept implements Serializable {

    private static final long serialVersionUID = -5107180568702296027L;
    private Integer id;
    private String dname;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
