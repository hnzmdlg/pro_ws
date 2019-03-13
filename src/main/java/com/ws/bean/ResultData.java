package com.ws.bean;

import java.io.Serializable;

public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 2721636316536981165L;
    private T data;

    private Integer code = 200;

    private String msg;

    private Boolean success = true;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
