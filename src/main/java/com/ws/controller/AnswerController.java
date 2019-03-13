package com.ws.controller;


import com.ws.bean.Answer;
import com.ws.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class AnswerController {

    @Autowired
    private AnswerService answerService;


    //查询用户表
    @RequestMapping("queryAnswer")
    @ResponseBody
    public  HashMap<String,Object> queryProblem(int page, int rows, Answer answer){
        HashMap<String,Object> list = answerService.queryAnswer(page,rows, answer);

        return list;
    }

    //批量删除
    @RequestMapping("deleteAnswerAll")
    @ResponseBody
    public  void  deleteAll(String id){
        answerService.deleteAll(id);
    }

    //修改回显
  @RequestMapping("queryAnswerById")
    @ResponseBody
    public Answer queryEvaluateById(Integer id){

      Answer  answer   = answerService.queryAnswerById(id);
        return answer;
    }

    //修改 ： 新增
    @RequestMapping("addAnswer")
    @ResponseBody
    public void  addAnswer(Answer answer){

        Integer id = answer.getId();
        if (id!=null){
            //修改
             answerService.updateAnswer(answer);
        }else {
            //新增
            answerService.addAnswer(answer);
        }

    }

}
