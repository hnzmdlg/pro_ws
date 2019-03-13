package com.ws.service;

import com.ws.bean.Answer;

import java.util.HashMap;

public interface AnswerService {
    HashMap<String, Object> queryAnswer(int page, int rows, Answer answer);

    void deleteAll(String id);

    void addAnswer(Answer answer);

    Answer queryAnswerById(Integer id);

    void updateAnswer(Answer answer);
}
