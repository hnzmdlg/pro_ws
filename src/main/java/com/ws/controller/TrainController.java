package com.ws.controller;

import com.ws.bean.Train;
import com.ws.service.RoleService;
import com.ws.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    // 分页查询报名
    @RequestMapping("queryTrain")
    @ResponseBody
    public HashMap<String,Object> queryTrain(int page, int rows, Train train){
        return trainService.queryTrain(page,rows,train);
    }

    // 前台报名新增
    @RequestMapping("addtrain")
    @ResponseBody
    public void addtrain(Train train){
        trainService.addtrain(train);
    }



}
