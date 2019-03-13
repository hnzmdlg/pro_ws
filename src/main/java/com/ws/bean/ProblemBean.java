package com.ws.bean;

import java.io.Serializable;

public class ProblemBean implements Serializable {

    private static final long serialVersionUID = 6675126324071626514L;
    private Integer id;
    private String pname;
    private String pcreatetime;
    private String psfzr;


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcreatetime() {
        return pcreatetime;
    }

    public void setPcreatetime(String pcreatetime) {
        this.pcreatetime = pcreatetime;
    }

    public String getPsfzr() {
        return psfzr;
    }

    public void setPsfzr(String psfzr) {
        this.psfzr = psfzr;
    }
}
