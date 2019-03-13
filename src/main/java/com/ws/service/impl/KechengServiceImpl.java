package com.ws.service.impl;

import com.ws.bean.Kecheng;
import com.ws.mapper.KechengMapper;
import com.ws.service.KechengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class KechengServiceImpl implements KechengService {

    @Autowired
    private KechengMapper kechengMapper;


    @Override
    public HashMap<String, Object> querykechen(int page, int rows, Kecheng kecheng) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =kechengMapper.queryTotak(kecheng);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Kecheng> list  = kechengMapper.queryPageKecheng(start,rows, kecheng);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            kechengMapper.deleteAll(sid[i]);
        }
    }

    //新增
    @Override
    public void addKecheng(Kecheng kecheng) {
        kechengMapper.addKecheng(kecheng);
    }
//修改
    @Override
    public void updateKecheng(Kecheng kecheng) {
        kechengMapper.updateKecheng(kecheng);
    }
//回显
    @Override
    public Kecheng queryKechengById(Integer id) {
        return kechengMapper.queryKechengById(id);
    }

    //不分页
    @Override
    public List<Kecheng> querykechen3() {
        return kechengMapper.querykechen3();
    }

    //查询没有审核的
    @Override
    public List<Kecheng> querykechenId() {
        return kechengMapper.querykechenId();
    }

    //通过审核
    @Override
    public void updatekechenId(Integer id) {
        kechengMapper.updatekechenId(id);
    }
}
