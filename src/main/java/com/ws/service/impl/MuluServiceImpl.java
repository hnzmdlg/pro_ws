package com.ws.service.impl;

import com.ws.bean.Interview;
import com.ws.bean.Mulu;
import com.ws.bean.Train;
import com.ws.mapper.MuluMapper;
import com.ws.mapper.TrainMapper;
import com.ws.service.MuluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class MuluServiceImpl implements MuluService {

    @Autowired
    private MuluMapper muluMapper;

    @Override
    public HashMap<String, Object> queryMulu(int page, int rows, Mulu mulu) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = muluMapper.queryTotal(mulu);
        //分页查询用户信息
        //计算开始位置   每页：3   第2页   456
        int start = (page-1)*rows;//3
        //计算结束位置
        int end = start + rows;//6
        List<Mulu> list = muluMapper.queryPage(start,rows,mulu);
        hashMap.put("total", total);//总条数
        hashMap.put("rows", list);//list集合
        return hashMap;
    }

    @Override
    public List<Mulu> showmulu(Mulu mulu) {
        return muluMapper.showmulu(mulu);
    }

    @Override
    public List<Interview> querymuluok(Integer id) {
        return muluMapper.querymuluok(id);
    }

    @Override
    public Interview addSessionOpenmuluuuu(Integer id) {
        return muluMapper.addSessionOpenmuluuuu(id);
    }
}
