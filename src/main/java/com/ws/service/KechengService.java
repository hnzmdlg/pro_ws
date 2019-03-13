package com.ws.service;

import com.ws.bean.Kecheng;

import java.util.HashMap;
import java.util.List;

public interface KechengService {
    HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng);

    void deleteAll(String id);

    void addKecheng(Kecheng kecheng);

    void updateKecheng(Kecheng kecheng);

    Kecheng queryKechengById(Integer id);

    List<Kecheng> querykechen3();

    List<Kecheng> querykechenId();

    void updatekechenId(Integer id);
}
