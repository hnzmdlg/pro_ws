package com.ws.service.impl;

import com.ws.bean.Xinwen;
import com.ws.mapper.XinwenMapper;
import com.ws.service.XinwenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class XinwenServiceImpl implements XinwenService {
    @Autowired
    private XinwenMapper xinwenMapper;

    @Override
    public HashMap<String, Object> queryAnswer(int page, int rows, Xinwen xinwen) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =xinwenMapper.queryTotal(xinwen);
        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Xinwen> list  = xinwenMapper.queryPageProblem(start,rows, xinwen);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void updateAnswer(Xinwen xinwen) {
        xinwenMapper.updateXinwen(xinwen);
    }

    @Override
    public void addAnswer(Xinwen xinwen) {
        xinwenMapper.addXinwen(xinwen);
    }

    @Override
    public Xinwen queryXinwenById(Integer id) {
        return xinwenMapper.queryXinwenById(id);
    }

    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            xinwenMapper.deleteAll(sid[i]);
        }
    }
}
