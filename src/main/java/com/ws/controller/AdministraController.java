package com.ws.controller;

import com.ws.bean.Administration;
import com.ws.service.AdministraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class AdministraController {

    @Autowired
    private AdministraService administraService;

    //查询用户表queryAdministra
    @RequestMapping("queryAdministra")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Administration administration){
        HashMap<String,Object> list = administraService.queryAdministra(page,rows, administration);

        return list;
    }
    //查询热门课程
    @RequestMapping("queryAdministration")
    @ResponseBody
    public List<Administration> queryAdmini(){

        return administraService.queryAdmini();
    }

    //新增热门课程
    @RequestMapping("addAdministration")
    @ResponseBody
    public  void  addAdministration(Administration administration){
        administraService.addAdministration(administration);
    }

}
