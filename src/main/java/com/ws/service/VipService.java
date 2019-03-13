package com.ws.service;

import com.ws.bean.Vip;

import java.util.HashMap;

public interface VipService {
    HashMap<String,Object> queryVip(int page, int rows, Vip vip);

    void updateVip(Vip vip);

    void addVip(Vip vip);

    Vip queryVipById(Integer id);

    void deleteAll(String id);
}
