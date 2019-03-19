package com.ws.bean;

import java.io.Serializable;

public class Xinwen implements Serializable {
    private static final long serialVersionUID = -2242341427072155810L;
    private  Integer id;//主键ID
    private  String content;//内容
    private  String createTime;//创建时间
    private  String createUser;//创建人
    private String url;//新闻封面
    private Integer ttid;//状态

    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}
