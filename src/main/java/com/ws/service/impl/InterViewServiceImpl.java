package com.ws.service.impl;

import com.ws.bean.Interview;
import com.ws.bean.Mulu;
import com.ws.mapper.InterViewMapper;
import com.ws.mapper.MuluMapper;
import com.ws.service.InterViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class InterViewServiceImpl implements InterViewService {

    @Autowired
    private InterViewMapper interViewMapper;


    @Override
    public HashMap<String, Object> queryInterView(int page, int rows, Interview interview) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = interViewMapper.queryTotal(interview);
        //分页查询用户信息
        //计算开始位置   每页：3   第2页   456
        int start = (page-1)*rows;//3
        //计算结束位置
        int end = start + rows;//6
        List<Interview> list = interViewMapper.queryPage(start,rows,interview);
        hashMap.put("total", total);//总条数
        hashMap.put("rows", list);//list集合
        return hashMap;
    }

    @Override
    public List<Interview> queryInterView2(Interview interview) {
        return interViewMapper.queryPage2(interview);
    }

    @Override
    public List<Interview> queryInterView3(Interview interview) {
        return interViewMapper.querypage3(interview);
    }

    @Override
    public Interview queryInterViewOpen(Integer id) {
        return interViewMapper.queryInterViewOpen(id);
    }

    @Override
    public Interview queryInterViewOpen2(Integer id) {
        return interViewMapper.queryInterViewOpen2(id);
    }

    @Override
    public void updatepvpv(Integer wid) {
        interViewMapper.updatepvpv(wid);
    }
}
