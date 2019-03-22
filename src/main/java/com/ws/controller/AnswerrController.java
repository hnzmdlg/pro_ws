package com.ws.controller;

import com.ws.bean.Answer;
import com.ws.bean.Interview;
import com.ws.service.AnswerrService;
import com.ws.service.InterViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class AnswerrController {


    @Autowired
    private AnswerrService answerrService;

    // 分页查询答案
    @RequestMapping("queryanswerr")
    @ResponseBody
    public HashMap<String,Object> queryanswerr(int page, int rows, Answer answer){
        return answerrService.queryanswerr(page,rows,answer);
    }
}
