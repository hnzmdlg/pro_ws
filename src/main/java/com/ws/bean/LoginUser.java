package com.ws.bean;

import java.io.Serializable;

public class LoginUser implements Serializable {

    private static final long serialVersionUID = 418179360260557728L;

    private Integer id;
    private String name;
    private String userimg;
    private Integer age;
    private Integer sex;
    private String phone;
    private String userpwd;

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

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getZhucedate() {
        return zhucedate;
    }

    public void setZhucedate(String zhucedate) {
        this.zhucedate = zhucedate;
    }

    private String zhucedate;


}
