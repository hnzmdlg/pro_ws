package com.ws.service;


import com.ws.bean.ProblemBean;

import java.util.HashMap;
import java.util.List;

public interface ProblemService {


    HashMap<String, Object> queryProblem2(int page, int rows, ProblemBean problemBean);

    void deleteAll(String id);

    void addProblemBean(ProblemBean problemBean);

    List<ProblemBean> queryProblem3();
}
