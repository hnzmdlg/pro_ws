package com.ws.bean;

import java.io.Serializable;

public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1947356796781463195L;
    private  Integer id;
    private  String puser;//评论人id
    private  Integer kcid;
    private  String contont;//评论内容
    private  String ptime;//评论时间
    private  Integer status;//评论状态


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPuser() {
        return puser;
    }

    public void setPuser(String puser) {
        this.puser = puser;
    }

    public Integer getKcid() {
        return kcid;
    }

    public void setKcid(Integer kcid) {
        this.kcid = kcid;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
