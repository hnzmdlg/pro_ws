package com.ws.mapper;

import com.ws.bean.Interview;
import com.ws.bean.Train;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface InterViewMapper {
    @Select("select count(*) from t_interview a")
    long queryTotal(@Param("interview") Interview interview);
    @Select("SELECT u.*,m.mname from t_interview u,t_mulu m where u.mid=m.mid GROUP BY u.wid LIMIT #{start},#{rows}")
    List<Interview> queryPage(@Param("start") int start, @Param("rows") int rows, @Param("interview") Interview interview);
    @Select("SELECT u.*,m.mname from t_interview u,t_mulu m where u.mid=m.mid GROUP BY u.wid order by u.pv desc limit 7")
    List<Interview> queryPage2(Interview interview);
    @Select("SELECT u.*,m.mname from t_interview u,t_mulu m where u.mid=m.mid GROUP BY u.wid order by u.creadate desc")
    List<Interview> querypage3(Interview interview);
    @Select("SELECT u.*,a.contont from t_interview u,t_answer a where u.wid=a.wid and u.wid = #{id}")
    Interview queryInterViewOpen(Integer id);
    @Select("select * from t_answer a where a.id = #{id}")
    Interview queryInterViewOpen2(Integer id);
    @Update("update t_interview set pv = pv+1 where wid = #{wid}")
    void updatepvpv(Integer wid);
}
