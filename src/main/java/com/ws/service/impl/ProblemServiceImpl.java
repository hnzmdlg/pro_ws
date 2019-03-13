package com.ws.service.impl;



import com.ws.bean.ProblemBean;
import com.ws.mapper.ProblemMapper;
import com.ws.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;


    @Override
    public HashMap<String, Object> queryProblem2(int page, int rows, ProblemBean problemBean) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =problemMapper.queryTotal(problemBean);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<ProblemBean> list  = problemMapper.queryPageProblem(start,rows, problemBean);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

//不分页
    @Override
    public List<ProblemBean> queryProblem3() {
        return problemMapper.queryProblem3();
    }

    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            problemMapper.deleteAll(sid[i]);
        }
    }

    @Override
    public void addProblemBean(ProblemBean problemBean) {
        problemMapper.addProblemBean(problemBean);
    }

}
