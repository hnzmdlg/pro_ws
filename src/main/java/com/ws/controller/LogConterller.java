package com.ws.controller;

import com.ws.bean.LogBean;
import com.ws.utils.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class LogConterller {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查询用户 query
    @RequestMapping("findLog")
    @ResponseBody
    public HashMap<String, Object> query(int page, int rows, LogBean logBean){

        HashMap<String, Object>  hashMap = new HashMap<>();
        Query query = new Query();
        //总条数
        long count = mongoTemplate.count(query, LogBean.class);
        //每页条数
        query.skip((page-1)*rows);
        //
        query.limit(rows);
        //放数据
        List<LogBean> find = mongoTemplate.find(query, LogBean.class);
        hashMap.put("total", count);
        hashMap.put("rows", find);
        return hashMap;

    }


    /**
     * POI导出Excel
     * @throws Exception
     */
    //POI导出word测试
    @RequestMapping("exportApplyForm")
    public void exportApplyForm(HttpServletResponse response)throws  Exception{
        Query query = new Query();
        List<LogBean> logBeanList = mongoTemplate.find(query,LogBean.class);
        //定义导出标题
        String tilte ="列表";
        //列头
        String[]rowName ={"UserId","记录时间","IP","类名字","接口名字"};
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-mm-dd");
        List<Object[]> objects =new ArrayList<Object[]>();
        for (LogBean logBean :logBeanList){
            Object[]obj =new Object[rowName.length];
            obj[0]=logBean.getUserId();
            obj[1]=logBean.getCreateDate();
            obj[2]=logBean.getIp();
            obj[3]=logBean.getClassName();
            obj[4]=logBean.getMethod();

            objects.add(obj);
        }
        ExportExcel exportExcel =new ExportExcel(tilte,rowName,objects,response);
        try {
            exportExcel.export();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
