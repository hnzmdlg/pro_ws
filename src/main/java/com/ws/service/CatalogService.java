package com.ws.service;

import com.ws.bean.Catalog;
import com.ws.bean.Kecheng;
import com.ws.bean.Node;
import com.ws.bean.Section;

import java.util.HashMap;
import java.util.List;

public interface CatalogService {
    HashMap<String, Object> queryCatalog(int page, int rows, Catalog catalog);

    List<Kecheng> queryRole();

    void addCatalog(Catalog catalog);

    Catalog queryEvaluateById(Integer id);

    void updateCatalog(Catalog catalog);

    void deleteAll(String id);


    HashMap<String, Object> querySection(int page, int rows, Section section);

    List<Catalog> queryMulu();

    Section querySectionById(Integer id);

    void updateSection(Section section);

    void addSection(Section section);

    void deleteSectionAll(String id);

    HashMap<String, Object> queryNode(int page, int rows, Node node);

    List<Section> querySections();

    Node queryNodeById(Integer id);

    void updateNode(Node node);

    void addNode(Node node);

    void deleteNodeAll(String id);
}
