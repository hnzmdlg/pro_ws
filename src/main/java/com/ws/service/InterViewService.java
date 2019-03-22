package com.ws.service;

import com.ws.bean.Interview;

import java.util.HashMap;
import java.util.List;

public interface InterViewService {

    HashMap<String, Object> queryInterView(int page, int rows, Interview interview);

    List<Interview> queryInterView2(Interview interview);

    List<Interview> queryInterView3(Interview interview);

    Interview queryInterViewOpen(Integer id);

    Interview queryInterViewOpen2(Integer id);

    void updatepvpv(Integer wid);
}
