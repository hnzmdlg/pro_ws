package com.ws.bean;

import java.io.Serializable;

public class Vip implements Serializable {

    private static final long serialVersionUID = 1298465431748750411L;
    private Integer id;
    private  String vname;
    private  Integer vprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Integer getVprice() {
        return vprice;
    }

    public void setVprice(Integer vprice) {
        this.vprice = vprice;
    }
}
