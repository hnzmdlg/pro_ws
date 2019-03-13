package com.ws.bean;

import java.io.Serializable;

public class Administration implements Serializable  {

    private static final long serialVersionUID = -3832375323961109839L;
    private  Integer id;
    private  String sdianji;
    private  String kname;
    private  Integer kss;
    private  Integer lls;
    private  String lteacher;
    private  String oktime;
    private  Integer ktype;
    private  String kdesc;
    private  String kurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdianji() {
        return sdianji;
    }

    public void setSdianji(String sdianji) {
        this.sdianji = sdianji;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }

    public Integer getKss() {
        return kss;
    }

    public void setKss(Integer kss) {
        this.kss = kss;
    }

    public Integer getLls() {
        return lls;
    }

    public void setLls(Integer lls) {
        this.lls = lls;
    }

    public String getLteacher() {
        return lteacher;
    }

    public void setLteacher(String lteacher) {
        this.lteacher = lteacher;
    }

    public String getOktime() {
        return oktime;
    }

    public void setOktime(String oktime) {
        this.oktime = oktime;
    }

    public Integer getKtype() {
        return ktype;
    }

    public void setKtype(Integer ktype) {
        this.ktype = ktype;
    }

    public String getKdesc() {
        return kdesc;
    }

    public void setKdesc(String kdesc) {
        this.kdesc = kdesc;
    }

    public String getKurl() {
        return kurl;
    }

    public void setKurl(String kurl) {
        this.kurl = kurl;
    }
}
