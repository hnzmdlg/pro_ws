package com.ws.mapper;

import com.ws.bean.Vip;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VipMapper {
    // 查询总条数
    @Select("select count(*) from t_vip")
    long queryTotal(Vip vip);

    //查询
    @Select("SELECT * FROM t_vip  LIMIT #{start},#{rows}")
    List<Vip> queryPageProblem(@Param("start")int start, @Param("rows")int rows, @Param("vip")Vip vip);
    // 修改
    @Update("UPDATE t_vip SET vname=#{vname} ,vprice=#{vprice} where id=#{id}")
    void updateVip(Vip vip);
    //新增
    @Insert("INSERT into t_vip(vname,vprice) VALUES(#{vname},#{vprice})")
    void addVip(Vip vip);
    //回显
    @Select("SELECT * FROM t_vip x where v.id=#{id}")
    Vip queryVipById(Integer id);
    //删除
    @Delete("delete from t_vip where id=#{s}")
    void deleteAll(String s);
}
