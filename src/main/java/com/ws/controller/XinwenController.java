package com.ws.controller;
import com.ws.bean.Xinwen;
import com.ws.service.XinwenService;
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

@Controller
public class XinwenController {

    @Autowired
    private XinwenService xinwenService;

    // 查询
    @RequestMapping("queryXinwen")
    @ResponseBody
    public HashMap<String,Object> queryProblem(int page, int rows, Xinwen xinwen){
        HashMap<String,Object> list = xinwenService.queryAnswer(page,rows, xinwen);
        return list;
    }

    @RequestMapping("toxinwen")
    public  String toxinwen(){
        return "xinwen";
    }

    //修改 ： 新增
    @RequestMapping("addXinwen")
    @ResponseBody
    public void  addAnswer(Xinwen xinwen){

        Integer id = xinwen.getId();
        if (id!=null){
            //修改
            xinwenService.updateAnswer(xinwen);
        }else {
            //新增
            xinwenService.addAnswer(xinwen);
        }

    }
    //修改回显
    @RequestMapping("queryXinwenById")
    @ResponseBody
    public Xinwen queryXinwenById(Integer id){

        Xinwen xinwen   = xinwenService.queryXinwenById(id);
        return xinwen;
    }

    //批量删除
    @RequestMapping("deleteXinwenAll")
    @ResponseBody
    public  void  deleteAll(String id){
        xinwenService.deleteAll(id);
    }

    //上传图片
    @RequestMapping("uploadImg1")
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


}
