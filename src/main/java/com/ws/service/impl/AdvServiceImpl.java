package com.ws.service.impl;


import com.ws.bean.Advertisement;
import com.ws.bean.WebUser;
import com.ws.mapper.AdvMapper;
import com.ws.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdvServiceImpl implements AdvService {


    @Autowired
    private AdvMapper advMapper;


    @Override
    public HashMap<String, Object> queryAdv(int page, int rows, Advertisement adv) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =advMapper.queryTota(adv);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Advertisement> list  = advMapper.queryPageAdv(start,rows, adv);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }



    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            advMapper.deleteAll(sid[i]);
        }
    }

    //修改 回显
    @Override
    public Advertisement queryById(Integer id) {
        return advMapper.queryById(id);
    }




    //修改
    @Override
    public void updateAdv( Advertisement adv) {
        advMapper.updateAdv(adv);
    }

    //新增
    @Override
    public void addAdv( Advertisement adv) {
        advMapper.addAdv(adv);
    }

}
