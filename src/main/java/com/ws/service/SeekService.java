package com.ws.service;

import com.ws.bean.Seek;

import java.util.HashMap;
import java.util.List;

public interface SeekService {
    HashMap<String, Object> salaryanswer(int page, int rows, Seek seek);

    void updateAnswer(Seek seek);

    void addAnswer(Seek seek);

    void seekAll(String id);

    Seek querySeekById(Integer id);

    List<Seek> seektlot();
}
