package com.ws.mapper;

import com.ws.bean.Interview;
import com.ws.bean.Mulu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MuluMapper {

    @Select("select count(*) from t_mulu a")
    long queryTotal(@Param("mulu") Mulu mulu);
    @Select("SELECT u.* from t_mulu u GROUP BY u.mid LIMIT #{start},#{rows}")
    List<Mulu> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("mulu") Mulu mulu);
    @Select("select * from t_mulu")
    List<Mulu> showmulu(@Param("mulu") Mulu mulu);
    @Select("SELECT u.*,a.mname from t_interview u,t_mulu a where u.mid=a.mid and u.mid = #{id}")
    List<Interview> querymuluok(@Param("id") Integer id);
    @Select("SELECT u.*,a.contont from t_interview u,t_answer a where u.wid=a.wid and u.wid = #{id}")
    Interview addSessionOpenmuluuuu(Integer id);
}
