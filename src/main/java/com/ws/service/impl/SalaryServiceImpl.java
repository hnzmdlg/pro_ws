package com.ws.service.impl;

import com.ws.bean.Answer;
import com.ws.bean.Salary;
import com.ws.mapper.SalaryMapper;
import com.ws.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Override
    public HashMap<String, Object> salaryanswer(int page, int rows, Salary salary) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =salaryMapper.queryTotal(salary);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Salary> list  = salaryMapper.queryPageProblem(start,rows, salary);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    @Override
    public void addAnswer(Salary salary) {
        salaryMapper.addAnswer(salary);
    }

    @Override
    public void updateAnswer(Salary salary) {
        salaryMapper.updateAnswer(salary);
    }

    @Override
    public void salaryAll(String id) {
        salaryMapper.salaryAll(id);
    }

    @Override
    public Salary querySalaryById(Integer id) {
        return salaryMapper.querySalaryById(id);
    }

    @Override
    public List<Salary> resetlot() {
        return salaryMapper.resetlot();
    }
}
