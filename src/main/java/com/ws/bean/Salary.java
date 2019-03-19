package com.ws.bean;

import java.io.Serializable;

public class Salary  implements Serializable {


    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 城市
     */
    private String city;

    /**
     * 学历
     */
    private String schooling;

    /**
     * 培训前薪资
     */
    private Double salary;

    /**
     * 培训后薪资
     */
    private Double ensalary;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSchooling() {
        return schooling;
    }

    public void setSchooling(String schooling) {
        this.schooling = schooling;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getEnsalary() {
        return ensalary;
    }

    public void setEnsalary(Double ensalary) {
        this.ensalary = ensalary;
    }
}
