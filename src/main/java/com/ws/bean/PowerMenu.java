package com.ws.bean;

import java.io.Serializable;

public class PowerMenu implements Serializable {

    private static final long serialVersionUID = -2111824331995641606L;
    private Integer id;
    private String name;
    private String url;
    private Integer power_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPower_id() {
        return power_id;
    }

    public void setPower_id(Integer power_id) {
        this.power_id = power_id;
    }
}
