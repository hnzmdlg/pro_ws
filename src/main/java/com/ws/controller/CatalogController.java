package com.ws.controller;

import com.ws.bean.Catalog;
import com.ws.bean.Kecheng;
import com.ws.bean.LogBean;
import com.ws.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    private CatalogService catalogService;



    //查询用户表
    @RequestMapping("queryCatalog")
    @ResponseBody
    public HashMap<String,Object> queryCatalog(int page, int rows, Catalog catalog){
        HashMap<String,Object> list = catalogService.queryCatalog(page,rows, catalog);

        return list;
    }

    //查询新增对应课程
    @RequestMapping("queryRoleKecheng")
    @ResponseBody
    public List<Kecheng>  queryRole(){

        return catalogService.queryRole();
    }

    //修改回显
 @RequestMapping("queryCatalogById")
    @ResponseBody
    public Catalog queryEvaluateById(Integer id){

     Catalog  catalog   = catalogService.queryEvaluateById(id);
        return catalog;
    }



    //修改 ： 新增
    @RequestMapping("addCatalog")
    @ResponseBody
    public void  addAnswer(Catalog catalog){

        Integer id = catalog.getId();
        if (id!=null){
            //修改
            catalogService.updateCatalog(catalog);
        }else {
            //新增
            catalogService.addCatalog(catalog);
        }

    }



        //批量删除
        @RequestMapping("deleteCatalogAll")
        @ResponseBody
        public  void  deleteCatalogAll(String id){
            catalogService.deleteAll(id);
        }

}
