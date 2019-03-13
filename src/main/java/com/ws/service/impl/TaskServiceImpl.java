package com.ws.service.impl;

import com.ws.bean.Task;
import com.ws.bean.UserBean;
import com.ws.mapper.TaskMapper;
import com.ws.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
//查询发布
    @Override
    public List<Task> queryTask(Integer uid) {
        return taskMapper.queryTask(uid);
    }
//查询任务人
    @Override
    public List<UserBean> queryTaskRole() {
        return taskMapper.queryTaskRole();
    }

    //发布任务
    @Override
    public void addTask(Task task) {
        taskMapper.addTask(task);
    }

    //我的任务
    @Override
    public List<Task> querywoTask(Integer uid) {
        return taskMapper.querywoTask(uid);
    }

    //完成的任务
    @Override
    public List<Task> queryweiTask(Integer uid) {
        return taskMapper.queryweiTask(uid);
    }

    //x修改状态
    @Override
    public void updateTaskId(Integer id) {
        taskMapper.updateTaskId(id);
    }


}
