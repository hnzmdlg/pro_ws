package com.ws.bean;

import java.io.Serializable;

public class Catalog implements Serializable {

    private static final long serialVersionUID = -4625796234104770874L;
    private Integer id;
    private String mlname;
    private Integer kid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMlname() {
        return mlname;
    }

    public void setMlname(String mlname) {
        this.mlname = mlname;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }
}
