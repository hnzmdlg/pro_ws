package com.ws.service;

import com.ws.bean.Evaluate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document(collection="Evaluate")
public interface EvaluateService {
    HashMap<String, Object> queryPinLun(int page, int rows, Evaluate evaluate);

    void deleteAll(String id);

    Evaluate queryEvaluateById(Integer id);

    void updateEvaluate(Evaluate evaluate);

    void addEvaluate(Evaluate evaluate);

    List<Evaluate> queryPinLun3();
}
