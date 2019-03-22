package com.ws.bean;

import java.io.Serializable;

public class Answer implements Serializable {

    private static final long serialVersionUID = 6229941346170802998L;
    private  Integer id;
    private  String contont;
    private  String createtime;
    private  Integer wid;
    private  Integer uid;
    private  String like;
    private  Integer status;
    private  String wname;

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
