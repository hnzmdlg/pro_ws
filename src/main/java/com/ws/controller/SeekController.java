package com.ws.controller;

import com.ws.bean.Salary;
import com.ws.bean.Seek;
import com.ws.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class SeekController {

    @Autowired
    private SeekService seekService;

    //查询薪资表
    @RequestMapping("seekanswer")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Seek seek){
        HashMap<String,Object> list = seekService.salaryanswer(page,rows, seek);

        return list;
    }
    //批量删除
    @RequestMapping("deleteseekAll")
    @ResponseBody
    public  void  seekAll(String id){
        seekService.seekAll(id);
    }

    //修改回显
    @RequestMapping("querySeekById")
    @ResponseBody
    public Seek querySeekById(Integer id){

        Seek  seek   = seekService.querySeekById(id);
        return seek;
    }
    //修改 ： 新增
    @RequestMapping("addseek")
    @ResponseBody
    public void  addAnswer(Seek seek){

        Integer id = seek.getId();
        if (id!=null){
            //修改
            seekService.updateAnswer(seek);
        }else {
            //新增
            seekService.addAnswer(seek);
        }

    }

    @RequestMapping("seektlot")
    @ResponseBody
    public List<Seek> seektlot(){
        List<Seek>list = seekService.seektlot();
        return list;

    }
}
