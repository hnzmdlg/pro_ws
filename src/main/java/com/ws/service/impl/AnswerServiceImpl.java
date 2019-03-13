package com.ws.service.impl;

import com.ws.bean.Answer;

import com.ws.mapper.AnswerMapper;
import com.ws.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public HashMap<String, Object> queryAnswer(int page, int rows, Answer answer) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =answerMapper.queryTotal(answer);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Answer> list  = answerMapper.queryPageProblem(start,rows, answer);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            answerMapper.deleteAll(sid[i]);
        }
    }

    @Override
    public void addAnswer(Answer answer) {
        answerMapper.addAnswer(answer);
    }

    //回显
    @Override
    public Answer queryAnswerById(Integer id) {
        return answerMapper.queryAnswerById(id);
    }
//修改
    @Override
    public void updateAnswer(Answer answer) {
        answerMapper.updateAnswer(answer);
    }
}
