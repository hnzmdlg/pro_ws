package com.ws.controller;

import com.ws.bean.Task;
import com.ws.bean.Tree;
import com.ws.bean.UserBean;
import com.ws.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    //查询任务
    @RequestMapping("queryTask")
    @ResponseBody
    public List<Task> queryTask(HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return taskService.queryTask(uid);
    }

    //查询用户名字
    @RequestMapping("queryTaskRole")
    @ResponseBody
    public  List<UserBean> queryTaskRole(){

        return taskService.queryTaskRole();
    }

    //新增任务
    @RequestMapping("addTask")
    @ResponseBody
    public  void  addTask(Task task,HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
       String iud= uid.toString();
        task.setUuid(iud);
        taskService.addTask(task);
    }

    //查询我的任务

    @RequestMapping("querywoTask")
    @ResponseBody
    public List<Task> querywoTask(HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return taskService.querywoTask(uid);
    }

    //查询完成任务
    @RequestMapping("queryweiTask")
    @ResponseBody
    public List<Task> queryweiTask(HttpSession session){
        UserBean user = (UserBean) session.getAttribute("user");
        Integer uid = user.getId();
        return taskService.queryweiTask(uid);
    }

    //完成任务
    @RequestMapping("updateTaskId")
    @ResponseBody
    public void  updateTaskId(Integer id){
        taskService.updateTaskId(id);
    }
}
