package com.ws.service.impl;

import com.ws.bean.Answer;
import com.ws.bean.Interview;
import com.ws.mapper.AnswerrMapper;
import com.ws.mapper.InterViewMapper;
import com.ws.service.AnswerService;
import com.ws.service.AnswerrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AnswerrServiceImpl implements AnswerrService {

    @Autowired
    private AnswerrMapper answerrMapper;

    @Override
    public HashMap<String, Object> queryanswerr(int page, int rows,Answer answer) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = answerrMapper.queryTotal(answer);
        //分页查询用户信息
        //计算开始位置   每页：3   第2页   456
        int start = (page-1)*rows;//3
        //计算结束位置
        int end = start + rows;//6
        List<Answer> list = answerrMapper.queryPage(start,rows,answer);
        hashMap.put("total", total);//总条数
        hashMap.put("rows", list);//list集合
        return hashMap;
    }

}
