package com.ws.bean;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = -2506528584027834195L;

    private Integer id;
    private String rname;
    private Integer info;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }
}
