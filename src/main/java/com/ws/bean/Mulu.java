package com.ws.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Mulu implements Serializable {
    private static final long serialVersionUID = 4902770122038552432L;
    private Integer mid;
    private String mname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creadate;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Date getCreadate() {
        return creadate;
    }

    public void setCreadate(Date creadate) {
        this.creadate = creadate;
    }
}
