package com.ws.controller;


import com.ws.bean.Evaluate;
import com.ws.bean.LogBean;
import com.ws.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("addpinluns")
    @ResponseBody
    public void addLog(){
        Evaluate evaluate=new Evaluate();
        evaluate.setId(2);
        evaluate.setContont("666");
        evaluate.setPtime("2018-11-05");
        evaluate.setStatus(1);
        mongoTemplate.save(evaluate);
        System.out.println("保存日志成功！");
    }

    //查询用户表
    @RequestMapping("queryPinLunee")
    @ResponseBody
    public HashMap<String,Object> queryUserBean(int page, int rows, Evaluate evaluate){


        return evaluateService.queryPinLun(page,rows,evaluate);
    }

    //批量删除
    @RequestMapping("deleteAll")
    @ResponseBody
    public  void  deleteAll(String[] id){
        Query query = new Query();
        for (int i = 0; i < id.length; i++) {
            query = Query.query(Criteria.where("id").is(id[i]));
            mongoTemplate.findAllAndRemove(query,Evaluate.class);
        }
    }

    //修改回显
    @RequestMapping("queryEvaluateById")
    @ResponseBody
    public Evaluate queryEvaluateById(Integer id){

        return mongoTemplate.findById(id,Evaluate.class);
    }

    //修改 ： 新增
    @RequestMapping("addEvaluate")
    @ResponseBody
    public void  addEvaluate(Evaluate evaluate){
         Evaluate evaluate1=new Evaluate();
        Integer id = evaluate.getId();
        if (id!=null){
            Query query=new Query(Criteria.where("_id").is(evaluate.getId()));
            //修改
            evaluateService.updateEvaluate(evaluate);
            Update update = new Update().set("contont", evaluate.getContont()).set("ptime", evaluate.getPtime());
            mongoTemplate.updateFirst(query, update, Evaluate.class);
            System.out.println("修改日志成功！");
        }else {
            //新增
            evaluateService.addEvaluate(evaluate);
        }

    }

    //queryPinLun
    //查询用户表
    @RequestMapping("queryPinLun")
    @ResponseBody
    public HashMap<String, Object> queryPinLun3(int page, int rows, Evaluate evaluate){
        HashMap<String, Object>  hashMap = new HashMap<>();
        Query query = new Query();
        Criteria criteria = Criteria.where("status").is(1);
        query.addCriteria(criteria);
        //总条数
        long count = mongoTemplate.count(query, Evaluate.class);
        //每页条数
        query.skip((page-1)*rows);
        //
        query.limit(rows);
        //放数据
        List<Evaluate> find = mongoTemplate.find(query, Evaluate.class);
        hashMap.put("total", count);
        hashMap.put("rows", find);
        return hashMap;
    }
}
