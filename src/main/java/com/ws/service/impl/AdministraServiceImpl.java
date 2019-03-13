package com.ws.service.impl;

import com.ws.bean.Administration;
import com.ws.bean.Answer;
import com.ws.mapper.AdministraMapper;
import com.ws.service.AdministraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdministraServiceImpl implements AdministraService {

    @Autowired
    private AdministraMapper administraMapper;

    @Override
    public HashMap<String, Object> queryAdministra(int page, int rows, Administration administration) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =administraMapper.queryTotal(administration);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Answer> list  = administraMapper.queryAdministra(start,rows, administration);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }
//查询课程
    @Override
    public List<Administration> queryAdmini() {
        return administraMapper.queryAdmini();
    }
//新增点击量
    @Override
    public void addAdministration(Administration administration) {
        administraMapper.addAdministration(administration);
    }


}
