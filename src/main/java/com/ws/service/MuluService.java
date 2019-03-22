package com.ws.service;

import com.ws.bean.Interview;
import com.ws.bean.Mulu;

import java.util.HashMap;
import java.util.List;

public interface MuluService {

    HashMap<String, Object> queryMulu(int page, int rows, Mulu mulu);

    List<Mulu> showmulu(Mulu mulu);

    List<Interview> querymuluok(Integer id);

    Interview addSessionOpenmuluuuu(Integer id);
}
