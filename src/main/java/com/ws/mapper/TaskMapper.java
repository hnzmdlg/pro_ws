package com.ws.mapper;


import com.ws.bean.Task;
import com.ws.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TaskMapper {
//发布的任务
    @Select("SELECT t.*,u.name uname from tt_task t LEFT JOIN user u on t.uid = u.id WHERE t.uuid=#{uid}")
    List<Task> queryTask(Integer uid);
//查询任务人
    @Select("SELECT u.id uid , u.name  from user u")
    List<UserBean> queryTaskRole();
    //新增任务
    @Insert("INSERT INTO tt_task(uuid,neirong,uid,rdate,rtype)VALUES(#{uuid},#{neirong},#{uid},SYSDATE(),0)")
    void addTask(Task task);
//查询我的任务
    @Select("SELECT t.*,u.name uname from tt_task t LEFT JOIN user u on t.uid = u.id WHERE t.uid=#{uid} and t.rtype=0")
    List<Task> querywoTask(Integer uid);

    //修改状态
    @Update("UPDATE tt_task k set k.rtype=1 WHERE k.id =#{id}")
    void updateTaskId(Integer id);
    //已完成的任务
    @Select("SELECT t.*,u.name uname from tt_task t LEFT JOIN user u on t.uid = u.id WHERE t.uid=#{id} and t.rtype=1")
    List<Task> queryweiTask(Integer uid);
}
