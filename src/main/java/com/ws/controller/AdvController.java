package com.ws.controller;


import com.ws.bean.Advertisement;
import com.ws.bean.WebUser;
import com.ws.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class AdvController {



    @Autowired
    private AdvService advService;



    //查询用户表
    @RequestMapping("queryAdvList")
    @ResponseBody
    public HashMap<String,Object> queryCatalog(int page, int rows, Advertisement adv){
        HashMap<String,Object> list = advService.queryAdv(page,rows, adv);

        return list;
    }



    //批量删除
    @RequestMapping("deleteAdvAll")
    @ResponseBody
    public  void  deleteAdvAll(String id){

        advService.deleteAll(id);
    }



    //修改回显

    @RequestMapping("queryById")
    @ResponseBody
    public Advertisement queryWebUserById(Integer id){

        Advertisement adv  = advService.queryById(id);
        return adv;
    }


    //修改 ： 新增
    @RequestMapping("addAdv")
    @ResponseBody
    public void  addAnswer(Advertisement adv){

        Integer id = adv.getId();
        if (id!=null){
            //修改
            advService.updateAdv(adv);
        }else {

            advService.addAdv(adv);
        }

    }


}
