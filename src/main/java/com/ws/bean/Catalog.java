package com.ws.bean;
//
import javax.persistence.Transient;
import java.io.Serializable;

public class Catalog implements Serializable {

    private static final long serialVersionUID = -4625796234104770874L;
    private Integer id;
    private String mlname;
    private Integer kid;
    @Transient
    private String kname;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname;
    }
}
