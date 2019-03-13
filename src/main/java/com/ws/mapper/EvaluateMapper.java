package com.ws.mapper;

import com.ws.bean.Evaluate;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface EvaluateMapper {

//查询总条数
    @Select("select count(*)  from t_pinlun a ")
    long queryTotal(@Param("evaluate") Evaluate evaluate);
    //查询
    @Select("SELECT * FROM t_pinlun where status=1 LIMIT #{start},#{rows}")
    List<Evaluate> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("evaluate") Evaluate evaluate);

    //批量删除
    @Update("UPDATE t_pinlun  p SET p.status=0 WHERE id=#{s} ")
    void deleteAll(String s);
//查询回显
    @Select("SELECT * FROM t_pinlun where id=#{id}")
    Evaluate queryEvaluateById(Integer id);

    //修改评价
    @Update("UPDATE t_pinlun  p SET p.puser=#{puser} ,p.kcid=#{kcid},p.contont=#{contont},p.ptime=#{ptime},p.status=#{status} WHERE id=#{id}")
    void updateEvaluate(Evaluate evaluate);
//新增评价
    @Insert("INSERT INTO t_pinlun(puser,kcid,contont,ptime,status) VALUES(#{puser},#{kcid},#{contont},#{ptime},1)")
    void addEvaluate(Evaluate evaluate);
    //查询
    @Select("SELECT * FROM t_pinlun where status=1")
    List<Evaluate> queryPinLun3();
}
