package com.ws.service.impl;

import com.ws.bean.Catalog;
import com.ws.bean.Kecheng;
import com.ws.bean.Node;
import com.ws.bean.Section;
import com.ws.mapper.CatalogMaper;
import com.ws.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMaper catalogMaper;

    @Override
    public HashMap<String, Object> queryCatalog(int page, int rows, Catalog catalog) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =catalogMaper.queryTota(catalog);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Catalog> list  = catalogMaper.queryPageCatalog(start,rows, catalog);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }
//查询课程（回显新增内容
    @Override
    public List<Kecheng> queryRole() {
        return catalogMaper.queryRole();
    }

    //新增
    @Override
    public void addCatalog(Catalog catalog) {
        catalogMaper.addCatalog(catalog);
    }


    //修改回显
    @Override
    public Catalog queryEvaluateById(Integer id) {
        return catalogMaper.queryEvaluateById(id);
    }

    //修改
    @Override
    public void updateCatalog(Catalog catalog) {
        catalogMaper.updateCatalog(catalog);
    }

    @Override
    public void deleteAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            catalogMaper.deleteAll(sid[i]);
        }
    }



    @Override
    public HashMap<String, Object> querySection(int page, int rows, Section section) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =catalogMaper.queryTota2(section);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Section> list  = catalogMaper.queryPageCatalog2(start,rows, section);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    @Override
    public List<Catalog> queryMulu() {
        return catalogMaper.queryMulu();
    }

    @Override
    public Section querySectionById(Integer id) {
        return catalogMaper.querySectionById(id);
    }

    @Override
    public void updateSection(Section section) {
        catalogMaper.updateSection(section);
    }

    @Override
    public void addSection(Section section) {
        catalogMaper.addSection(section);
    }

    @Override
    public void deleteSectionAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            catalogMaper.deleteSectionAll(sid[i]);
        }
    }

    @Override
    public HashMap<String, Object> queryNode(int page, int rows, Node node) {
        HashMap<String, Object>  hashMap = new  HashMap<>();
        //查询总条数
        long  total =catalogMaper.queryTota3(node);

        //计算开始位置
        int start =(page-1)*rows;
        //计算结束位置
        int  end = start +rows;
        List<Node> list  = catalogMaper.queryPageCatalog3(start,rows, node);
        hashMap.put("total",total);
        hashMap.put("rows",list);


        return hashMap;
    }

    @Override
    public List<Section> querySections() {
        return catalogMaper.querySections();
    }

    @Override
    public Node queryNodeById(Integer id) {
        return catalogMaper.queryNodeById(id);
    }

    @Override
    public void updateNode(Node node) {
        catalogMaper.updateNode(node);
    }

    @Override
    public void addNode(Node node) {
        catalogMaper.addNode(node);
    }

    @Override
    public void deleteNodeAll(String id) {
        String[] sid = id.split(",");
        for (int i=0;i<sid.length;i++){
            catalogMaper.deleteNodeAll(sid[i]);
        }    }


}
