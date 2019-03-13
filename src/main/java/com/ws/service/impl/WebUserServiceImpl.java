package com.ws.service.impl;

import com.ws.bean.WebUser;
import com.ws.mapper.WebUserMapper;
import com.ws.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WebUserServiceImpl implements WebUserService {

    @Autowired
    private WebUserMapper webUserMapper;

    @Override
    public HashMap<String, Object> queryWebUser(int page, int rows, WebUser webuser) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =webUserMapper.queryTota(webuser);
        long  total2 =webUserMapper.queryTota2(webuser);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<WebUser> list  = webUserMapper.queryPageWebUser(start,rows, webuser);
        hashMap.put("total",total);
        hashMap.put("total",total2);

        hashMap.put("rows",list);


        return hashMap;
    }
    //修改 回显
    @Override
    public WebUser queryWebUserById(Integer id) {
        return webUserMapper.queryWebUserById(id);
    }

    //修改
    @Override
    public void updateWebUser(WebUser webuser) {
        webUserMapper.updateWebUser(webuser);
    }

    //新增
    @Override
    public void addWebUser(WebUser webuser) {
        webUserMapper.addWebUser(webuser);
    }

    //删除
    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            webUserMapper.deleteAll(sid[i]);
        }
    }

    //查询未审核
    @Override
    public HashMap<String, Object> queryWebUserWei(int page, int rows, WebUser webuser) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =webUserMapper.queryTota(webuser);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<WebUser> list  = webUserMapper.queryWebUserWei(start,rows, webuser);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    //通过审核
    @Override
    public void updateWebUserId(Integer id) {
        webUserMapper.updateWebUserId(id);
    }

    //查询审核通过了吗
    @Override
    public WebUser queryWebUserTtid(Integer id) {
        return webUserMapper.queryWebUserTtid(id);
    }
}
