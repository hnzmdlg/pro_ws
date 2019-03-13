package com.ws.controller;

import com.ws.bean.Vip;
import com.ws.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class VipController {
    @Autowired
    private VipService vipService;

    @RequestMapping("toVip")
    public  String toVip(){
        return "vip";
    }

    // 查询
    @RequestMapping("queryVip")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Vip vip){
        HashMap<String,Object> list = vipService.queryVip(page,rows, vip);
        return list;
    }

    //修改 ： 新增
    @RequestMapping("addVip")
    @ResponseBody
    public void  addAnswer(Vip vip){

        Integer id = vip.getId();
        if (id!=null){
            //修改
            vipService.updateVip(vip);
        }else {
            //新增
            vipService.addVip(vip);
        }

    }
    //修改回显
    @RequestMapping("queryVipById")
    @ResponseBody
    public Vip queryVipById(Integer id){

        Vip vip   = vipService.queryVipById(id);
        return vip;
    }

    //批量删除
    @RequestMapping("deleteVipAll")
    @ResponseBody
    public  void  deleteAll(String id){
        vipService.deleteAll(id);
    }






}
