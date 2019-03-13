package com.ws.service.impl;

import com.ws.bean.Vip;
import com.ws.mapper.VipMapper;
import com.ws.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Autowired
    private VipMapper vipMapper;

    //查询
    @Override
    public HashMap<String, Object> queryVip(int page, int rows, Vip vip) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =vipMapper.queryTotal(vip);
        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Vip> list  = vipMapper.queryPageProblem(start,rows, vip);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }
//修改
    @Override
    public void updateVip(Vip vip) {
        vipMapper.updateVip(vip);
    }
//新增
    @Override
    public void addVip(Vip vip) {
        vipMapper.addVip(vip);
    }
//回显
    @Override
    public Vip queryVipById(Integer id) {
        return vipMapper.queryVipById(id);
    }
//删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            vipMapper.deleteAll(sid[i]);
        }
    }
}
