package com.ws.bean;

import java.io.Serializable;

public class Advertisement implements Serializable {


    private static final long serialVersionUID = -556493573839358540L;
    private Integer id;
    private String url;
    private String href;
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
