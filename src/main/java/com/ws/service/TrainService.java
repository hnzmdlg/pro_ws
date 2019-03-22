package com.ws.service;

import com.ws.bean.Train;

import java.util.HashMap;

public interface TrainService {

    HashMap<String, Object> queryTrain(int page, int rows, Train train);

    void addtrain(Train train);
}
