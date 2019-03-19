package com.ws.controller;

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

}
