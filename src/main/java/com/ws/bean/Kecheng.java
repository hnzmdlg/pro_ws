package com.ws.bean;

import java.io.Serializable;
//
public class Kecheng implements Serializable {

    private static final long serialVersionUID = -2974925595632283124L;
    private  Integer id;

    private  String kname;//课程名称
    private  Integer kss;//课记数
    private  Integer lls;//浏览数
    private  String lteacher;//教师名称
    private  String oktime;//有效时间

    private  String kdesc;//课程介绍
    private  String kurl;//封面



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
