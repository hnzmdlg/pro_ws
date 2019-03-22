package com.ws.bean;

import java.io.Serializable;

public class Meal implements Serializable {


    private static final long serialVersionUID = -2699691067113568764L;

    private  Integer id;
  private String name;
  private Integer mouth;

  private Integer money;

  private Integer status;

  private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public Integer getMouth() {
        return mouth;
    }

    public void setMouth(Integer mouth) {
        this.mouth = mouth;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
