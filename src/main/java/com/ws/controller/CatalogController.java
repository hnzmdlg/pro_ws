package com.ws.controller;

import com.ws.bean.*;
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

    //查询
    @RequestMapping("querySection")
    @ResponseBody
    public HashMap<String,Object> querySection(int page, int rows, Section section){
        HashMap<String,Object> list = catalogService.querySection(page,rows, section);

        return list;
    }
    //查询新增对应目录
    @RequestMapping("queryMulu")
    @ResponseBody
    public List<Catalog>  queryMulu(){

        return catalogService.queryMulu();
    }
    //修改回显
    @RequestMapping("querySectionById")
    @ResponseBody
    public Section querySectionById(Integer id){

        Section  section   = catalogService.querySectionById(id);
        return section;
    }

    //修改 ： 新增
    @RequestMapping("addSection")
    @ResponseBody
    public void  addAnswer(Section section){

        Integer id = section.getZid();

        if (id!=null){
            //修改
            catalogService.updateSection(section);
        }else {
            //新增
            catalogService.addSection(section);
        }
        System.out.println(id);
    }
    //批量删除
    @RequestMapping("deleteSectionAll")
    @ResponseBody
    public  void  deleteSectionAll(String id){
        catalogService.deleteSectionAll(id);
    }

    //查询
    @RequestMapping("queryNode")
    @ResponseBody
    public HashMap<String,Object> queryNode(int page, int rows, Node node){
        HashMap<String,Object> list = catalogService.queryNode(page,rows,node);
        return list;
    }
    //查询新增对应目录
    @RequestMapping("querySections")
    @ResponseBody
    public List<Section>  querySections(){

        return catalogService.querySections();
    }
    //修改回显
    @RequestMapping("queryNodeById")
    @ResponseBody
    public Node queryNodeById(Integer id){


        return catalogService.queryNodeById(id);
    }
    //修改 ： 新增
    @RequestMapping("addNode")
    @ResponseBody
    public void  addAnswer(Node node){

        Integer id = node.getSid();

        if (id!=null){
            //修改
            catalogService.updateNode(node);
        }else {
            //新增
            catalogService.addNode(node);
        }
        System.out.println(id);
    }
    //批量删除
    @RequestMapping("deleteNodeAll")
    @ResponseBody
    public  void  deleteNodeAll(String id){
        catalogService.deleteNodeAll(id);
    }
}
