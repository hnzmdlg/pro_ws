package com.ws.controller;

import com.ws.bean.Kecheng;
import com.ws.service.KechengService;
import com.ws.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class KechengController {

    @Autowired
    private KechengService kechengService;




    //查询用户表
    @RequestMapping("querykechen2")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Kecheng kecheng){
        HashMap<String,Object> list = kechengService.querykechen(page,rows, kecheng);

        return list;
    }



    //查询审核后的
    @RequestMapping("querykecheneeee")
    @ResponseBody
    public List<Kecheng> querykechen3(){

        return kechengService.querykechen3();
    }

    //查询审核前的
    @RequestMapping("querykechenId")
    @ResponseBody
    public List<Kecheng> querykechenId(){

        return kechengService.querykechenId();
    }

    //审核通过
    @RequestMapping("updatekechenId")
    @ResponseBody
    public String  updatekechenId(Integer id){
        kechengService.updatekechenId(id);
        return "审核通过";
    }

    //批量删除
    @RequestMapping("deleteKechenAll")
    @ResponseBody
    public  void  deleteAll(String id){

        kechengService.deleteAll(id);
    }

    //修改回显
   @RequestMapping("queryKechengById")
    @ResponseBody
    public Kecheng queryKechengById(Integer id){

       Kecheng  kecheng   = kechengService.queryKechengById(id);
        return kecheng;
    }



    //上传图片
    @RequestMapping("uploadImg2")
    @ResponseBody
    public String upload(HttpServletRequest request, @RequestParam(value="picFile",required=false) MultipartFile picFile) {
        String path = null;
        try {
            path = FileUtil.FileUpload(picFile, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(path.contains("null")) {
            return null;
        }else {
            System.out.println(path);
            return path;

        }
    }



    //修改 ： 新增
    @RequestMapping("addKechen")
    @ResponseBody
    public void  addAnswer(Kecheng kecheng){

        Integer id = kecheng.getId();
        if (id!=null){
            //修改

            kechengService.updateKecheng(kecheng);
        }else {
            //新增

            kecheng.setLls(0);
            kechengService.addKecheng(kecheng);
        }

    }



}
