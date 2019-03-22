package com.ws.controller;

import com.ws.bean.Answer;
import com.ws.bean.Salary;
import com.ws.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    //查询薪资表
    @RequestMapping("salaryanswer")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Salary salary){
        HashMap<String,Object> list = salaryService.salaryanswer(page,rows, salary);

        return list;
    }
    //批量删除
    @RequestMapping("deleteSalaryAll")
    @ResponseBody
    public  void  salaryAll(String id){
        salaryService.salaryAll(id);
    }

    //修改回显
    @RequestMapping("querySalaryById")
    @ResponseBody
    public Salary querySalaryById(Integer id){

        Salary  salary   = salaryService.querySalaryById(id);
        return salary;
    }
    //修改 ： 新增
    @RequestMapping("addAsalary")
    @ResponseBody
    public void  addAnswer(Salary salary){

        Integer id = salary.getId();
        if (id!=null){
            //修改
            salaryService.updateAnswer(salary);
        }else {
            //新增
            salaryService.addAnswer(salary);
        }

    }

    @RequestMapping("resetlot")
    @ResponseBody
    public List<Salary> resetlot(){
        List<Salary>list = salaryService.resetlot();
        return list;

    }

}
