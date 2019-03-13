package com.ws.service;

import com.ws.bean.Task;
import com.ws.bean.UserBean;

import java.util.List;

public interface TaskService {
    List<Task> queryTask(Integer uid);

    List<UserBean> queryTaskRole();

    void addTask(Task task);

    List<Task> querywoTask(Integer uid);

    void updateTaskId(Integer id);

    List<Task> queryweiTask(Integer uid);
}
