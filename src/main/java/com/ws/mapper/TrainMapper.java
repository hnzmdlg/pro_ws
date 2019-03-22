package com.ws.mapper;

import com.ws.bean.Train;
import com.ws.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainMapper {

    // 查看报名
    @Select("select count(*) from train a")
    long queryTotal(@Param("train") Train train);
    @Select("SELECT u.* from train u GROUP BY u.id LIMIT #{start},#{rows}")
    List<Train> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("train") Train train);

    @Insert("insert into train(name,sex,phone,qq,vx,xl,outdate,money,dqzt) values(#{name},#{sex},#{phone},#{qq},#{vx},#{xl},#{outdate},#{money},#{dqzt})")
    void addtrain(Train train);
}
