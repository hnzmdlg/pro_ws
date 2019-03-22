package com.ws.service.impl;

import com.ws.bean.Train;
import com.ws.bean.UserBean;
import com.ws.mapper.TrainMapper;
import com.ws.mapper.TreeMapper;
import com.ws.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainMapper trainMapper;


    @Override
    public HashMap<String, Object> queryTrain(int page, int rows, Train train) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = trainMapper.queryTotal(train);
        //分页查询用户信息
        //计算开始位置   每页：3   第2页   456
        int start = (page-1)*rows;//3
        //计算结束位置
        int end = start + rows;//6
        List<Train> list = trainMapper.queryPage(start,rows,train);
        hashMap.put("total", total);//总条数
        hashMap.put("rows", list);//list集合
        return hashMap;
    }

    // 前台新增
    @Override
    public void addtrain(Train train) {
        trainMapper.addtrain(train);
    }
}
