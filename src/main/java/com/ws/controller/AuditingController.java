package com.ws.controller;

import com.ws.bean.Salary;
import com.ws.bean.Seek;
import com.ws.bean.Xinwen;
import com.ws.service.AuditingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuditingController {

    @Autowired
    private AuditingService auditingService;



    //查询新闻审核前的
    @RequestMapping("auditingId")
    @ResponseBody
    public List<Xinwen> auditingId(){

        return auditingService.auditingId();
    }

    //审核通过
    @RequestMapping("updateauditingId")
    @ResponseBody
    public String  updateauditingId(Integer id){
        auditingService.updateauditingId(id);
        return "审核通过";
    }


    //查询薪资审核前的
    @RequestMapping("salarytingId")
    @ResponseBody
    public List<Salary> salarytingId(){

        return auditingService.salarytingId();
    }

    //审核通过
    @RequestMapping("updatesalarytingId")
    @ResponseBody
    public String  updatesalarytingId(Integer id){
        auditingService.updatesalarytingId(id);
        return "审核通过";
    }

    //咨询管理
    @RequestMapping("tosqeekid")
    @ResponseBody
    public List<Seek>tosqeekid(){
        return auditingService.tosqeekid();
    }
    //审核通过
    @RequestMapping("updateseek")
    @ResponseBody
    public String updateseek(Integer id){
        auditingService.updateseek(id);
        return "审核通过";
    }

}
