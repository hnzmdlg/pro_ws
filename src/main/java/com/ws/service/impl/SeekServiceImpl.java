package com.ws.service.impl;

import com.ws.bean.Salary;
import com.ws.bean.Seek;
import com.ws.mapper.SeekMapper;
import com.ws.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SeekServiceImpl implements SeekService {

    @Autowired
    private SeekMapper seekMapper;

    @Override
    public HashMap<String, Object> salaryanswer(int page, int rows, Seek seek) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =seekMapper.queryTotal(seek);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Seek> list  = seekMapper.queryPageProblem(start,rows, seek);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    @Override
    public void updateAnswer(Seek seek) {
        seekMapper.updateAnswer(seek);
    }

    @Override
    public void addAnswer(Seek seek) {
        seekMapper.addAnswer(seek);
    }

    @Override
    public void seekAll(String id) {
        seekMapper.seekAll(id);
    }

    @Override
    public Seek querySeekById(Integer id) {
        return seekMapper.querySeekById(id);
    }

    @Override
    public List<Seek> seektlot() {
        return seekMapper.seektlot();
    }
}
