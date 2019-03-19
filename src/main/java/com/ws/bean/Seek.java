package com.ws.bean;

import java.io.Serializable;

public class Seek implements Serializable {

    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String url;

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
}
