package com.ws.service;

import com.ws.bean.Xinwen;

import java.util.HashMap;

public interface XinwenService {
    HashMap<String,Object> queryAnswer(int page, int rows, Xinwen xinwen);

    void updateAnswer(Xinwen xinwen);

    void addAnswer(Xinwen xinwen);

    Xinwen queryXinwenById(Integer id);

    void deleteAll(String id);
}
