package com.ws.service.impl;

import com.ws.bean.Evaluate;
import com.ws.mapper.EvaluateMapper;
import com.ws.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Override
    public HashMap<String, Object> queryPinLun(int page, int rows, Evaluate evaluate) {

        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =evaluateMapper.queryTotal(evaluate);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Evaluate> list  = evaluateMapper.queryPage(start,rows,evaluate);
        hashMap.put("total",total);
        hashMap.put("rows",list);


         return hashMap;
    }


    //批量删除
    @Override
    public void deleteAll(String id) {

        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            evaluateMapper.deleteAll(sid[i]);
        }
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    @Override
    public Evaluate queryEvaluateById(Integer id) {
        return evaluateMapper.queryEvaluateById(id);
    }

    ///修改评价
    @Override
    public void updateEvaluate(Evaluate evaluate) {
        evaluateMapper.updateEvaluate(evaluate);
    }
//新增评价
    @Override
    public void addEvaluate(Evaluate evaluate) {
        evaluateMapper.addEvaluate(evaluate);
    }

    @Override
    public List<Evaluate> queryPinLun3() {
        return evaluateMapper.queryPinLun3();
    }
}
