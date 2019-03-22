package com.ws.mapper;

import com.ws.bean.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerrMapper {

    @Select("select count(*) from t_answer a")
    long queryTotal(@Param("answer") Answer answer);
    @Select("SELECT u.*,m.name wname from t_answer u,t_interview m where u.wid=m.wid GROUP BY u.id LIMIT #{start},#{rows}")
    List<Answer> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("answer") Answer answer);

}
